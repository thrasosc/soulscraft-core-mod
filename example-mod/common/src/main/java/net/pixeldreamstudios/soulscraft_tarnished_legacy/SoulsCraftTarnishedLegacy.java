package net.pixeldreamstudios.soulscraft_tarnished_legacy;

import mod.azure.azurelib.common.internal.common.AzureLib;
import net.pixeldreamstudios.soulscraft.registry.SoulsCraftItemRegistry;
import net.pixeldreamstudios.soulscraft_tarnished_legacy.registry.ItemRegistry;

public final class SoulsCraftTarnishedLegacy {
    public static final String MOD_ID = "soulscraft_tarnished_legacy";

    public static void init() {
        AzureLib.initialize();
        ItemRegistry.init();
        // CALL AFTER REGISTERING ITEMS
        SoulsCraftItemRegistry.init(SoulsCraftTarnishedLegacy.MOD_ID);
    }

    public static void initClient() {
        SoulsCraftItemRegistry.initClient(MOD_ID);
    }
}
