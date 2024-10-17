package bau.LoLSearch.services;

import bau.LoLSearch.mappers.GameMapper;
import bau.LoLSearch.models.dtos.GameDataDTO;
import bau.LoLSearch.models.entities.GameData;
import bau.LoLSearch.repositories.GameDataRepository;
import bau.LoLSearch.Util;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class GameServiceImplTest {


  @MockBean
  private GameDataRepository  gameRepository;



  @Autowired
  private GameServiceImpl gameService;


  private static GameData testData;

  private static GameDataDTO testDataDTO;

  @BeforeAll
  static void beforeAll()  {
    testData = Util.jsonToGameData("src/test/java/bau/LoLSearch/testData.json");
    testDataDTO = GameMapper.INSTANCE.gameToGameDTO(testData);
  }

  @Test
  public void testGetGameDataByGameId_FoundInDatabase() {
    when(gameRepository.findById("LA2_1441385901")).thenReturn(Optional.ofNullable(testData));

    GameServiceImpl gameServiceSpy = Mockito.spy(gameService);

    GameDataDTO result = gameServiceSpy.getGameDataByGameId("LA2_1441385901");

    // Assert: Check that the result comes from the database and no API call is made
    assertNotNull(result);
    assertEquals(testDataDTO, result);

    verify(gameServiceSpy, never()).fetchGameFromApiById(anyString());
    verify(gameServiceSpy, never()).saveGameData(any(GameDataDTO.class));
  }
  @Test
  public void testGetGameDataByGameId_FetchedFromApi() {
    GameServiceImpl gameServiceSpy = Mockito.spy(gameService);

    GameDataDTO result = gameServiceSpy.getGameDataByGameId("LA2_1441385901");


    assertNotNull(result);
    assertEquals(testDataDTO, result);
    verify(gameServiceSpy, times(1)).fetchGameFromApiById("LA2_1441385901");
    verify(gameServiceSpy, times(1)).saveGameData(testDataDTO);
  }

  @Test
  void fetchGameFromApiById() {
    assertEquals(testDataDTO,gameService.fetchGameFromApiById("LA2_1441385901"));
  }

  @Test
  void fetchGameFromDatabaseById() {
    when(gameRepository.findById("LA2_1441385901")).thenReturn(Optional.ofNullable(testData));

    GameDataDTO gameDataDTO = gameService.fetchGameFromDatabaseById("LA2_1441385901");
    assertEquals(testDataDTO, gameDataDTO);


  }


}