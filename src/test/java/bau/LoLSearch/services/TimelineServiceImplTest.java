package bau.LoLSearch.services;

import bau.LoLSearch.Util;
import bau.LoLSearch.models.entities.GameTimeline.Timeline;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class TimelineServiceImplTest {

  @Autowired
  private TimelineService timelineService;
  private static Timeline testTimeline;


  @BeforeAll
  static void beforeAll() {
    testTimeline = Util.jsonToTimeline("src/test/java/bau/LoLSearch/testTimeline.json");
  }


  @Test
  void getTimeline() {
    Timeline gameTimeline = timelineService.getTimeline("LA2_1441579110").get();
    assertEquals(testTimeline, gameTimeline);
  }
}