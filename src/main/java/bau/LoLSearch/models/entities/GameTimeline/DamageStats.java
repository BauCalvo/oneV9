package bau.LoLSearch.models.entities.GameTimeline;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DamageStats {
  public int magicDamageDone;
  public int magicDamageDoneToChampions;
  public int magicDamageTaken;
  public int physicalDamageDone;
  public int physicalDamageDoneToChampions;
  public int physicalDamageTaken;
  public int totalDamageDone;
  public int totalDamageDoneToChampions;
  public int totalDamageTaken;
  public int trueDamageDone;
  public int trueDamageDoneToChampions;
  public int trueDamageTaken;
}
