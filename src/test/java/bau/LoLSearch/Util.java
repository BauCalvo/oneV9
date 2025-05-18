package bau.LoLSearch;

import bau.LoLSearch.models.entities.account.AccountMainInfo;
import bau.LoLSearch.models.entities.game.GameData;
import bau.LoLSearch.models.entities.GameTimeline.Timeline;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class Util {
  static public GameData jsonToGameData(String path) {
    ObjectMapper objectMapper = new ObjectMapper();

    try {
      File jsonFile = new File(path);

      return objectMapper.readValue(jsonFile, new TypeReference<GameData>() {});

    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }
  static public AccountMainInfo jsonToAccountMainInfo(String path) {
    ObjectMapper objectMapper = new ObjectMapper();

    try {
      File jsonFile = new File(path);

      return objectMapper.readValue(jsonFile, new TypeReference<AccountMainInfo>() {});

    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }
  static public Timeline jsonToTimeline(String path) {
    ObjectMapper objectMapper = new ObjectMapper();

    try {
      File jsonFile = new File(path);

      return objectMapper.readValue(jsonFile, new TypeReference<Timeline>() {});

    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }
}
