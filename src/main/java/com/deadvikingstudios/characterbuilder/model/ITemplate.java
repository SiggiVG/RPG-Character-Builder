package com.deadvikingstudios.characterbuilder.model;

import com.sun.istack.internal.NotNull;

public interface ITemplate
{
    String getUnlocalizedName();
    void setUnlocalizedName(@NotNull String name);

    Type getType();

    enum Type
    {
        CREATURE,
        ITEM,
        EFFECT;
    }
}
