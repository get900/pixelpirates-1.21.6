package net.get900.pixelpirates.entity.client;

import net.get900.pixelpirates.entity.custom.RaftEntity;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3d;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class RaftEntityRenderer extends GeoEntityRenderer<RaftEntity> {

    public RaftEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new RaftModel());
        this.shadowRadius = 1.0f; // Adjust depending on your raft model size
    }


    @Override
    public RenderLayer getRenderType(RaftEntity animatable, Identifier texture,
                                     VertexConsumerProvider bufferSource, float partialTick) {
        return RenderLayer.getEntityCutout(texture);
    }
}
