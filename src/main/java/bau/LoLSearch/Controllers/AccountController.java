package bau.LoLSearch.Controllers;

import bau.LoLSearch.Records.AccountMainInfo;
import bau.LoLSearch.Srvices.AccountService;
import bau.LoLSearch.Srvices.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class AccountController {

    private final AccountService accountService;
    private final GameService gameService;

    @Autowired
    public AccountController(AccountService accountService, GameService gameService) {
        this.accountService = accountService;
        this.gameService = gameService;
    }

    @GetMapping("search/{gameName}/{tagLine}")
    public ResponseEntity<AccountMainInfo> search(@PathVariable String gameName,
                                                  @PathVariable String tagLine ,
                                                  @RequestParam(required = false)String queue) {

        AccountMainInfo accountMainInfo = accountService.fetchAccountMainInfo(gameName, tagLine);
        List<String> gameIds = accountService.fetchAccountGamesIdsBypuuidAndQueue(accountMainInfo.puuid(),queue);

        return ResponseEntity.ok(accountMainInfo);
    }
}