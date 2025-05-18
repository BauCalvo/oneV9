package bau.LoLSearch.services;

import bau.LoLSearch.models.entities.GameTimeline.Timeline;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TimelineServiceImpl implements TimelineService {

  private final RestTemplate restTemplate;
  @Value("${api.key}")
  private String API_KEY;

  @Override
  public Optional<Timeline> getTimeline(String matchId) {

    String url = UriComponentsBuilder
      .fromUriString("https://americas.api.riotgames.com/lol/match/v5/matches/{matchId}/timeline")
      .queryParam("api_key", API_KEY)
      .buildAndExpand(matchId)
      .toUriString();

    try {
      ResponseEntity<Timeline> response = restTemplate.getForEntity(url, Timeline.class);
      return Optional.ofNullable(response.getBody());
    }catch (Exception e) {
      return Optional.empty();
    }
  }


}
