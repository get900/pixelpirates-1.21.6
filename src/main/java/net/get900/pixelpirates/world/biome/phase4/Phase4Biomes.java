package net.get900.pixelpirates.world.biome.phase4;

import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.get900.pixelpirates.PixelPirates;
import net.get900.pixelpirates.datagen.biome.PixelPiratesBiomes;
import net.minecraft.registry.*;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.PlacedFeature;

public class Phase4Biomes {
    public static final RegistryKey<Biome> PHANTOM_WAKE = key("phantom_wake");
    public static final RegistryKey<Biome> SHIPGRAVE_DEPTHS = key("shipgrave_depths");
    public static final RegistryKey<Biome> DROWNED_TRENCH = key("drowned_trench");

    public static void register(FabricDynamicRegistryProvider.Entries entries, RegistryWrapper.WrapperLookup lookup) {
        entries.add(PHANTOM_WAKE, PixelPiratesBiomes.buildPhantomWake(lookup));
        entries.add(SHIPGRAVE_DEPTHS, PixelPiratesBiomes.buildShipgraveDepths(lookup));
        entries.add(DROWNED_TRENCH, PixelPiratesBiomes.buildDrownedTrench(lookup));
    }

    public static void bootstrap(Registerable<Biome> context) {
        RegistryEntryLookup<PlacedFeature> placed = context.getRegistryLookup(RegistryKeys.PLACED_FEATURE);
        context.register(PHANTOM_WAKE, PixelPiratesBiomes.buildPhantomWake(placed));
        context.register(SHIPGRAVE_DEPTHS, PixelPiratesBiomes.buildShipgraveDepths(placed));
        context.register(DROWNED_TRENCH, PixelPiratesBiomes.buildDrownedTrench(placed));
    }

    private static RegistryKey<Biome> key(String name) {
        return RegistryKey.of(RegistryKeys.BIOME, PixelPirates.id(name));
    }
}
