package bau.LoLSearch.services;

import bau.LoLSearch.Util;
import bau.LoLSearch.models.entities.account.AccountMainInfo;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class AccountServiceTest {


  @Autowired
  private AccountService accountService;

  private static AccountMainInfo testAccount;

  @BeforeAll
  static void beforeAll() {
    testAccount = Util.jsonToAccountMainInfo("src/test/java/bau/LoLSearch/testAccount.json");
  }

  @Test
  public void fetchAccountMainInfoTest() {
    AccountMainInfo fetchedAccountMainInfo = accountService.fetchAccountMainInfo("Paralelepipedo","NETS").get();
    assertEquals(testAccount,fetchedAccountMainInfo);

  }

  @Test
  public void fetchAccountGamesIdsBypuuidAndQueueTest() {
    ArrayList<String> gameIds = accountService.fetchAccountGamesIdsBypuuidAndQueue(testAccount.getPuuid(),"");

    String idPattern = "^LA2_\\d{10}$";
    assertThat("LA2_1440131324").matches(idPattern);

    System.out.println(gameIds);
    assertThat(gameIds.stream().allMatch(id -> id.matches(idPattern))).isTrue();
  }

}