package com.deadvikingstudios.characterbuilder.model.creatures;

import com.sun.istack.internal.NotNull;

public interface IAbilityScoreMods extends IAbilityScores
{
    int[] getMods();
    int getMod(@NotNull IAbilityScores.Score score);
}
