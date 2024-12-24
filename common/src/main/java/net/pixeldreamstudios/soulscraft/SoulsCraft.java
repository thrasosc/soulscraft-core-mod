package net.pixeldreamstudios.soulscraft;

import mod.azure.azurelib.common.internal.common.AzureLib;
import net.pixeldreamstudios.soulscraft.registry.SoulsCraftItemRegistry;

public final class SoulsCraft {
    public static final String MOD_ID = "soulscraft";

    public static void init() {
        AzureLib.initialize();
        SoulsCraftItemRegistry.init();
    }
}
