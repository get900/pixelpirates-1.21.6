package net.get900.pixelpirates.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.get900.pixelpirates.PixelPirates;
//import net.get900.pixelpirates.block.ModBlocks;
//import net.get900.pixelpirates.item.custom.GrogItem;
//import net.get900.pixelpirates.item.custom.RaftItem;
//import net.get900.pixelpirates.item.custom.ShipItem;
import net.get900.pixelpirates.item.custom.GrogItem;
import net.get900.pixelpirates.item.custom.ModArmorItem;
import net.get900.pixelpirates.util.ModTags;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.component.type.FoodComponents;
import net.minecraft.item.*;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.function.Function;

public class ModItems {
    public static final Item COIN = registerItem("coin", new Item(new Item.Settings()));
    public static final Item PIRATE_COIN = registerItem("pirate_coin", new Item(new Item.Settings()));
    public static final Item KRAKEN_INK = registerItem("kraken_ink", new Item(new Item.Settings()));
    public static final Item DYNAMITE = registerItem("dynamite", new Item(new Item.Settings()));
    public static final Item ROPE = registerItem("rope", new Item(new Item.Settings()));
    public static final Item CANNON = registerItem("cannon", new Item(new Item.Settings()));
    public static final Item SAIL = registerItem("sail", new Item(new Item.Settings()));
    public static final Item MAST_WITH_SAILS = registerItem("mast_with_sails", new Item(new Item.Settings()));
    public static final Item MAST = registerItem("mast", new Item(new Item.Settings()));
    public static final Item DRIFTWOOD = registerItem("driftwood", new Item(new Item.Settings()));
    public static final Item TATTERED_CLOTH = registerItem("tattered_cloth", new Item(new Item.Settings()));

    //Special items
    public static final Item CANNON_BALL = registerItem("cannon_ball", new Item(new Item.Settings()) {
        private boolean isValidItem(ItemStack stack) {
            return stack.isIn(ModTags.Items.SHOOTABLE_ITEMS);
        }
    });

   // public static final Item SHIP_ITEM = Registry.register(Registries.ITEM, Identifier.of(PixelPirates.MOD_ID, "ship_item"),
     //       new ShipItem(new Item.Settings().maxCount(1)));
   // public static final Item RAFT_ITEM = Registry.register(Registries.ITEM, Identifier.of(PixelPirates.MOD_ID, "raft_item"),
     //       new RaftItem(new Item.Settings().maxCount(1)));

    //Food items
    public static final Item GROG = Registry.register(Registries.ITEM, Identifier.of(PixelPirates.MOD_ID, "grog"),
            new GrogItem(new Item.Settings().maxCount(16).food(FoodComponents.HONEY_BOTTLE)));
    public static final Item COOKED_SHARK_MEAT = registerItem("cooked_shark_meat", new Item(new Item.Settings().food(ModFoodComponents.COOKED_SHARK_MEAT)));
    public static final Item RAW_SHARK_MEAT = registerItem("raw_shark_meat", new Item(new Item.Settings().food(ModFoodComponents.RAW_SHARK_MEAT)));
    public static final Item RAW_SALTED_SWIMMER = registerItem("raw_salted_swimmer", new Item(new Item.Settings().food(ModFoodComponents.RAW_SALTED_SWIMMER)));
    public static final Item COOKED_SALTED_SWIMMER = registerItem("cooked_salted_swimmer", new Item(new Item.Settings().food(ModFoodComponents.COOKED_SALTED_SWIMMER)));

    //Fuel items

    //Tool items

    //Armor items
    public static final Item PIRATE_HELMET = registerItem("pirate_helmet",
            new ModArmorItem(ModArmorMaterials.PIRATE_ARMOR_MATERIAL, ArmorItem.Type.HELMET, new Item.Settings()
                    .maxDamage(ArmorItem.Type.HELMET.getMaxDamage(15))));
    public static final Item PIRATE_CHESTPLATE = registerItem("pirate_chestplate",
            new ArmorItem(ModArmorMaterials.PIRATE_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Settings()
                    .maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(15))));
    public static final Item PIRATE_LEGGINGS = registerItem("pirate_leggings",
            new ArmorItem(ModArmorMaterials.PIRATE_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Settings()
                    .maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(15))));
    public static final Item PIRATE_BOOTS = registerItem("pirate_boots",
            new ArmorItem(ModArmorMaterials.PIRATE_ARMOR_MATERIAL, ArmorItem.Type.BOOTS, new Item.Settings()
                    .maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(15))));

    //Weapon items
    public static final Item CUTLASS = registerItem("cutlass",
            new SwordItem(ModToolMaterials.PIRATE, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.PIRATE, 4, 2))));
    public static final Item DAGGER = registerItem("dagger",
            new SwordItem(ModToolMaterials.PIRATE, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.PIRATE, 2, 4))));
    public static final Item RUSTED_CUTLASS = registerItem("rusted_cutlass",
            new SwordItem(ModToolMaterials.PIRATE, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.PIRATE, 2, 2))));
    public static final Item BROKEN_SHOVEL = registerItem("broken_shovel",
            new ShovelItem(ModToolMaterials.PIRATE, new Item.Settings().attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.PIRATE, 0, -2.4f))));
    public static final Item BOARDING_AXE = registerItem("boarding_axe",
            new AxeItem(ModToolMaterials.PIRATE, new Item.Settings().attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.PIRATE, 1, 2))) {
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("tooltip.pixelpirates.boarding_axe.tooltip"));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(PixelPirates.MOD_ID, name), item);
    }

    public static void registerModItems() {
        PixelPirates.LOGGER.info("Registering Mod Items for " + PixelPirates.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(COIN);
            entries.add(PIRATE_COIN);
            entries.add(CUTLASS);
            entries.add(DAGGER);
            entries.add(DYNAMITE);
            entries.add(CANNON_BALL);
           // entries.add(SHIP_ITEM);
           // entries.add(RAFT_ITEM);
            //entries.add(PIRATE_HAT);
            entries.add(ROPE);
          //  entries.add(RAW_SHARK_MEAT);
            entries.add(KRAKEN_INK);
            entries.add(CANNON);
            entries.add(SAIL);
            entries.add(MAST_WITH_SAILS);
            entries.add(MAST);
          //  entries.add(COOKED_SHARK_MEAT);
            entries.add(DRIFTWOOD);

           // entries.add(ModBlocks.GUNPOWDER_BARREL);
           // entries.add(ModBlocks.GROG_BARREL);
           // entries.add(ModBlocks.DRIFTWOOD_BLOCK);

            //Special items

            //Food items
           // entries.add(GROG);
            //Fuel items

            //Tool items
        });
    }
}
