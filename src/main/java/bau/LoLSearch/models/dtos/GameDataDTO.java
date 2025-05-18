package bau.LoLSearch.models.dtos;

import bau.LoLSearch.models.entities.game.GameInfo;
import bau.LoLSearch.models.entities.game.GameMetaData;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class GameDataDTO {
  private  GameMetaData metadata;
  private  GameInfo info;
}
