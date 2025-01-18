package net.pixeldreamstudios.soulscraft.item.armor;

import net.minecraft.core.Holder;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;

public abstract class SoulsCraftArmorItem extends ArmorItem {

    public SoulsCraftArmorItem(Holder<ArmorMaterial> holder, Type type) {
        super(holder, type, new Item.Properties());
    }
}
