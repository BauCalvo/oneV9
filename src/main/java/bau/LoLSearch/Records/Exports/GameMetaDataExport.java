package bau.LoLSearch.Records.Exports;


import java.sql.Timestamp;

public record GameMetaDataExport(String matchId, int queueId, int gameDuration, Timestamp gameEndTime
        , Timestamp gameStartTime,String gameVersion,String plataformId, long gameId) {

}

