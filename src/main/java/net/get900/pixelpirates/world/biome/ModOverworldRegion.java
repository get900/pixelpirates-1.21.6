package net.get900.pixelpirates.world.biome;

import com.mojang.datafixers.util.Pair;
import net.get900.pixelpirates.PixelPirates;
import net.get900.pixelpirates.world.biome.phase1.Phase1Biomes;
import net.get900.pixelpirates.world.biome.phase2.Phase2Biomes;
import net.get900.pixelpirates.world.biome.phase3.Phase3Biomes;
import net.get900.pixelpirates.world.biome.phase4.Phase4Biomes;
import net.get900.pixelpirates.world.biome.phase5.Phase5Biomes;

import net.minecraft.registry.Registry;
import net.minecraft.world.biome.source.util.MultiNoiseUtil;
import terrablender.api.Region;
import terrablender.api.RegionType;

import net.minecraft.registry.RegistryKey;
import net.minecraft.world.biome.Biome;

import java.util.function.Consumer;

public class ModOverworldRegion extends Region {
    public ModOverworldRegion() {
        super(PixelPirates.id("overworld_region"), RegionType.OVERWORLD, 10000);
    }

    @Override
    public void addBiomes(Registry<Biome> registry, Consumer<Pair<MultiNoiseUtil.NoiseHypercube, RegistryKey<Biome>>> mapper) {
        // Ring 1: Phase 1 (center, weirdness around 0.0)
        mapper.accept(Pair.of(MultiNoiseUtil.createNoiseHypercube(0.0F, 0.0F, 0F, 0F, 0F, 0.0F, 0F), Phase1Biomes.TEMPERATE_SHALLOWS));
        mapper.accept(Pair.of(MultiNoiseUtil.createNoiseHypercube(0.0F, 0.0F, 0F, 0F, 0F, 0.0F, 0F), Phase1Biomes.OPEN_OCEAN));
        mapper.accept(Pair.of(MultiNoiseUtil.createNoiseHypercube(0.0F, 0.0F, 0F, 0F, 0F, 0.0F, 0F), Phase1Biomes.ISLAND_THICKETS));

// Ring 2: Phase 2 (±0.25 weirdness)
        mapper.accept(Pair.of(MultiNoiseUtil.createNoiseHypercube(0.25F, 0.25F, 0F, 0F, 0F, 0.25F, 0F), Phase2Biomes.CORAL_BAY));
        mapper.accept(Pair.of(MultiNoiseUtil.createNoiseHypercube(0.25F, 0.25F, 0F, 0F, 0F, 0.25F, 0F), Phase2Biomes.REEF_EDGE));
        mapper.accept(Pair.of(MultiNoiseUtil.createNoiseHypercube(0.25F, 0.25F, 0F, 0F, 0F, 0.25F, 0F), Phase2Biomes.SIREN_SEA));
        mapper.accept(Pair.of(MultiNoiseUtil.createNoiseHypercube(-0.25F, -0.25F, 0F, 0F, 0F, -0.25F, 0F), Phase2Biomes.CORAL_BAY));
        mapper.accept(Pair.of(MultiNoiseUtil.createNoiseHypercube(-0.25F, -0.25F, 0F, 0F, 0F, -0.25F, 0F), Phase2Biomes.REEF_EDGE));
        mapper.accept(Pair.of(MultiNoiseUtil.createNoiseHypercube(-0.25F, -0.25F, 0F, 0F, 0F, -0.25F, 0F), Phase2Biomes.SIREN_SEA));

// Ring 3: Phase 3 (±0.5 weirdness)
        mapper.accept(Pair.of(MultiNoiseUtil.createNoiseHypercube(0.5F, 0.5F, 0F, 0F, 0F, 0.5F, 0F), Phase3Biomes.ASH_REEF));
        mapper.accept(Pair.of(MultiNoiseUtil.createNoiseHypercube(0.5F, 0.5F, 0F, 0F, 0F, 0.5F, 0F), Phase3Biomes.BOILING_BASIN));
        mapper.accept(Pair.of(MultiNoiseUtil.createNoiseHypercube(0.5F, 0.5F, 0F, 0F, 0F, 0.5F, 0F), Phase3Biomes.MAGMA_SEA));
        mapper.accept(Pair.of(MultiNoiseUtil.createNoiseHypercube(-0.5F, -0.5F, 0F, 0F, 0F, -0.5F, 0F), Phase3Biomes.ASH_REEF));
        mapper.accept(Pair.of(MultiNoiseUtil.createNoiseHypercube(-0.5F, -0.5F, 0F, 0F, 0F, -0.5F, 0F), Phase3Biomes.BOILING_BASIN));
        mapper.accept(Pair.of(MultiNoiseUtil.createNoiseHypercube(-0.5F, -0.5F, 0F, 0F, 0F, -0.5F, 0F), Phase3Biomes.MAGMA_SEA));

// Ring 4: Phase 4 (±0.75 weirdness)
        mapper.accept(Pair.of(MultiNoiseUtil.createNoiseHypercube(0.75F, 0.75F, 0F, 0F, 0F, 0.75F, 0F), Phase4Biomes.PHANTOM_WAKE));
        mapper.accept(Pair.of(MultiNoiseUtil.createNoiseHypercube(0.75F, 0.75F, 0F, 0F, 0F, 0.75F, 0F), Phase4Biomes.SHIPGRAVE_DEPTHS));
        mapper.accept(Pair.of(MultiNoiseUtil.createNoiseHypercube(0.75F, 0.75F, 0F, 0F, 0F, 0.75F, 0F), Phase4Biomes.DROWNED_TRENCH));
        mapper.accept(Pair.of(MultiNoiseUtil.createNoiseHypercube(-0.75F, -0.75F, 0F, 0F, 0F, -0.75F, 0F), Phase4Biomes.PHANTOM_WAKE));
        mapper.accept(Pair.of(MultiNoiseUtil.createNoiseHypercube(-0.75F, -0.75F, 0F, 0F, 0F, -0.75F, 0F), Phase4Biomes.SHIPGRAVE_DEPTHS));
        mapper.accept(Pair.of(MultiNoiseUtil.createNoiseHypercube(-0.75F, -0.75F, 0F, 0F, 0F, -0.75F, 0F), Phase4Biomes.DROWNED_TRENCH));

// Ring 5: Phase 5 (±0.95 weirdness)
        mapper.accept(Pair.of(MultiNoiseUtil.createNoiseHypercube(0.95F, 0.95F, 0F, 0F, 0F, 0.95F, 0F), Phase5Biomes.ABYSSAL_RINGS));
        mapper.accept(Pair.of(MultiNoiseUtil.createNoiseHypercube(0.95F, 0.95F, 0F, 0F, 0F, 0.95F, 0F), Phase5Biomes.PILLAR_SEA));
        mapper.accept(Pair.of(MultiNoiseUtil.createNoiseHypercube(0.95F, 0.95F, 0F, 0F, 0F, 0.95F, 0F), Phase5Biomes.MAW_DEPTHS));
        mapper.accept(Pair.of(MultiNoiseUtil.createNoiseHypercube(-0.95F, -0.95F, 0F, 0F, 0F, -0.95F, 0F), Phase5Biomes.ABYSSAL_RINGS));
        mapper.accept(Pair.of(MultiNoiseUtil.createNoiseHypercube(-0.95F, -0.95F, 0F, 0F, 0F, -0.95F, 0F), Phase5Biomes.PILLAR_SEA));
        mapper.accept(Pair.of(MultiNoiseUtil.createNoiseHypercube(-0.95F, -0.95F, 0F, 0F, 0F, -0.95F, 0F), Phase5Biomes.MAW_DEPTHS));
    }
}