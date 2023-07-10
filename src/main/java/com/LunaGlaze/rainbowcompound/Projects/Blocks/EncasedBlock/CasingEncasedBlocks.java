package com.LunaGlaze.rainbowcompound.Projects.Blocks.EncasedBlock;

import com.LunaGlaze.rainbowcompound.Projects.Blocks.BlockRegistryTterrag;
import com.simibubi.create.AllBlocks;
import com.simibubi.create.AllSpriteShifts;
import com.simibubi.create.Create;
import com.simibubi.create.content.decoration.encasing.EncasingRegistry;
import com.simibubi.create.content.kinetics.simpleRelays.encased.EncasedCogCTBehaviour;
import com.simibubi.create.foundation.block.connected.AllCTTypes;
import com.simibubi.create.foundation.block.connected.CTSpriteShiftEntry;
import com.simibubi.create.foundation.block.connected.CTSpriteShifter;
import com.simibubi.create.foundation.block.connected.CTType;
import com.simibubi.create.foundation.data.BuilderTransformers;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.simibubi.create.foundation.utility.Couple;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.world.level.material.MaterialColor;

import static com.LunaGlaze.rainbowcompound.RainbowCompound.REGISTRATE;
import static com.simibubi.create.foundation.data.TagGen.axeOrPickaxe;

public class CasingEncasedBlocks {


    public static final BlockEntry<ModEncasedShaftBlock> REFINED_RADIANCE_ENCASED_SHAFT =
            REGISTRATE.block("refined_radiance_encased_shaft", p -> new ModEncasedShaftBlock(p, AllBlocks.REFINED_RADIANCE_CASING::get))
                    .properties(p -> p.color(MaterialColor.PODZOL).lightLevel((p_152686_) -> {return 12;}))
                    .transform(BuilderTransformers.encasedShaft("refined_radiance", () -> AllSpriteShifts.REFINED_RADIANCE_CASING))
                    .transform(EncasingRegistry.addVariantTo(AllBlocks.SHAFT))
                    .transform(axeOrPickaxe())
                    .register();

    public static final BlockEntry<ModEncasedShaftBlock> SHADOW_STEEL_ENCASED_SHAFT =
            REGISTRATE.block("shadow_steel_encased_shaft", p -> new ModEncasedShaftBlock(p, AllBlocks.SHADOW_STEEL_CASING::get))
                    .properties(p -> p.color(MaterialColor.PODZOL))
                    .transform(BuilderTransformers.encasedShaft("shadow_steel", () -> AllSpriteShifts.SHADOW_STEEL_CASING))
                    .transform(EncasingRegistry.addVariantTo(AllBlocks.SHAFT))
                    .transform(axeOrPickaxe())
                    .register();

    public static final BlockEntry<ModEncasedShaftBlock> OVERCHARGED_ENCASED_SHAFT =
            REGISTRATE.block("overcharged_encased_shaft", p -> new ModEncasedShaftBlock(p, BlockRegistryTterrag.OVERCHARGED_CASING::get))
                    .properties(p -> p.color(MaterialColor.PODZOL).lightLevel((p_152686_) -> {return 8;}))
                    .transform(BuilderTransformers.encasedShaft("overcharged", () -> omni("overcharged_casing")))
                    .transform(EncasingRegistry.addVariantTo(AllBlocks.SHAFT))
                    .transform(axeOrPickaxe())
                    .register();


    public static final BlockEntry<ModEncasedCogwheelBlock> REFINED_RADIANCE_ENCASED_COGWHEEL =
            REGISTRATE.block("refined_radiance_encased_cogwheel", p -> new ModEncasedCogwheelBlock(p, false, AllBlocks.REFINED_RADIANCE_CASING::get))
                    .properties(p -> p.color(MaterialColor.TERRACOTTA_BROWN).lightLevel((p_152686_) -> {return 12;}))
                    .transform(BuilderTransformers.encasedCogwheel("refined_radiance", () -> AllSpriteShifts.REFINED_RADIANCE_CASING))
                    .transform(EncasingRegistry.addVariantTo(AllBlocks.COGWHEEL))
                    .onRegister(CreateRegistrate.connectedTextures(() -> new EncasedCogCTBehaviour(AllSpriteShifts.REFINED_RADIANCE_CASING,
                            Couple.create(ModNewSpriteShifts.REFINED_RADIANCE_ENCASED_COGWHEEL_SIDE,
                                    ModNewSpriteShifts.REFINED_RADIANCE_ENCASED_COGWHEEL_OTHERSIDE))))
                    .transform(axeOrPickaxe())
                    .register();

