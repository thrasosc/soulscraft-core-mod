package net.pixeldreamstudios.soulscraft_tarnished_legacy.item.armor.client.renderer;

import mod.azure.azurelib.common.api.client.renderer.GeoArmorRenderer;
import net.pixeldreamstudios.soulscraft_tarnished_legacy.item.armor.client.model.NightRiderArmorModel;
import net.pixeldreamstudios.soulscraft_tarnished_legacy.item.armor.sets.NightRiderArmorItem;

public class NightRiderArmorRenderer extends GeoArmorRenderer<NightRiderArmorItem> {
    public NightRiderArmorRenderer() {
        super(new NightRiderArmorModel());
    }
}