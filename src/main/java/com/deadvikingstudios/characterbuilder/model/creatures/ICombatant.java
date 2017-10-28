package com.deadvikingstudios.characterbuilder.model.creatures;

public interface ICombatant
{
    /** d20 + Dex + Misc */
    int rollInitiative();
    int getCurrentHealth();
    int getTempHealth();
    int getMaxHealth();
    String[] getWounds();
    int getCourage();
    int getPassivePerception();
    int getDeflection();
    int getReflexes();
    int getDefense();
    int getDefense(boolean useReflexes);
    int getDefense(boolean useReflexes, boolean useDeflection);
    int getRenown();

}
