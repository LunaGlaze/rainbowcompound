package com.LunaGlaze.rainbowcompound.Linkage.createaddition;

import com.LunaGlaze.rainbowcompound.Core.Tab.RainbowcompoundTab;
import com.LunaGlaze.rainbowcompound.Linkage.createaddition.EncasedBlock.CCAModSpriteShifts;
import com.simibubi.create.foundation.block.connected.SimpleCTBehaviour;
import com.simibubi.create.foundation.data.BuilderTransformers;
import com.tterrag.registrate.util.entry.BlockEntry;


import static com.LunaGlaze.rainbowcompound.RainbowCompound.REGISTRATE;
import static com.simibubi.create.foundation.data.CreateRegistrate.connectedTextures;

public class CCABlockRegistryTterrag {

    static {
        REGISTRATE.setCreativeTab(RainbowcompoundTab.MOD_TAB);
    }

    public static final BlockEntry<OverchargedCasing>
        OVERCHARGED_CASING = REGISTRATE.block("overcharged_casing",OverchargedCasing::new)
            .transform(BuilderTransformers.casing(() -> CCAModSpriteShifts.OVERCHARGED_CASING))
            .onRegister(connectedTextures(() -> new SimpleCTBehaviour(CCAModSpriteShifts.OVERCHARGED_CASING)))
            .properties(p -> p.lightLevel($ -> 8))
            .register();

    public static void register() {}
}
