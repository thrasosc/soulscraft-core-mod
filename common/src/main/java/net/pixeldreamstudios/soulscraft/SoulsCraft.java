package net.pixeldreamstudios.soulscraft;

import mod.azure.azurelib.common.internal.common.AzureLib;
import net.pixeldreamstudios.soulscraft.registry.SoulsCraftItemRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class SoulsCraft {
    public static final String MOD_ID = "soulscraft";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static void init() {
        AzureLib.initialize();
        SoulsCraftItemRegistry.init();
    }
}
