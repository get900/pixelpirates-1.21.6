package net.get900.pixelpirates.world.biome.phase2;

import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.get900.pixelpirates.PixelPirates;
import net.get900.pixelpirates.datagen.biome.PixelPiratesBiomes;
import net.minecraft.registry.*;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.PlacedFeature;

public class Phase2Biomes {
    public static final RegistryKey<Biome> CORAL_BAY = key("coral_bay");
    public static final RegistryKey<Biome> REEF_EDGE = key("reef_edge");
    public static final RegistryKey<Biome> SIREN_SEA = key("siren_sea");

    public static void register(FabricDynamicRegistryProvider.Entries entries, RegistryWrapper.WrapperLookup lookup) {
        entries.add(CORAL_BAY, PixelPiratesBiomes.buildCoralBay(lookup));
        entries.add(REEF_EDGE, PixelPiratesBiomes.buildReefEdge(lookup));
        entries.add(SIREN_SEA, PixelPiratesBiomes.buildSirenSea(lookup));
    }

    public static void bootstrap(Registerable<Biome> context) {
        RegistryEntryLookup<PlacedFeature> placed = context.getRegistryLookup(RegistryKeys.PLACED_FEATURE);
        context.register(CORAL_BAY, PixelPiratesBiomes.buildCoralBay(placed));
        context.register(REEF_EDGE, PixelPiratesBiomes.buildReefEdge(placed));
        context.register(SIREN_SEA, PixelPiratesBiomes.buildSirenSea(placed));
    }

    private static RegistryKey<Biome> key(String name) {
        return RegistryKey.of(RegistryKeys.BIOME, PixelPirates.id(name));
    }
}
