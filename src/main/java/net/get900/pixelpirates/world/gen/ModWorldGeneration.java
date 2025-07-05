package net.get900.pixelpirates.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.get900.pixelpirates.world.ModPlacedFeatures;

import net.get900.pixelpirates.world.biome.ModBiomeKeys;
import net.minecraft.world.gen.GenerationStep;

public class ModWorldGeneration {
    public static void generateModWorldGen() {
        generateBlockPiles();
        generateShorewoodTrees();
    }

    private static void generateBlockPiles() {
        BiomeModifications.addFeature(
                BiomeSelectors.includeByKey(ModBiomeKeys.TEMPERATE_SHALLOWS),
                GenerationStep.Feature.LOCAL_MODIFICATIONS,
                ModPlacedFeatures.DRIFTWOOD_BLOCK_PLACED_KEY
        );
    }

    private static void generateShorewoodTrees() {
        BiomeModifications.addFeature(
                BiomeSelectors.includeByKey(ModBiomeKeys.TEMPERATE_SHALLOWS),
                GenerationStep.Feature.VEGETAL_DECORATION,
                ModPlacedFeatures.SHOREWOOD_TREE_PLACED_KEY
        );
    }
}
