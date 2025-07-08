package net.get900.pixelpirates;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.get900.pixelpirates.block.ModBlocks;
import net.get900.pixelpirates.entity.ModEntities;
import net.get900.pixelpirates.entity.client.RaftEntityRenderer;
import net.get900.pixelpirates.entity.client.SloopEntityRenderer;
import net.minecraft.client.render.RenderLayer;
import net.get900.pixelpirates.entity.client.SharkEntityRenderer;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;

public class PixelPiratesClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DRIFTWOOD_BLOCK, RenderLayer.getCutout());
        EntityRendererRegistry.register(ModEntities.SHARK, SharkEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.RAFT, RaftEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.SLOOP, SloopEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.DYNAMITE, FlyingItemEntityRenderer::new);


        PixelPirates.LOGGER.info("Pixel Pirates client initializing...");


}}