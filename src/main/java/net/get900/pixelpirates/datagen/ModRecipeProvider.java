package net.get900.pixelpirates.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.get900.pixelpirates.block.ModBlocks;
import net.get900.pixelpirates.item.ModItems;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.MinecartItem;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter recipeExporter) {
        List<ItemConvertible> RAW_SHARK_MEAT_SMELTABLES = List.of(ModItems.RAW_SHARK_MEAT);
        List<ItemConvertible> RAW_SALTED_SWIMMER_SMELTABLES = List.of(ModItems.RAW_SALTED_SWIMMER);

        offerSmelting(recipeExporter, RAW_SHARK_MEAT_SMELTABLES, RecipeCategory.FOOD, ModItems.RAW_SHARK_MEAT, 0.5f, 200,"cooked_shark_meat");
        offerSmelting(recipeExporter, RAW_SALTED_SWIMMER_SMELTABLES, RecipeCategory.FOOD, ModItems.RAW_SALTED_SWIMMER, 0.5f, 200,"cooked_salted_swimmer");

        // Make a block from 9 items
        offerReversibleCompactingRecipes(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModItems.DRIFTWOOD, RecipeCategory.MISC, ModBlocks.DRIFTWOOD_BLOCK);
    }
}
