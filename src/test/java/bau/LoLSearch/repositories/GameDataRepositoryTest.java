package bau.LoLSearch.repositories;

import bau.LoLSearch.Util;
import bau.LoLSearch.models.entities.game.GameData;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataMongoTest
class GameDataRepositoryTest {

  @Autowired
  private GameDataRepository gameDataRepository;

  private final GameData testData;


  GameDataRepositoryTest(){
    testData = Util.jsonToGameData("src/test/java/bau/LoLSearch/testData.json");
  }

  @Test
  void testSaveGame(){
    GameData savedGame = gameDataRepository.save(testData);

    assertThat(savedGame).isNotNull();
    assertThat(savedGame.getMatchId()).isNotNull();
  }

  @Test
  void testFindGameByMatchId(){
    GameData savedGame = gameDataRepository.findById(testData.getMatchId()).get();

    assertEquals(testData, savedGame);
  }

}