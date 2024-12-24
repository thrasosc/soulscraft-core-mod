package net.pixeldreamstudios.soulscraft.item.armor;

import mod.azure.azurelib.common.api.common.animatable.GeoItem;
import mod.azure.azurelib.common.internal.common.util.AzureLibUtil;
import mod.azure.azurelib.core.animatable.instance.AnimatableInstanceCache;
import mod.azure.azurelib.core.animation.AnimatableManager;
import mod.azure.azurelib.core.animation.AnimationController;
import mod.azure.azurelib.core.object.PlayState;
import net.minecraft.core.Holder;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;

public abstract class SoulsCraftArmorItem extends ArmorItem implements GeoItem {
    private final AnimatableInstanceCache cache = AzureLibUtil.createInstanceCache(this);

    public SoulsCraftArmorItem(Holder<ArmorMaterial> holder, Type type) {
        super(holder, type, new Item.Properties());
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, "controllerName", 0, event ->
        {
            return PlayState.STOP;
        }));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }
}
