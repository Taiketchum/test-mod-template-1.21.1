package net.tai.testmod.item.custom;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;
import net.tai.testmod.componet.ModDataComponentTypes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChiselItem extends Item {
    /*private static final Map<Block, Block> CHISEL_MAP =
            Map.ofEntries(
                    Blocks.STONE, Blocks.STONE_BRICKS),
                    Blocks.POLISHED_DEEPSLATE, Blocks.DEEPSLATE_BRICKS),
                    Blocks.PACKED_MUD, Blocks.MUD_BRICKS),
                    Blocks.POLISHED_TUFF, Blocks.TUFF_BRICKS),
                    Blocks.END_STONE, Blocks.END_STONE_BRICKS),
                    Blocks.POLISHED_BLACKSTONE, Blocks.POLISHED_BLACKSTONE_BRICKS),
                    Blocks.QUARTZ_BLOCK, Blocks.QUARTZ_BRICKS),
                    Blocks.PRISMARINE, Blocks.PRISMARINE_BRICKS),

                    Blocks.STONE_BRICKS, Blocks.CHISELED_STONE_BRICKS),
                    Blocks.DEEPSLATE_BRICKS, Blocks.CHISELED_DEEPSLATE),
                    Blocks.TUFF, Blocks.CHISELED_TUFF),
                    Blocks.TUFF_BRICKS, Blocks.CHISELED_TUFF_BRICKS),
                    Blocks.SANDSTONE, Blocks.CHISELED_SANDSTONE),
                    Blocks.RED_SANDSTONE, Blocks.CHISELED_RED_SANDSTONE),
                    Blocks.NETHER_BRICKS, Blocks.CHISELED_NETHER_BRICKS),
                    Blocks.POLISHED_BLACKSTONE_BRICKS, Blocks.CHISELED_POLISHED_BLACKSTONE),
                    Blocks.QUARTZ_BRICKS, Blocks.CHISELED_QUARTZ_BLOCK)
            );

     */
    //what blocks can be chisel what they turn into
    private static final Map<Block, Block> CHISEL_MAP = new HashMap<>();

    static {
        CHISEL_MAP.put(Blocks.STONE, Blocks.STONE_BRICKS);
        CHISEL_MAP.put(Blocks.POLISHED_DEEPSLATE, Blocks.DEEPSLATE_BRICKS);
        CHISEL_MAP.put(Blocks.PACKED_MUD, Blocks.MUD_BRICKS);
        CHISEL_MAP.put(Blocks.POLISHED_TUFF, Blocks.TUFF_BRICKS);
        CHISEL_MAP.put(Blocks.END_STONE, Blocks.END_STONE_BRICKS);
        CHISEL_MAP.put(Blocks.POLISHED_BLACKSTONE, Blocks.POLISHED_BLACKSTONE_BRICKS);
        CHISEL_MAP.put(Blocks.QUARTZ_BLOCK, Blocks.QUARTZ_BRICKS);
        CHISEL_MAP.put(Blocks.PRISMARINE, Blocks.PRISMARINE_BRICKS);

        CHISEL_MAP.put(Blocks.STONE_BRICKS, Blocks.CHISELED_STONE_BRICKS);
        CHISEL_MAP.put(Blocks.DEEPSLATE_BRICKS, Blocks.CHISELED_DEEPSLATE);
        CHISEL_MAP.put(Blocks.TUFF, Blocks.CHISELED_TUFF);
        CHISEL_MAP.put(Blocks.TUFF_BRICKS, Blocks.CHISELED_TUFF_BRICKS);
        CHISEL_MAP.put(Blocks.SANDSTONE, Blocks.CHISELED_SANDSTONE);
        CHISEL_MAP.put(Blocks.RED_SANDSTONE, Blocks.CHISELED_RED_SANDSTONE);
        CHISEL_MAP.put(Blocks.NETHER_BRICKS, Blocks.CHISELED_NETHER_BRICKS);
        CHISEL_MAP.put(Blocks.POLISHED_BLACKSTONE_BRICKS, Blocks.CHISELED_POLISHED_BLACKSTONE);
        CHISEL_MAP.put(Blocks.QUARTZ_BRICKS, Blocks.CHISELED_QUARTZ_BLOCK);
    }

    public ChiselItem(Settings settings) {
        super(settings);
    }
//function: changes the block and damages the chisel
    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        Block clickedBlock = world.getBlockState(context.getBlockPos()).getBlock();

        if(CHISEL_MAP.containsKey(clickedBlock)) {
            if(!world.isClient()) {
                world.setBlockState(context.getBlockPos(), CHISEL_MAP.get(clickedBlock).getDefaultState());

                context.getStack().damage(1, ((ServerWorld) world), ((ServerPlayerEntity) context.getPlayer()),
                        item -> context.getPlayer().sendEquipmentBreakStatus(item, EquipmentSlot.MAINHAND));

                world.playSound(null, context.getBlockPos(), SoundEvents.BLOCK_GRINDSTONE_USE, SoundCategory.BLOCKS);
                //dataComponents
                context.getStack().set(ModDataComponentTypes.COORDINATES, context.getBlockPos());
            }
        }

        return ActionResult.SUCCESS;
    }
//tooltip
    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        if (Screen.hasShiftDown()){
            tooltip.add(Text.translatable("tooltip.testmod.chisel"));
        }
        else {
            tooltip.add(Text.translatable("tooltip.testmod.shift_down"));
        }
        //dataComponents
        if (stack.get(ModDataComponentTypes.COORDINATES) != null){
            tooltip.add(Text.literal("§7Last block changed at "+stack.get(ModDataComponentTypes.COORDINATES)+"§r"));
        }
        super.appendTooltip(stack, context, tooltip, type);
    }
}