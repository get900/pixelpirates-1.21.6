package net.get900.pixelpirates.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.get900.pixelpirates.entity.ModEntities;
import net.get900.pixelpirates.world.ModPlacedFeatures;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.PlacedFeature;

import java.util.concurrent.CompletableFuture;

public class ModBiomeProvider extends FabricDynamicRegistryProvider {
    public ModBiomeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> lookup) {
        super(output, lookup);
    }

    @Override
    public void configure(RegistryWrapper.WrapperLookup lookup, Entries entries) {
        RegistryKey<Biome> biomeKey = RegistryKey.of(RegistryKeys.BIOME, Identifier.of("pixelpirates", "temperate_shallows"));
        entries.add(biomeKey, buildTemperateShallows(lookup));
        RegistryKey<Biome> openOceanKey = RegistryKey.of(RegistryKeys.BIOME, Identifier.of("pixelpirates", "open_ocean"));
        entries.add(openOceanKey, buildOpenOcean(lookup));
        RegistryKey<Biome> volcanicWatersKey = RegistryKey.of(RegistryKeys.BIOME, Identifier.of("pixelpirates", "volcanic_waters"));
        entries.add(volcanicWatersKey, buildVolcanicWaters(lookup));
        RegistryKey<Biome> deadWatersKey = RegistryKey.of(RegistryKeys.BIOME, Identifier.of("pixelpirates", "dead_waters"));
        entries.add(deadWatersKey, buildDeadWaters(lookup));
        RegistryKey<Biome> frozenSeaKey = RegistryKey.of(RegistryKeys.BIOME, Identifier.of("pixelpirates", "frozen_sea"));
        entries.add(frozenSeaKey, buildFrozenSea(lookup));
    }

    private Biome buildTemperateShallows(RegistryWrapper.WrapperLookup lookup) {
        RegistryWrapper<PlacedFeature> placedFeatureLookup = lookup.getWrapperOrThrow(RegistryKeys.PLACED_FEATURE);
        GenerationSettings.Builder generationSettings = new GenerationSettings.Builder();

        generationSettings.feature(
                GenerationStep.Feature.LOCAL_MODIFICATIONS,
                placedFeatureLookup.getOrThrow(ModPlacedFeatures.DRIFTWOOD_BLOCK_PLACED_KEY)
        );

        SpawnSettings.Builder spawnSettings = new SpawnSettings.Builder();

        // 👇 Add the shark to the WATER_CREATURE group
        spawnSettings.spawn(SpawnGroup.WATER_CREATURE, new SpawnSettings.SpawnEntry(
                ModEntities.SHARK,
                10, // weight (higher = more frequent)
                1,  // min group size
                3   // max group size
        ));

        return new Biome.Builder()
                .precipitation(true)
                .temperature(0.3f)
                .downfall(0.4f)
                .effects(new BiomeEffects.Builder()
                        .waterColor(0x33ccff).waterFogColor(0x66ccff)
                        .fogColor(0xC0D8FF).skyColor(0x87CEEB).build())
                .spawnSettings(new SpawnSettings.Builder().build())
                .generationSettings(generationSettings.build())
                .build();
    }

    private Biome buildOpenOcean(RegistryWrapper.WrapperLookup lookup) {
        GenerationSettings.Builder generationSettings = new GenerationSettings.Builder();

        // No vegetation or driftwood — make it feel empty/oceanic
        // You could add coral or gravel patches later

        return new Biome.Builder()
                .precipitation(true)
                .temperature(0.5f) // Warmer
                .downfall(0.1f)    // Dryer
                .effects(new BiomeEffects.Builder()
                        .waterColor(0x0000cc)         // Deep blue
                        .waterFogColor(0x000099)
                        .fogColor(0x222244)           // Darker fog
                        .skyColor(0x2233aa)           // Cooler sky tone
                        .build())
                .spawnSettings(new SpawnSettings.Builder().build())
                .generationSettings(generationSettings.build())
                .build();
    }

    private Biome buildVolcanicWaters(RegistryWrapper.WrapperLookup lookup) {
        GenerationSettings.Builder generationSettings = new GenerationSettings.Builder();

        // No features yet — later we can add magma block veins or steam vents

        return new Biome.Builder()
                .precipitation(false)  // Hot and dry
                .temperature(0.8f)     // Maximum heat
                .downfall(0.0f)
                .effects(new BiomeEffects.Builder()
                        .waterColor(0x8B0000)         // Deep red
                        .waterFogColor(0x550000)
                        .fogColor(0x330000)           // Dark red-black fog
                        .skyColor(0x660000)           // Blood-red sky
                        .build())
                .spawnSettings(new SpawnSettings.Builder().build())
                .generationSettings(generationSettings.build())
                .build();
    }

    private Biome buildDeadWaters(RegistryWrapper.WrapperLookup lookup) {
        GenerationSettings.Builder generationSettings = new GenerationSettings.Builder();

        return new Biome.Builder()
                .precipitation(false)
                .temperature(0.3f)
                .downfall(0.0f)
                .effects(new BiomeEffects.Builder()
                        .waterColor(0x444444)         // Dim gray water
                        .waterFogColor(0x2b2b2b)       // Near black fog
                        .fogColor(0x1e1e1e)            // Low visibility, dark tone
                        .skyColor(0x2a2a2a)            // Desaturated sky
                        .build())
                .spawnSettings(new SpawnSettings.Builder().build())
                .generationSettings(generationSettings.build())
                .build();
    }

    private Biome buildFrozenSea(RegistryWrapper.WrapperLookup lookup) {
        GenerationSettings.Builder generationSettings = new GenerationSettings.Builder();

        // No features for now — later: ice floes, spires, frost corals

        return new Biome.Builder()
                .precipitation(true)
                .temperature(-0.5f)   // Below freezing
                .downfall(0.5f)
                .effects(new BiomeEffects.Builder()
                        .waterColor(0x336699)         // Icy blue
                        .waterFogColor(0x223355)
                        .fogColor(0x99bbcc)           // Cold and dense
                        .skyColor(0xbbddee)           // Frozen overcast
                        .build())
                .spawnSettings(new SpawnSettings.Builder().build())
                .generationSettings(generationSettings.build())
                .build();
    }

    @Override
    public String getName() {
        return "Pixel Pirates Biomes";
    }
}
