package bau.LoLSearch.Records;

import java.util.List;

public record GameMetaData(String dataVersion, String matchId, List<String> participants) {
}
