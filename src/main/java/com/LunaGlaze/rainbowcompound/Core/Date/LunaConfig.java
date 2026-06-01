package com.LunaGlaze.rainbowcompound.Core.Date;

import net.neoforged.neoforge.common.ModConfigSpec;

public class LunaConfig {
    public static ModConfigSpec COMMON_CONFIG;

    public static ModConfigSpec.DoubleValue ELYTRA_SPEED;

    static {
        ModConfigSpec.Builder confingbuilder = new ModConfigSpec.Builder();
        confingbuilder.comment("Rainbow Compound settings").push("CRC_config");
        ELYTRA_SPEED = confingbuilder.comment("Speed multiplier for Dynamic Elytra")
                .defineInRange("dynamic_elytra_speed", 1.0d, 0.0d, Double.MAX_VALUE);

        confingbuilder.pop();
        COMMON_CONFIG = confingbuilder.build();
    }
}
