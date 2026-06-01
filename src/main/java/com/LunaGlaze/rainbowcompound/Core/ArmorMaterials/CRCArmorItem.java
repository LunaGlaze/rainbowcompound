package com.LunaGlaze.rainbowcompound.Core.ArmorMaterials;

import com.LunaGlaze.rainbowcompound.LunaUtils;
import com.google.common.base.Predicates;
import net.createmod.catnip.math.VecHelper;
import net.minecraft.core.Holder;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

import java.util.function.Predicate;

public class CRCArmorItem extends ArmorItem {

    public CRCArmorItem(ArmorMaterial pMaterial, Type pSlot, Properties pProperties) {
        super(Holder.direct(pMaterial), pSlot, pProperties.stacksTo(1));
    }

    // Rainbow Item Like
    @Override
    public boolean onEntityItemUpdate(ItemStack stack, ItemEntity entity) {
        if (entity.getItem().getItem() instanceof ArmorItem) {
            if (((ArmorItem) entity.getItem().getItem()).getMaterial().is(ResourceLocation.fromNamespaceAndPath(LunaUtils.MOD_ID, "rainbow"))) {
                Level world = entity.level();
                Vec3 pos = entity.position();
                CompoundTag persistentData = entity.getPersistentData();

                if (world.isClientSide) {
                    if (world.random.nextFloat() < getIdleParticleChance(entity)) {
                        Vec3 ppos = VecHelper.offsetRandomly(pos, world.random, .5f);
                        world.addParticle(ParticleTypes.END_ROD, ppos.x, pos.y, ppos.z, 0, -.1f, 0);
                    }

                    if (entity.isSilent() && !persistentData.getBoolean("PlayEffects")) {
                        Vec3 basemotion = new Vec3(0, 1, 0);
                        world.addParticle(ParticleTypes.FLASH, pos.x, pos.y, pos.z, 0, 0, 0);
                        for (int i = 0; i < 20; i++) {
                            Vec3 motion = VecHelper.offsetRandomly(basemotion, world.random, 1);
                            world.addParticle(ParticleTypes.WITCH, pos.x, pos.y, pos.z, motion.x, motion.y, motion.z);
                            world.addParticle(ParticleTypes.END_ROD, pos.x, pos.y, pos.z, motion.x, motion.y, motion.z);
                        }
                        persistentData.putBoolean("PlayEffects", true);
                    }

                    return false;
                }

                entity.setNoGravity(true);

                if (!persistentData.contains("JustCreated"))
                    return false;
                onCreated(entity, persistentData);
                return false;
            }
        }
        return super.onEntityItemUpdate(stack, entity);
    }

    protected void onCreated(ItemEntity entity, CompoundTag persistentData) {
        entity.lifespan = 6000;
        persistentData.remove("JustCreated");

        // just a flag to tell the client to play an effect
        entity.setSilent(true);

        float yMotion = Math.max((entity.fallDistance + 3) / 50f, .25f);
        entity.setDeltaMovement(0, yMotion, 0);
    }

    protected float getIdleParticleChance(ItemEntity entity) {
        return Mth.clamp(entity.getItem()
                .getCount() - 10, (float) Math.min(5, Mth.clamp(entity.getDeltaMovement().y * 20, 5, 20)), 100) / 64f;
    }
}
