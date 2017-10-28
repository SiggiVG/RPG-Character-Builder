package com.deadvikingstudios.characterbuilder.model.creatures;

import com.sun.istack.internal.NotNull;

public interface IAbilityRolls extends IAbilityScoreMods
{
    String[] getRolls();
    void setRolls(@NotNull String[] rolls);
    String getRoll(@NotNull IAbilityScores.Score score);
    void setRoll(@NotNull IAbilityScores.Score score, @NotNull String roll);
}
