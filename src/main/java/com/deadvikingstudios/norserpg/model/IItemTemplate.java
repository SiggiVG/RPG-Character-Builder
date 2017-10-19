package com.deadvikingstudios.norserpg.model;

public interface IItemTemplate extends ITemplate
{
    enum EquipmentType //TODO: move to it's own class.
    {
        //Head
        HEAD, //helmets, hats, crowns
        FACE, //covers only the face
        EAR_LEFT,
        EAR_RIGHT,
        NECK, //scarves
        //Torso
        CHEST, //represents a suit of armor
        UNDERCHEST, //cloths/padding
        SHOULDERS, //cloaks, capes, pauldrons
        BROOCH, //cloak clasp

        WAIST, //belt
        LEGGINGS,
        FEET;
    }
}
