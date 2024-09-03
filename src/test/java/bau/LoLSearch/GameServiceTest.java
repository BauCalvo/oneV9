package bau.LoLSearch;

import bau.LoLSearch.Records.GameData;
import bau.LoLSearch.Srvices.GameService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;


@SpringBootTest
public class GameServiceTest {

    @Autowired
    private GameService gameService;

    @Test
    public void fetchGameDataByGameIdTest() {
        String testGameId = "LA2_1441385901";
        GameData gameData = gameService.fetchGameDataByGameId(testGameId);

        assertThat(gameData.metadata().matchId().equals(testGameId)).isTrue();
    }
    @Test
    public void fetchGameDataByGameIdNullTest() {
        String fakeGameId = "LA2_0000000000";
        GameData emptyGameData = gameService.fetchGameDataByGameId(fakeGameId);
        assertNull(emptyGameData);
    }

    @Test
    public void getGamesDataByGameIdTest() {
        ArrayList<GameData> gamesData = gameService.getGamesDataByGameId(gamesIdTest());

        assertEquals(gamesIdTest().size(),gamesData.size());


        for(int i = 0; i < gamesData.size(); i++){
            String matchId = gamesData.get(i).metadata().matchId();
            assertEquals(gamesIdTest().get(i),matchId);
        }
    }


    private List<String> gamesIdTest(){
        String[] ids = {
                "LA2_1441579110", "LA2_1441545911", "LA2_1441539013", "LA2_1441530112",
                "LA2_1441385901", "LA2_1441374085", "LA2_1441360477", "LA2_1441338704",
                "LA2_1441324348", "LA2_1441151929", "LA2_1441134888", "LA2_1441117947",
                "LA2_1441106614", "LA2_1440140446", "LA2_1440131324", "LA2_1440123429",
                "LA2_1440112890", "LA2_1440038920", "LA2_1440032105", "LA2_1440009436"};
        return new ArrayList<>(Arrays.asList(ids));
    }
}
