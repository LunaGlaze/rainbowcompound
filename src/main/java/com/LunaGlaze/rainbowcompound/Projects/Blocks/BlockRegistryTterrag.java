package com.LunaGlaze.rainbowcompound.Projects.Blocks;

import com.LunaGlaze.rainbowcompound.Core.Group.CreativeModeTabGroup;
import com.LunaGlaze.rainbowcompound.Projects.Blocks.EncasedBlock.ModSpriteShifts;
import com.simibubi.create.foundation.block.connected.SimpleCTBehaviour;
import com.simibubi.create.foundation.data.BuilderTransformers;
import com.tterrag.registrate.util.entry.BlockEntry;


import static com.LunaGlaze.rainbowcompound.RainbowCompound.REGISTRATE;
import static com.simibubi.create.foundation.data.CreateRegistrate.connectedTextures;

public class BlockRegistryTterrag {

    static {
        REGISTRATE.creativeModeTab(() -> CreativeModeTabGroup.group);
    }

    public static final BlockEntry<OverchargedCasing>
        OVERCHARGED_CASING = REGISTRATE.block("overcharged_casing",OverchargedCasing::new)
            .transform(BuilderTransformers.casing(() -> ModSpriteShifts.OVERCHARGED_CASING))
            .onRegister(connectedTextures(() -> new SimpleCTBehaviour(ModSpriteShifts.OVERCHARGED_CASING)))
            .properties(p -> p.lightLevel($ -> 8))
            .register();

    public static void register() {}
}
