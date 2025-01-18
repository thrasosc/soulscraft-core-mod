package net.pixeldreamstudios.soulscraft_tarnished_legacy.item.armor.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.pixeldreamstudios.soulscraft.item.armor.client.renderer.SoulsCraftArmorRenderer;
import net.pixeldreamstudios.soulscraft_tarnished_legacy.SoulsCraftTarnishedLegacy;
import net.pixeldreamstudios.soulscraft_tarnished_legacy.item.armor.client.animator.NightRiderArmorAnimator;

public class NightRiderArmorRenderer extends SoulsCraftArmorRenderer {

    public NightRiderArmorRenderer() {
        super(
                ResourceLocation.fromNamespaceAndPath(SoulsCraftTarnishedLegacy.MOD_ID, "geo/armor/night_rider.geo.json"),
                ResourceLocation.fromNamespaceAndPath(SoulsCraftTarnishedLegacy.MOD_ID, "textures/armor/night_rider.png"),
                NightRiderArmorAnimator::new
        );
    }
}