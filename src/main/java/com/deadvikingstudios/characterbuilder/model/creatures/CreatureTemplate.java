package com.deadvikingstudios.characterbuilder.model.creatures;

import com.deadvikingstudios.characterbuilder.model.ITemplate;
import com.sun.istack.internal.NotNull;

public abstract class CreatureTemplate implements ITemplate
{
    private String unlocalizedName;
    protected static String unlocalizedNamePrefix = "creature";

    protected CreatureTemplate(@NotNull String unlocalizedName)
    {
        this.setUnlocalizedName(unlocalizedName);
    }

    @Override
    public String getUnlocalizedName()
    {
        return this.unlocalizedName;
    }

    @Override
    public void setUnlocalizedName(String unlocalizedName)
    {
        this.unlocalizedName = unlocalizedNamePrefix + '.' + unlocalizedName;
    }

    @Override
    public Type getType()
    {
        return Type.CREATURE;
    }
}
