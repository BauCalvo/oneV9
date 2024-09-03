package bau.LoLSearch;

import bau.LoLSearch.Records.AccountMainInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AccountControllerTest {

	@Autowired
	TestRestTemplate restTemplate;

	@Autowired
	private ObjectMapper objectMapper;


//
//	@Test
//	void searchFindsAccount() {
//		ResponseEntity<AccountMainInfo> response = restTemplate.getForEntity("/search/Paralelepipedo/NETS", AccountMainInfo.class);
//
//		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
//		assertThat(response.getBody()).isEqualTo(testAccount());
//
//	}
//
//	@Test
//	void searchFoundNone() {
//		ResponseEntity<AccountMainInfo> response = restTemplate.getForEntity("/search/FakeName/NETS", AccountMainInfo.class);
//		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
//		assertThat(response.getBody()).isEqualTo(AccountMainInfo.empty());
//	}
//
//	AccountMainInfo testAccount(){
//		return new AccountMainInfo(
//				"pneU6bUTxo-WXRvm5cODPgQJORFaTYAjM72KWlIDOPf-XtCSLHArWYUJSDzdNJjfWQTjs3KzYDSA3g"
//				,"Paralelepipedo"
//				, "NETS");
//	}

}
