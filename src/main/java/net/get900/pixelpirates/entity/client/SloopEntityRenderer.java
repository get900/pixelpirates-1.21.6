package net.get900.pixelpirates.entity.client;

import net.get900.pixelpirates.entity.custom.SloopEntity;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class SloopEntityRenderer extends GeoEntityRenderer<SloopEntity> {

    public SloopEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new SloopModel());
        this.shadowRadius = 1.0f; // Adjust depending on your raft model size
        System.out.println("✅ SloopEntityRenderer initialized!");
    }


    @Override
    public RenderLayer getRenderType(SloopEntity animatable, Identifier texture,
                                     VertexConsumerProvider bufferSource, float partialTick) {
        return RenderLayer.getEntityCutout(texture);
    }
}