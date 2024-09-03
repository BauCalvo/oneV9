package bau.LoLSearch.Srvices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;
import bau.LoLSearch.Records.AccountMainInfo;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class AccountService {


    private final RestTemplate restTemplate;
    @Autowired
    public AccountService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Value("${api.key}")
    private String API_KEY;

    public AccountMainInfo fetchAccountMainInfo(String gameName, String tagLine) {
        String url = UriComponentsBuilder
                .fromUriString("https://americas.api.riotgames.com/riot/account/v1/accounts/by-riot-id/{gameName}/{tagLine}")
                .queryParam("api_key", API_KEY)
                .buildAndExpand(gameName, tagLine)
                .toUriString();

        try {
            ResponseEntity<AccountMainInfo> response = restTemplate.getForEntity(url, AccountMainInfo.class);
            return response.getBody();
        } catch (RestClientException e) {
            return AccountMainInfo.empty();
        }
    }

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
            return new ArrayList<>();
        }
    }
}
