package com.deadvikingstudios.characterbuilder.model.items;

import com.deadvikingstudios.characterbuilder.model.ITemplate;

public class ItemTemplate implements ITemplate
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
        return Type.ITEM;
    }
}
