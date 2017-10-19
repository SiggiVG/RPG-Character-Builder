package com.deadvikingstudios.norserpg.model;

import java.util.ArrayList;
import java.util.List;

public class Creature implements ICreatureTemplate
{
    protected ICreatureRace raceTemplate;
    private List<ICreatureTemplate> creatureTemplates;
    private List<IItemTemplate> itemTemplates;
    private List<IEffectTemplate> effectTemplates;

    private int[] scores = new int[Score.values().length];

    protected Creature(ITemplate... templates)// throws IllegalArgumentException
    {
        this.creatureTemplates = new ArrayList<>();
        this.itemTemplates = new ArrayList<>();
        this.effectTemplates = new ArrayList<>();

        boolean hasRace = false;
        for(ITemplate temp : templates)
        {
           if(temp instanceof ICreatureRace && !hasRace)
           {
               this.raceTemplate = (ICreatureRace) temp;
               hasRace = true;
           }
           else if(temp instanceof ICreatureTemplate && !(temp instanceof Creature))
           {
               this.creatureTemplates.add((ICreatureTemplate) temp);
           }
           else if(temp instanceof IItemTemplate)
           {
               this.itemTemplates.add((IItemTemplate) temp);
           }
           else if(temp instanceof IEffectTemplate)
           {
               this.effectTemplates.add((IEffectTemplate) temp);
           }
        }
        if(!hasRace) throw new IllegalArgumentException("Attempted to create a Creature without a Race");

        updateScores();
    }

    private void updateScores()
    {
        int[] scr = raceTemplate.getScores();

        List<ITemplate> temps = new ArrayList<>();
        temps.addAll(creatureTemplates);
        temps.addAll(itemTemplates);
        temps.addAll(effectTemplates);

        for (ITemplate temp : temps)
        {
            for (int i = 0; i < scr.length; i++)
            {
                scr[i] += temp.getScore(ITemplate.Score.values()[i]);
            }
        }
    }

    public ICreatureRace getRace()
    {
        return raceTemplate;
    }

    public ITemplate getTemplate(ITemplate.Type type, int i)
    {
        switch (type)
        {
            case CREATURE: return this.creatureTemplates.get(i);
            case ITEM: return this.itemTemplates.get(i);
            case EFFECT: return this.effectTemplates.get(i);
        }
        return null;
    }

    @Override
    public int getStrength()
    {
        return scores[Score.STR.ordinal()];
    }

    @Override
    public int getDexterity()
    {
        return scores[Score.DEX.ordinal()];
    }

    @Override
    public int getConstitution()
    {
        return scores[Score.CON.ordinal()];
    }

    @Override
    public int getSize()
    {
        return scores[Score.SIZ.ordinal()];
    }

    @Override
    public int getIntellect()
    {
        return scores[Score.INT.ordinal()];
    }

    @Override
    public int getWill()
    {
        return scores[Score.WIL.ordinal()];
    }

    @Override
    public int getCharisma()
    {
        return scores[Score.CHA.ordinal()];
    }

    @Override
    public int getDevotion()
    {
        return scores[Score.DEV.ordinal()];
    }

    @Override
    public int getFavor()
    {
        return scores[Score.FAV.ordinal()];
    }

    @Override
    public int[] getScores()
    {
        return scores;
    }

    @Override
    public int getScore(ITemplate.Score score)
    {
        return scores[score.ordinal()];
    }

    @Override
    public String getTemplateName()
    {
        return "creature:" + this.toString();
    }


    public enum Type
    {
        BEAST("beast", "fauna"),
        BEAST_MAGICAL("beast_magical", "great_fauna"),
        CONSTRUCT("construct"),
        DRAGON("dragon"),
        GIANT("giant", "devourer"),
        HORROR("horror", "aberration"),
        HUMANOID("humanoid", "folk"),
        DEITY("deity", "great_spirit"),
        PLANT("plant", "flora"),
        SPIRIT("spirit"),
        UNDEAD("undead"),
        VERMIN("vermin");

        final String unlocalizedName;
        final String otherName;

        Type(String name)
        {
            this(name, name);
        }

        Type(String name, String otherName)
        {
            this.unlocalizedName = name;
            this.otherName = otherName;
        }

    }
}