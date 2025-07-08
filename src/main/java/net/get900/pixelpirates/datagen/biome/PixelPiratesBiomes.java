package net.get900.pixelpirates.datagen.biome;

import net.get900.pixelpirates.entity.ModEntities;
import net.get900.pixelpirates.world.ModPlacedFeatures;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.WaterCreatureEntity;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.PlacedFeature;

public class PixelPiratesBiomes {

    //Phase 1 Spawns
    private static SpawnSettings.Builder createPhase1Spawns() {
        SpawnSettings.Builder spawns = new SpawnSettings.Builder();
        spawns.spawn(SpawnGroup.WATER_CREATURE, new SpawnSettings.SpawnEntry(
                ModEntities.SHARK, 1, 1, 1
        ));
        spawns.spawn(SpawnGroup.WATER_CREATURE, new SpawnSettings.SpawnEntry(
                EntityType.COD, 1, 1, 1
        ));
        spawns.spawn(SpawnGroup.WATER_CREATURE, new SpawnSettings.SpawnEntry(
                EntityType.SALMON, 1, 1, 1
        ));
        spawns.spawn(SpawnGroup.WATER_CREATURE, new SpawnSettings.SpawnEntry(
                EntityType.DOLPHIN, 1, 1, 1
        ));
        return spawns;
    }
    //Phase 1 Effects
    private static BiomeEffects.Builder createPhase1Effects() {
        return new BiomeEffects.Builder()
                .waterColor(0x33ccff).waterFogColor(0x66ccff)
                .fogColor(0xC0D8FF).skyColor(0x87CEEB);
    }

    //Phase 1 Biomes

    public static Biome buildTemperateShallows(RegistryWrapper.WrapperLookup lookup) {
        RegistryWrapper<PlacedFeature> placed = lookup.getWrapperOrThrow(RegistryKeys.PLACED_FEATURE);
        return buildTemperateShallows(placed);
    }

    public static Biome buildTemperateShallows(RegistryEntryLookup<PlacedFeature> placedFeatures) {
        GenerationSettings.Builder generation = new GenerationSettings.Builder();
        generation.feature(
                GenerationStep.Feature.LOCAL_MODIFICATIONS,
                placedFeatures.getOrThrow(ModPlacedFeatures.DRIFTWOOD_BLOCK_PLACED_KEY)
        );

        return new Biome.Builder()
                .precipitation(true)
                .temperature(0.3f)
                .downfall(0.4f)
                .effects(createPhase1Effects().build())
                .spawnSettings(createPhase1Spawns().build())
                .generationSettings(generation.build())
                .build();
    }

    public static Biome buildIslandThickets(RegistryWrapper.WrapperLookup lookup) {
        RegistryWrapper<PlacedFeature> placed = lookup.getWrapperOrThrow(RegistryKeys.PLACED_FEATURE);
        return buildIslandThickets(placed);
    }
    public static Biome buildIslandThickets(RegistryEntryLookup<PlacedFeature> placedFeatures) {
        GenerationSettings.Builder generation = new GenerationSettings.Builder();
        generation.feature(
                GenerationStep.Feature.LOCAL_MODIFICATIONS,
                placedFeatures.getOrThrow(ModPlacedFeatures.DRIFTWOOD_BLOCK_PLACED_KEY)
        );
        return new Biome.Builder()
                .precipitation(true)
                .temperature(0.3f)
                .downfall(0.4f)
                .effects(createPhase1Effects().build())
                .spawnSettings(createPhase1Spawns().build())
                .generationSettings(new GenerationSettings.Builder().build())
                .build();
    }

    public static Biome buildOpenOcean(RegistryWrapper.WrapperLookup lookup) {
        RegistryWrapper<PlacedFeature> placed = lookup.getWrapperOrThrow(RegistryKeys.PLACED_FEATURE);
        return buildOpenOcean(placed);
    }

    public static Biome buildOpenOcean(RegistryEntryLookup<PlacedFeature> placedFeatures) {
        GenerationSettings.Builder generation = new GenerationSettings.Builder();
        generation.feature(
                GenerationStep.Feature.LOCAL_MODIFICATIONS,
                placedFeatures.getOrThrow(ModPlacedFeatures.DRIFTWOOD_BLOCK_PLACED_KEY)
        );
        return new Biome.Builder()
                .precipitation(true)
                .temperature(0.3f)
                .downfall(0.4f)
                .effects(createPhase1Effects().build())
                .spawnSettings(createPhase1Spawns().build())
                .generationSettings(new GenerationSettings.Builder().build())
                .build();
    }

