package com.deadvikingstudios.characterbuilder.model;

public class EffectTemplate implements ITemplate
{
    private String unlocalizedName;

    @Override
    public String getUnlocalizedName()
    {
        return unlocalizedName;
    }

    @Override
    public void setUnlocalizedName(String name)
    {
        this.unlocalizedName = "item" + '.' + name;
    }

    @Override
    public Type getType()
    {
        return Type.EFFECT;
    }
}
