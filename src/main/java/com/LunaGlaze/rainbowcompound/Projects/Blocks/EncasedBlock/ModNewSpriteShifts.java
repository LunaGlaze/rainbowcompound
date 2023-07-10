package com.LunaGlaze.rainbowcompound.Projects.Blocks.EncasedBlock;

import com.simibubi.create.Create;
import com.simibubi.create.foundation.block.connected.AllCTTypes;
import com.simibubi.create.foundation.block.connected.CTSpriteShiftEntry;
import com.simibubi.create.foundation.block.connected.CTSpriteShifter;
import com.simibubi.create.foundation.block.connected.CTType;

public class ModNewSpriteShifts {

    public static final CTSpriteShiftEntry
            REFINED_RADIANCE_ENCASED_COGWHEEL_SIDE = vertical("refined_radiance_encased_cogwheel_side"),
            REFINED_RADIANCE_ENCASED_COGWHEEL_OTHERSIDE = horizontal("refined_radiance_encased_cogwheel_side"),
            SHADOW_STEEL_ENCASED_COGWHEEL_SIDE = vertical("shadow_steel_encased_cogwheel_side"),
            SHADOW_STEEL_ENCASED_COGWHEEL_OTHERSIDE = horizontal("shadow_steel_encased_cogwheel_side"),
            OVERCHARGED_ENCASED_COGWHEEL_SIDE = vertical("overcharged_encased_cogwheel_side"),
            OVERCHARGED_ENCASED_COGWHEEL_OTHERSIDE = horizontal("overcharged_encased_cogwheel_side");


    private static CTSpriteShiftEntry getCT(CTType type, String blockTextureName, String connectedTextureName) {
        return CTSpriteShifter.getCT(type, Create.asResource("block/" + blockTextureName), Create.asResource("block/" + connectedTextureName + "_connected"));
    }

    private static CTSpriteShiftEntry horizontal(String name) {
        return getCT(AllCTTypes.HORIZONTAL, name, name);
    }

    private static CTSpriteShiftEntry vertical(String name) {
        return getCT(AllCTTypes.VERTICAL, name, name);
    }
}