    //Phase 2 Spawns
    private static SpawnSettings.Builder createPhase2Spawns() {
        SpawnSettings.Builder spawns = new SpawnSettings.Builder();
        spawns.spawn(SpawnGroup.WATER_CREATURE, new SpawnSettings.SpawnEntry(
                ModEntities.SHARK, 1, 1, 1
        ));

        return spawns;
    }
    //Phase 2 Effects
    private static BiomeEffects.Builder createPhase2Effects() {
        return new BiomeEffects.Builder()
                .waterColor(0x0000cc).waterFogColor(0x000099)
                .fogColor(0x222244).skyColor(0x2233aa);
    }

    //Phase 2 Biomes
    public static Biome buildCoralBay(RegistryWrapper.WrapperLookup lookup) {
        RegistryWrapper<PlacedFeature> placed = lookup.getWrapperOrThrow(RegistryKeys.PLACED_FEATURE);
        return buildCoralBay(placed);
    }

    public static Biome buildCoralBay(RegistryEntryLookup<PlacedFeature> placedFeatures) {
        GenerationSettings.Builder generation = new GenerationSettings.Builder();
        generation.feature(
                GenerationStep.Feature.LOCAL_MODIFICATIONS,
                placedFeatures.getOrThrow(ModPlacedFeatures.DRIFTWOOD_BLOCK_PLACED_KEY)
        );
        return new Biome.Builder()
                .precipitation(true)
                .temperature(0.5f)
                .downfall(0.1f)
                .effects(createPhase2Effects().build())
                .spawnSettings(createPhase2Spawns().build())
                .generationSettings(new GenerationSettings.Builder().build())
                .build();
    }

    public static Biome buildReefEdge(RegistryWrapper.WrapperLookup lookup) {
        RegistryWrapper<PlacedFeature> placed = lookup.getWrapperOrThrow(RegistryKeys.PLACED_FEATURE);
        return buildReefEdge(placed);
    }

    public static Biome buildReefEdge(RegistryEntryLookup<PlacedFeature> placedFeatures) {
        GenerationSettings.Builder generation = new GenerationSettings.Builder();
        generation.feature(
                GenerationStep.Feature.LOCAL_MODIFICATIONS,
                placedFeatures.getOrThrow(ModPlacedFeatures.DRIFTWOOD_BLOCK_PLACED_KEY)
        );
        return new Biome.Builder()
                .precipitation(true)
                .temperature(0.5f)
                .downfall(0.1f)
                .effects(createPhase2Effects().build())
                .spawnSettings(createPhase2Spawns().build())
                .generationSettings(new GenerationSettings.Builder().build())
                .build();
    }

    public static Biome buildSirenSea(RegistryWrapper.WrapperLookup lookup) {
        RegistryWrapper<PlacedFeature> placed = lookup.getWrapperOrThrow(RegistryKeys.PLACED_FEATURE);
        return buildSirenSea(placed);
    }

    public static Biome buildSirenSea(RegistryEntryLookup<PlacedFeature> placedFeatures) {
        GenerationSettings.Builder generation = new GenerationSettings.Builder();
        generation.feature(
                GenerationStep.Feature.LOCAL_MODIFICATIONS,
                placedFeatures.getOrThrow(ModPlacedFeatures.DRIFTWOOD_BLOCK_PLACED_KEY)
        );
        return new Biome.Builder()
                .precipitation(true)
                .temperature(0.5f)
                .downfall(0.1f)
                .effects(createPhase2Effects().build())
                .spawnSettings(createPhase2Spawns().build())
                .generationSettings(new GenerationSettings.Builder().build())
                .build();
    }

    //Phase 3 Spawns
    private static SpawnSettings.Builder createPhase3Spawns() {
        SpawnSettings.Builder spawns = new SpawnSettings.Builder();
        spawns.spawn(SpawnGroup.WATER_CREATURE, new SpawnSettings.SpawnEntry(
                ModEntities.SHARK, 1, 1, 1
        ));

        return spawns;
    }

    //Phase 3 Effects
    private static BiomeEffects.Builder createPhase3Effects() {
        return new BiomeEffects.Builder()
                .waterColor(0x8B0000).waterFogColor(0x550000)
                .fogColor(0x330000).skyColor(0x660000);
    }

    //Phase 3 Biomes
    public static Biome buildAshReef(RegistryWrapper.WrapperLookup lookup) {
        RegistryWrapper<PlacedFeature> placed = lookup.getWrapperOrThrow(RegistryKeys.PLACED_FEATURE);
        return buildAshReef(placed);
    }

    public static Biome buildAshReef(RegistryEntryLookup<PlacedFeature> placedFeatures) {
        GenerationSettings.Builder generation = new GenerationSettings.Builder();
        generation.feature(
                GenerationStep.Feature.LOCAL_MODIFICATIONS,
                placedFeatures.getOrThrow(ModPlacedFeatures.DRIFTWOOD_BLOCK_PLACED_KEY)
        );
        return new Biome.Builder()
                .precipitation(false)
                .temperature(0.8f)
                .downfall(0.0f)
                .effects(createPhase3Effects().build())
                .spawnSettings(createPhase3Spawns().build())
                .generationSettings(new GenerationSettings.Builder().build())
                .build();
    }

