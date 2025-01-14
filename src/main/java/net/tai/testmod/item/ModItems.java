package net.tai.testmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.tai.testmod.TestMod;
import net.tai.testmod.item.custom.ChiselItem;
import net.tai.testmod.item.custom.Drink;

import java.util.List;

public class ModItems {
    public static final Item RUBY_GEM = registerItem("ruby_gem", new Item(new Item.Settings()));
    public static final Item RAW_RUBY = registerItem("raw_ruby", new Item(new Item.Settings()));

    public static final Item SMASHED_COAL = registerItem("smashed_coal", new Item(new Item.Settings()));

    public static final Item TRUFFLE = registerItem("truffle", new Item(new Item.Settings().maxCount(16).food(ModFoodComponents.TRUFFLE)));

    public static final Item TRUFFLE_STEW = registerItem("truffle_stew", new Item(new Item.Settings().maxCount(1).food(ModFoodComponents.TRUFFLE_STEW)){
        @Override
        public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType options) {
            if (Screen.hasShiftDown()) {
                tooltip.add(Text.translatable("tooltip.testmod.truffle_stew"));
            }
            else {
                tooltip.add(Text.translatable("tooltip.testmod.shift_down"));
            }
            super.appendTooltip(stack, context, tooltip, options);
        }});
    public static final Item DRINK = registerItem("drink", new Drink(new Item.Settings().food(ModFoodComponents.DRINK)));


    public static final Item IRON_CHISEL = registerItem("iron_chisel", new ChiselItem(new Item.Settings().maxDamage(32)));
    public static final Item DIAMOND_CHISEL = registerItem("diamond_chisel", new ChiselItem(new Item.Settings().maxDamage(64)));
    public static final Item NETHERITE_CHISEL = registerItem("netherite_chisel", new ChiselItem(new Item.Settings().maxDamage(128)));

    public static final Item COD_SKEWER = registerItem("cod_skewer", new Item(new Item.Settings().maxCount(16).food(ModFoodComponents.COD_SKEWER)));
    public static final Item SALMON_SKEWER = registerItem("salmon_skewer", new Item(new Item.Settings().maxCount(16).food(ModFoodComponents.SALMON_SKEWER)));

    public static final Item BAKED_APPLE = registerItem("baked_apple", new Item(new Item.Settings().food(ModFoodComponents.BAKED_APPLE)));



    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, Identifier.of(TestMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        TestMod.LOGGER.info("Registering Mod Items for "+ TestMod.MOD_ID);

    }
}
