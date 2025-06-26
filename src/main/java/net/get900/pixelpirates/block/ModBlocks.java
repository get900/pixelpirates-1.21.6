package net.get900.pixelpirates.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.get900.pixelpirates.PixelPirates;

import net.get900.pixelpirates.block.custom.GrogBarrelBlock;
import net.get900.pixelpirates.block.custom.WaterLightBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block GROG_BARREL = registerBlock("grog_barrel",
            new GrogBarrelBlock(AbstractBlock.Settings.create().strength(1.0f)
                    .sounds(BlockSoundGroup.WOOD)));

    public static final Block DRIFTWOOD_BLOCK = registerBlock("driftwood_block",
            new Block(AbstractBlock.Settings.create().strength(1.0f)
                    .requiresTool().sounds(BlockSoundGroup.WOOD)));

    public static final Block WATER_LIGHT_BLOCK = registerBlock("water_light_block",
            new WaterLightBlock(AbstractBlock.Settings.create().strength(1f).requiresTool().luminance(state -> state.get(WaterLightBlock.CLICKED)
            ? 15 : 0)));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(PixelPirates.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(PixelPirates.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        PixelPirates.LOGGER.info("Registered all mod blocks for " + PixelPirates.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(ModBlocks.DRIFTWOOD_BLOCK);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(ModBlocks.GROG_BARREL);
        });

    }
}