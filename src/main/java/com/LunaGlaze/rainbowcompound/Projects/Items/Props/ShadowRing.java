package com.LunaGlaze.rainbowcompound.Projects.Items.Props;

import com.LunaGlaze.rainbowcompound.LunaUtils;
import com.LunaGlaze.rainbowcompound.Projects.Effect.EffectRegistry;
import com.LunaGlaze.rainbowcompound.Projects.Items.Armors.ArmorsItemRegistry;
import com.google.common.collect.Multimap;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

import javax.annotation.Nullable;
import java.util.List;
import java.util.UUID;

public class ShadowRing extends Item implements ICurioItem {

    public ShadowRing() {
        super(new Properties().rarity(Rarity.UNCOMMON).stacksTo(1));
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(SlotContext slotContext, UUID uuid, ItemStack stack) {
        Multimap<Attribute, AttributeModifier> result = ICurioItem.super.getAttributeModifiers(slotContext, uuid, stack);
        result.put(Attributes.ATTACK_SPEED,
                new AttributeModifier(uuid, new ResourceLocation(LunaUtils.MOD_ID, "shadow_ring_attack_speed").toString(),
                        0.1, AttributeModifier.Operation.ADDITION));
        return result;
    }

    @Override
    public void curioTick(SlotContext slotContext, ItemStack stack) {
        LivingEntity livingEntity = slotContext.entity();
        int i = RainbowKit(slotContext);
        if(i>0 && livingEntity.level().isNight()){
            livingEntity.addEffect(new MobEffectInstance(EffectRegistry.resonance_rainbow.get(),20,i-1));
        }else removeAttributeModifiers(livingEntity);
    }

    public int RainbowKit(SlotContext slotContext) {
        int i = 0;
        LivingEntity livingEntity = slotContext.entity();
        Item head = livingEntity.getItemBySlot(EquipmentSlot.HEAD).getItem();
        Item chest = livingEntity.getItemBySlot(EquipmentSlot.CHEST).getItem();
        Item legs = livingEntity.getItemBySlot(EquipmentSlot.LEGS).getItem();
        Item feet = livingEntity.getItemBySlot(EquipmentSlot.FEET).getItem();
        if(head == ArmorsItemRegistry.rainbowhelmet.get()){
            i=i+1;
        }
        if(chest == ArmorsItemRegistry.rainbowchestplate.get()){
            i=i+1;
        }
        if(legs == ArmorsItemRegistry.rainbowleggings.get()){
            i=i+1;
        }
        if(feet == ArmorsItemRegistry.rainbowboots.get()){
            i=i+1;
        }
        return i;
    }

    public void removeAttributeModifiers(LivingEntity pLivingEntity) {
        if (pLivingEntity.getHealth() > pLivingEntity.getMaxHealth()) {
            pLivingEntity.setHealth(pLivingEntity.getMaxHealth());
        }
    }

    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag isAdvanced){
        tooltip.add(Component.translatable(LunaUtils.MOD_ID + ".tooltip.shadowring", new Object[0]).withStyle(ChatFormatting.BLUE));
    }

}