    public static Biome buildBoilingBasin(RegistryWrapper.WrapperLookup lookup) {
        RegistryWrapper<PlacedFeature> placed = lookup.getWrapperOrThrow(RegistryKeys.PLACED_FEATURE);
        return buildBoilingBasin(placed);
    }

    public static Biome buildBoilingBasin(RegistryEntryLookup<PlacedFeature> placedFeatures) {
        GenerationSettings.Builder generation = new GenerationSettings.Builder();
        generation.feature(
                GenerationStep.Feature.LOCAL_MODIFICATIONS,
                placedFeatures.getOrThrow(ModPlacedFeatures.DRIFTWOOD_BLOCK_PLACED_KEY)
        );
        return new Biome.Builder()
                .precipitation(false)
                .temperature(0.8f)
                .downfall(0.0f)
                .effects(createPhase3Effects().build())
                .spawnSettings(createPhase3Spawns().build())
                .generationSettings(new GenerationSettings.Builder().build())
                .build();
    }

    public static Biome buildMagmaSea(RegistryWrapper.WrapperLookup lookup) {
        RegistryWrapper<PlacedFeature> placed = lookup.getWrapperOrThrow(RegistryKeys.PLACED_FEATURE);
        return buildMagmaSea(placed);
    }

    public static Biome buildMagmaSea(RegistryEntryLookup<PlacedFeature> placedFeatures) {
        GenerationSettings.Builder generation = new GenerationSettings.Builder();
        generation.feature(
                GenerationStep.Feature.LOCAL_MODIFICATIONS,
                placedFeatures.getOrThrow(ModPlacedFeatures.DRIFTWOOD_BLOCK_PLACED_KEY)
        );
        return new Biome.Builder()
                .precipitation(false)
                .temperature(0.8f)
                .downfall(0.0f)
                .effects(createPhase3Effects().build())
                .spawnSettings(createPhase3Spawns().build())
                .generationSettings(new GenerationSettings.Builder().build())
                .build();
    }

    //Phase 4 Spawns
    private static SpawnSettings.Builder createPhase4Spawns() {
        SpawnSettings.Builder spawns = new SpawnSettings.Builder();
        spawns.spawn(SpawnGroup.WATER_CREATURE, new SpawnSettings.SpawnEntry(
                ModEntities.SHARK, 1, 1, 1
        ));

        return spawns;
    }

    //Phase 4 Effects
    private static BiomeEffects.Builder createPhase4Effects() {
        return new BiomeEffects.Builder()
                .waterColor(0x444444).waterFogColor(0x2b2b2b)
                .fogColor(0x1e1e1e).skyColor(0x2a2a2a);
    }

    //Phase 4 Biomes
    public static Biome buildPhantomWake(RegistryWrapper.WrapperLookup lookup) {
        RegistryWrapper<PlacedFeature> placed = lookup.getWrapperOrThrow(RegistryKeys.PLACED_FEATURE);
        return buildPhantomWake(placed);
    }

    public static Biome buildPhantomWake(RegistryEntryLookup<PlacedFeature> placedFeatures) {
        GenerationSettings.Builder generation = new GenerationSettings.Builder();
        generation.feature(
                GenerationStep.Feature.LOCAL_MODIFICATIONS,
                placedFeatures.getOrThrow(ModPlacedFeatures.DRIFTWOOD_BLOCK_PLACED_KEY)
        );
        return new Biome.Builder()
                .precipitation(false)
                .temperature(0.3f)
                .downfall(0.0f)
                .effects(createPhase4Effects().build())
                .spawnSettings(createPhase4Spawns().build())
                .generationSettings(new GenerationSettings.Builder().build())
                .build();
    }

    public static Biome buildShipgraveDepths(RegistryWrapper.WrapperLookup lookup) {
        RegistryWrapper<PlacedFeature> placed = lookup.getWrapperOrThrow(RegistryKeys.PLACED_FEATURE);
        return buildShipgraveDepths(placed);
    }

    public static Biome buildShipgraveDepths(RegistryEntryLookup<PlacedFeature> placedFeatures) {
        GenerationSettings.Builder generation = new GenerationSettings.Builder();
        generation.feature(
                GenerationStep.Feature.LOCAL_MODIFICATIONS,
                placedFeatures.getOrThrow(ModPlacedFeatures.DRIFTWOOD_BLOCK_PLACED_KEY)
        );
        return new Biome.Builder()
                .precipitation(false)
                .temperature(0.3f)
                .downfall(0.0f)
                .effects(createPhase4Effects().build())
                .spawnSettings(createPhase4Spawns().build())
                .generationSettings(new GenerationSettings.Builder().build())
                .build();
    }

