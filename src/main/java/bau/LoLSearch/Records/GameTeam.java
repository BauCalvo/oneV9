package bau.LoLSearch.Records;

import java.util.List;

public record GameTeam(List<Ban> bans, Objectives objectives, int teamId, boolean win) {

    public record Ban(int championId, int pickTurn){};

    public record Objectives(
            Baron baron, Champion champion, Dragon dragon, Horde horde
            , Inhibitor inhibitor, RiftHerald riftHerald, Tower tower){};

    public record Baron(boolean first, int kills){};
    public record Champion(boolean first, int kills){};
    public record Dragon(boolean first, int kills){};
    public record Horde(boolean first, int kills){};
    public record Inhibitor(boolean first, int kills){};
    public record RiftHerald(boolean first, int kills){};
    public record Tower(boolean first, int kills){};

}
