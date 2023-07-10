package com.LunaGlaze.rainbowcompound.Core.Curios;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import top.theillusivec4.curios.api.SlotTypeMessage;
import top.theillusivec4.curios.api.SlotTypePreset;

public class Curios {
    public static void init(IEventBus modEventBus, IEventBus forgeEventBus) {
        modEventBus.addListener(Curios::onInterModEnqueue);
    }

    private static void onInterModEnqueue(final InterModEnqueueEvent event) {
        InterModComms.sendTo("curios", SlotTypeMessage.REGISTER_TYPE, () -> SlotTypePreset.RING.getMessageBuilder()
                .build());
    }
}
