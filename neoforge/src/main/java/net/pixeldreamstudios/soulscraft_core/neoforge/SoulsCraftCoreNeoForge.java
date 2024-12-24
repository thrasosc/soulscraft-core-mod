package net.pixeldreamstudios.soulscraft_core.neoforge;

import net.pixeldreamstudios.soulscraft_core.SoulsCraftCore;
import net.neoforged.fml.common.Mod;

@Mod(SoulsCraftCore.MOD_ID)
public final class SoulsCraftCoreNeoForge {
    public SoulsCraftCoreNeoForge() {
        // Run our common setup.
        SoulsCraftCore.init();
    }
}
