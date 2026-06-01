package com.LunaGlaze.rainbowcompound.Projects.Blocks;

import com.LunaGlaze.rainbowcompound.LunaUtils;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class BlocksBlockRegistry {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(BuiltInRegistries.BLOCK, LunaUtils.MOD_ID);
    public static final DeferredHolder<Block, Block> refinedradianceneon = BLOCKS.register("refined_radiance_neon",RefinedRadianceNeon::new);
}
