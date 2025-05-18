package bau.LoLSearch.models.entities.account;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountMainInfo {
  private  String puuid;
  private  String gameName;
  private  String tagLine;
}
