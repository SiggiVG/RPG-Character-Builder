package com.deadvikingstudios.characterbuilder.model.items;

public class ItemEquipment
{
    public final Equipment.EquipmentType equipmentType;

    public ItemEquipment(Equipment.EquipmentType equipmentType)
    {
        this.equipmentType = equipmentType;
    }

    public Equipment.EquipmentType getEquipmentType()
    {
        return equipmentType;
    }
}
