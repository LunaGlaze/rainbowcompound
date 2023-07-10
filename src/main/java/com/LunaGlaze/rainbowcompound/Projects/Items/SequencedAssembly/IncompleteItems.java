package com.LunaGlaze.rainbowcompound.Projects.Items.SequencedAssembly;

import com.simibubi.create.content.processing.sequenced.SequencedAssemblyItem;
import com.tterrag.registrate.util.entry.ItemEntry;

import static com.LunaGlaze.rainbowcompound.RainbowCompound.REGISTRATE;

public class IncompleteItems {

    public static final ItemEntry<SequencedAssemblyItem>
            incomplete_integrated_circuit = sequencedIngredient("incomplete_integrated_circuit"),
            incomplete_radiance_mechanism = sequencedIngredient("incomplete_radiance_mechanism"),
            incomplete_shadow_mechanism = sequencedIngredient("incomplete_shadow_mechanism"),
            incomplete_radiance_resonant_assembly = sequencedIngredient("incomplete_radiance_resonant_assembly"),
            incomplete_shadow_resonant_assembly = sequencedIngredient("incomplete_shadow_resonant_assembly");

    private static ItemEntry<SequencedAssemblyItem> sequencedIngredient(String name) {
        return REGISTRATE.item(name, SequencedAssemblyItem::new)
                .register();
    }

    public static void register() {}
}
