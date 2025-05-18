package bau.LoLSearch.mappers;

import bau.LoLSearch.models.dtos.GameDataDTO;
import bau.LoLSearch.models.entities.game.GameData;
import bau.LoLSearch.models.entities.game.GameInfo;
import bau.LoLSearch.models.entities.game.GameMetaData;

public class GameMapper {

  private static GameMapper instance;

  public static GameMapper getInstance() {
    if (instance == null) {
      instance = new GameMapper();
    }
    return instance;
  }


  public GameDataDTO gameToGameDTO(GameData gameData) {
    if ( gameData == null ) {
      return null;
    }

    GameMetaData metadata = null;
    GameInfo info = null;

    metadata = gameData.getMetadata();
    info = gameData.getInfo();

    GameDataDTO gameDataDTO = new GameDataDTO( metadata, info );

    return gameDataDTO;
  }

  public GameData gameDTOToGameData(GameDataDTO gameDataDTO) {
    if ( gameDataDTO == null ) {
      return null;
    }

    GameData gameData = new GameData(gameDataDTO.getMetadata(),gameDataDTO.getInfo());

    return gameData;
  }
}