    public static final BlockEntry<ModEncasedCogwheelBlock> SHADOW_STEEL_ENCASED_COGWHEEL =
            REGISTRATE.block("shadow_steel_encased_cogwheel", p -> new ModEncasedCogwheelBlock(p, false, AllBlocks.SHADOW_STEEL_CASING::get))
                    .properties(p -> p.color(MaterialColor.TERRACOTTA_BROWN))
                    .transform(BuilderTransformers.encasedCogwheel("shadow_steel", () -> AllSpriteShifts.SHADOW_STEEL_CASING))
                    .transform(EncasingRegistry.addVariantTo(AllBlocks.COGWHEEL))
                    .onRegister(CreateRegistrate.connectedTextures(() -> new EncasedCogCTBehaviour(AllSpriteShifts.SHADOW_STEEL_CASING,
                            Couple.create(ModNewSpriteShifts.SHADOW_STEEL_ENCASED_COGWHEEL_SIDE,
                                    ModNewSpriteShifts.SHADOW_STEEL_ENCASED_COGWHEEL_OTHERSIDE))))
                    .transform(axeOrPickaxe())
                    .register();

    public static final BlockEntry<ModEncasedCogwheelBlock> OVERCHARGED_ENCASED_COGWHEEL =
            REGISTRATE.block("overcharged_encased_cogwheel", p -> new ModEncasedCogwheelBlock(p, false, BlockRegistryTterrag.OVERCHARGED_CASING::get))
                    .properties(p -> p.color(MaterialColor.TERRACOTTA_BROWN).lightLevel((p_152686_) -> {return 8;}))
                    .transform(BuilderTransformers.encasedCogwheel("overcharged", () -> omni("overcharged_casing")))
                    .transform(EncasingRegistry.addVariantTo(AllBlocks.COGWHEEL))
                    .onRegister(CreateRegistrate.connectedTextures(() -> new EncasedCogCTBehaviour(omni("overcharged_casing"),
                            Couple.create(ModNewSpriteShifts.OVERCHARGED_ENCASED_COGWHEEL_SIDE,
                                    ModNewSpriteShifts.OVERCHARGED_ENCASED_COGWHEEL_OTHERSIDE))))
                    .transform(axeOrPickaxe())
                    .register();


    public static final BlockEntry<ModEncasedCogwheelBlock> REFINED_RADIANCE_ENCASED_LARGE_COGWHEEL =
            REGISTRATE.block("refined_radiance_encased_large_cogwheel", p -> new ModEncasedCogwheelBlock(p, true, AllBlocks.REFINED_RADIANCE_CASING::get))
                    .properties(p -> p.color(MaterialColor.PODZOL).lightLevel((p_152686_) -> {return 12;}))
                    .transform(BuilderTransformers.encasedLargeCogwheel("refined_radiance", () -> AllSpriteShifts.REFINED_RADIANCE_CASING))
                    .transform(EncasingRegistry.addVariantTo(AllBlocks.LARGE_COGWHEEL))
                    .transform(axeOrPickaxe())
                    .register();

    public static final BlockEntry<ModEncasedCogwheelBlock> SHADOW_STEEL_ENCASED_LARGE_COGWHEEL =
            REGISTRATE.block("shadow_steel_encased_large_cogwheel", p -> new ModEncasedCogwheelBlock(p, true, AllBlocks.SHADOW_STEEL_CASING::get))
                    .properties(p -> p.color(MaterialColor.PODZOL))
                    .transform(BuilderTransformers.encasedLargeCogwheel("shadow_steel", () -> AllSpriteShifts.SHADOW_STEEL_CASING))
                    .transform(EncasingRegistry.addVariantTo(AllBlocks.LARGE_COGWHEEL))
                    .transform(axeOrPickaxe())
                    .register();

    public static final BlockEntry<ModEncasedCogwheelBlock> OVERCHARGED_ENCASED_LARGE_COGWHEEL =
            REGISTRATE.block("overcharged_encased_large_cogwheel", p -> new ModEncasedCogwheelBlock(p, true, BlockRegistryTterrag.OVERCHARGED_CASING::get))
                    .properties(p -> p.color(MaterialColor.PODZOL).lightLevel((p_152686_) -> {return 8;}))
                    .transform(BuilderTransformers.encasedLargeCogwheel("refined_radiance", () -> omni("overcharged_casing")))
                    .transform(EncasingRegistry.addVariantTo(AllBlocks.LARGE_COGWHEEL))
                    .transform(axeOrPickaxe())
                    .register();




    public static CTSpriteShiftEntry omni(String name) {
        return getCT(AllCTTypes.OMNIDIRECTIONAL, name);
    }
    private static CTSpriteShiftEntry getCT(CTType type, String blockTextureName, String connectedTextureName) {
        return CTSpriteShifter.getCT(type, Create.asResource("block/" + blockTextureName), Create.asResource("block/" + connectedTextureName + "_connected"));
    }

    private static CTSpriteShiftEntry getCT(CTType type, String blockTextureName) {
        return getCT(type, blockTextureName, blockTextureName);
    }

    public static void register() {}
}
