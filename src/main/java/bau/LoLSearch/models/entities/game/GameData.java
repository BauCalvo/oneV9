package bau.LoLSearch.models.entities.game;

import bau.LoLSearch.exceptions.NullGameException;
import com.mongodb.lang.NonNull;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode
@Document(collection = "Game")
public class GameData {
  @Id
  private  String matchId;

  @NonNull
  private GameMetaData metadata;
  @NonNull
  private GameInfo info;

  public GameData(@NonNull GameMetaData metadata, @NonNull GameInfo info) {

    this.metadata = metadata;
    this.info = info;

    if (metadata.getMatchId().isBlank()){
      throw new NullGameException("Match id is blank");
    }
    matchId = metadata.getMatchId();
  }

}
