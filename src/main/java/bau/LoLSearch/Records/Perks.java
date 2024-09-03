package bau.LoLSearch.Records;

import java.util.List;

public record Perks(StatPerks statPerks, List<Style> styles){



    public record StatPerks(int defense,int flex,int offense){};

    public record Style(String description, List<Selection> selections, int style){};

    public record Selection(int perk, int var1, int var2, int var3){};

};