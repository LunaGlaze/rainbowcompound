package com.LunaGlaze.rainbowcompound.Core.Class;

import com.LunaGlaze.rainbowcompound.Core.Date.KeyBoard.ElytraFlyKey;
import com.LunaGlaze.rainbowcompound.Core.Date.LunaConfig;
import com.LunaGlaze.rainbowcompound.Core.Tab.RainbowcompoundTab;
import com.LunaGlaze.rainbowcompound.Projects.Items.Basic.ItemsItemRegistry;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.UUID;

@Mod.EventBusSubscriber
public class RainbowElytra extends ModElytraItem implements Equipable {

    private static final UUID uuid = UUID.fromString("D8499B04-0E66-4726-AB29-64469D734E0D");
    private final Multimap<Attribute, AttributeModifier> defaultModifiers;

    public RainbowElytra() {
        super(new Properties().fireResistant().durability(1632).rarity(Rarity.UNCOMMON));
        DispenserBlock.registerBehavior(this, ArmorItem.DISPENSE_ITEM_BEHAVIOR);
        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
        int defense = this.getDefense();
        float toughness = this.getToughness();
        builder.put(Attributes.ARMOR, new AttributeModifier(uuid, "Armor modifier", defense, AttributeModifier.Operation.ADDITION));
        builder.put(Attributes.ARMOR_TOUGHNESS, new AttributeModifier(uuid, "Armor modifier", toughness, AttributeModifier.Operation.ADDITION));
        this.defaultModifiers = builder.build();
    }

    @Override
    public boolean isFoil(ItemStack stack) {
        return true;
    }

    @Override
    public boolean isValidRepairItem(ItemStack pToRepair, ItemStack pRepair) {
        return pRepair.is(ItemsItemRegistry.rainbowcompound.get());
    }
    private int getDefense(){
        return 6;
    }

    private float getToughness(){
        return 3;
    }

    @Override
    public int getEnchantmentValue() {
        return 18;
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot pEquipmentSlot) {
        return pEquipmentSlot == EquipmentSlot.CHEST ? this.defaultModifiers : super.getDefaultAttributeModifiers(pEquipmentSlot);
    }

    @SubscribeEvent(priority = EventPriority.LOW)
    @OnlyIn(Dist.CLIENT)
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        Player player = event.player;
        Item item = player.getItemBySlot(EquipmentSlot.CHEST).getItem();
        if (player.isFallFlying() && item instanceof RainbowElytra && ElytraFlyKey.ELYTRA_FLY_KEY.isPressed()) {
            Vec3 lookAngle = player.getLookAngle();
            Vec3 flyAngle = player.getDeltaMovement();
            double d = 0.1;
            double i = 1.5;
            double t = 0.5;
            double c = LunaConfig.ELYTRA_SPEED.get();
            player.setDeltaMovement(flyAngle.add(
                    (lookAngle.x * d + (lookAngle.x * i - flyAngle.x) * t) * c,
                    (lookAngle.y * d + (lookAngle.y * i - flyAngle.y) * t) * c,
                    (lookAngle.z * d + (lookAngle.z * i - flyAngle.z) * t) * c));
        }
    }

    @Override
    public boolean elytraFlightTick(ItemStack stack, net.minecraft.world.entity.LivingEntity entity, int flightTicks) {
        if(!entity.level().isClientSide) {
            int nextFlightTick = flightTicks + 1;
            if (nextFlightTick % 10 == 0) {
                if ((flightTicks) % 25 == 0 && ElytraFlyKey.ELYTRA_FLY_KEY.isPressed()) {
                    stack.hurtAndBreak(1, entity, e -> e.broadcastBreakEvent(net.minecraft.world.entity.EquipmentSlot.CHEST));
                }
                entity.gameEvent(GameEvent.ELYTRA_GLIDE);
            }
        }
        return true;
    }
}