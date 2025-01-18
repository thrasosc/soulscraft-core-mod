package net.pixeldreamstudios.soulscraft_tarnished_legacy.item.armor.sets;

import net.pixeldreamstudios.soulscraft.item.armor.client.dispatcher.SoulsCraftArmorDispatcher;
import net.pixeldreamstudios.soulscraft.item.armor.sets.SoulsCraftArmorItem;
import net.pixeldreamstudios.soulscraft_tarnished_legacy.item.armor.TarnishedArmorMaterials;
import net.pixeldreamstudios.soulscraft_tarnished_legacy.item.armor.client.renderer.NightRiderArmorRenderer;

public class NightRiderArmorItem extends SoulsCraftArmorItem {
    // This is your class where you will setup the AzCommands/Animations you wish to play
    public final SoulsCraftArmorDispatcher DISPATCHER;

    public NightRiderArmorItem(Type type) {
        super(TarnishedArmorMaterials.NIGHT_RIDER, type, NightRiderArmorRenderer::new);
        this.DISPATCHER = new SoulsCraftArmorDispatcher();
    }
}
