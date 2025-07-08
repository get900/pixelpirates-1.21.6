package net.get900.pixelpirates.world.biome;

import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;

public class ModBiomeKeys {
    //Phase 1
    public static final RegistryKey<Biome> TEMPERATE_SHALLOWS = RegistryKey.of(
            RegistryKeys.BIOME, Identifier.of("pixelpirates", "temperate_shallows"));
    public static final RegistryKey<Biome> ISLAND_THICKETS = RegistryKey.of(
            RegistryKeys.BIOME, Identifier.of("pixelpirates", "island_thickets"));
    public static final RegistryKey<Biome> OPEN_OCEAN = RegistryKey.of(
            RegistryKeys.BIOME, Identifier.of("pixelpirates", "open_ocean"));
    //Phase 2
    public static final RegistryKey<Biome> CORAL_BAY = RegistryKey.of(
            RegistryKeys.BIOME, Identifier.of("pixelpirates", "coral_bay"));
    public static final RegistryKey<Biome> REEF_EDGE = RegistryKey.of(
            RegistryKeys.BIOME, Identifier.of("pixelpirates", "reef_edge"));
    public static final RegistryKey<Biome> SIREN_SEA = RegistryKey.of(
            RegistryKeys.BIOME, Identifier.of("pixelpirates", "siren_sea"));
    //Phase3
    public static final RegistryKey<Biome> ASH_REEF = RegistryKey.of(
            RegistryKeys.BIOME, Identifier.of("pixelpirates", "ash_reef"));
    public static final RegistryKey<Biome> BOILING_BASIN = RegistryKey.of(
            RegistryKeys.BIOME, Identifier.of("pixelpirates", "boiling_basin"));
    public static final RegistryKey<Biome> MAGMA_SEA = RegistryKey.of(
            RegistryKeys.BIOME, Identifier.of("pixelpirates", "magma_sea"));
    //Phase 4
    public static final RegistryKey<Biome> PHANTOM_WAKE = RegistryKey.of(
            RegistryKeys.BIOME, Identifier.of("pixelpirates", "phantom_wake"));
    public static final RegistryKey<Biome> SHIPGRAVE_DEPTHS = RegistryKey.of(
            RegistryKeys.BIOME, Identifier.of("pixelpirates", "shipgrave_depths"));
    public static final RegistryKey<Biome> DROWNED_TRENCH = RegistryKey.of(
            RegistryKeys.BIOME, Identifier.of("pixelpirates", "drowned_trench"));
    //Phase 5
    public static final RegistryKey<Biome> ABYSSAL_RINGS = RegistryKey.of(
            RegistryKeys.BIOME, Identifier.of("pixelpirates", "abyssal_rings"));
    public static final RegistryKey<Biome> PILLAR_SEA = RegistryKey.of(
            RegistryKeys.BIOME, Identifier.of("pixelpirates", "pillar_sea"));
    public static final RegistryKey<Biome> MAW_DEPTHS = RegistryKey.of(
            RegistryKeys.BIOME, Identifier.of("pixelpirates", "maw_depths"));
}
