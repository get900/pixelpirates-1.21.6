package net.get900.pixelpirates.world;

import net.get900.pixelpirates.PixelPirates;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.Heightmap;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ModPlacedFeatures {

    public static final RegistryKey<PlacedFeature> DRIFTWOOD_BLOCK_PLACED_KEY =
            registerKey("driftwood_block_placed");
    public static final RegistryKey<PlacedFeature> SHOREWOOD_TREE_PLACED_KEY =
            registerKey("shorewood_tree_placed");


    public static void bootstrap(Registerable<PlacedFeature> context) {
        var configuredFeatures = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        register(context, DRIFTWOOD_BLOCK_PLACED_KEY,
                configuredFeatures.getOrThrow(ModConfiguredFeatures.DRIFTWOOD_BLOCK_KEY),
                modifiersWithCount(1,
                        SquarePlacementModifier.of(),
                        HeightmapPlacementModifier.of(Heightmap.Type.WORLD_SURFACE),
                        BiomePlacementModifier.of()
                )
        );
        register(context, SHOREWOOD_TREE_PLACED_KEY,
                configuredFeatures.getOrThrow((RegistryKey<ConfiguredFeature<?, ?>>)(Object) ModConfiguredFeatures.SHOREWOOD_TREE_KEY),
                List.of(
                        CountPlacementModifier.of(5),
                        SquarePlacementModifier.of(),
                        SurfaceWaterDepthFilterPlacementModifier.of(0), // ✅ Prevent placement in water
                        HeightmapPlacementModifier.of(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES),
                        BiomePlacementModifier.of()
                )
        );


    }

    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(PixelPirates.MOD_ID, name));
    }

    public static List<PlacementModifier> modifiersWithCount(int count, PlacementModifier... modifiers) {
        List<PlacementModifier> list = new ArrayList<>();
        list.add(CountPlacementModifier.of(count));
        Collections.addAll(list, modifiers);
        return list;
    }

    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key,
                                                                                   RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                                                                   PlacementModifier... modifiers) {
        register(context, key, configuration, List.of(modifiers));
    }
}
