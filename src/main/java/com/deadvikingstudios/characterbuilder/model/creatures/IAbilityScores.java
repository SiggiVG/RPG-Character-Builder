package com.deadvikingstudios.characterbuilder.model.creatures;

import com.sun.istack.internal.NotNull;

public interface IAbilityScores
{
    int[] getScores();
    void setScores(@NotNull int[] scores);
    int getScore(@NotNull Score score);
    void setScore(@NotNull Score score, int i);

    enum Score
    {
        STR("strength", "STR", 10),
        DEX("dexterity", "DEX", 10),
        CON("constitution", "CON", 10),
        AWE("awareness", "AWE", 10),
        INT("intellect", "INT", 10),
        WIL("will", "WIL", 10),
        CHA("charisma", "CHA", 10),
        DEV("devotion", "DEV", 10),
        /** Once per day, a character can change a failure to a success by rolling under their Favor score */
        FAV("favor", "FAV", 0);

        public final String name, abbreviation;
        public int average;

        Score(String name, String abbreviation, int average)
        {
            this.name = name;
            this.abbreviation = abbreviation;
            this.average = average;
        }

        public static int length()
        {
            return values().length;
        }
    }
}
