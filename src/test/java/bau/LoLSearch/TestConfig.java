package bau.LoLSearch;

import bau.LoLSearch.Records.AccountMainInfo;
import bau.LoLSearch.Records.Exports.GameDataExport;
import bau.LoLSearch.Records.GameData;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
public class TestConfig {

    @Bean
    public AccountMainInfo testAccount(){
        return new AccountMainInfo(
                "pneU6bUTxo-WXRvm5cODPgQJORFaTYAjM72KWlIDOPf-XtCSLHArWYUJSDzdNJjfWQTjs3KzYDSA3g"
                ,"Paralelepipedo"
                , "NETS");
    }

    @Bean
    public List<String> gamesIdTest(){

        return new ArrayList<>(Arrays.asList(new String[]{
                "LA2_1441579110", "LA2_1441545911", "LA2_1441539013", "LA2_1441530112",
                "LA2_1441385901", "LA2_1441374085", "LA2_1441360477", "LA2_1441338704",
                "LA2_1441324348", "LA2_1441151929", "LA2_1441134888", "LA2_1441117947",
                "LA2_1441106614", "LA2_1440140446", "LA2_1440131324", "LA2_1440123429",
                "LA2_1440112890", "LA2_1440038920", "LA2_1440032105", "LA2_1440009436"}));
    }


    @Bean
    public String testMatchId(){
        return "LA2_1441385901";
    }

    @Bean
    public GameDataExport testGameDataExport() {
        ObjectMapper objectMapper = new ObjectMapper();
        GameDataExport gameDataExport = null;
        try {

            GameData gameData = objectMapper.readValue(new File("src/test/java/bau/LoLSearch/testData.json"), GameData.class);

           if (gameData != null) {
               gameDataExport = new GameDataExport(gameData);
           }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return gameDataExport;
    }

    @Bean
    public GameData testGameData() {
        ObjectMapper objectMapper = new ObjectMapper();
        GameData gameData = null;
        try {

            gameData = objectMapper.readValue(new File("src/test/java/bau/LoLSearch/testData.json"), GameData.class);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return gameData;
    }


}
