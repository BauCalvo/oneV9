package bau.LoLSearch.models.entities.GameTimeline;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParticipantTimeline {
  public int participantId;
  public String puuid;
}
