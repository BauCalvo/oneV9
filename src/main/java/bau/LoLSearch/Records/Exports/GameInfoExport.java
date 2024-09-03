package bau.LoLSearch.Records.Exports;

import bau.LoLSearch.Records.GameInfo;
import bau.LoLSearch.Records.GameParticipant;
import bau.LoLSearch.Records.GameTeam;

import java.util.ArrayList;
import java.util.List;

public record GameInfoExport(List<GameTeam> teams, ArrayList<GameParticipantExport> participants) {
    public GameInfoExport(GameInfo info) {
        this(info.teams(),trimParticpantsData(info.participants()));
    }
    private static ArrayList<GameParticipantExport> trimParticpantsData(List<GameParticipant> participants){
        ArrayList<GameParticipantExport> trimedParticipants = new ArrayList<>();
        for(GameParticipant participant : participants){
            trimedParticipants.add(new GameParticipantExport(participant));
        }
        return trimedParticipants;
    }
}
