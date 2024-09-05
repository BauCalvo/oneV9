package bau.LoLSearch;

import bau.LoLSearch.Records.Exports.GameDataExport;
import bau.LoLSearch.Records.GameData;
import bau.LoLSearch.Srvices.GameService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
public class GameServiceTest {

    @Autowired private GameService gameService;

    @Autowired private GameData testGameData;

    @Autowired private GameDataExport testGameDataExport;

    @Autowired private String testGameId;

    @Autowired private ArrayList<String> gamesIdList;


    @Test
    public void getGameDataByGameIdTest() {
        GameDataExport gameData = gameService.getGameDataByGameId(testGameId);
        assertNotNull(gameData);
        assertEquals(testGameDataExport,gameData);
    }

    @Test
    public void getGameDataByGameIdNullTest() {
        String fakeGameId = "LA2_0000000000";
        GameDataExport emptyGameData = gameService.getGameDataByGameId(fakeGameId);
        assertNull(emptyGameData);
    }

    @Test
    public void getGamesDataByGameIdTest() {
        ArrayList<GameDataExport> gamesData = gameService.getGamesDataByGameId(gamesIdList);

        assertEquals(gamesIdList.size(),gamesData.size());


        for(int i = 0; i < gamesData.size(); i++){
            String matchId = gamesData.get(i).matchId();
            assertEquals(gamesIdList.get(i),matchId);
        }
    }



}
