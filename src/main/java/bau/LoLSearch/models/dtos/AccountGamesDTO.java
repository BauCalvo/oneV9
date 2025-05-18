package bau.LoLSearch.models.dtos;

import bau.LoLSearch.models.entities.account.AccountMainInfo;
import lombok.*;

import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class AccountGamesDTO {
  private AccountMainInfo accountMainInfo;
  private ArrayList<GameDataDTO> games;
}
