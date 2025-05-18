package bau.LoLSearch.models.entities.GameTimeline;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Timeline {
  private TimelineMetadata metadata;
  private TimelineInfo info;
}
