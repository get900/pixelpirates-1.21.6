package net.get900.pixelpirates.world.biome.phase1;

import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.get900.pixelpirates.PixelPirates;
import net.get900.pixelpirates.datagen.biome.PixelPiratesBiomes;
import net.minecraft.registry.*;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.PlacedFeature;

import java.util.List;

public class Phase1Biomes {
    public static final RegistryKey<Biome> TEMPERATE_SHALLOWS = key("temperate_shallows");
    public static final RegistryKey<Biome> ISLAND_THICKETS = key("island_thickets");
    public static final RegistryKey<Biome> OPEN_OCEAN = key("open_ocean");

    public static void register(FabricDynamicRegistryProvider.Entries entries, RegistryWrapper.WrapperLookup lookup) {
        registerWithStructures(entries, TEMPERATE_SHALLOWS, PixelPiratesBiomes.buildTemperateShallows(lookup),
                List.of(PixelPirates.id("pirate_port_01")));
        entries.add(ISLAND_THICKETS, PixelPiratesBiomes.buildIslandThickets(lookup));
        entries.add(OPEN_OCEAN, PixelPiratesBiomes.buildOpenOcean(lookup));
    }

    public static void bootstrap(Registerable<Biome> context) {
        RegistryEntryLookup<PlacedFeature> placed = context.getRegistryLookup(RegistryKeys.PLACED_FEATURE);
        context.register(TEMPERATE_SHALLOWS, PixelPiratesBiomes.buildTemperateShallows(placed));
        context.register(ISLAND_THICKETS, PixelPiratesBiomes.buildIslandThickets(placed));
        context.register(OPEN_OCEAN, PixelPiratesBiomes.buildOpenOcean(placed));
    }

    private static RegistryKey<Biome> key(String name) {
        return RegistryKey.of(RegistryKeys.BIOME, PixelPirates.id(name));
    }

    private static void registerWithStructures(
            FabricDynamicRegistryProvider.Entries entries,
            RegistryKey<Biome> biomeKey,
            Biome biome,
            List<Identifier> structures
    ) {
        entries.add(biomeKey, biome);

        // You can later use this list to write your own JSON patcher or log warning
        if (!structures.isEmpty()) {
            PixelPirates.LOGGER.info("Registered " + biomeKey.getValue() + " with structures: " + structures);
        }
    }
}
