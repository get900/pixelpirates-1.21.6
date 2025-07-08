package net.get900.pixelpirates.entity.client;

import net.get900.pixelpirates.PixelPirates;
import net.get900.pixelpirates.entity.custom.SloopEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.model.GeoModel;

public class SloopModel extends GeoModel<SloopEntity> {

    @Override
    public Identifier getModelResource(SloopEntity animatable) {
        return Identifier.of(PixelPirates.MOD_ID, "geo/sloop.geo.json");
    }

    @Override
    public Identifier getTextureResource(SloopEntity animatable) {
        return Identifier.of(PixelPirates.MOD_ID, "textures/entity/sloop.png");
    }

    @Override
    public Identifier getAnimationResource(SloopEntity animatable) {
        return Identifier.of(PixelPirates.MOD_ID, "animations/sloop.animation.json");
    }

    @Override
    public void setCustomAnimations(SloopEntity entity, long instanceId, AnimationState<SloopEntity> animationState) {
        super.setCustomAnimations(entity, instanceId, animationState);

        float yawRotation = (float) Math.toRadians(-entity.getYaw());

        GeoBone base = getAnimationProcessor().getBone("sloop");
        if (base != null) {
            base.setRotY(yawRotation);
            base.setPivotY(base.getPivotY() + entity.getSinkingAmount()); // ✅ visual sinking
        }

        GeoBone rudder = getAnimationProcessor().getBone("rudder");
        if (rudder != null) rudder.setRotY(yawRotation);

        GeoBone mast = getAnimationProcessor().getBone("mast");
        if (mast != null) mast.setRotY(yawRotation);
    }
}
