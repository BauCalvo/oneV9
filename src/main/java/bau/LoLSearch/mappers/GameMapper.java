package bau.LoLSearch.mappers;

import bau.LoLSearch.models.dtos.GameDataDTO;
import bau.LoLSearch.models.entities.GameData;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface GameMapper {
  GameMapper INSTANCE = Mappers.getMapper(GameMapper.class);

  GameDataDTO gameToGameDTO(GameData gameData);
  GameData gameDTOToGameData(GameDataDTO gameDataDTO);
}
