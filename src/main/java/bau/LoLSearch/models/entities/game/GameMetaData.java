package bau.LoLSearch.models.entities.game;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GameMetaData {
  private  String dataVersion;private   String matchId;private   List<String> participants;
}

