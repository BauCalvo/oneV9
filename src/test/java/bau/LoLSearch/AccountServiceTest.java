package bau.LoLSearch;

import bau.LoLSearch.Records.AccountMainInfo;
import bau.LoLSearch.Srvices.AccountService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class AccountServiceTest {

    @Autowired
    private AccountService accountService;

    @Test
    public void fetchAccountMainInfoTest() {
        AccountMainInfo fetchedAccountMainInfo = accountService.fetchAccountMainInfo("Paralelepipedo","NETS");
        assertThat(fetchedAccountMainInfo.equals(testAccount())).isTrue();

        AccountMainInfo fetchedFakeName = accountService.fetchAccountMainInfo("fakeName","NETS");
        assertThat(fetchedFakeName.equals(AccountMainInfo.empty())).isTrue();
    }

    @Test
    public void fetchAccountGamesIdsBypuuidAndQueueTest() {
        ArrayList<String> gameIds = accountService.fetchAccountGamesIdsBypuuidAndQueue(testAccount().puuid(),"");

        String idPattern = "^LA2_\\d{10}$";
        assertThat("LA2_1440131324").matches(idPattern);

        System.out.println(gameIds);
        assertThat(gameIds.stream().allMatch(id -> id.matches(idPattern))).isTrue();
    }


    AccountMainInfo testAccount(){
        return new AccountMainInfo(
                "pneU6bUTxo-WXRvm5cODPgQJORFaTYAjM72KWlIDOPf-XtCSLHArWYUJSDzdNJjfWQTjs3KzYDSA3g"
                ,"Paralelepipedo"
                , "NETS");
    }

}
