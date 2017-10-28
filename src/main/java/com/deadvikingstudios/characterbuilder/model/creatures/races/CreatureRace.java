package com.deadvikingstudios.characterbuilder.model.creatures.races;

import com.deadvikingstudios.characterbuilder.model.creatures.Creature;
import com.deadvikingstudios.characterbuilder.model.creatures.CreatureTemplate;
import com.deadvikingstudios.characterbuilder.model.creatures.IAbilityRolls;
import com.deadvikingstudios.characterbuilder.model.creatures.IAbilityScores;
import com.sun.istack.internal.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class CreatureRace extends CreatureTemplate implements IAbilityScores
{
    protected int[] scores = new int[Score.length()];

    static {
        unlocalizedNamePrefix = "race";
    }

    protected int[] ageMilestones = new int[CreatureAge.values().length];

    public CreatureRace()
    {
        this("unnamed");
    }

    protected CreatureRace(@NotNull String unlocalizedName)
    {
        super(unlocalizedNamePrefix + '.' + unlocalizedName);
        for (int i = 0; i < scores.length-1; i++)
        {
            this.scores[i] = 10;
        }
        this.scores[Score.FAV.ordinal()] = 0;
    }

    @Override
    public int[] getScores()
    {
        return scores.clone();
    }

    @Override
    public void setScores(int[] vals)
    {
        Score[] values = Score.values();
        for (int j = 0; j < vals.length && j < values.length; j++)
        {
            setScore(values[j], vals[j]);
        }
    }

    @Override
    public int getScore(Score score)
    {
        return scores[score.ordinal()];
    }

    @Override
    public void setScore(Score score, int val)
    {
        scores[score.ordinal()] = val;
    }

    @Override
    public Type getType()
    {
        return Type.CREATURE;
    }

    public static final HashMap<String, CreatureRace> races = new HashMap<>();

    public static CreatureRace addRace(final CreatureRace race)
    {
        races.put(race.getUnlocalizedName(), race);
        return race;
    }


}
