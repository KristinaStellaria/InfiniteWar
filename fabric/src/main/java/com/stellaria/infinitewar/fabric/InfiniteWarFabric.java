package com.stellaria.infinitewar.fabric;

import com.stellaria.infinitewar.fabric.item.ModItemFabricFactory;
import net.fabricmc.api.ModInitializer;

import com.stellaria.infinitewar.InfiniteWar;

public final class InfiniteWarFabric implements ModInitializer {
    InfiniteWar modInstance = new InfiniteWar(new ModItemFabricFactory());

    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.

        // Run our common setup.
//        modInstance.createItems();
        modInstance.init();
    }
}
