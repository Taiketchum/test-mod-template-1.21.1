package net.tai.testmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.client.*;
import net.minecraft.util.Identifier;
import net.tai.testmod.block.ModBlocks;
import net.tai.testmod.block.custom.LampBlock;
import net.tai.testmod.item.ModItems;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RUBY_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_RUBY_BLOCK);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RUBY_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_RUBY_ORE);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TRUFFLE_DIRT);

        BlockStateModelGenerator.BlockTexturePool palmWoodPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.PALM_PLANK);

        palmWoodPool.stairs(ModBlocks.PALM_STAIRS);
        palmWoodPool.slab(ModBlocks.PALM_SLAB);

        palmWoodPool.button(ModBlocks.PALM_BUTTON);
        palmWoodPool.pressurePlate(ModBlocks.PALM_PRESSURE_PLATE);

        palmWoodPool.fence(ModBlocks.PALM_FENCE);
        palmWoodPool.fenceGate(ModBlocks.PALM_FENCE_GATE);

        blockStateModelGenerator.registerDoor(ModBlocks.PALM_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.PALM_TRAPDOOR);

        BlockStateModelGenerator.BlockTexturePool marblePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.MARBLE);
        BlockStateModelGenerator.BlockTexturePool polishedMarblePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.POLISHED_MARBLE);

        marblePool.stairs(ModBlocks.MARBLE_STAIRS);
        marblePool.slab(ModBlocks.MARBLE_SLAB);
        marblePool.wall(ModBlocks.MARBLE_WALL);

        polishedMarblePool.stairs(ModBlocks.POLISHED_MARBLE_STAIRS);
        polishedMarblePool.slab(ModBlocks.POLISHED_MARBLE_SLAB);
        polishedMarblePool.wall(ModBlocks.POLISHED_MARBLE_WALL);

        BlockStateModelGenerator.BlockTexturePool polishedAndesitePool = blockStateModelGenerator.registerCubeAllModelTexturePool(Blocks.POLISHED_ANDESITE);
        BlockStateModelGenerator.BlockTexturePool polishedGranitePool = blockStateModelGenerator.registerCubeAllModelTexturePool(Blocks.POLISHED_GRANITE);
        BlockStateModelGenerator.BlockTexturePool polishedDioritePool = blockStateModelGenerator.registerCubeAllModelTexturePool(Blocks.POLISHED_DIORITE);

        polishedAndesitePool.wall(ModBlocks.POLISHED_ANDESITE_WALL);
        polishedGranitePool.wall(ModBlocks.POLISHED_GRANITE_WALL);
        polishedDioritePool.wall(ModBlocks.POLISHED_DIORITE_WALL);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.LANTERN_PULSE);

        Identifier lampOffIdentifier = TexturedModel.CUBE_ALL.upload(ModBlocks.LAMP, blockStateModelGenerator.modelCollector);
        Identifier lampOnIdentifier = blockStateModelGenerator.createSubModel(ModBlocks.LAMP, "_on", Models.CUBE_ALL, TextureMap::all);
        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(ModBlocks.LAMP)
                .coordinate(BlockStateModelGenerator.createBooleanModelMap(LampBlock.CLICKED, lampOnIdentifier, lampOffIdentifier)));

// AHEAD ---------------------------------------------------------------------------------------------------------------

        blockStateModelGenerator.registerLog(ModBlocks.PALM_LOG).log(ModBlocks.PALM_LOG).wood(ModBlocks.PALM_WOOD);
        blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_PALM_LOG).log(ModBlocks.STRIPPED_PALM_LOG).wood(ModBlocks.STRIPPED_PALM_WOOD);


    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.RAW_RUBY, Models.GENERATED);
        itemModelGenerator.register(ModItems.RUBY_GEM, Models.GENERATED);

        itemModelGenerator.register(ModItems.SMASHED_COAL, Models.GENERATED);

        itemModelGenerator.register(ModItems.TRUFFLE, Models.GENERATED);
        itemModelGenerator.register(ModItems.TRUFFLE_STEW, Models.GENERATED);

        itemModelGenerator.register(ModItems.COD_SKEWER, Models.GENERATED);
        itemModelGenerator.register(ModItems.SALMON_SKEWER, Models.GENERATED);
        itemModelGenerator.register(ModItems.BAKED_APPLE, Models.GENERATED);

        itemModelGenerator.register(ModItems.ELECTRIC_DUST, Models.GENERATED);
        itemModelGenerator.register(ModItems.HEART_OF_THE_STORM, Models.GENERATED);

        itemModelGenerator.register(ModItems.DRINK, Models.GENERATED);

        itemModelGenerator.register(ModItems.IRON_CHISEL, Models.GENERATED);
        itemModelGenerator.register(ModItems.DIAMOND_CHISEL, Models.GENERATED);
        itemModelGenerator.register(ModItems.NETHERITE_CHISEL, Models.GENERATED);

        itemModelGenerator.register(ModItems.RUBY_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.RUBY_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.RUBY_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.RUBY_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.RUBY_HOE, Models.HANDHELD);

        itemModelGenerator.register(ModItems.GOLD_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SILVER_AXE, Models.HANDHELD);
    }
}
