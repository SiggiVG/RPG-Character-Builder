package com.deadvikingstudios.characterbuilder.model.creatures.races;

import com.deadvikingstudios.characterbuilder.model.creatures.IAbilityRolls;
import com.deadvikingstudios.characterbuilder.model.creatures.IAbilityScores;

public class RaceHumanoid extends CreatureRace implements IAbilityRolls
{
    protected String[] rolls = new String[IAbilityScores.Score.length()];

    /** height, measured in inches */
    protected int height = 60;

    static {unlocalizedNamePrefix = "humanoid";}

    public RaceHumanoid()
    {
        this("unnamed");
    }

    public RaceHumanoid(String unlocalizedName)
    {
        super( unlocalizedNamePrefix + '.' + unlocalizedName);
    }

    @Override
    public String[] getRolls()
    {
        return this.rolls.clone();
    }

    @Override
    public void setRolls(String[] rolls)
    {
        Score[] values = Score.values();
        for (int j = 0; j < rolls.length && j < values.length; j++)
        {
            setRoll(values[j], rolls[j]);
        }
    }

    @Override
    public String getRoll(Score score)
    {
        return this.rolls[score.ordinal()];
    }

    @Override
    public void setRoll(Score score, String roll)
    {
        this.rolls[score.ordinal()] = roll;
    }

    @Override
    public int[] getMods()
    {
        int[] mods = new int[scores.length];
        for (int i = 0; i < mods.length-1; i++)
        {
            mods[i] = (scores[i] - 10) / 2;
        }
        mods[Score.FAV.ordinal()] = scores[Score.FAV.ordinal()];
        return mods;
    }

    @Override
    public int getMod(Score score)
    {
        if(score == Score.FAV) return scores[Score.FAV.ordinal()];
        return (scores[score.ordinal()]-10)/2;
    }
}
