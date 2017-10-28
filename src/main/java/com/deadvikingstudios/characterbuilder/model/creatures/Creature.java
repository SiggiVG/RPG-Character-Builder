package com.deadvikingstudios.characterbuilder.model.creatures;

import com.deadvikingstudios.characterbuilder.model.*;
import com.deadvikingstudios.characterbuilder.model.creatures.races.CreatureRace;
import com.deadvikingstudios.characterbuilder.model.items.Equipment;
import com.deadvikingstudios.characterbuilder.model.items.ItemTemplate;
import com.deadvikingstudios.characterbuilder.model.rng.DiceRoller;
import com.sun.istack.internal.NotNull;

import java.util.ArrayList;
import java.util.List;

public class Creature implements IAbilityRolls, ICombatant
{
    protected CreatureRace race;
    private List<CreatureTemplate> creatureTemplates;
    private List<ItemTemplate> itemTemplates;
    private List<EffectTemplate> effectTemplates;
    private Equipment equipment = new Equipment();

    private int[] scores = new int[Score.values().length];
    private String[] rolls = new String[Score.values().length];

    protected int currentHealth;
    protected int bonusHealth;
    private List<String> wounds = new ArrayList<String>();
    protected int courage;
    protected int renown;

    public Creature()
    {
        this.creatureTemplates = new ArrayList<>();
        this.itemTemplates = new ArrayList<>();
        this.effectTemplates = new ArrayList<>();
    }

    public Creature(@NotNull CreatureRace race, ITemplate... templates)// throws IllegalArgumentException
    {
        this.race = race;

        //might just dump all of these into a hashmap, or an insertion sort array
        this.creatureTemplates = new ArrayList<>();
        this.itemTemplates = new ArrayList<>();
        this.effectTemplates = new ArrayList<>();

        boolean hasRace = false;
        for(ITemplate temp : templates)
        {
           if(temp instanceof CreatureTemplate && !(temp instanceof CreatureRace))
           {
               this.creatureTemplates.add((CreatureTemplate) temp);
           }
           else if(temp instanceof ItemTemplate)
           {
               this.itemTemplates.add((ItemTemplate) temp);
           }
           else if(temp instanceof EffectTemplate)
           {
               this.effectTemplates.add((EffectTemplate) temp);
           }
        }

        updateScores();
    }

    //this doesnt do anything rn
    private void updateScores()
    {
        int[] scr = race.getScores();

        List<ITemplate> temps = new ArrayList<>();
        temps.addAll(creatureTemplates);
        temps.addAll(itemTemplates);
        temps.addAll(effectTemplates);

        List<IAbilityScores> list = (List<IAbilityScores>) temps.stream().filter(tmp -> (tmp instanceof IAbilityScores));

        for (IAbilityScores temp : list)
        {
            for (int i = 0; i < scr.length; i++)
            {
                scr[i] += temp.getScore(IAbilityScores.Score.values()[i]);
            }
        }
        this.setScores(scr);
    }

    public CreatureRace getRace()
    {
        return race;
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

    public void addTemplate(ITemplate template)
    {
        switch (template.getType())
        {
            case CREATURE: this.creatureTemplates.add((CreatureTemplate) template);
            case ITEM: this.itemTemplates.add((ItemTemplate) template);
            case EFFECT: this.effectTemplates.add((EffectTemplate) template);
        }
        updateScores();
    }

    public boolean removeTemplate(ITemplate.Type type, int i)
    {
        switch (type)
        {
            case CREATURE:
            {
                if (this.creatureTemplates.remove(i) != null)
                {
                    updateScores();
                    return true;
                }
                return false;
            }
            case ITEM:
            {
                if(this.itemTemplates.remove(i) != null)
                {
                    updateScores();
                    return true;
                }
                return false;
            }
            case EFFECT:
            {
                if(this.effectTemplates.remove(i) != null)
                {
                    updateScores();
                    return true;
                }
                return false;
            }
            default: return false;
        }
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
    public int getScore( Score score)
    {
        return scores[score.ordinal()];
    }

    @Override
    public void setScore(@NotNull Score score, int val)
    {
        scores[score.ordinal()] = val;
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

    @Override
    public int rollInitiative()
    {
        return DiceRoller.roll(1,20) + getMod(Score.DEX);
    }

    @Override
    public int getCurrentHealth()
    {
        return currentHealth;
    }

    @Override
    public int getTempHealth()
    {
        return bonusHealth;
    }

    @Override
    public int getMaxHealth()
    {
        //From templates
        return 0;
    }

    @Override
    public String[] getWounds()
    {
        String[] res = (String[]) this.wounds.toArray();
        return res.length > 0 ? res : null;
    }

    @Override
    public int getCourage()
    {
        return courage;
    }

    @Override
    public int getPassivePerception()
    {
        return 10 + getMod(Score.AWE); //+ from templates
    }

    @Override
    public int getDeflection()
    {
        return 0; //from armor
    }

    @Override
    public int getReflexes()
    {
        return getMod(Score.DEX);//Math.min(getMod(Score.DEX), ARMOR);
    }

    @Override
    public int getDefense()
    {
        return getDefense(true, true);
    }

    @Override
    public int getDefense(boolean useReflexes)
    {
        return getDefense(useReflexes, true);
    }

    @Override
    public int getDefense(boolean useReflexes, boolean useDeflection)
    {
        int res = 10;
        if(useReflexes) res += getReflexes();
        if(useDeflection) res += getDeflection();
        return res;
    }

    @Override
    public int getRenown()
    {
        return renown;
    }

    @Override
    public String[] getRolls()
    {
        return this.rolls.clone();
    }

    @Override
    public void setRolls(String[] rolls)
    {
        Score[] scores = Score.values();
        for (int i = 0; i < rolls.length && i < Score.length(); i++)
        {
            setRoll(scores[i], rolls[i]);
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
        if(roll.isEmpty()) roll = null;
        this.rolls[score.ordinal()] = roll;
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