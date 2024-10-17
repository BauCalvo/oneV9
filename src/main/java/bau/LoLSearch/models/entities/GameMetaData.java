package bau.LoLSearch.models.entities;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GameMetaData {
  private  String dataVersion;private   String matchId;private   List<String> participants;
}

