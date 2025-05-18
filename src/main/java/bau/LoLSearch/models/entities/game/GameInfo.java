package bau.LoLSearch.models.entities.game;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GameInfo {
  private   long gameCreation;private   int gameDuration;
  private  long gameEndTimestamp	;private  long gameStartTimestamp; int gameId;
  private  String gameMode; private   String gameVersion;
  private  String mapId;private   List<GameParticipant> participants;
  private  String platformId;private   int queueId;private   List<GameTeam> teams;
}