    public static Biome buildDrownedTrench(RegistryWrapper.WrapperLookup lookup) {
        RegistryWrapper<PlacedFeature> placed = lookup.getWrapperOrThrow(RegistryKeys.PLACED_FEATURE);
        return buildDrownedTrench(placed);
    }

    public static Biome buildDrownedTrench(RegistryEntryLookup<PlacedFeature> placedFeatures) {
        GenerationSettings.Builder generation = new GenerationSettings.Builder();
        generation.feature(
                GenerationStep.Feature.LOCAL_MODIFICATIONS,
                placedFeatures.getOrThrow(ModPlacedFeatures.DRIFTWOOD_BLOCK_PLACED_KEY)
        );
        return new Biome.Builder()
                .precipitation(false)
                .temperature(0.3f)
                .downfall(0.0f)
                .effects(createPhase4Effects().build())
                .spawnSettings(createPhase4Spawns().build())
                .generationSettings(new GenerationSettings.Builder().build())
                .build();
    }

    //Phase 5 Spawns
    private static SpawnSettings.Builder createPhase5Spawns() {
        SpawnSettings.Builder spawns = new SpawnSettings.Builder();
        spawns.spawn(SpawnGroup.WATER_CREATURE, new SpawnSettings.SpawnEntry(
                ModEntities.SHARK, 1, 1, 1
        ));

        return spawns;
    }

    //Phase 5 Effects
    private static BiomeEffects.Builder createPhase5Effects() {
        return new BiomeEffects.Builder()
                .waterColor(0x336699).waterFogColor(0x223355)
                .fogColor(0x99bbcc).skyColor(0xbbddee);
    }
    //Phase 5 Biomes
    public static Biome buildAbyssalRings(RegistryWrapper.WrapperLookup lookup) {
        RegistryWrapper<PlacedFeature> placed = lookup.getWrapperOrThrow(RegistryKeys.PLACED_FEATURE);
        return buildAbyssalRings(placed);
    }

    public static Biome buildAbyssalRings(RegistryEntryLookup<PlacedFeature> placedFeatures) {
        GenerationSettings.Builder generation = new GenerationSettings.Builder();
        generation.feature(
                GenerationStep.Feature.LOCAL_MODIFICATIONS,
                placedFeatures.getOrThrow(ModPlacedFeatures.DRIFTWOOD_BLOCK_PLACED_KEY)
        );
        return new Biome.Builder()
                .precipitation(true)
                .temperature(-0.5f)
                .downfall(0.5f)
                .effects(createPhase5Effects().build())
                .spawnSettings(createPhase5Spawns().build())
                .generationSettings(new GenerationSettings.Builder().build())
                .build();
    }

    public static Biome buildPillarSea(RegistryWrapper.WrapperLookup lookup) {
        RegistryWrapper<PlacedFeature> placed = lookup.getWrapperOrThrow(RegistryKeys.PLACED_FEATURE);
        return buildPillarSea(placed);
    }

    public static Biome buildPillarSea(RegistryEntryLookup<PlacedFeature> placedFeatures) {
        GenerationSettings.Builder generation = new GenerationSettings.Builder();
        generation.feature(
                GenerationStep.Feature.LOCAL_MODIFICATIONS,
                placedFeatures.getOrThrow(ModPlacedFeatures.DRIFTWOOD_BLOCK_PLACED_KEY)
        );
        return new Biome.Builder()
                .precipitation(true)
                .temperature(-0.5f)
                .downfall(0.5f)
                .effects(createPhase5Effects().build())
                .spawnSettings(createPhase5Spawns().build())
                .generationSettings(new GenerationSettings.Builder().build())
                .build();
    }

    public static Biome buildMawDepths(RegistryWrapper.WrapperLookup lookup) {
        RegistryWrapper<PlacedFeature> placed = lookup.getWrapperOrThrow(RegistryKeys.PLACED_FEATURE);
        return buildMawDepths(placed);
    }

    public static Biome buildMawDepths(RegistryEntryLookup<PlacedFeature> placedFeatures) {
        GenerationSettings.Builder generation = new GenerationSettings.Builder();
        generation.feature(
                GenerationStep.Feature.LOCAL_MODIFICATIONS,
                placedFeatures.getOrThrow(ModPlacedFeatures.DRIFTWOOD_BLOCK_PLACED_KEY)
        );
        return new Biome.Builder()
                .precipitation(true)
                .temperature(-0.5f)
                .downfall(0.5f)
                .effects(createPhase5Effects().build())
                .spawnSettings(createPhase5Spawns().build())
                .generationSettings(new GenerationSettings.Builder().build())
                .build();
    }
}