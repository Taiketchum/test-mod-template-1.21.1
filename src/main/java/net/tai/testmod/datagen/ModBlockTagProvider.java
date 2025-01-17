package net.tai.testmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.tai.testmod.block.ModBlocks;
import net.tai.testmod.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture){
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.RAW_RUBY_BLOCK)
                .add(ModBlocks.RUBY_ORE)
                .add(ModBlocks.DEEPSLATE_RUBY_ORE)
                .add(ModBlocks.RUBY_BLOCK)

                .add(ModBlocks.MARBLE)
                .add(ModBlocks.POLISHED_MARBLE)

                .add(ModBlocks.MARBLE_STAIRS)
                .add(ModBlocks.MARBLE_SLAB)
                .add(ModBlocks.MARBLE_WALL)

                .add(ModBlocks.POLISHED_MARBLE_STAIRS)
                .add(ModBlocks.POLISHED_MARBLE_SLAB)
                .add(ModBlocks.POLISHED_MARBLE_WALL)

                .add(ModBlocks.POLISHED_ANDESITE_WALL)
                .add(ModBlocks.POLISHED_GRANITE_WALL)
                .add(ModBlocks.POLISHED_DIORITE_WALL);

        getOrCreateTagBuilder(BlockTags.SHOVEL_MINEABLE)
                .add(ModBlocks.TRUFFLE_DIRT);

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.RAW_RUBY_BLOCK)
                .add(ModBlocks.RUBY_ORE)
                .add(ModBlocks.RUBY_BLOCK);

        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.DEEPSLATE_RUBY_ORE);

        getOrCreateTagBuilder(BlockTags.WOODEN_FENCES)
                .add(ModBlocks.PALM_FENCE)
                .add(ModBlocks.DARK_CHERRY_FENCE);

        getOrCreateTagBuilder(BlockTags.FENCE_GATES)
                .add(ModBlocks.PALM_FENCE_GATE)
                .add(ModBlocks.DARK_CHERRY_FENCE_GATE);

        getOrCreateTagBuilder(BlockTags.WALLS)
                .add(ModBlocks.MARBLE_WALL)
                .add(ModBlocks.POLISHED_MARBLE_WALL)
                .add(ModBlocks.POLISHED_ANDESITE_WALL)
                .add(ModBlocks.POLISHED_GRANITE_WALL)
                .add(ModBlocks.POLISHED_DIORITE_WALL);

        getOrCreateTagBuilder(ModTags.Blocks.NEEDS_RUBY_TOOL)
                .addTag(BlockTags.NEEDS_IRON_TOOL);

        getOrCreateTagBuilder(ModTags.Blocks.NEEDS_STORM_TOOL)
                .addTag(BlockTags.NEEDS_DIAMOND_TOOL);

        getOrCreateTagBuilder(ModTags.Blocks.NEEDS_KAIJU_TOOL)
                .addTag(BlockTags.NEEDS_DIAMOND_TOOL);

// AHEAD ---------------------------------------------------------------------------------------------------------------
        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
                .add(ModBlocks.PALM_LOG)
                .add(ModBlocks.PALM_WOOD)
                .add(ModBlocks.STRIPPED_PALM_LOG)
                .add(ModBlocks.STRIPPED_PALM_WOOD)
                .add(ModBlocks.PALM_PLANK)
                .add(ModBlocks.PALM_STAIRS)
                .add(ModBlocks.PALM_SLAB)
                .add(ModBlocks.PALM_BUTTON)
                .add(ModBlocks.PALM_PRESSURE_PLATE)
                .add(ModBlocks.PALM_FENCE)
                .add(ModBlocks.PALM_FENCE_GATE)
                .add(ModBlocks.PALM_DOOR)
                .add(ModBlocks.PALM_TRAPDOOR)
                .add(ModBlocks.DARK_CHERRY_LOG)
                .add(ModBlocks.DARK_CHERRY_WOOD)
                .add(ModBlocks.STRIPPED_DARK_CHERRY_LOG)
                .add(ModBlocks.STRIPPED_DARK_CHERRY_WOOD)
                .add(ModBlocks.DARK_CHERRY_PLANK)
                .add(ModBlocks.DARK_CHERRY_STAIRS)
                .add(ModBlocks.DARK_CHERRY_SLAB)
                .add(ModBlocks.DARK_CHERRY_BUTTON)
                .add(ModBlocks.DARK_CHERRY_PRESSURE_PLATE)
                .add(ModBlocks.DARK_CHERRY_FENCE)
                .add(ModBlocks.DARK_CHERRY_FENCE_GATE)
                .add(ModBlocks.DARK_CHERRY_DOOR)
                .add(ModBlocks.DARK_CHERRY_TRAPDOOR);

        getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.PALM_LOG)
                .add(ModBlocks.PALM_WOOD)
                .add(ModBlocks.STRIPPED_PALM_LOG)
                .add(ModBlocks.STRIPPED_PALM_WOOD)
                .add(ModBlocks.DARK_CHERRY_LOG)
                .add(ModBlocks.DARK_CHERRY_WOOD)
                .add(ModBlocks.STRIPPED_DARK_CHERRY_LOG)
                .add(ModBlocks.STRIPPED_DARK_CHERRY_WOOD);

//  CUSTOM -------------------------------------------------------------------------------------------------------------
        getOrCreateTagBuilder(BlockTags.BEACON_BASE_BLOCKS)
                .add(ModBlocks.RUBY_BLOCK);

    }
}
