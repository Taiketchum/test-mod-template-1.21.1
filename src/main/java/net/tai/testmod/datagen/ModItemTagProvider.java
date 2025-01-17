package net.tai.testmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.tai.testmod.block.ModBlocks;
import net.tai.testmod.item.ModItems;
import net.tai.testmod.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {

    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(ModTags.Items.TRANSFORMABLE_ITEMS)
                .add(Items.BROWN_MUSHROOM)
                .add(Items.RED_MUSHROOM);

        getOrCreateTagBuilder(ItemTags.SWORDS)
                .add(ModItems.RUBY_SWORD)
                .add(ModItems.SW_2023)
                .add(ModItems.SW_2024)
                .add(ModItems.STORM_SCYTHE);

        getOrCreateTagBuilder(ItemTags.PICKAXES)
                .add(ModItems.RUBY_PICKAXE);

        getOrCreateTagBuilder(ItemTags.AXES)
                .add(ModItems.GOLD_AXE)
                .add(ModItems.SILVER_AXE)
                .add(ModItems.RUBY_AXE);

        getOrCreateTagBuilder(ItemTags.SHOVELS)
                .add(ModItems.RUBY_SHOVEL);

        getOrCreateTagBuilder(ItemTags.HOES)
                .add(ModItems.RUBY_HOE);

        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.KAIJU_HELMET)
                .add(ModItems.KAIJU_CHESTPLATE)
                .add(ModItems.KAIJU_LEGGINGS)
                .add(ModItems.KAIJU_BOOTS)

                .add(ModItems.RUBY_HELMET)
                .add(ModItems.RUBY_CHESTPLATE)
                .add(ModItems.RUBY_LEGGINGS)
                .add(ModItems.RUBY_BOOTS);

        getOrCreateTagBuilder(ItemTags.ARMOR_ENCHANTABLE)
                .add(ModItems.RUBY_HELMET)
                .add(ModItems.RUBY_CHESTPLATE)
                .add(ModItems.RUBY_LEGGINGS)
                .add(ModItems.RUBY_BOOTS);
        getOrCreateTagBuilder(ItemTags.HEAD_ARMOR_ENCHANTABLE)
                .add(ModItems.RUBY_HELMET);
        getOrCreateTagBuilder(ItemTags.CHEST_ARMOR_ENCHANTABLE)
                .add(ModItems.RUBY_CHESTPLATE);
        getOrCreateTagBuilder(ItemTags.LEG_ARMOR_ENCHANTABLE)
                .add(ModItems.RUBY_LEGGINGS);
        getOrCreateTagBuilder(ItemTags.FOOT_ARMOR_ENCHANTABLE)
                .add(ModItems.RUBY_BOOTS);
// AHEAD ---------------------------------------------------------------------------------------------------------------

        getOrCreateTagBuilder(ItemTags.LOGS_THAT_BURN)
                .add(ModBlocks.PALM_LOG.asItem())
                .add(ModBlocks.PALM_WOOD.asItem())
                .add(ModBlocks.STRIPPED_PALM_LOG.asItem())
                .add(ModBlocks.STRIPPED_PALM_WOOD.asItem())
                .add(ModBlocks.DARK_CHERRY_LOG.asItem())
                .add(ModBlocks.DARK_CHERRY_WOOD.asItem())
                .add(ModBlocks.STRIPPED_DARK_CHERRY_LOG.asItem())
                .add(ModBlocks.STRIPPED_DARK_CHERRY_WOOD.asItem());

        getOrCreateTagBuilder(ItemTags.PLANKS)
                .add(ModBlocks.PALM_PLANK.asItem())
                .add(ModBlocks.DARK_CHERRY_PLANK.asItem());

        getOrCreateTagBuilder(ItemTags.STONE_CRAFTING_MATERIALS)
                .add(Items.ANDESITE)
                .add(Items.GRANITE)
                .add(Items.DIORITE)
                .add(ModItems.MARBLE);
        getOrCreateTagBuilder(ItemTags.STONE_TOOL_MATERIALS)
                .add(Items.ANDESITE)
                .add(Items.GRANITE)
                .add(Items.DIORITE)
                .add(ModItems.MARBLE);
    }
}
