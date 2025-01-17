package net.tai.testmod.item.custom;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.component.type.ToolComponent;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StormScythe extends ToolItem {
    public StormScythe(ToolMaterial toolMaterial, Item.Settings settings) {
        super(toolMaterial, settings.component(DataComponentTypes.TOOL, createToolComponent()));
    }

    // Mapping entity types to their respective head items
    private static final Map<EntityType<?>, ItemStack> HEAD_DROPS = new HashMap<>();

    static {

        // Predefined entity-to-head mappings
        HEAD_DROPS.put(EntityType.ZOMBIE, new ItemStack(Items.ZOMBIE_HEAD));
        HEAD_DROPS.put(EntityType.SKELETON, new ItemStack(Items.SKELETON_SKULL));
        HEAD_DROPS.put(EntityType.CREEPER, new ItemStack(Items.CREEPER_HEAD));
        HEAD_DROPS.put(EntityType.WITHER_SKELETON, new ItemStack(Items.WITHER_SKELETON_SKULL));
        HEAD_DROPS.put(EntityType.PIGLIN, new ItemStack(Items.PIGLIN_HEAD));

        // Add new entity-to-head mappings here in the future
    }

    private static ToolComponent createToolComponent() {
        return new ToolComponent(
                List.of(ToolComponent.Rule.ofAlwaysDropping(List.of(Blocks.COBWEB), 15.0F), ToolComponent.Rule.of(BlockTags.SWORD_EFFICIENT, 1.5F)), 1.0F, 2
        );
    }

    public static AttributeModifiersComponent createAttributeModifiers(ToolMaterial material, int baseAttackDamage, float attackSpeed) {
        return AttributeModifiersComponent.builder()
                .add(
                        EntityAttributes.GENERIC_ATTACK_DAMAGE,
                        new EntityAttributeModifier(
                                BASE_ATTACK_DAMAGE_MODIFIER_ID, (double) ((float) baseAttackDamage + material.getAttackDamage()), EntityAttributeModifier.Operation.ADD_VALUE
                        ),
                        AttributeModifierSlot.MAINHAND
                )
                .add(
                        EntityAttributes.GENERIC_ATTACK_SPEED,
                        new EntityAttributeModifier(BASE_ATTACK_SPEED_MODIFIER_ID, (double) attackSpeed, EntityAttributeModifier.Operation.ADD_VALUE),
                        AttributeModifierSlot.MAINHAND
                )
                .build();
    }

    @Override
    public boolean canMine(BlockState state, World world, BlockPos pos, PlayerEntity miner) {
        return !miner.isCreative();
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (!attacker.getWorld().isClient()) {
            // Summon a lightning bolt at the target's location
            summonLightning(target, (ServerWorld) attacker.getWorld());
            // Drop the head if the target's health is 0 or less
            if (target.getHealth() <= 0) {
                dropHead(target, (ServerWorld) attacker.getWorld());
            }
        }
        return super.postHit(stack, target, attacker);
    }

    @Override
    public void postDamageEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        stack.damage(1, attacker, EquipmentSlot.MAINHAND);
    }

    private void dropHead(LivingEntity entity, ServerWorld world) {
        // Fetch the corresponding head item from the mapping
        ItemStack headDrop = HEAD_DROPS.get(entity.getType());
        if (headDrop != null) {
            entity.dropStack(headDrop.copy());
        }
    }

    private void summonLightning(LivingEntity target, ServerWorld world) {
       /* BlockPos position = target.getBlockPos();
        LightningEntity lightning = EntityType.LIGHTNING_BOLT.create(world);
        if (lightning != null) {
            lightning.refreshPositionAfterTeleport(position.getX(), position.getY(), position.getZ());
            world.spawnEntity(lightning);
        }*/
    }
}



