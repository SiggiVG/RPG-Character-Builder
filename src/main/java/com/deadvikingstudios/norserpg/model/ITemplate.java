package com.deadvikingstudios.norserpg.model;

public interface ITemplate
{
    String getTemplateName();
    int getStrength();
    int getDexterity();
    int getConstitution();
    int getSize();
    int getIntellect();
    int getWill();
    int getCharisma();
    int getDevotion();
    int getFavor();
    int[] getScores();
    int getScore(Score score);

    enum Score
    {
        STR("strength", "STR"),
        DEX("dexterity", "DEX"),
        CON("constitution", "CON"),
        SIZ("size", "SIZ"),
        INT("intellect", "INT"),
        WIL("will", "WIL"),
        CHA("charisma", "CHA"),
        DEV("devotion", "DEV"),
        FAV("favor", "FAV");

        public final String name, abbreviation;

        Score(String name, String abbreviation)
        {
            this.name = name;
            this.abbreviation = abbreviation;
        }
    }

    enum Type
    {
        CREATURE,
        ITEM,
        EFFECT;
    }
}
