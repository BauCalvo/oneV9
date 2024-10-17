package bau.LoLSearch.services;

import bau.LoLSearch.models.dtos.GameDataDTO;

import java.util.ArrayList;
import java.util.List;

public interface GameService {

  public ArrayList<GameDataDTO> getGamesDataByGameId(List<String> gameIds);

  public GameDataDTO getGameDataByGameId(String matchId);
}
