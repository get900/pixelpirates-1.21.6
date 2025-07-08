package net.get900.pixelpirates.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.get900.pixelpirates.PixelPirates;
import net.get900.pixelpirates.entity.custom.DynamiteEntity;
import net.get900.pixelpirates.entity.custom.RaftEntity;
import net.get900.pixelpirates.entity.custom.SharkEntity;
import net.get900.pixelpirates.entity.custom.SloopEntity;
import net.minecraft.entity.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.world.Heightmap;

public class ModEntities {
    public static final EntityType<SharkEntity> SHARK = Registry.register(
            Registries.ENTITY_TYPE,
            Identifier.of(PixelPirates.MOD_ID, "shark"),
            FabricEntityTypeBuilder.create(SpawnGroup.WATER_CREATURE, SharkEntity::new)
                    .dimensions(EntityDimensions.fixed(0.3f, 0.2f))
                    .trackRangeChunks(8)
                    .build()
    );

    public static final EntityType<RaftEntity> RAFT = Registry.register(
            Registries.ENTITY_TYPE,
            Identifier.of(PixelPirates.MOD_ID, "raft"),
            FabricEntityTypeBuilder.<RaftEntity>create(SpawnGroup.MISC, RaftEntity::new)
                    .dimensions(EntityDimensions.fixed(7.0f, 0.25f)) // Adjust to fit your raft model
                    .trackRangeBlocks(12)
                    .trackedUpdateRate(1)
                    .build()
    );

    public static final EntityType<SloopEntity> SLOOP = Registry.register(
            Registries.ENTITY_TYPE,
            Identifier.of(PixelPirates.MOD_ID, "sloop"),
            FabricEntityTypeBuilder.<SloopEntity>create(SpawnGroup.MISC, SloopEntity::new)
                    .dimensions(EntityDimensions.fixed(14.0f, 7.0f)) // Adjust to fit your sloop model
                    .trackRangeBlocks(80)
                    .trackedUpdateRate(1)
                    .build()
    );

    public static final EntityType<DynamiteEntity> DYNAMITE = Registry.register(
            Registries.ENTITY_TYPE,
            Identifier.of(PixelPirates.MOD_ID, "dynamite"),
            FabricEntityTypeBuilder.<DynamiteEntity>create(SpawnGroup.MISC, DynamiteEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25f, 0.25f))
                    .trackRangeBlocks(64)
                    .trackedUpdateRate(10)
                    .build()
    );

    public static void registerModEntities() {
        PixelPirates.LOGGER.info("Registering ModEntities for " + PixelPirates.MOD_ID);
    }
}
