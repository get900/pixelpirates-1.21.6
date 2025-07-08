package net.get900.pixelpirates.world;

import net.get900.pixelpirates.PixelPirates;
import net.get900.pixelpirates.block.ModBlocks;
import net.get900.pixelpirates.world.tree.BananaTreeDecorator;
import net.get900.pixelpirates.world.tree.CoconutTreeDecorator;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.treedecorator.BeehiveTreeDecorator;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

import java.util.List;


public class ModConfiguredFeatures {
    // CF (Configure Feature, What) -> PF (Place Feature, How) -> BM (Biome Modifications, Where)
    public static final RegistryKey<ConfiguredFeature<?, ?>> DRIFTWOOD_BLOCK_KEY = registerKey("driftwood_block");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
      //  RuleTest stoneReplaceable = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
       // RuleTest deepslateReplaceable = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
       // RuleTest netherReplaceable = new TagMatchRuleTest(BlockTags.BASE_STONE_NETHER);
       // RuleTest endReplaceable = new BlockMatchRuleTest(Blocks.END_STONE);

        register(context, DRIFTWOOD_BLOCK_KEY, Feature.BLOCK_PILE, new BlockPileFeatureConfig(
                BlockStateProvider.of(ModBlocks.DRIFTWOOD_BLOCK)
        ));
        TreeFeatureConfig shorewoodTreeConfig = new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.SHOREWOOD_LOG),
                new StraightTrunkPlacer(5, 2, 1),
                BlockStateProvider.of(ModBlocks.SHOREWOOD_LEAVES.getDefaultState().with(Properties.PERSISTENT, true)),
                new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 3),
                new TwoLayersFeatureSize(1, 0, 1)
        )
                .decorators(List.of(new BananaTreeDecorator(0.2f), new CoconutTreeDecorator(0.1f), new BeehiveTreeDecorator(0.05f)))
                .ignoreVines().build();

        ConfiguredFeature<?, ?> shorewoodTreeFeature = new ConfiguredFeature<>(Feature.TREE, shorewoodTreeConfig);

        context.register(
                (RegistryKey<ConfiguredFeature<?, ?>>)(Object) SHOREWOOD_TREE_KEY,
                shorewoodTreeFeature
        );
    }

    //TemperateShallows
    @SuppressWarnings("unchecked")
    public static final RegistryKey<ConfiguredFeature<TreeFeatureConfig, ?>> SHOREWOOD_TREE_KEY =
            (RegistryKey<ConfiguredFeature<TreeFeatureConfig, ?>>)(Object)
                    RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE,
                            Identifier.of(PixelPirates.MOD_ID, "shorewood_tree"));


    //Helpers

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(PixelPirates.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
