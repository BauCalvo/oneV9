package bau.LoLSearch;

import bau.LoLSearch.Records.AccountMainInfo;
import bau.LoLSearch.Srvices.AccountService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class AccountServiceTest {

    @Autowired
    private AccountService accountService;

    @Autowired
    private AccountMainInfo testAccount;

    @Test
    public void fetchAccountMainInfoTest() {
        AccountMainInfo fetchedAccountMainInfo = accountService.fetchAccountMainInfo("Paralelepipedo","NETS");

        assertEquals(testAccount,fetchedAccountMainInfo);

        AccountMainInfo fetchedFakeName = accountService.fetchAccountMainInfo("fakeName","NETS");

        assertNull(fetchedFakeName);
    }

    @Test
    public void fetchAccountGamesIdsBypuuidAndQueueTest() {
        ArrayList<String> gameIds = accountService.fetchAccountGamesIdsBypuuidAndQueue(testAccount.puuid(),"");

        String idPattern = "^LA2_\\d{10}$";

        assertTrue(gameIds.stream().allMatch(id -> id.matches(idPattern)));
    }




}
