package net.get900.pixelpirates.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.get900.pixelpirates.block.ModBlocks;
import net.get900.pixelpirates.block.custom.WaterLightBlock;
import net.get900.pixelpirates.item.ModItems;
import net.minecraft.data.client.*;
import net.minecraft.item.ArmorItem;
import net.minecraft.util.Identifier;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
       blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.GROG_BARREL);

        Identifier lampOffIdentifier = TexturedModel.CUBE_ALL.upload(ModBlocks.WATER_LIGHT_BLOCK, blockStateModelGenerator.modelCollector);
        Identifier lampOnIdentifier = blockStateModelGenerator.createSubModel(ModBlocks.WATER_LIGHT_BLOCK, "_on", Models.CUBE_ALL, TextureMap::all);
        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(ModBlocks.WATER_LIGHT_BLOCK)
                .coordinate(BlockStateModelGenerator.createBooleanModelMap(WaterLightBlock.CLICKED, lampOnIdentifier, lampOffIdentifier)));

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.BOARDING_AXE, Models.GENERATED);
        itemModelGenerator.register(ModItems.CANNON, Models.GENERATED);
        itemModelGenerator.register(ModItems.CANNON_BALL, Models.GENERATED);
        itemModelGenerator.register(ModItems.COIN, Models.GENERATED);
        itemModelGenerator.register(ModItems.COOKED_SALTED_SWIMMER, Models.GENERATED);
        itemModelGenerator.register(ModItems.COOKED_SHARK_MEAT, Models.GENERATED);
        itemModelGenerator.register(ModItems.CUTLASS, Models.GENERATED);
        itemModelGenerator.register(ModItems.DAGGER, Models.GENERATED);
        itemModelGenerator.register(ModItems.DRIFTWOOD, Models.GENERATED);
        itemModelGenerator.register(ModItems.DYNAMITE, Models.GENERATED);
        itemModelGenerator.register(ModItems.GROG, Models.GENERATED);
        itemModelGenerator.register(ModItems.KRAKEN_INK, Models.GENERATED);
        itemModelGenerator.register(ModItems.MAST, Models.GENERATED);
        itemModelGenerator.register(ModItems.MAST_WITH_SAILS, Models.GENERATED);
        itemModelGenerator.register(ModItems.PIRATE_COIN, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_SALTED_SWIMMER, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_SHARK_MEAT, Models.GENERATED);
        itemModelGenerator.register(ModItems.ROPE, Models.GENERATED);
        itemModelGenerator.register(ModItems.RUSTED_CUTLASS, Models.GENERATED);
        itemModelGenerator.register(ModItems.SAIL, Models.GENERATED);
        itemModelGenerator.register(ModItems.BROKEN_SHOVEL, Models.GENERATED);
        itemModelGenerator.register(ModItems.TATTERED_CLOTH, Models.GENERATED);

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.PIRATE_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.PIRATE_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.PIRATE_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.PIRATE_BOOTS));

    }
}
