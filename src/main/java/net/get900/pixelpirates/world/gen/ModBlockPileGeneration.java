package net.get900.pixelpirates.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.get900.pixelpirates.world.ModPlacedFeatures;
import net.minecraft.registry.tag.BiomeTags;
import net.minecraft.world.gen.GenerationStep;

public class ModBlockPileGeneration {
    public static void generateBlockPiles() {
        System.out.println("[PixelPirates] Applying biome modifications for driftwood piles");

        BiomeModifications.addFeature(
                BiomeSelectors.foundInOverworld().and(BiomeSelectors.tag(BiomeTags.IS_BEACH)),
                GenerationStep.Feature.LOCAL_MODIFICATIONS,
                ModPlacedFeatures.DRIFTWOOD_BLOCK_PLACED_KEY
        );
    }
}