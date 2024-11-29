package com.LunaGlaze.rainbowcompound.Linkage.elytraslot;

import com.LunaGlaze.rainbowcompound.Core.Class.ModElytraItem;
import com.illusivesoulworks.elytraslot.ElytraSlotCommonMod;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Wearable;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurio;
import top.theillusivec4.curios.api.type.capability.ICuriosItemHandler;
import top.theillusivec4.curios.api.type.inventory.ICurioStacksHandler;
import top.theillusivec4.curios.api.type.inventory.IDynamicStackHandler;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

public class CuriosModElytraItem extends ModElytraItem implements ICurio {

    public static final AttributeModifier MOD_ELYTRA_MODIFIER =
            new AttributeModifier(UUID.fromString("92b506f3-0a87-4989-a203-2ed4c7b4c1fd"),
                    "CRC Elytra modifier", 1.0D, AttributeModifier.Operation.ADDITION);
    // private final ItemStack stack = this.getStack();
    public CuriosModElytraItem(Item.Properties pProperties) {
        super(pProperties);
        DispenserBlock.registerBehavior(this, ArmorItem.DISPENSE_ITEM_BEHAVIOR);
    }

    @Override
    public ItemStack getStack() {
        return new ItemStack(this);
    }

    public boolean canEquip(SlotContext slotContext) {
        return ElytraSlotCommonMod.canEquip(slotContext.entity());
    }

    @Nonnull
    public ICurio.SoundInfo getEquipSound(SlotContext slotContext) {
        return new ICurio.SoundInfo(SoundEvents.ARMOR_EQUIP_ELYTRA, 1.0F, 1.0F);
    }

    public boolean canEquipFromUse(SlotContext slotContext) {
        return true;
    }

    @Override
    public void curioTick(SlotContext slotContext) {
        LivingEntity livingEntity = slotContext.entity();
        final ItemStack[] stack = new ItemStack[1];
        ICuriosItemHandler curiosInventory = CuriosApi.getCuriosHelper().getCuriosHandler(livingEntity).resolve().get();
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
}
