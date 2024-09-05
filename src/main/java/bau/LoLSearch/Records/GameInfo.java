package bau.LoLSearch.Records;


import java.util.List;

public record GameInfo(String endOfGameResult, long gameCreation, int gameDuration
        , long gameEndTimestamp	,long gameStartTimestamp, int gameId, String gameMode
        , String gameName, String gameVersion, String mapId, List<GameParticipant> participants
        , String platformId, int queueId, List<GameTeam> teams, String tournamentCode, String gameType) {
}
