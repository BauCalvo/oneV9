package bau.LoLSearch.Srvices;

import bau.LoLSearch.Records.Exports.GameDataExport;
import bau.LoLSearch.Records.GameData;
import bau.LoLSearch.Repositorys.GameDataExportRepository;
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

    private final GameDataExportRepository repository;

    @Autowired
    public GameService(RestTemplate restTemplate, GameDataExportRepository repository) {
        this.restTemplate = restTemplate;
        this.repository = repository;
    }



    @Value("${api.key}")
    private String API_KEY;

    public ArrayList<GameDataExport> getGamesDataByGameId(List<String> gameIds) {

        ExecutorService executor = Executors.newFixedThreadPool(10);

        List<Future<GameDataExport>> futures = new ArrayList<>();

        for (String gameId : gameIds) {
            Callable<GameDataExport> task = () -> getGameDataByGameId(gameId);
            futures.add(executor.submit(task));
        }
        ArrayList<GameDataExport> gameDataList = new ArrayList<>();

        try {
            for (Future<GameDataExport> future : futures) {
                gameDataList.add(future.get());
            }
        }catch (Exception e) {
            e.printStackTrace();
        }

        executor.shutdown();

        return gameDataList;
    }


    public GameDataExport getGameDataByGameId(String matchId) {
        GameDataExport gameData =null;
        gameData = findGameInDatabaseById(matchId);
        if (gameData == null) {
            gameData = fetchGameFromApiById(matchId);
        }
        return gameData;
    }

    private GameDataExport fetchGameFromApiById(String matchId) {
        String url = UriComponentsBuilder
                .fromUriString("https://americas.api.riotgames.com/lol/match/v5/matches/{gameId}")
                .queryParam("api_key", API_KEY)
                .buildAndExpand(matchId)
                .toUriString();

        GameDataExport gameData;

        try {
            ResponseEntity<GameData> response = restTemplate.getForEntity(url, GameData.class);
            gameData = new GameDataExport(response.getBody());
            saveGameData(gameData);
        }catch (Exception e){
            gameData = null;
        }
        return gameData;
    }

    private void saveGameData(GameDataExport gameData) {
        repository.save(gameData);
    }

    private GameDataExport findGameInDatabaseById( String matchId) {
        return repository.findById(matchId).orElse(null);
    }





}
