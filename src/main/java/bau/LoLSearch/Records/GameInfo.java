package bau.LoLSearch.Records;

import java.sql.Timestamp;
import java.util.List;

public record GameInfo(String endOfGameResult, Timestamp gameCreation, int gameDuration
        , Timestamp gameEndTimestamp,Timestamp gameStartTimestamp, int gameId, String gameMode
        , String gameName, String gameVersion, String mapId, List<GameParticipant> participants
        , String platformId, int queueId, List<GameTeam> teams, String tournamentCode) {
}
