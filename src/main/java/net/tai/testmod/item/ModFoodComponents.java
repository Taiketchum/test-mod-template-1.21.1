package net.tai.testmod.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Items;

public class ModFoodComponents {
    public static final FoodComponent TRUFFLE_STEW = new FoodComponent.Builder().nutrition(6).saturationModifier(0.6f).usingConvertsTo(Items.BOWL)
            .statusEffect(new StatusEffectInstance(StatusEffects.HEALTH_BOOST,200), 0.40f).build();
    public static final FoodComponent TRUFFLE = new FoodComponent.Builder().nutrition(1).saturationModifier(0.3f)
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION,100), 0.05f).build();

    public static final FoodComponent COD_SKEWER = new FoodComponent.Builder().nutrition(6).saturationModifier(0.6f).usingConvertsTo(Items.STICK)
            .build();
    public static final FoodComponent SALMON_SKEWER = new FoodComponent.Builder().nutrition(6).saturationModifier(0.6f).usingConvertsTo(Items.STICK)
            .build();
    public static final FoodComponent BAKED_APPLE = new FoodComponent.Builder().nutrition(6).saturationModifier(0.6f)
            .build();


    public static final FoodComponent DRINK = new FoodComponent.Builder().nutrition(1).saturationModifier(0.1f)
            .statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA,200), 1f).build();
}
