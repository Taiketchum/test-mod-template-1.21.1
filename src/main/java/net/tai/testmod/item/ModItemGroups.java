package net.tai.testmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.tai.testmod.TestMod;
import net.tai.testmod.block.ModBlocks;

public class ModItemGroups {
    public static final ItemGroup TEST_ITEM_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(TestMod.MOD_ID, "test_items"),
            FabricItemGroup.builder().icon(()-> new ItemStack(ModItems.RUBY_GEM))
                    .displayName(Text.translatable("itemgroup.testmod.test_group_items"))
                    .entries((displayContext, entries) -> {
                      entries.add(ModItems.RUBY_GEM);
                      entries.add(ModItems.RAW_RUBY);

                      entries.add(ModItems.SMASHED_COAL);

                      entries.add(ModItems.IRON_CHISEL);
                      entries.add(ModItems.DIAMOND_CHISEL);
                      entries.add(ModItems.NETHERITE_CHISEL);

                      entries.add(ModItems.TRUFFLE);
                      entries.add(ModItems.TRUFFLE_STEW);

                      entries.add(ModItems.SALMON_SKEWER);
                      entries.add(ModItems.COD_SKEWER);
                      entries.add(ModItems.BAKED_APPLE);

                      entries.add(ModItems.ELECTRIC_DUST);
                      entries.add(ModItems.HEART_OF_THE_STORM);

                      entries.add(ModItems.STORM_SCYTHE);

                      entries.add(ModItems.SILVER_AXE);
                      entries.add(ModItems.GOLD_AXE);

                      entries.add(ModItems.RUBY_SWORD);
                      entries.add(ModItems.RUBY_AXE);
                      entries.add(ModItems.RUBY_PICKAXE);
                      entries.add(ModItems.RUBY_SHOVEL);
                      entries.add(ModItems.RUBY_HOE);

                      entries.add(ModItems.IRON_HAMMER);
                      entries.add(ModItems.DIAMOND_HAMMER);
                      entries.add(ModItems.NETHERITE_HAMMER);

                      entries.add(ModItems.DRINK);
                    }).build());
    public static final ItemGroup TEST_BLOCK_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(TestMod.MOD_ID, "test_blocks"),
            FabricItemGroup.builder().icon(()-> new ItemStack(ModBlocks.RUBY_BLOCK))
                    .displayName(Text.translatable("itemgroup.testmod.test_group_blocks"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.RUBY_BLOCK);
                        entries.add(ModBlocks.RAW_RUBY_BLOCK);

                        entries.add(ModBlocks.RUBY_ORE);
                        entries.add(ModBlocks.DEEPSLATE_RUBY_ORE);

                        entries.add(ModBlocks.TRUFFLE_DIRT);

                        entries.add(ModBlocks.PALM_STAIRS);
                        entries.add(ModBlocks.PALM_SLAB);

                        entries.add(ModBlocks.PALM_BUTTON);
                        entries.add(ModBlocks.PALM_PRESSURE_PLATE);

                        entries.add(ModBlocks.PALM_FENCE);
                        entries.add(ModBlocks.PALM_FENCE_GATE);

                        entries.add(ModBlocks.PALM_DOOR);
                        entries.add(ModBlocks.PALM_TRAPDOOR);

                        entries.add(ModBlocks.MARBLE);
                        entries.add(ModBlocks.POLISHED_MARBLE);

                        entries.add(ModBlocks.MARBLE_STAIRS);
                        entries.add(ModBlocks.MARBLE_SLAB);
                        entries.add(ModBlocks.MARBLE_WALL);

                        entries.add(ModBlocks.POLISHED_MARBLE_STAIRS);
                        entries.add(ModBlocks.POLISHED_MARBLE_SLAB);
                        entries.add(ModBlocks.POLISHED_MARBLE_WALL);

                        entries.add(ModBlocks.POLISHED_ANDESITE_WALL);
                        entries.add(ModBlocks.POLISHED_GRANITE_WALL);
                        entries.add(ModBlocks.POLISHED_DIORITE_WALL);

                        entries.add(ModBlocks.LANTERN_PULSE);
                        entries.add(ModBlocks.LAMP);

// AHEAD ---------------------------------------------------------------------------------------------------------------

                        entries.add(ModBlocks.PALM_LOG);
                        entries.add(ModBlocks.PALM_WOOD);
                        entries.add(ModBlocks.STRIPPED_PALM_LOG);
                        entries.add(ModBlocks.STRIPPED_PALM_WOOD);
                        entries.add(ModBlocks.PALM_PLANK);
                    }).build());
    public static final ItemGroup TEST_FOOD_ITEMS = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(TestMod.MOD_ID, "test_food"),
            FabricItemGroup.builder().icon(()-> new ItemStack(ModItems.BAKED_APPLE))
                    .displayName(Text.translatable("itemgroup.testmod.test_group_foods"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.TRUFFLE);
                        entries.add(ModItems.TRUFFLE_STEW);

                        entries.add(ModItems.SALMON_SKEWER);
                        entries.add(ModItems.COD_SKEWER);
                        entries.add(ModItems.BAKED_APPLE);
                    }).build());



    public static void registerItemGroups(){
        TestMod.LOGGER.info("Registering Item Groups for "+ TestMod.MOD_ID);
    }
}
