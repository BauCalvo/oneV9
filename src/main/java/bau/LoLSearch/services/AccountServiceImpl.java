package bau.LoLSearch.services;

import bau.LoLSearch.exceptions.AccountNotFoundException;
import bau.LoLSearch.exceptions.ErrorResponse;
import bau.LoLSearch.models.entities.AccountMainInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {


  private final RestTemplate restTemplate;


  public AccountServiceImpl(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  @Value("${api.key}")
  private String API_KEY;

  @Override
  public Optional<AccountMainInfo> fetchAccountMainInfo(String gameName, String tagLine) {
    String url = UriComponentsBuilder
      .fromUriString("https://americas.api.riotgames.com/riot/account/v1/accounts/by-riot-id/{gameName}/{tagLine}")
      .queryParam("api_key", API_KEY)
      .buildAndExpand(gameName, tagLine)
      .toUriString();

    Optional<AccountMainInfo> account = Optional.empty();
    try {
      ResponseEntity<AccountMainInfo> response = restTemplate.getForEntity(url, AccountMainInfo.class);
      if (response.getBody() != null) {
        account = Optional.of(response.getBody());
      }
      else {
        throw new AccountNotFoundException("Account not found");
      }
    } catch (HttpClientErrorException e) {


      ErrorResponse response = e.getResponseBodyAs(ErrorResponse.class);
      throw new AccountNotFoundException(response.getStatus().getMessage());
    }
    return account;
  }

  @Override
  public ArrayList<String> fetchAccountGamesIdsBypuuidAndQueue(String puuid, String queueId) {
    Optional<String> queue = Optional.ofNullable(queueId);

    String url = UriComponentsBuilder
      .fromUriString("https://americas.api.riotgames.com/lol/match/v5/matches/by-puuid/{puuid}/ids")
      .queryParam("api_key", API_KEY)
      .queryParamIfPresent("queue", queue)
      .buildAndExpand(puuid)
      .toUriString();

    try {
      ResponseEntity<ArrayList<String>> response = restTemplate.exchange
        (url, HttpMethod.GET, null, new ParameterizedTypeReference<ArrayList<String>>() {});

      return response.getBody();
    } catch (RestClientException e) {
      return null;
    }
  }
}
