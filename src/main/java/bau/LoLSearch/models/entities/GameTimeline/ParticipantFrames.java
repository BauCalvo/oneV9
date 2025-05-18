package bau.LoLSearch.models.entities.GameTimeline;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParticipantFrames {
  @JsonProperty("1")
  private ParticipantFrame participant1;
  @JsonProperty("2")
  private ParticipantFrame participant2;
  @JsonProperty("3")
  private ParticipantFrame participant3;
  @JsonProperty("4")
  private ParticipantFrame participant4;
  @JsonProperty("5")
  private ParticipantFrame participant5;
  @JsonProperty("6")
  private ParticipantFrame participant6;
  @JsonProperty("7")
  private ParticipantFrame participant7;
  @JsonProperty("8")
  private ParticipantFrame participant8;
  @JsonProperty("9")
  private ParticipantFrame participant9;
  @JsonProperty("10")
  private ParticipantFrame participant10;
}
