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
                      entries.add(ModItems.IRON_CHISEL);
                      entries.add(ModItems.DIAMOND_CHISEL);
                      entries.add(ModItems.NETHERITE_CHISEL);
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
                    }).build());



    public static void registerItemGroups(){
        TestMod.LOGGER.info("Registering Item Groups for "+ TestMod.MOD_ID);
    }
}
