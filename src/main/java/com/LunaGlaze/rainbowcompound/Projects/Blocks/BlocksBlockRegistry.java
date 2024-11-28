package com.LunaGlaze.rainbowcompound.Projects.Blocks;

import com.LunaGlaze.rainbowcompound.LunaUtils;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlocksBlockRegistry {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, LunaUtils.MOD_ID);
    public static final RegistryObject<Block> refinedradianceneon = BLOCKS.register("refined_radiance_neon",RefinedRadianceNeon::new);
}
