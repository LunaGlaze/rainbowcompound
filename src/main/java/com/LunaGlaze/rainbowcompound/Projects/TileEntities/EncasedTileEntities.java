package com.LunaGlaze.rainbowcompound.Projects.TileEntities;


import com.LunaGlaze.rainbowcompound.Projects.Blocks.EncasedBlock.CasingEncasedBlocks;
import com.simibubi.create.content.kinetics.base.KineticBlockEntity;
import com.simibubi.create.content.kinetics.base.ShaftInstance;
import com.simibubi.create.content.kinetics.base.ShaftRenderer;
import com.simibubi.create.content.kinetics.simpleRelays.SimpleKineticBlockEntity;
import com.simibubi.create.content.kinetics.simpleRelays.encased.EncasedCogInstance;
import com.simibubi.create.content.kinetics.simpleRelays.encased.EncasedCogRenderer;
import com.tterrag.registrate.util.entry.BlockEntityEntry;

import static com.LunaGlaze.rainbowcompound.RainbowCompound.REGISTRATE;

public class EncasedTileEntities {
    public static final BlockEntityEntry<KineticBlockEntity> ENCASED_SHAFT = REGISTRATE
            .blockEntity("encased_shaft", KineticBlockEntity::new)
            .instance(() -> ShaftInstance::new, false)
            .validBlocks(CasingEncasedBlocks.REFINED_RADIANCE_ENCASED_SHAFT,CasingEncasedBlocks.SHADOW_STEEL_ENCASED_SHAFT,CasingEncasedBlocks.OVERCHARGED_ENCASED_SHAFT)
            .renderer(() -> ShaftRenderer::new)
            .register();

    public static final BlockEntityEntry<SimpleKineticBlockEntity> ENCASED_COGWHEEL = REGISTRATE
            .blockEntity("encased_cogwheel", SimpleKineticBlockEntity::new)
            .instance(() -> EncasedCogInstance::small, false)
            .validBlocks(CasingEncasedBlocks.REFINED_RADIANCE_ENCASED_COGWHEEL,CasingEncasedBlocks.SHADOW_STEEL_ENCASED_COGWHEEL,CasingEncasedBlocks.OVERCHARGED_ENCASED_COGWHEEL)
            .renderer(() -> EncasedCogRenderer::small)
            .register();

    public static final BlockEntityEntry<SimpleKineticBlockEntity> ENCASED_LARGE_COGWHEEL = REGISTRATE
            .blockEntity("encased_large_cogwheel", SimpleKineticBlockEntity::new)
            .instance(() -> EncasedCogInstance::large, false)
            .validBlocks(CasingEncasedBlocks.REFINED_RADIANCE_ENCASED_LARGE_COGWHEEL,CasingEncasedBlocks.SHADOW_STEEL_ENCASED_LARGE_COGWHEEL,CasingEncasedBlocks.OVERCHARGED_ENCASED_LARGE_COGWHEEL)
            .renderer(() -> EncasedCogRenderer::large)
            .register();

    public static void register() {}
}
