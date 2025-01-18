package net.pixeldreamstudios.soulscraft_tarnished_legacy.neoforge;

import dev.architectury.utils.EnvExecutor;
import net.neoforged.api.distmarker.Dist;
import net.pixeldreamstudios.soulscraft_tarnished_legacy.SoulsCraftTarnishedLegacy;
import net.neoforged.fml.common.Mod;

@Mod(SoulsCraftTarnishedLegacy.MOD_ID)
public final class SoulsCraftTarnishedLegacyNeoForge {
    public SoulsCraftTarnishedLegacyNeoForge() {
        // Run our common setup.
        SoulsCraftTarnishedLegacy.init();
        EnvExecutor.runInEnv(Dist.CLIENT, () -> SoulsCraftTarnishedLegacy::initClient);
    }
}
