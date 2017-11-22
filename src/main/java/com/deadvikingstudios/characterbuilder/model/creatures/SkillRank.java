package com.deadvikingstudios.characterbuilder.model.creatures;

public class SkillRank
{
    public final Skill skill;
    //TODO Template origin;
    public enum Scale
    {
        PRIMARY, SECONDARY, TERTRIARY, HOBBY;
    }
    public final Scale scale;
    public int rank;
    public final int limit;

    public SkillRank(Skill skill, Scale scale)
    {
        this(skill, scale, 0);
    }

    public SkillRank(Skill skill, Scale scale, int rank)
    {
        this(skill, scale, rank, Integer.MAX_VALUE);
    }

    public SkillRank(Skill skill, Scale scale, int rank, int limit)
    {
        this.skill = skill;
        this.scale = scale;
        this.rank = rank;
        this.limit = limit;
    }
}
