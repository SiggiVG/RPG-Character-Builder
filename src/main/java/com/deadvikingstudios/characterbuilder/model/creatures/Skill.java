package com.deadvikingstudios.characterbuilder.model.creatures;

import java.util.HashMap;

public class Skill implements SkillCheck
{
    private Skill superSkill = null;
    private String unlocalizedName;
    protected Type skillType;
    protected SkillRank[] requirements;
    protected String[] tags;

    public Skill(String unlocalizedName, Type type, String... tags)
    {
        this.setUnlocalizedName(unlocalizedName);
        this.skillType = type;
        this.tags = tags;
    }

    public Skill(String unlocalizedName, Type type, Skill superSkill, SkillRank[] requirements, String... tags)
    {
        this(unlocalizedName, type, tags);
        this.superSkill = superSkill;
        this.requirements = requirements;
    }

    public Skill(String unlocalizedName, Type type, Skill superSkill, String... tags)
    {
        this(unlocalizedName, type, superSkill, null, tags);
        this.superSkill = superSkill;
    }

    public String getUnlocalizedName()
    {
        return unlocalizedName;
    }

    private void setUnlocalizedName(String unlocalizedName)
    {
        this.unlocalizedName = "skill" + '.' + unlocalizedName;
    }

    public Skill getSuperSkill()
    {
        return superSkill;
    }

    public void setSuperSkill(Skill superSkill)
    {
        this.superSkill = superSkill;
    }

    public Type getSkillType()
    {
        return skillType;
    }

    public void setSkillType(Type skillType)
    {
        this.skillType = skillType;
    }

    public enum Type
    {
        GENERIC,
        ATTACK,
        ATTRIBUTE,
        COMBAT,
        CRAFT,
        DEFENSE,
        FEAT,
        INTERACTION,
        MOVEMENT,
        PROFESSION;
    }

    private static HashMap<String, Skill> skillList = new HashMap<>();

    public static boolean addSkill(Skill skill)
    {
        if(skill != null)
        {
            if(skillList.put(skill.getUnlocalizedName(), skill) != null) return true;
        }
        return false;
    }

    public static Skill getSkill(String skillName)
    {
        return skillList.get(skillName);
    }

    public static boolean removeSkill(Skill skill)
    {
        if(skill != null)
        {
            return skillList.remove(skill.getUnlocalizedName(), skill);
        }
        return false;
    }

    public static boolean replaceSkill(Skill skill)
    {
        if(skill != null)
        {
            if(skillList.replace(skill.getUnlocalizedName(), skill) != null) return true;
        }
        return false;
    }

    static
    {
        addSkill(new Skill("athletics", Type.GENERIC, IAbilityScores.STR));
        addSkill(new Skill("brawling", Type.COMBAT, IAbilityScores.STR));
        addSkill(new Skill("grappling", Type.COMBAT, getSkill("brawling")));
        //Glima adds new maneuvers to wresting
        //addSkill(new Skill("wrestling_norse", Type.FEAT, null, new SkillRank[]{new SkillRank(getSkill("brawling"), SkillRank.Scale.HOBBY, 7)}, "regional:norsgard"));
    }
}
