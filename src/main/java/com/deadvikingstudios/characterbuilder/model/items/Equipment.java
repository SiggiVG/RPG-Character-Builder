package com.deadvikingstudios.characterbuilder.model.items;

public class Equipment
{
    protected ItemEquipment[] equipment = new ItemEquipment[EquipmentType.values().length];

    public ItemEquipment[] getAllEquipment()
    {
        return equipment.clone();
    }

    public ItemEquipment getEquipment(EquipmentType slot)
    {
        return equipment[slot.ordinal()];
    }

    //returns the item that was previously equipped
    public ItemEquipment equip(ItemEquipment item)
    {
        ItemEquipment eq = equipment[item.getEquipmentType().ordinal()];
        equipment[item.getEquipmentType().ordinal()] = item;
        return eq;
    }

    public ItemEquipment unequip(EquipmentType slot)
    {
        ItemEquipment eq = equipment[slot.ordinal()];
        equipment[slot.ordinal()] = null;
        return eq;
    }

    enum EquipmentType //TODO: move to it's own class.
    {
        //Head
        HEAD, //helmets, hats, crowns
        FACE, //covers only the face
        EYES, //glasses, blindfolds
        EAR_LEFT,
        EAR_RIGHT,
        NECK, //scarves
        //Torso
        CHEST, //represents a suit of armor
        CLOTHING, //cloths/padding
        SHOULDERS, //cloaks, capes, pauldrons
        BROOCH, //cloak clasp

        WAIST, //belt
        LEGGINGS,
        FEET;
    }
}
