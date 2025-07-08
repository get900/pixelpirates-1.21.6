package net.get900.pixelpirates.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.get900.pixelpirates.entity.ModEntities;
import net.get900.pixelpirates.world.biome.ModBiomeKeys;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnLocationTypes;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.mob.WaterCreatureEntity;

import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.BiomeKeys;

public class ModEntitySpawns {
    public static void addSpawns() {
       // BiomeModifications.addSpawn(BiomeSelectors.includeByKey(ModBiomeKeys.TEMPERATE_SHALLOWS, ModBiomeKeys.OPEN_OCEAN),
       //         SpawnGroup.WATER_CREATURE, ModEntities.SHARK, 10, 1, 3);
       // SpawnRestriction.register(ModEntities.SHARK, SpawnLocationTypes.IN_WATER,
       //         Heightmap.Type.OCEAN_FLOOR, WaterCreatureEntity::canSpawn);
    }
}