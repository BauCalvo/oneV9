package bau.LoLSearch.models.entities;

import bau.LoLSearch.models.entities.objectives.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Objectives {
  private  Baron baron;private  Champion champion; private  Dragon dragon;private  Horde horde;
  private  Inhibitor inhibitor; private  RiftHerald riftHerald; private  Tower tower;
}
