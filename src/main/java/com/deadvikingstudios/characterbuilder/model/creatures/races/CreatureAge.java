package com.deadvikingstudios.characterbuilder.model.creatures.races;

import com.deadvikingstudios.characterbuilder.model.ITemplate;
import com.deadvikingstudios.characterbuilder.model.creatures.IAbilityScores;
import com.sun.istack.internal.NotNull;

import java.util.HashMap;

public enum CreatureAge implements ITemplate, IAbilityScores//extends CreatureTemplate implements IAbilityScores
{
    //these are the stats associated with different milestones in life. When those milestones occur is dependent on race
    INFANT("infant", new int[]{-8, -8, -8, -8, -8, -8, -6, -8, -8}),
    TODDLER("toddler", new int[]{-6, -6, -6, -6, -8, -6, -4, -6, -6}),
    CHILD("child", new int[]{-4, -4, -4, -4, -4, -4, -4, -4, -4}),
    PRETEEN("preteen", new int[]{-2, -2, -2, -2, -4, -2, -4, -2, -2}),
    TEENAGER("teenager", new int[]{0, 0, 0, 0, -1, -1, -1, 0, 0}),
    ADULT("adult", new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0}),
    MIDDLE("middle", new int[]{-1, -1, -1, 0, 0, 1, 0, 0, 1}),
    ELDER("elder", new int[]{-2, -2, -2, -1, 1, 2, -1, 1, 2}),
    VENERABLE("venerable", new int[]{-3, -3, -3, -2, 2, 4, -2, 4, 3}),
    ANCIENT("ancient", new int[]{-4, -4, -4, -3, 3, 6, -3, 8, 4});

    public static final HashMap<CreatureAge, Integer> defaultMilestones = new HashMap<>();

    static
    {
        defaultMilestones.put(INFANT, 0);
        defaultMilestones.put(TODDLER, 2);
        defaultMilestones.put(CHILD, 4);
        defaultMilestones.put(PRETEEN, 10);
        defaultMilestones.put(TEENAGER, 13);
        defaultMilestones.put(ADULT, 18);
        defaultMilestones.put(MIDDLE, 40);
        defaultMilestones.put(ELDER, 65);
        defaultMilestones.put(VENERABLE, 80);
        defaultMilestones.put(ANCIENT, 100);
    }

    public String unlocalizedName;
    protected int[] scores = new int[Score.length()];

    CreatureAge(@NotNull String unlocalizedName, int[] scores)
    {
        this.unlocalizedName = "creature.age." + unlocalizedName;
        for (int i = 0; i < scores.length && i < this.scores.length; i++)
        {
            this.scores[i] = scores[i];
        }
    }

    public CreatureAge next()
    {
        if(this == ANCIENT) return ANCIENT;
        return values()[this.ordinal()+1];
    }

    public CreatureAge previous()
    {
        if(this == INFANT) return INFANT;
        return values()[this.ordinal()-1];
    }

    @Override
    public int[] getScores()
    {
        return scores.clone();
    }

    @Override
    public void setScores(int[] scores)
    {
        for (int i = 0; i < scores.length && i < this.scores.length; i++)
        {
            this.scores[i] = scores[i];
        }
    }

    @Override
    public int getScore(Score score)
    {
        return this.scores[score.ordinal()];
    }

    @Override
    public void setScore(Score score, int i)
    {
        this.scores[score.ordinal()] = i;
    }

    @Override
    public String getUnlocalizedName()
    {
        return unlocalizedName;
    }

    @Override
    public void setUnlocalizedName(String name)
    {
        this.unlocalizedName = name;
    }

    @Override
    public Type getType()
    {
        return Type.CREATURE;
    }
}
