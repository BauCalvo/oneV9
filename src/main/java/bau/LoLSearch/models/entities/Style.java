package bau.LoLSearch.models.entities;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Style {
  private  String description;private   List<Selection> selections;private   int style;
}
