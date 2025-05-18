package bau.LoLSearch.models.entities.GameTimeline;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParticipantFrame {
  public ChampionStats championStats;
  public int currentGold;
  public DamageStats damageStats;
  public int goldPerSecond;
  public int jungleMinionsKilled;
  public int level;
  public int minionsKilled;
  public int participantId;
  public Position position;
  public int timeEnemySpentControlled;
  public int totalGold;
  public int xp;
}
