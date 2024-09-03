package bau.LoLSearch.Records.Exports;

import bau.LoLSearch.Records.GameParticipant;
import bau.LoLSearch.Records.Perks;

public record GameParticipantExport(int teamId, int champLvl, int summonerSpell1, int summonerSpell2,
                                    Perks perks,int kills,int deaths, int asists,int totalDamageDelt,
                                    int totalDamageTaken,int visionScore,int wardsKilled,int wardsPlaced,
                                    int pinks, int totalMinionsKilled, int goldEarned, int item0,
                                    int item1, int item2, int item3, int item4, int item5, int item6,
                                    String riotIdGameName,String teamPosition,String puuid) {

    public GameParticipantExport(GameParticipant participant) {
        this(participant.teamId(),participant.champLevel(),participant.summoner1Id(),participant.summoner2Id()
                ,participant.perks(),participant.kills(),participant.deaths(),participant.assists()
                ,participant.totalDamageDealt(),participant.totalDamageTaken(),participant.visionScore(),
                participant.wardsKilled(),participant.wardsPlaced(),participant.detectorWardsPlaced(),
                participant.totalMinionsKilled(),participant.goldEarned(),participant.item0(),participant.item1(),
                participant.item2(),participant.item3(),participant.item4(),participant.item5(),participant.item6(),
                participant.riotIdGameName(), participant.teamPosition(), participant.puuid());
    }
}
