package bau.LoLSearch.services;

import bau.LoLSearch.models.entities.GameTimeline.Timeline;

import java.util.Optional;

public interface TimelineService {
  Optional<Timeline> getTimeline(String matchId);
}
