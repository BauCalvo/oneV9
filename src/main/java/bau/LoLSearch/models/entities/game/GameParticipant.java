package bau.LoLSearch.models.entities.game;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GameParticipant {
  private   int assists; private   int baronKills; private   int championId; private 
  String championName; private   int championTransform; private   int champLevel;
  private   int damageDealtToBuildings; private   int damageDealtToObjectives;
  private  int damageDealtToTurrets; private   int damageSelfMitigated;  private   int deaths;
  private  int detectorWardsPlaced; private   int dragonKills;
  private   boolean firstBloodAssist; private   boolean firstBloodKill;
  private  boolean firstTowerKill; private   int goldEarned; private  int goldSpent;
  private  int inhibitorKills; private   int inhibitorsLost;private   int inhibitorTakedowns;
  private  int item0; private   int item1; private   int item2;
  private   int item3; private   int item4;private   int item5; private   int item6;
  private  int itemsPurchased;private   int kills ;private  int magicDamageDealtToChampions;
  private   int magicDamageTaken;private   int neutralMinionsKilled;private   int participantId;
  private  int pentaKills;private Perks perks; private  int physicalDamageDealtToChampions;
  private   String puuid; private   String riotIdGameName; private  String riotIdTagline;
  private   int sightWardsBoughtInGame;   private   int summoner1Id;private   int summoner2Id;
  private   String summonerName;  private  int teamId;private   String teamPosition;
  private   int timeCCingOthers;  private   int totalAllyJungleMinionsKilled;
  private   int totalDamageDealtToChampions; private   int totalDamageShieldedOnTeammates;
  private  int totalDamageTaken;private   int totalEnemyJungleMinionsKilled;
  private   int totalHeal;private   int totalHealsOnTeammates;
  private  int totalMinionsKilled;private   int totalTimeCCDealt;
  private   int trueDamageDealtToChampions; private   int trueDamageTaken; private  int turretKills;
  private   int turretTakedowns; private   int visionScore; private   int visionWardsBoughtInGame;
  private  int wardsKilled; private   int wardsPlaced; private   boolean win;
}
