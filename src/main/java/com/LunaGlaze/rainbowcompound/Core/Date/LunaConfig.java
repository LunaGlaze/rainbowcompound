package com.LunaGlaze.rainbowcompound.Core.Date;

import net.minecraftforge.common.ForgeConfigSpec;

public class LunaConfig {
    public static ForgeConfigSpec COMMON_CONFIG;
    public static ForgeConfigSpec.DoubleValue ELYTRA_SPEED;
    public static ForgeConfigSpec.IntValue RAINBOW_ARMOR_Defense;
    public static ForgeConfigSpec.IntValue RAINBOW_ARMOR_Toughness ;
    public static ForgeConfigSpec.IntValue RAINBOW_TOOL_Damage;


    static {
        ForgeConfigSpec.Builder confingbuilder = new ForgeConfigSpec.Builder();
        confingbuilder.comment("Rainbow Compound settings").push("config");
        ELYTRA_SPEED = confingbuilder
                .comment("Speed multiplier for Dynamic Elytra")
                .defineInRange("dynamic_elytra_speed", 1.0d, 0.0d, Double.MAX_VALUE);
        RAINBOW_ARMOR_Defense = confingbuilder
                .comment("Rainbow Armor Extra Defense （On the original basis）")
                .defineInRange("rainbow_armor_exdef",0,0, Integer.MAX_VALUE);
        RAINBOW_ARMOR_Toughness = confingbuilder
                .comment("Rainbow Armor Extra Toughness （On the original basis）")
                .defineInRange("rainbow_armor_extough",0,0, Integer.MAX_VALUE);
        RAINBOW_TOOL_Damage = confingbuilder
                .comment("Rainbow Tools and Weapons Extra Damage （On the original basis）")
                .defineInRange("rainbow_tool_exdamage",0,0, Integer.MAX_VALUE);

        confingbuilder.pop();
        COMMON_CONFIG = confingbuilder.build();
    }
}
