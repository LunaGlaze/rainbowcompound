package com.LunaGlaze.rainbowcompound.Core.ArmorMaterials;


import com.LunaGlaze.rainbowcompound.LunaUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;

import static net.minecraft.world.entity.EquipmentSlot.LEGS;

public class CRCArmorItem extends ArmorItem {

    public CRCArmorItem(ArmorMaterial pMaterial, Type pSlot, Properties pProperties) {
        super(pMaterial, pSlot, pProperties.stacksTo(1));
    }

    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
        final ArmorItem armor = (ArmorItem) stack.getItem();
        final ResourceLocation TEXTURE = LunaUtils.asResource("textures/models/armor/"+ armor.getMaterial().getName() +"_layer_"+ this.slotmun(slot) +".png");
        return TEXTURE.toString();
    }

    private int slotmun(EquipmentSlot slot) {
        if (slot==LEGS){return 2;}
        else {return 1;}
    }

}
