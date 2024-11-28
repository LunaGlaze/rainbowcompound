package com.LunaGlaze.rainbowcompound.Core.Date;

import net.minecraftforge.common.ForgeConfigSpec;

public class LunaConfig {
    public static ForgeConfigSpec COMMON_CONFIG;
    public static ForgeConfigSpec.DoubleValue ELYTRA_SPEED;


    static {
        ForgeConfigSpec.Builder confingbuilder = new ForgeConfigSpec.Builder();
        confingbuilder.comment("Rainbow Compound settings").push("config");
        ELYTRA_SPEED = confingbuilder
                .comment("Speed multiplier for Dynamic Elytra")
                .defineInRange("dynamic_elytra_speed", 1.0d, 0.0d, Double.MAX_VALUE);

        confingbuilder.pop();
        COMMON_CONFIG = confingbuilder.build();
    }
}
