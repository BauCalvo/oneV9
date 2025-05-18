package bau.LoLSearch.models.entities.game;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GameTeam {
  List<Ban> bans;private Objectives objectives;private   int teamId; private  boolean win;
}
