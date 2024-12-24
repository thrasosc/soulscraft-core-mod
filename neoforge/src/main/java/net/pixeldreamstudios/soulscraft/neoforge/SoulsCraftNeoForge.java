package net.pixeldreamstudios.soulscraft.neoforge;

import net.pixeldreamstudios.soulscraft.SoulsCraft;
import net.neoforged.fml.common.Mod;

@Mod(SoulsCraft.MOD_ID)
public final class SoulsCraftNeoForge {
    public SoulsCraftNeoForge() {
        // Run our common setup.
        SoulsCraft.init();
    }
}
