package bau.LoLSearch.models.entities.game;

import bau.LoLSearch.models.entities.game.objectives.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Objectives {
  private  Baron baron;private  Champion champion; private Dragon dragon;private Horde horde;
  private Inhibitor inhibitor; private RiftHerald riftHerald; private Tower tower;
}
