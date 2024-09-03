package bau.LoLSearch.Srvices;

import bau.LoLSearch.Records.Exports.GameDataExport;
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

    public ArrayList<GameDataExport> getGamesDataByGameId(List<String> gameIds) {

        ExecutorService executor = Executors.newFixedThreadPool(10);


        List<Future<GameData>> futures = new ArrayList<>();


        for (String gameId : gameIds) {
            Callable<GameData> task = () -> fetchGameDataByGameId(gameId);
            futures.add(executor.submit(task));
        }


        ArrayList<GameData> gameDataList = new ArrayList<>();

        try {
            for (Future<GameData> future : futures) {
                gameDataList.add(future.get());
            }
        }catch (Exception e) {
            e.printStackTrace();
        }

        executor.shutdown();

        return getExportData(gameDataList);
    }


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

    private ArrayList<GameDataExport> getExportData(ArrayList<GameData> data) {
        ArrayList<GameDataExport> exportList = new ArrayList<>();
        for (GameData gameData : data) {
            exportList.add(new GameDataExport(gameData));
        }
        return exportList;
    }



}
