package net.get900.pixelpirates.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.get900.pixelpirates.PixelPirates;
import net.get900.pixelpirates.block.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup PIXELPIRATES_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(PixelPirates.MOD_ID,"pixelpirates"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.PIRATE_COIN))
                    .displayName(Text.translatable("itemgroup.pixelpirates.pixelpirates"))
                    .entries((displayContext, entries) -> {

                        entries.add(ModItems.COIN);
                        entries.add(ModItems.PIRATE_COIN);
                        entries.add(ModItems.CUTLASS);
                        entries.add(ModItems.DAGGER);
                        entries.add(ModItems.DYNAMITE);
                        entries.add(ModItems.CANNON_BALL);
                  //      entries.add(ModItems.SHIP_ITEM);
                  //      entries.add(ModItems.RAFT_ITEM);
                        //entries.add(ModItems.PIRATE_HAT);
                        entries.add(ModItems.ROPE);
                        entries.add(ModItems.KRAKEN_INK);
                        entries.add(ModItems.CANNON);
                        entries.add(ModItems.SAIL);
                        entries.add(ModItems.MAST_WITH_SAILS);
                        entries.add(ModItems.MAST);
                        entries.add(ModItems.DRIFTWOOD);
                        entries.add(ModItems.TATTERED_CLOTH);

                    }).build());

    public static final ItemGroup PIXELPIRATES_BLOCKS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(PixelPirates.MOD_ID,"pixelpirates_blocks"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.DRIFTWOOD_BLOCK))
                    .displayName(Text.translatable("itemgroup.pixelpirates.pixelpirates_blocks"))
                    .entries((displayContext, entries) -> {

                        entries.add(ModBlocks.GROG_BARREL);
                        entries.add(ModBlocks.DRIFTWOOD_BLOCK);
                        entries.add(ModBlocks.WATER_LIGHT_BLOCK);

                    }).build());

    public static final ItemGroup PIXELPIRATES_FOOD_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(PixelPirates.MOD_ID,"pixelpirates_food"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.GROG))
                    .displayName(Text.translatable("itemgroup.pixelpirates.pixelpirates_food"))
                    .entries((displayContext, entries) -> {

                        entries.add(ModItems.GROG);
                        entries.add(ModItems.RAW_SHARK_MEAT);
                        entries.add(ModItems.COOKED_SHARK_MEAT);
                        entries.add(ModItems.RAW_SALTED_SWIMMER);
                        entries.add(ModItems.COOKED_SALTED_SWIMMER);

                    }).build());

    public static final ItemGroup PIXELPIRATES_GEAR_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(PixelPirates.MOD_ID,"pixelpirates_gear"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.CUTLASS))
                    .displayName(Text.translatable("itemgroup.pixelpirates.pixelpirates_gear"))
                    .entries((displayContext, entries) -> {

                        entries.add(ModItems.CUTLASS);
                        entries.add(ModItems.DAGGER);
                        entries.add(ModItems.DYNAMITE);
                        entries.add(ModItems.RUSTED_CUTLASS);
                        entries.add(ModItems.BOARDING_AXE);
                        entries.add(ModItems.BROKEN_SHOVEL);
                        entries.add(ModItems.PIRATE_HELMET);
                        entries.add(ModItems.PIRATE_CHESTPLATE);
                        entries.add(ModItems.PIRATE_LEGGINGS);
                        entries.add(ModItems.PIRATE_BOOTS);

                    }).build());

    public static void registerItemGroups() {
        PixelPirates.LOGGER.info("Registering Item Groups for " + PixelPirates.MOD_ID);
    }
}
