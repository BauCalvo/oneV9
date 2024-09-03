package bau.LoLSearch.Records;

public record AccountMainInfo(String puuid, String gameName, String tagLine) {
    public static AccountMainInfo empty() {
        return new AccountMainInfo("", "", "");
    }
}
