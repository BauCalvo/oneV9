package bau.LoLSearch.models.entities.GameTimeline;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TimelineInfo {
  public String endOfGameResult;
  public long frameInterval;
  public ArrayList<Frame> frames;
  public long gameId;
  public ArrayList<ParticipantTimeline> participants;
}
