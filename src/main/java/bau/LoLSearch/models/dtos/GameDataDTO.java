package bau.LoLSearch.models.dtos;

import bau.LoLSearch.models.entities.GameInfo;
import bau.LoLSearch.models.entities.GameMetaData;
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
