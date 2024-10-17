package bau.LoLSearch.models.entities;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GameTeam {
  List<Ban> bans;private   Objectives objectives;private   int teamId; private  boolean win;
}
