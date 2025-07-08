package net.get900.pixelpirates.world.biome.phase3;

import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.get900.pixelpirates.PixelPirates;
import net.get900.pixelpirates.datagen.biome.PixelPiratesBiomes;
import net.minecraft.registry.*;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.PlacedFeature;

public class Phase3Biomes {
    public static final RegistryKey<Biome> ASH_REEF = key("ash_reef");
    public static final RegistryKey<Biome> BOILING_BASIN = key("boiling_basin");
    public static final RegistryKey<Biome> MAGMA_SEA = key("magma_sea");

    public static void register(FabricDynamicRegistryProvider.Entries entries, RegistryWrapper.WrapperLookup lookup) {
        entries.add(ASH_REEF, PixelPiratesBiomes.buildAshReef(lookup));
        entries.add(BOILING_BASIN, PixelPiratesBiomes.buildBoilingBasin(lookup));
        entries.add(MAGMA_SEA, PixelPiratesBiomes.buildMagmaSea(lookup));
    }

    public static void bootstrap(Registerable<Biome> context) {
        RegistryEntryLookup<PlacedFeature> placed = context.getRegistryLookup(RegistryKeys.PLACED_FEATURE);
        context.register(ASH_REEF, PixelPiratesBiomes.buildAshReef(placed));
        context.register(BOILING_BASIN, PixelPiratesBiomes.buildBoilingBasin(placed));
        context.register(MAGMA_SEA, PixelPiratesBiomes.buildMagmaSea(placed));
    }

    private static RegistryKey<Biome> key(String name) {
        return RegistryKey.of(RegistryKeys.BIOME, PixelPirates.id(name));
    }
}
