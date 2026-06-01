package com.LunaGlaze.rainbowcompound.Linkage.elytraslot;

import com.LunaGlaze.rainbowcompound.Core.Class.ModElytraItem;
import com.LunaGlaze.rainbowcompound.LunaUtils;
import com.google.common.collect.Multimap;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.ItemStack;
import top.theillusivec4.caelus.api.CaelusApi;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurio;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

import java.util.Objects;
import java.util.UUID;

public class CuriosModElytraItem extends ModElytraItem implements ICurioItem {


    public CuriosModElytraItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(SlotContext slotContext, UUID uuid, ItemStack stack) {
        if (slotContext.identifier().equals("back")) {
            Multimap<Attribute, AttributeModifier> result = ICurioItem.super.getAttributeModifiers(slotContext, uuid, stack);
            result.put(CaelusApi.getInstance().getFlightAttribute(), new AttributeModifier(uuid,new ResourceLocation(LunaUtils.MOD_ID, "elytra").toString(), 1, AttributeModifier.Operation.ADDITION));
            return result;
        }
        return ((ICurio) () -> ItemStack.EMPTY).getAttributeModifiers(slotContext, uuid);
    }

    @Override
    public boolean canEquip(SlotContext slotContext, ItemStack stack) {
        AttributeInstance attribute = slotContext.entity().getAttribute(CaelusApi.getInstance().getFlightAttribute());
        if (Objects.isNull(attribute)) return false;
        return attribute.getValue() < 1;
    }
/*
    //public ItemStack stack = getStack();
    public CuriosModElytraItem(Item.Properties pProperties) {
        super(pProperties);
        DispenserBlock.registerBehavior(this, ArmorItem.DISPENSE_ITEM_BEHAVIOR);
    }

    @Override
    public ItemStack getStack() {
        return new ItemStack(this);
    }

    @Override
    public void curioTick(SlotContext slotContext) {
        LivingEntity livingEntity = slotContext.entity();
        final ItemStack[] stack = new ItemStack[1];
        if(livingEntity == null || !CuriosApi.getCuriosInventory(livingEntity).isPresent()){ return; }
        ICuriosItemHandler curiosInventory = CuriosApi.getCuriosInventory(livingEntity).resolve().get();
        AtomicBoolean hasrlytras = new AtomicBoolean(false);
        curiosInventory.getStacksHandler("back").ifPresent(slotInventory -> {
            int slotsnum = slotInventory.getSlots();
            for (int i=0 ; i<slotsnum && !hasrlytras.get(); i++){
                ItemStack stack1 = slotInventory.getStacks().getStackInSlot(i);
                if( stack1.getItem() instanceof CuriosModElytraItem){
                    hasrlytras.set(true);
                    stack[0] = stack1;
                }
            }
        });
        int ticks = livingEntity.getFallFlyingTicks();

        if (ticks > 0 && livingEntity.isFallFlying() && stack[0] != null) {
            stack[0].elytraFlightTick(livingEntity, ticks);
        }
    }
 */
}
