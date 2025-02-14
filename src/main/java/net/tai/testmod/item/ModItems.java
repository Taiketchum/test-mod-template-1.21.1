package net.tai.testmod.item;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.item.*;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.tai.testmod.TestMod;
import net.tai.testmod.block.ModBlocks;
import net.tai.testmod.item.custom.*;

import java.util.List;

import static net.minecraft.item.Items.register;

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
    public static final Item DRINK = registerItem("drink", new Drink(new Item.Settings().food(ModFoodComponents.DRINK)){
        @Override
        public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType options) {
            if (Screen.hasShiftDown()) {
                tooltip.add(Text.translatable("tooltip.testmod.drink"));
            }
            else {
                tooltip.add(Text.translatable("tooltip.testmod.shift_down"));
            }
            super.appendTooltip(stack, context, tooltip, options);
        }});


    public static final Item IRON_CHISEL = registerItem("iron_chisel", new ChiselItem(new Item.Settings().maxDamage(32)));
    public static final Item DIAMOND_CHISEL = registerItem("diamond_chisel", new ChiselItem(new Item.Settings().maxDamage(64)));
    public static final Item NETHERITE_CHISEL = registerItem("netherite_chisel", new ChiselItem(new Item.Settings().maxDamage(128)));

    public static final Item COD_SKEWER = registerItem("cod_skewer", new Item(new Item.Settings().maxCount(16).food(ModFoodComponents.COD_SKEWER)));
    public static final Item SALMON_SKEWER = registerItem("salmon_skewer", new Item(new Item.Settings().maxCount(16).food(ModFoodComponents.SALMON_SKEWER)));

    public static final Item BAKED_APPLE = registerItem("baked_apple", new Item(new Item.Settings().food(ModFoodComponents.BAKED_APPLE)));

    public static final Item ELECTRIC_DUST = registerItem("electric_dust", new Item(new Item.Settings().maxCount(16)));
    public static final Item HEART_OF_THE_STORM = registerItem("heart_of_the_storm", new Item(new Item.Settings().maxCount(1)));
    public static final Item ELECTRIC_INGOT = registerItem("electric_ingot", new Item(new Item.Settings()));

    public static final Item STORM_SCYTHE = registerItem("storm_scythe",
            new StormScythe(ModToolMaterials.STORM, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.STORM,7,-3.4f))));

    public static final Item SILVER_AXE = registerItem("silver_axe",
            new AxeItem(ToolMaterials.IRON, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.IRON,6,-3.2f))));
    public static final Item GOLD_AXE = registerItem("gold_axe",
            new AxeItem(ToolMaterials.IRON, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.IRON,6,-3.2f))));

    public static final Item SW_2023 = registerItem("sw_2023",
            new SwordItem(ModToolMaterials.KAIJU, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.KAIJU,3,-2.4f))));
    public static final Item SW_2024 = registerItem("sw_2024",
            new SwordItem(ModToolMaterials.KAIJU, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.KAIJU,3,-2.4f))));

    public static final Item RUBY_SWORD = registerItem("ruby_sword",
            new SwordItem(ModToolMaterials.RUBY_GEM, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.RUBY_GEM,3,-2.4f))));
    public static final Item RUBY_PICKAXE = registerItem("ruby_pickaxe",
            new PickaxeItem(ModToolMaterials.RUBY_GEM, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.RUBY_GEM,1,-2.8f))));
    public static final Item RUBY_SHOVEL = registerItem("ruby_shovel",
            new ShovelItem(ModToolMaterials.RUBY_GEM, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.RUBY_GEM,1,-3f))));
    public static final Item RUBY_AXE = registerItem("ruby_axe",
            new AxeItem(ModToolMaterials.RUBY_GEM, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.RUBY_GEM,6,-3.2f))));
    public static final Item RUBY_HOE = registerItem("ruby_hoe",
            new HoeItem(ModToolMaterials.RUBY_GEM, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.RUBY_GEM,0,-3f))));

    public static final Item IRON_HAMMER = registerItem("iron_hammer",
            new HammerItem(ToolMaterials.IRON, 1,new Item.Settings()
                    .attributeModifiers(PickaxeItem.createAttributeModifiers(ToolMaterials.IRON,3,-2f))));
    public static final Item DIAMOND_HAMMER = registerItem("diamond_hammer",
            new HammerItem(ToolMaterials.DIAMOND,2, new Item.Settings()
                    .attributeModifiers(PickaxeItem.createAttributeModifiers(ToolMaterials.DIAMOND,3,-2f))));
    public static final Item NETHERITE_HAMMER = registerItem("netherite_hammer",
            new HammerItem(ToolMaterials.NETHERITE,3, new Item.Settings()
                    .attributeModifiers(PickaxeItem.createAttributeModifiers(ToolMaterials.NETHERITE,3,-2f))));

    public static final Item KAIJU_HELMET = registerItem("kaiju_helmet",
            new ModArmorEffects(ModArmorMaterials.KAIJU_ARMOR_MATERIAL, ArmorItem.Type.HELMET, new Item.Settings()
                    .maxDamage(ArmorItem.Type.HELMET.getMaxDamage(15))));
    public static final Item KAIJU_CHESTPLATE = registerItem("kaiju_chestplate",
            new ArmorItem(ModArmorMaterials.KAIJU_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Settings()
                    .maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(15))));
    public static final Item KAIJU_LEGGINGS = registerItem("kaiju_leggings",
            new ArmorItem(ModArmorMaterials.KAIJU_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Settings()
                    .maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(15))));
    public static final Item KAIJU_BOOTS = registerItem("kaiju_boots",
            new ArmorItem(ModArmorMaterials.KAIJU_ARMOR_MATERIAL, ArmorItem.Type.BOOTS, new Item.Settings()
                    .maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(15))));

    public static final Item RUBY_HELMET = registerItem("ruby_helmet",
            new ModArmorEffects(ModArmorMaterials.RUBY_ARMOR_MATERIAL, ArmorItem.Type.HELMET, new Item.Settings()
                    .maxDamage(ArmorItem.Type.HELMET.getMaxDamage(15))));
    public static final Item RUBY_CHESTPLATE = registerItem("ruby_chestplate",
            new ArmorItem(ModArmorMaterials.RUBY_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Settings()
                    .maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(15))));
    public static final Item RUBY_LEGGINGS = registerItem("ruby_leggings",
            new ArmorItem(ModArmorMaterials.RUBY_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Settings()
                    .maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(15))));
    public static final Item RUBY_BOOTS = registerItem("ruby_boots",
            new ArmorItem(ModArmorMaterials.RUBY_ARMOR_MATERIAL, ArmorItem.Type.BOOTS, new Item.Settings()
                    .maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(15))));

    public static final Item MARBLE = register(ModBlocks.MARBLE);




    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, Identifier.of(TestMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        TestMod.LOGGER.info("Registering Mod Items for "+ TestMod.MOD_ID);

    }
}
