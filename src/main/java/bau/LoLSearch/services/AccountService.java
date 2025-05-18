package bau.LoLSearch.services;

import bau.LoLSearch.models.entities.account.AccountMainInfo;
import java.util.ArrayList;
import java.util.Optional;

public interface AccountService {
    Optional<AccountMainInfo> fetchAccountMainInfo(String gameName, String tagLine);
    ArrayList<String> fetchAccountGamesIdsBypuuidAndQueue(String puuid, String queueId);
}
