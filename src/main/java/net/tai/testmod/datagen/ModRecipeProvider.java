package net.tai.testmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.ShapedRecipe;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;
import net.tai.testmod.TestMod;
import net.tai.testmod.block.ModBlocks;
import net.tai.testmod.item.ModItems;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter recipeExporter) {
        List<ItemConvertible> RUBY_SMELTABLES = List.of(ModItems.RAW_RUBY, ModBlocks.RUBY_ORE, ModBlocks.DEEPSLATE_RUBY_ORE);
        List<ItemConvertible> COAL_SMELTABLES = List.of(Items.COAL);

        offerSmelting(recipeExporter, RUBY_SMELTABLES, RecipeCategory.MISC, ModItems.RUBY_GEM, 0.25f,200,"Ruby");
        offerBlasting(recipeExporter, RUBY_SMELTABLES, RecipeCategory.MISC, ModItems.RUBY_GEM, 0.25f,100,"Ruby");

        offerBlasting(recipeExporter, COAL_SMELTABLES, RecipeCategory.MISC, ModItems.SMASHED_COAL, 0.25f,160,"Coal");

        offerReversibleCompactingRecipes(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModItems.RUBY_GEM, RecipeCategory.DECORATIONS, ModBlocks.RUBY_BLOCK);
        offerReversibleCompactingRecipes(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModItems.RAW_RUBY, RecipeCategory.DECORATIONS, ModBlocks.RAW_RUBY_BLOCK);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.TRUFFLE_STEW,1)
                        .input(ModItems.TRUFFLE)
                        .input(Items.CARROT)
                        .input(Items.BOWL)
                        .input(Items.MILK_BUCKET)
                        .criterion(hasItem(ModItems.TRUFFLE), conditionsFromItem(ModItems.TRUFFLE))
                        .offerTo(recipeExporter, Identifier.of(TestMod.MOD_ID,"truffle_stew"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.COD_SKEWER,1)
                .input(Items.COOKED_COD,2)
                .input(Items.STICK)
                .criterion(hasItem(Items.COD), conditionsFromItem(Items.COD))
                .offerTo(recipeExporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.SALMON_SKEWER,1)
                .input(Items.COOKED_SALMON,2)
                .input(Items.STICK)
                .criterion(hasItem(Items.SALMON), conditionsFromItem(Items.SALMON))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.IRON_CHISEL)
                .pattern("I")
                .pattern("S")
                .pattern("D")
                .input('I', Items.IRON_INGOT)
                .input('S', Items.STONE)
                .input('D', Items.POLISHED_DEEPSLATE)
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .offerTo(recipeExporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.DIAMOND_CHISEL)
                .pattern("$")
                .pattern("S")
                .pattern("D")
                .input('$', Items.DIAMOND)
                .input('S', Items.STONE)
                .input('D', Items.POLISHED_DEEPSLATE)
                .criterion(hasItem(Items.DIAMOND), conditionsFromItem(Items.DIAMOND))
                .offerTo(recipeExporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.NETHERITE_CHISEL)
                .pattern("N")
                .pattern("S")
                .pattern("D")
                .input('N', Items.NETHERITE_INGOT)
                .input('S', Items.STONE)
                .input('D', Items.POLISHED_DEEPSLATE)
                .criterion(hasItem(Items.NETHERITE_INGOT), conditionsFromItem(Items.NETHERITE_INGOT))
                .offerTo(recipeExporter);

        createStairsRecipe(ModBlocks.PALM_STAIRS, Ingredient.ofItems(ModBlocks.PALM_PLANK))
                .criterion(hasItem(ModBlocks.PALM_PLANK), conditionsFromItem(ModBlocks.PALM_PLANK))
                .offerTo(recipeExporter);
        offerSlabRecipe(recipeExporter,RecipeCategory.BUILDING_BLOCKS,ModBlocks.PALM_SLAB,ModBlocks.PALM_PLANK);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.REDSTONE, ModBlocks.PALM_BUTTON,1)
                .input(ModBlocks.PALM_PLANK)
                .criterion(hasItem(ModBlocks.PALM_PLANK), conditionsFromItem(ModBlocks.PALM_PLANK))
                .offerTo(recipeExporter);
        offerPressurePlateRecipe(recipeExporter, ModBlocks.PALM_PRESSURE_PLATE, ModBlocks.PALM_PLANK);

        createFenceRecipe(ModBlocks.PALM_FENCE,Ingredient.ofItems(ModBlocks.PALM_PLANK))
                .criterion(hasItem(ModBlocks.PALM_PLANK), conditionsFromItem(ModBlocks.PALM_PLANK))
                .offerTo(recipeExporter);
        createFenceGateRecipe(ModBlocks.PALM_FENCE_GATE,Ingredient.ofItems(ModBlocks.PALM_PLANK))
                .criterion(hasItem(ModBlocks.PALM_PLANK), conditionsFromItem(ModBlocks.PALM_PLANK))
                .offerTo(recipeExporter);

        createDoorRecipe(ModBlocks.PALM_DOOR,Ingredient.ofItems(ModBlocks.PALM_PLANK))
                .criterion(hasItem(ModBlocks.PALM_PLANK), conditionsFromItem(ModBlocks.PALM_PLANK))
                .offerTo(recipeExporter);
        createTrapdoorRecipe(ModBlocks.PALM_TRAPDOOR,Ingredient.ofItems(ModBlocks.PALM_PLANK))
                .criterion(hasItem(ModBlocks.PALM_PLANK), conditionsFromItem(ModBlocks.PALM_PLANK))
                .offerTo(recipeExporter);

        offerBarkBlockRecipe(recipeExporter,ModBlocks.POLISHED_MARBLE,ModBlocks.MARBLE);

        createStairsRecipe(ModBlocks.MARBLE_STAIRS, Ingredient.ofItems(ModBlocks.MARBLE))
                .criterion(hasItem(ModBlocks.MARBLE), conditionsFromItem(ModBlocks.MARBLE))
                .offerTo(recipeExporter);
        offerSlabRecipe(recipeExporter,RecipeCategory.BUILDING_BLOCKS,ModBlocks.MARBLE_SLAB,ModBlocks.MARBLE);
        offerWallRecipe(recipeExporter,RecipeCategory.BUILDING_BLOCKS,ModBlocks.MARBLE_WALL, ModBlocks.MARBLE);


        createStairsRecipe(ModBlocks.POLISHED_MARBLE_STAIRS, Ingredient.ofItems(ModBlocks.POLISHED_MARBLE))
                .criterion(hasItem(ModBlocks.POLISHED_MARBLE), conditionsFromItem(ModBlocks.POLISHED_MARBLE))
                .offerTo(recipeExporter);
        offerSlabRecipe(recipeExporter,RecipeCategory.BUILDING_BLOCKS,ModBlocks.POLISHED_MARBLE_SLAB,ModBlocks.POLISHED_MARBLE);
        offerWallRecipe(recipeExporter,RecipeCategory.BUILDING_BLOCKS,ModBlocks.POLISHED_MARBLE_WALL, ModBlocks.POLISHED_MARBLE);

        offerWallRecipe(recipeExporter,RecipeCategory.BUILDING_BLOCKS,ModBlocks.POLISHED_ANDESITE_WALL, Blocks.POLISHED_ANDESITE);
        offerWallRecipe(recipeExporter,RecipeCategory.BUILDING_BLOCKS,ModBlocks.POLISHED_GRANITE_WALL,Blocks.POLISHED_GRANITE);
        offerWallRecipe(recipeExporter,RecipeCategory.BUILDING_BLOCKS,ModBlocks.POLISHED_DIORITE_WALL,Blocks.POLISHED_DIORITE);

// AHEAD ---------------------------------------------------------------------------------------------------------------
        offerBarkBlockRecipe(recipeExporter,ModBlocks.PALM_WOOD,ModBlocks.PALM_LOG);
        offerBarkBlockRecipe(recipeExporter,ModBlocks.STRIPPED_PALM_WOOD,ModBlocks.STRIPPED_PALM_LOG);

        offerShapelessRecipe(recipeExporter,ModBlocks.PALM_PLANK,ModBlocks.PALM_LOG,"Palm",4);
        offerShapelessRecipe(recipeExporter,ModBlocks.PALM_PLANK,ModBlocks.PALM_WOOD,"Palm",4);
        offerShapelessRecipe(recipeExporter,ModBlocks.PALM_PLANK,ModBlocks.STRIPPED_PALM_LOG,"Palm",4);
        offerShapelessRecipe(recipeExporter,ModBlocks.PALM_PLANK,ModBlocks.STRIPPED_PALM_WOOD,"Palm",4);

    }
}
