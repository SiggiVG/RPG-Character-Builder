package com.deadvikingstudios.characterbuilder.model.creatures;

import com.sun.istack.internal.NotNull;

public interface IAbilityScores
{
    int[] getScores();
    void setScores(@NotNull int[] scores);
    int getScore(@NotNull String score);
    void setScore(@NotNull String score, int i);

    public class Attribute extends Skill
    {
        public final String abbreviation;
        public Attribute(String unlocalizedName, String abbreviation)
        {
            super("attribute" + '.' + unlocalizedName, Skill.Type.ATTRIBUTE);
            this.abbreviation = abbreviation;
        }
    }

    public static final Attribute STR = new Attribute("strength", "str");
    public static final Attribute DEX = new Attribute("dexterity", "dex");
    public static final Attribute CON = new Attribute("constitution", "con");
    public static final Attribute INT = new Attribute("intellect", "int");
    public static final Attribute WIL = new Attribute("willpower", "wil");
    public static final Attribute AWE = new Attribute("awareness", "awe");
    public static final Attribute CHA = new Attribute("charisma", "cha");
    public static final Attribute DEV = new Attribute("devotion", "dev");
    public static final Attribute FAV = new Attribute("favor", "fav");
}
