package bau.LoLSearch.Records.Exports;

import bau.LoLSearch.Records.GameData;


public record GameDataExport(GameMetaDataExport metadata, GameInfoExport info) {
    public GameDataExport(GameData data) {
        this(new GameMetaDataExport(data.metadata().matchId(),data.info().queueId(),data.info().gameDuration()
                ,data.info().gameEndTimestamp(), data.info().gameStartTimestamp(),data.info().gameVersion()
                ,data.info().platformId(),data.info().gameId()),new GameInfoExport(data.info()));
    }
}
