package net.get900.pixelpirates.world.biome.phase5;

import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.get900.pixelpirates.PixelPirates;
import net.get900.pixelpirates.datagen.biome.PixelPiratesBiomes;
import net.minecraft.registry.*;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.PlacedFeature;

public class Phase5Biomes {
    public static final RegistryKey<Biome> ABYSSAL_RINGS = key("abyssal_rings");
    public static final RegistryKey<Biome> PILLAR_SEA = key("pillar_sea");
    public static final RegistryKey<Biome> MAW_DEPTHS = key("maw_depths");

    public static void register(FabricDynamicRegistryProvider.Entries entries, RegistryWrapper.WrapperLookup lookup) {
        entries.add(ABYSSAL_RINGS, PixelPiratesBiomes.buildAbyssalRings(lookup));
        entries.add(PILLAR_SEA, PixelPiratesBiomes.buildPillarSea(lookup));
        entries.add(MAW_DEPTHS, PixelPiratesBiomes.buildMawDepths(lookup));
    }

    public static void bootstrap(Registerable<Biome> context) {
        RegistryEntryLookup<PlacedFeature> placed = context.getRegistryLookup(RegistryKeys.PLACED_FEATURE);
        context.register(ABYSSAL_RINGS, PixelPiratesBiomes.buildAbyssalRings(placed));
        context.register(PILLAR_SEA, PixelPiratesBiomes.buildPillarSea(placed));
        context.register(MAW_DEPTHS, PixelPiratesBiomes.buildMawDepths(placed));
    }

    private static RegistryKey<Biome> key(String name) {
        return RegistryKey.of(RegistryKeys.BIOME, PixelPirates.id(name));
    }
}
