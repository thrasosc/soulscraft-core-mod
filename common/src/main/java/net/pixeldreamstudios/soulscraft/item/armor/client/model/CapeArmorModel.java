package net.pixeldreamstudios.soulscraft.item.armor.client.model;

import mod.azure.azurelib.common.api.client.helper.ClientUtils;
import mod.azure.azurelib.common.api.client.model.GeoModel;
import mod.azure.azurelib.core.animatable.GeoAnimatable;
import mod.azure.azurelib.core.animation.AnimationState;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Player;
import net.pixeldreamstudios.soulscraft.item.armor.SoulsCraftArmorItem;

public abstract class CapeArmorModel<T extends SoulsCraftArmorItem & GeoAnimatable> extends GeoModel<T> {
    @Override
    public void setCustomAnimations(T animatable, long instanceId, AnimationState<T> animationState) {
        super.setCustomAnimations(animatable, instanceId, animationState);
        var cape = getAnimationProcessor().getBone("cape");

        Player abstractClientPlayer = ClientUtils.getClientPlayer();

        cape.updateRotation(-0.013f, 0.0f, 0.125f);

        float h = 0.5f;
        double d = Mth.lerp(h, abstractClientPlayer.xCloakO, abstractClientPlayer.xCloak) - Mth.lerp(h, abstractClientPlayer.xo, abstractClientPlayer.getX());
        double e = Mth.lerp(h, abstractClientPlayer.yCloakO, abstractClientPlayer.yCloak) - Mth.lerp(h, abstractClientPlayer.yo, abstractClientPlayer.getY());
        double m = Mth.lerp(h, abstractClientPlayer.zCloakO, abstractClientPlayer.zCloak) - Mth.lerp(h, abstractClientPlayer.zo, abstractClientPlayer.getZ());
        float n = Mth.rotLerp(h, abstractClientPlayer.yBodyRotO, abstractClientPlayer.yBodyRot);
        double o = Mth.sin(n * ((float)Math.PI / 180));
        double p = -Mth.cos(n * ((float)Math.PI / 180));
        float q = (float)e * 10.0f;
        q = Mth.clamp(q, -6.0f, 32.0f);
        float r = (float)(d * o + m * p) * 100.0f;
        r = Mth.clamp(r, 0.0f, 150.0f);
        float s = (float)(d * p - m * o) * 100.0f;
        s = Mth.clamp(s, -10.0f, 10.0f);
        if (r < 0.0f) {
            r = 0.0f;
        }
        float t = Mth.lerp(h, abstractClientPlayer.oBob, abstractClientPlayer.bob);
        q += Mth.sin(Mth.lerp(h, abstractClientPlayer.walkDistO, abstractClientPlayer.walkDist) * 6.0f) * 32.0f * t;
        if (abstractClientPlayer.isCrouching()) {
            q += 25.0f;
        }

        cape.setRotX(cape.getRotX() * (r / 2.0f + q));
        cape.setRotZ(cape.getRotZ() * (s / 2.0f));
        cape.setRotY(cape.getRotY() * (180.0f - s / 2.0f));
    }
}