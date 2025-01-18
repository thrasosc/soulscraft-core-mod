package net.pixeldreamstudios.soulscraft.item.armor.client;

import mod.azure.azurelib.rewrite.animation.AzAnimator;
import mod.azure.azurelib.rewrite.render.AzRendererConfig;
import mod.azure.azurelib.rewrite.render.armor.AzArmorRenderer;
import mod.azure.azurelib.rewrite.render.armor.AzArmorRendererConfig;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

import java.util.function.Supplier;

public abstract class SoulsCraftArmorRenderer extends AzArmorRenderer {
    public SoulsCraftArmorRenderer(AzRendererConfig<ItemStack> config, ResourceLocation modelLocation, ResourceLocation textureLocation, Supplier<@Nullable AzAnimator<ItemStack>> animatorProvider) {
        super(
                AzArmorRendererConfig.builder(modelLocation, textureLocation)
                        .setAnimatorProvider(animatorProvider)
                        .build()
        );
    }
}
