package net.get900.pixelpirates.entity.client;

import net.get900.pixelpirates.entity.custom.SharkEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class SharkEntityRenderer extends GeoEntityRenderer<SharkEntity> {
    public SharkEntityRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new SharkModel());
    }

    @Override
    public Identifier getTextureLocation(SharkEntity entity) {
        return Identifier.of("pixelpirates", "textures/entity/shark.png");
    }

    @Override
    public void render(SharkEntity entity, float entityYaw, float partialTick, MatrixStack poseStack,
                       VertexConsumerProvider bufferSource, int packedLight) {
        poseStack.scale(10.0f, 10.0f, 10.0f); // uniform 10× scale
        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}
