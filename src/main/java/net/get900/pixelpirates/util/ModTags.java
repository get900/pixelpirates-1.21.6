package net.get900.pixelpirates.util;

import net.get900.pixelpirates.PixelPirates;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> NEEDS_PIRATE_TOOL = createTag("needs_pirate_tool");
        public static final TagKey<Block> INCORRECT_FOR_PIRATE_TOOL = createTag("incorrect_for_pirate_tool");

        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(PixelPirates.MOD_ID, name));
        }
    }

    public static class Items {
            public static final TagKey<Item> SHOOTABLE_ITEMS = createTag("shootable_items");

            private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(PixelPirates.MOD_ID, name));
        }
    }
}
