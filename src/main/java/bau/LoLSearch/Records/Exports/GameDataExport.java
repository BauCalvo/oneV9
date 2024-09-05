package bau.LoLSearch.Records.Exports;

import bau.LoLSearch.Records.GameData;
import org.springframework.data.annotation.Id;


public record GameDataExport(@Id String matchId, int queueId, int gameDuration, long gameEndTime
        , long gameStartTime,String gameVersion,String plataformId, long gameId, GameInfoExport info)  {
    public GameDataExport(GameData data) {
        this(data.metadata().matchId(),data.info().queueId(),data.info().gameDuration()
                ,data.info().gameEndTimestamp(), data.info().gameStartTimestamp(),data.info().gameVersion()
                ,data.info().platformId(),data.info().gameId(),new GameInfoExport(data.info()));
    }
}
