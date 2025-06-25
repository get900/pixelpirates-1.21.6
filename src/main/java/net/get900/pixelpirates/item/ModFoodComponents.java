package net.get900.pixelpirates.item;


import net.minecraft.component.type.FoodComponent;

public class ModFoodComponents {
    public static final FoodComponent COOKED_SHARK_MEAT = new FoodComponent.Builder().nutrition(8).saturationModifier(0.3f).build();

    public static final FoodComponent RAW_SHARK_MEAT = new FoodComponent.Builder()
            .nutrition(4)
            .saturationModifier(0.3F)
            .build();
}