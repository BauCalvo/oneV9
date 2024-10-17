package bau.LoLSearch.controllers;


import bau.LoLSearch.models.dtos.AccountGamesDTO;
import bau.LoLSearch.models.dtos.GameDataDTO;
import bau.LoLSearch.models.entities.AccountMainInfo;
import bau.LoLSearch.services.AccountService;
import bau.LoLSearch.services.GameService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/")
public class AccountController {

  private final AccountService accountService;
  private final GameService gameService;


  @GetMapping("search/{gameName}/{tagLine}")
  public AccountGamesDTO search(@PathVariable String gameName,
                                @PathVariable String tagLine ,
                                @RequestParam(required = false)String queue) {

      AccountMainInfo accountMainInfo = accountService.fetchAccountMainInfo(gameName, tagLine).get();
      List<String> gameIds = accountService.fetchAccountGamesIdsBypuuidAndQueue(accountMainInfo.getPuuid(),queue);
      ArrayList<GameDataDTO> games = gameService.getGamesDataByGameId(gameIds);
      return new AccountGamesDTO(accountMainInfo,games);


  }
}