package bau.LoLSearch.models.entities;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Perks {
  private  StatPerks statPerks; private  List<Style> styles;
}
