package net.get900.pixelpirates;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.get900.pixelpirates.block.ModBlocks;
import net.get900.pixelpirates.entity.ModEntities;
import net.get900.pixelpirates.entity.custom.SharkEntity;
import net.get900.pixelpirates.item.ModItemGroups;
import net.get900.pixelpirates.item.ModItems;
import net.get900.pixelpirates.world.gen.ModWorldGeneration;
import net.get900.pixelpirates.world.tree.ModTreeDecorator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class PixelPirates implements ModInitializer {
	public static final String MOD_ID = "pixelpirates";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModItemGroups.registerItemGroups();
		ModBlocks.registerModBlocks();

		ModWorldGeneration.generateModWorldGen();
		ModTreeDecorator.init();

		FuelRegistry.INSTANCE.add(ModItems.DRIFTWOOD, 800);

		ModEntities.registerSpawns();
		ModEntities.registerModEntities();
		FabricDefaultAttributeRegistry.register(ModEntities.SHARK, SharkEntity.createAttributes());

		LOGGER.info("Pixel Pirates is initializing...");

		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.DRIFTWOOD_BLOCK, 5, 5);
	}
}