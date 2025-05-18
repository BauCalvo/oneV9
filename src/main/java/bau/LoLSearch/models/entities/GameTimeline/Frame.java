package bau.LoLSearch.models.entities.GameTimeline;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Frame {
  private ParticipantFrames participantFrames;
  private long timestamp;
}
