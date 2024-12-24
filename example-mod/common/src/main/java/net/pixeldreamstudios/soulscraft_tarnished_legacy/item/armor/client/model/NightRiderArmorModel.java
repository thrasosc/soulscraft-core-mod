package net.pixeldreamstudios.soulscraft_tarnished_legacy.item.armor.client.model;

import net.minecraft.resources.ResourceLocation;
import net.pixeldreamstudios.soulscraft.item.armor.client.model.CapeArmorModel;
import net.pixeldreamstudios.soulscraft_tarnished_legacy.SoulsCraftTarnishedLegacy;
import net.pixeldreamstudios.soulscraft_tarnished_legacy.item.armor.sets.NightRiderArmorItem;

public class NightRiderArmorModel extends CapeArmorModel<NightRiderArmorItem> {
    private static final ResourceLocation model = ResourceLocation.fromNamespaceAndPath(SoulsCraftTarnishedLegacy.MOD_ID, "geo/armor/night_rider.geo.json");
    private static final ResourceLocation texture = ResourceLocation.fromNamespaceAndPath(SoulsCraftTarnishedLegacy.MOD_ID, "textures/armor/night_rider.png");
    private static final ResourceLocation animation = ResourceLocation.fromNamespaceAndPath(SoulsCraftTarnishedLegacy.MOD_ID, "animations/armor/night_rider.animation.json");

    @Override
    public ResourceLocation getModelResource(NightRiderArmorItem nightArmorItem) {
        return model;
    }

    @Override
    public ResourceLocation getTextureResource(NightRiderArmorItem nightArmorItem) {
        return texture;
    }

    @Override
    public ResourceLocation getAnimationResource(NightRiderArmorItem nightArmorItem) {
        return animation;
    }
}