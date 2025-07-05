package net.get900.pixelpirates.entity.client;

import net.get900.pixelpirates.PixelPirates;
import net.get900.pixelpirates.entity.custom.RaftEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.model.GeoModel;

public class RaftModel extends GeoModel<RaftEntity> {

    @Override
    public Identifier getModelResource(RaftEntity animatable) {
        return Identifier.of(PixelPirates.MOD_ID, "geo/raft.geo.json");
    }

    @Override
    public Identifier getTextureResource(RaftEntity animatable) {
        return Identifier.of(PixelPirates.MOD_ID, "textures/entity/raft.png");
    }

    @Override
    public Identifier getAnimationResource(RaftEntity animatable) {
        return Identifier.of(PixelPirates.MOD_ID, "animations/raft.animation.json");
    }

    @Override
    public void setCustomAnimations(RaftEntity entity, long instanceId, AnimationState<RaftEntity> animationState) {
        super.setCustomAnimations(entity, instanceId, animationState);

        float yawRotation = (float) Math.toRadians(-entity.getYaw());

        GeoBone base = getAnimationProcessor().getBone("raft_base");
        if (base != null) {
            base.setRotY(yawRotation);
            base.setPivotY(base.getPivotY() + entity.getSinkingAmount()); // ✅ visual sinking
        }

        GeoBone sail = getAnimationProcessor().getBone("sail");
        if (sail != null) sail.setRotY(yawRotation);

        GeoBone mast = getAnimationProcessor().getBone("mast");
        if (mast != null) mast.setRotY(yawRotation);
    }
}
