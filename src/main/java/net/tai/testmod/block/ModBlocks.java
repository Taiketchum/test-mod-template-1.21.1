package net.tai.testmod.block;

import net.minecraft.block.*;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.tai.testmod.TestMod;
import net.tai.testmod.block.custom.LampBlock;
import net.tai.testmod.block.custom.TruffleDirtBlock;

import java.util.List;

public class ModBlocks {

    public static final Block RUBY_BLOCK = registerBlock("ruby_block",
            new Block(AbstractBlock.Settings.create().strength(4f).requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK)));
    public static final Block RAW_RUBY_BLOCK = registerBlock("raw_ruby_block",
            new Block(AbstractBlock.Settings.create().strength(4f).requiresTool()));

    public static final Block RUBY_ORE = registerBlock("ruby_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2, 5),
                    AbstractBlock.Settings.create().strength(3f).requiresTool().sounds(BlockSoundGroup.STONE)));
    public static final Block DEEPSLATE_RUBY_ORE = registerBlock("deepslate_ruby_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(3, 6),
                    AbstractBlock.Settings.create().strength(3f).requiresTool().sounds(BlockSoundGroup.DEEPSLATE)));

    public static final Block TRUFFLE_DIRT = registerBlock("truffle_dirt",
            new TruffleDirtBlock(AbstractBlock.Settings.create().strength(1f).sounds(BlockSoundGroup.GRAVEL)));

    public static final Block PALM_PLANK = registerBlock("palm_plank",
            new Block(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS)));

    public static final Block PALM_STAIRS =registerBlock("palm_stairs",
            new StairsBlock(ModBlocks.PALM_PLANK.getDefaultState(),
                    AbstractBlock.Settings.create().strength(2f).requiresTool()));
    public static final Block PALM_SLAB =registerBlock("palm_slab",
            new SlabBlock(AbstractBlock.Settings.create().strength(2f).requiresTool()));

    public static final Block PALM_BUTTON =registerBlock("palm_button",
            new ButtonBlock(BlockSetType.OAK, 10, AbstractBlock.Settings.create().strength(2f).requiresTool().noCollision()));
    public static final Block PALM_PRESSURE_PLATE =registerBlock("palm_pressure_plate",
            new PressurePlateBlock(BlockSetType.OAK, AbstractBlock.Settings.create().strength(2f).requiresTool().noCollision()));

    public static final Block PALM_FENCE =registerBlock("palm_fence",
            new FenceBlock(AbstractBlock.Settings.create().strength(2f).requiresTool()));
    public static final Block PALM_FENCE_GATE =registerBlock("palm_fence_gate",
            new FenceGateBlock(WoodType.OAK, AbstractBlock.Settings.create().strength(2f).requiresTool()));

    public static final Block PALM_DOOR =registerBlock("palm_door",
            new DoorBlock(BlockSetType.OAK, AbstractBlock.Settings.create().strength(2f).requiresTool().nonOpaque()));
    public static final Block PALM_TRAPDOOR =registerBlock("palm_trapdoor",
            new TrapdoorBlock(BlockSetType.OAK, AbstractBlock.Settings.create().strength(2f).requiresTool().nonOpaque()));

    public static final Block PALM_LOG = registerBlock("palm_log",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.OAK_LOG)));
    public static final Block PALM_WOOD = registerBlock("palm_wood",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.OAK_LOG)));
    public static final Block STRIPPED_PALM_LOG = registerBlock("stripped_palm_log",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.OAK_LOG)));
    public static final Block STRIPPED_PALM_WOOD = registerBlock("stripped_palm_wood",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.OAK_LOG)));

    public static final Block MARBLE = registerBlock("marble",
            new Block(AbstractBlock.Settings.copy(Blocks.ANDESITE)));
    public static final Block POLISHED_MARBLE = registerBlock("polished_marble",
            new Block(AbstractBlock.Settings.copy(Blocks.ANDESITE)));

    public static final Block MARBLE_STAIRS =registerBlock("marble_stairs",
            new StairsBlock(ModBlocks.MARBLE.getDefaultState(),
                    AbstractBlock.Settings.create().strength(2f).requiresTool()));
    public static final Block MARBLE_SLAB =registerBlock("marble_slab",
            new SlabBlock(AbstractBlock.Settings.create().strength(2f).requiresTool()));
    public static final Block MARBLE_WALL =registerBlock("marble_wall",
        new WallBlock(AbstractBlock.Settings.create().strength(2f).requiresTool()));

    public static final Block POLISHED_MARBLE_STAIRS =registerBlock("polished_marble_stairs",
            new StairsBlock(ModBlocks.MARBLE.getDefaultState(),
                    AbstractBlock.Settings.create().strength(2f).requiresTool()));
    public static final Block POLISHED_MARBLE_SLAB =registerBlock("polished_marble_slab",
            new SlabBlock(AbstractBlock.Settings.create().strength(2f).requiresTool()));
    public static final Block POLISHED_MARBLE_WALL =registerBlock("polished_marble_wall",
            new WallBlock(AbstractBlock.Settings.create().strength(2f).requiresTool()));

    public static final Block POLISHED_ANDESITE_WALL =registerBlock("polished_andesite_wall",
            new WallBlock(AbstractBlock.Settings.copy(Blocks.POLISHED_ANDESITE)));
    public static final Block POLISHED_GRANITE_WALL =registerBlock("polished_granite_wall",
            new WallBlock(AbstractBlock.Settings.copy(Blocks.POLISHED_GRANITE)));
    public static final Block POLISHED_DIORITE_WALL =registerBlock("polished_diorite_wall",
            new WallBlock(AbstractBlock.Settings.copy(Blocks.POLISHED_DIORITE)));

    public static final Block LANTERN_PULSE = registerBlock("lantern_pulse",
            new Block(AbstractBlock.Settings.copy(Blocks.SEA_LANTERN)){
                @Override
                public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType options) {
                    if (Screen.hasShiftDown()) {
                        tooltip.add(Text.translatable("tooltip.testmod.lantern_pulse"));
                    }
                    else {
                        tooltip.add(Text.translatable("tooltip.testmod.shift_down"));
                    }
                    super.appendTooltip(stack, context, tooltip, options);
                }});

    public static final Block LAMP = registerBlock("lamp",
            new LampBlock(AbstractBlock.Settings.create().strength(1f).requiresTool().luminance(state -> state.get(LampBlock.CLICKED)?15:0)));




    private static Block registerBlock(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(TestMod.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(TestMod.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks(){
        TestMod.LOGGER.info("Registering Mod Blocks for "+ TestMod.MOD_ID);

    }
}