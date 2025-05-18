package bau.LoLSearch.controllers;

import bau.LoLSearch.exceptions.NullTimelineException;
import bau.LoLSearch.models.entities.GameTimeline.Timeline;
import bau.LoLSearch.services.TimelineService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@AllArgsConstructor
@RequestMapping("/")
public class TimelineController {
  private final TimelineService timelineService;

  @GetMapping("game/{matchId}")
  public Timeline getTimeline(@PathVariable String matchId) {
    return timelineService.getTimeline(matchId).orElseThrow(NullTimelineException::new);
  }
}
