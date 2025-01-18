package net.pixeldreamstudios.soulscraft_tarnished_legacy.fabric.client;

import net.fabricmc.api.ClientModInitializer;
import net.pixeldreamstudios.soulscraft_tarnished_legacy.SoulsCraftTarnishedLegacy;

public class SoulsCraftTarnishedLegacyFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        SoulsCraftTarnishedLegacy.initClient();
    }
}
