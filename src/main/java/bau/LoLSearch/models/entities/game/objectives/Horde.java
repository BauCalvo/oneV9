package bau.LoLSearch.models.entities.game.objectives;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Horde {
  private boolean first;
  private int kills;
}
