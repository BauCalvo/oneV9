package bau.LoLSearch.Controllers;

import bau.LoLSearch.Records.AccountMainInfo;
import bau.LoLSearch.Records.Exports.GameDataExport;
import bau.LoLSearch.Records.GameData;
import bau.LoLSearch.Srvices.AccountService;
import bau.LoLSearch.Srvices.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    public ResponseEntity<ArrayList<GameDataExport>> search(@PathVariable String gameName,
                                                  @PathVariable String tagLine ,
                                                  @RequestParam(required = false)String queue) {

        try {

            AccountMainInfo accountMainInfo = accountService.fetchAccountMainInfo(gameName, tagLine);
            List<String> gameIds = accountService.fetchAccountGamesIdsBypuuidAndQueue(accountMainInfo.puuid(),queue);

            ArrayList<GameDataExport> gameDataList = gameService.getGamesDataByGameId(gameIds);
            return ResponseEntity.ok(gameDataList);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.ok(null);
        }


    }
}