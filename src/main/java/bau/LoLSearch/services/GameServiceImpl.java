package bau.LoLSearch.services;

import bau.LoLSearch.mappers.GameMapper;
import bau.LoLSearch.models.dtos.GameDataDTO;
import bau.LoLSearch.models.entities.game.GameData;
import bau.LoLSearch.repositories.GameDataRepository;
import jakarta.annotation.PreDestroy;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Service
@Primary
@RequiredArgsConstructor
public class GameServiceImpl implements GameService {

    private final RestTemplate restTemplate;

    private final GameDataRepository repository;

    private ExecutorService executor;


    @Value("${api.key}")
    private String API_KEY;

    public ArrayList<GameDataDTO> getGamesDataByGameId(List<String> gameIds) {

        ExecutorService executor = getExecutor();

        List<Future<GameDataDTO>> futures = new ArrayList<>();

        for (String gameId : gameIds) {
            Callable<GameDataDTO> task = () -> getGameDataByGameId(gameId);
            futures.add(executor.submit(task));
        }
        ArrayList<GameDataDTO> gameDataList = new ArrayList<>();

        try {
            for (Future<GameDataDTO> future : futures) {
                gameDataList.add(future.get());
            }
        }catch (Exception e) {
            e.printStackTrace();
        }

        return gameDataList;
    }


    public GameDataDTO getGameDataByGameId(String matchId) {
        GameDataDTO gameData =null;
        gameData = fetchGameFromDatabaseById(matchId);
        if (gameData == null) {
            gameData = fetchGameFromApiById(matchId);
            if(gameData != null) { saveGameData(gameData);}
        }
        return gameData;
    }

    public GameDataDTO fetchGameFromApiById(String matchId) {

        String url = UriComponentsBuilder
            .fromUriString("https://americas.api.riotgames.com/lol/match/v5/matches/{gameId}")
            .queryParam("api_key", API_KEY)
            .buildAndExpand(matchId)
            .toUriString();

        try {
            ResponseEntity<GameData> response = restTemplate.getForEntity(url, GameData.class);
            return GameMapper.getInstance().gameToGameDTO(response.getBody());
        }catch (Exception e) {
            return null;
        }
    }

    public GameDataDTO fetchGameFromDatabaseById(String matchId) {

        GameData gameData = repository.findById(matchId).orElse(null);
        GameDataDTO gameDataDTO = null;
        if (gameData != null) {
            gameDataDTO = GameMapper.getInstance().gameToGameDTO(gameData);
        }

        return gameDataDTO;
    }

    public void saveGameData(GameDataDTO gameDataDTO) {
        GameData gameData = GameMapper.getInstance().gameDTOToGameData(gameDataDTO);
        repository.save(gameData);
    }

    private ExecutorService getExecutor() {
        if (executor == null) {
            executor =  Executors.newFixedThreadPool(5);;
        }
        return executor;

    }

    @PreDestroy
    public void cleanup() {
        if (executor != null && !executor.isShutdown()) {
            executor.shutdown();
        }
    }
}
