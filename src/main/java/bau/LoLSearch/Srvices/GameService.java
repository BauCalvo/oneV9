package bau.LoLSearch.Srvices;

import bau.LoLSearch.Records.GameData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

@Service
public class GameService {

    private final RestTemplate restTemplate;

    @Autowired
    public GameService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Value("${api.key}")
    private String API_KEY;

    public GameData fetchGameDataByGameId(String gameId) {
        String url = UriComponentsBuilder
                .fromUriString("https://americas.api.riotgames.com/lol/match/v5/matches/{gameId}")
                .queryParam("api_key", API_KEY)
                .buildAndExpand(gameId)
                .toUriString();

        try {
            ResponseEntity<GameData> response = restTemplate.getForEntity(url, GameData.class);
            return response.getBody();
        }catch (Exception e){
            return null;
        }
    }


    public ArrayList<GameData> getGamesDataByGameId(List<String> gameIds) {
        // Create an ExecutorService with a fixed thread pool
        ExecutorService executor = Executors.newFixedThreadPool(10);

        // List to hold Future objects
        List<Future<GameData>> futures = new ArrayList<>();

        // Submit tasks for each gameId
        for (String gameId : gameIds) {
            Callable<GameData> task = () -> fetchGameDataByGameId(gameId);
            futures.add(executor.submit(task));
        }

        // List to hold the results in the correct order
        ArrayList<GameData> gameDataList = new ArrayList<>();

        try {
            for (Future<GameData> future : futures) {
                gameDataList.add(future.get());
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        // Shutdown the executor
        executor.shutdown();

        return gameDataList;
    }
}
