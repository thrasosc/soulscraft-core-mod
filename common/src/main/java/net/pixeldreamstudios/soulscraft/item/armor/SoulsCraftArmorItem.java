package net.pixeldreamstudios.soulscraft.item.armor;

import mod.azure.azurelib.rewrite.render.armor.AzArmorRenderer;
import net.minecraft.core.Holder;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;

import java.util.function.Supplier;

public abstract class SoulsCraftArmorItem extends ArmorItem {
    public final Supplier<AzArmorRenderer> RENDERER;

    public SoulsCraftArmorItem(Holder<ArmorMaterial> holder, Type type, Supplier<AzArmorRenderer> soulsCraftArmorRenderer) {
        super(holder, type, new Item.Properties());
        this.RENDERER = soulsCraftArmorRenderer;
    }
}
