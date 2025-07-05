package net.get900.pixelpirates.item;


import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class ModFoodComponents {
    public static final FoodComponent COOKED_SHARK_MEAT = new FoodComponent.Builder().nutrition(8).saturationModifier(0.3f).build();
    public static final FoodComponent RAW_SHARK_MEAT = new FoodComponent.Builder().nutrition(4).saturationModifier(0.3F)
            .statusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 200, 0), 0.4f).build();
    public static final FoodComponent RAW_SALTED_SWIMMER = new FoodComponent.Builder().nutrition(2).saturationModifier(0.3F)
            .statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 200, 0), 0.4f).build();
    public static final FoodComponent COOKED_SALTED_SWIMMER = new FoodComponent.Builder().nutrition(5).saturationModifier(0.3F).build();
    public static final FoodComponent BANANA = new FoodComponent.Builder().nutrition(2).saturationModifier(0.1F).build();
    public static final FoodComponent COCONUT = new FoodComponent.Builder().nutrition(2).saturationModifier(0.1F).build();
}