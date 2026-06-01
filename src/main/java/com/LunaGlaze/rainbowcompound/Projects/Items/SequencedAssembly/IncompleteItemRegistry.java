package com.LunaGlaze.rainbowcompound.Projects.Items.SequencedAssembly;

import com.LunaGlaze.rainbowcompound.Core.Registries.BaseRegistry;
import com.LunaGlaze.rainbowcompound.LunaUtils;
import com.simibubi.create.content.processing.sequenced.SequencedAssemblyItem;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class IncompleteItemRegistry extends BaseRegistry {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(LunaUtils.MOD_ID);

    public static final DeferredItem<SequencedAssemblyItem> incomplete_integrated_circuit = ITEMS.registerItem("incomplete_integrated_circuit", SequencedAssemblyItem::new);
    public static final DeferredItem<SequencedAssemblyItem> incomplete_radiance_mechanism = ITEMS.registerItem("incomplete_radiance_mechanism", SequencedAssemblyItem::new);
    public static final DeferredItem<SequencedAssemblyItem> incomplete_shadow_mechanism = ITEMS.registerItem("incomplete_shadow_mechanism", SequencedAssemblyItem::new);
    public static final DeferredItem<SequencedAssemblyItem> incomplete_radiance_resonant_assembly = ITEMS.registerItem("incomplete_radiance_resonant_assembly", SequencedAssemblyItem::new);
    public static final DeferredItem<SequencedAssemblyItem> incomplete_shadow_resonant_assembly = ITEMS.registerItem("incomplete_shadow_resonant_assembly", SequencedAssemblyItem::new);
}
