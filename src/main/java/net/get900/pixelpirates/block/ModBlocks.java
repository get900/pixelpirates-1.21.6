package net.get900.pixelpirates.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.get900.pixelpirates.PixelPirates;

import net.get900.pixelpirates.block.custom.GrogBarrelBlock;
import net.get900.pixelpirates.block.custom.WaterLightBlock;
import net.get900.pixelpirates.world.ModConfiguredFeatures;
import net.minecraft.block.*;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {
    //General
    public static final Block GROG_BARREL = registerBlock("grog_barrel",
            new GrogBarrelBlock(AbstractBlock.Settings.create().strength(1.0f)
                    .sounds(BlockSoundGroup.WOOD)));

    public static final Block WATER_LIGHT_BLOCK = registerBlock("water_light_block",
            new WaterLightBlock(AbstractBlock.Settings.create().strength(1f).requiresTool().luminance(state -> state.get(WaterLightBlock.CLICKED)
            ? 15 : 0)));

    //Temperate Shallows
    public static final Block DRIFTWOOD_BLOCK = registerBlock("driftwood_block",
            new PillarBlock(AbstractBlock.Settings.create().strength(1.0f)
                    .requiresTool().sounds(BlockSoundGroup.WOOD)));
    public static final Block SHOREWOOD_LOG = registerBlock("shorewood_log",
            new PillarBlock(AbstractBlock.Settings.create().strength(2.0f).mapColor(MapColor.SPRUCE_BROWN)));
    public static final Block SHOREWOOD_WOOD = registerBlock("shorewood_wood",
            new PillarBlock(AbstractBlock.Settings.create().strength(2.0f).mapColor(MapColor.SPRUCE_BROWN)));
    public static final Block STRIPPED_SHOREWOOD_LOG = registerBlock("stripped_shorewood_log",
            new PillarBlock(AbstractBlock.Settings.create().strength(2.0f).mapColor(MapColor.PALE_YELLOW)));
    public static final Block STRIPPED_SHOREWOOD_WOOD = registerBlock("stripped_shorewood_wood",
            new PillarBlock(AbstractBlock.Settings.create().strength(2.0f).mapColor(MapColor.PALE_YELLOW)));
    public static final Block SHOREWOOD_LEAVES = registerBlock("shorewood_leaves",
            new LeavesBlock(AbstractBlock.Settings.create().strength(0.2f).nonOpaque().mapColor(MapColor.DARK_GREEN)));
    public static final Block SHOREWOOD_SAPLING = registerBlock("shorewood_sapling",
            new FlowerBlock(StatusEffects.LUCK, 0,  // Temporary base block
                    AbstractBlock.Settings.create().strength(0.0f).ticksRandomly().nonOpaque().mapColor(MapColor.DARK_GREEN)));
    public static final Block POTTED_SHOREWOOD_SAPLING = Registry.register(Registries.BLOCK,
            Identifier.of(PixelPirates.MOD_ID, "potted_shorewood_sapling"), new FlowerPotBlock(SHOREWOOD_SAPLING,
                    AbstractBlock.Settings.create().nonOpaque().breakInstantly()));
    public static final Block BANANA_BLOCK = registerBlock("banana_block",
            new Block(AbstractBlock.Settings.create().strength(0.3f).nonOpaque().mapColor(MapColor.YELLOW)));
    public static final Block COCONUT_BLOCK = registerBlock("coconut_block",
            new Block(AbstractBlock.Settings.create().strength(0.5f).nonOpaque().mapColor(MapColor.BROWN)));

    //Deep Ocean

    //Volcanic Waters

    //Dead Waters

    //Frozen Sea

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