package net.get900.pixelpirates.world.biome;

import net.get900.pixelpirates.PixelPirates;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;

public class ModBiomeKeys {
    public static final RegistryKey<Biome> TEMPERATE_SHALLOWS = RegistryKey.of(
            RegistryKeys.BIOME, Identifier.of("pixelpirates", "temperate_shallows"));
    public static RegistryKey<Biome> OPEN_OCEAN = RegistryKey.of(
            RegistryKeys.BIOME, Identifier.of("pixelpirates", "open_ocean"));
    public static RegistryKey<Biome> VOLCANIC_WATERS = RegistryKey.of(
            RegistryKeys.BIOME, Identifier.of("pixelpirates", "volcanic_waters"));
    public static RegistryKey<Biome> DEAD_WATERS = RegistryKey.of(
            RegistryKeys.BIOME, Identifier.of("pixelpirates", "dead_waters"));
    public static RegistryKey<Biome> FROZEN_SEA = RegistryKey.of(
            RegistryKeys.BIOME, Identifier.of("pixelpirates", "frozen_sea"));
}