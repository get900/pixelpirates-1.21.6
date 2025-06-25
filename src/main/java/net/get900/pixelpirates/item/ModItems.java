package net.get900.pixelpirates.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.get900.pixelpirates.PixelPirates;
//import net.get900.pixelpirates.block.ModBlocks;
//import net.get900.pixelpirates.item.custom.GrogItem;
//import net.get900.pixelpirates.item.custom.RaftItem;
//import net.get900.pixelpirates.item.custom.ShipItem;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModItems {
    public static final Item COIN = registerItem("coin", Item::new);
    public static final Item PIRATE_COIN = registerItem("pirate_coin", Item::new);
    public static final Item KRAKEN_INK = registerItem("kraken_ink", Item::new);
    public static final Item DYNAMITE = registerItem("dynamite", Item::new);
    public static final Item CANNON_BALL = registerItem("cannon_ball", Item::new);
    public static final Item ROPE = registerItem("rope", Item::new);
    public static final Item CANNON = registerItem("cannon", Item::new);
    public static final Item SAIL = registerItem("sail", Item::new);
    public static final Item MAST_WITH_SAILS = registerItem("mast_with_sails", Item::new);
    public static final Item MAST = registerItem("mast", Item::new);
    public static final Item DRIFTWOOD = registerItem("driftwood", Item::new);

    //Special items

   // public static final Item SHIP_ITEM = Registry.register(Registries.ITEM, Identifier.of(PixelPirates.MOD_ID, "ship_item"),
     //       new ShipItem(new Item.Settings().maxCount(1)));
   // public static final Item RAFT_ITEM = Registry.register(Registries.ITEM, Identifier.of(PixelPirates.MOD_ID, "raft_item"),
     //       new RaftItem(new Item.Settings().maxCount(1)));

    //Food items
    //public static final Item GROG = Registry.register(Registries.ITEM, Identifier.of(PixelPirates.MOD_ID, "grog"),
        //    new GrogItem(new Item.Settings().maxCount(16).food(FoodComponents.HONEY_BOTTLE)));
    public static final Item COOKED_SHARK_MEAT = registerItem("cooked_shark_meat", settings -> new Item(settings.food(ModFoodComponents.COOKED_SHARK_MEAT)));
    public static final Item RAW_SHARK_MEAT = registerItem("raw_shark_meat", setting -> new Item(setting.food(ModFoodComponents.RAW_SHARK_MEAT)));

    //Fuel items

    //Tool items

    //Armor items

    //Weapon items
    public static final Item CUTLASS = registerItem("cutlass", Item::new);
    public static final Item DAGGER = registerItem("dagger", Item::new);

    private static Item registerItem(String name, Function<Item.Settings, Item> function) {
        return Registry.register(Registries.ITEM, Identifier.of(PixelPirates.MOD_ID, name),
                function.apply(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(PixelPirates.MOD_ID, name)))));
    }

    public static Identifier id = Identifier.of(PixelPirates.MOD_ID, "your_item_name");
    public static RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, id);

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
            entries.add(RAW_SHARK_MEAT);
            entries.add(KRAKEN_INK);
            entries.add(CANNON);
            entries.add(SAIL);
            entries.add(MAST_WITH_SAILS);
            entries.add(MAST);
            entries.add(COOKED_SHARK_MEAT);
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
