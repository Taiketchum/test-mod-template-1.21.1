package net.tai.testmod.Events;

import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.entity.EntityType;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.EntityPropertiesLootCondition;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.context.LootContext;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.predicate.entity.EntityPredicate;
import net.minecraft.registry.RegistryKey;
import net.tai.testmod.item.ModItems;
import net.minecraft.predicate.NbtPredicate;

public class LootTableModifiers {

    private static final RegistryKey<LootTable> CREEPER_KEY = EntityType.CREEPER.getLootTableId();

    public LootTableModifiers(){
        throw new AssertionError();
    }

    public static void register() {
        NbtCompound nbtCompound = new NbtCompound();
        nbtCompound.putBoolean("powered", true);
        LootTableEvents.MODIFY.register((key, tableBuilder, source, registries)->{
            if (key.equals(CREEPER_KEY)){
                LootPool electric_dust = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1.0f)) // 100%
                        .conditionally(EntityPropertiesLootCondition.builder(LootContext.EntityTarget.THIS,
                                EntityPredicate.Builder.create()
                                        .type(EntityType.CREEPER)
                                        .nbt(new NbtPredicate(nbtCompound)) // Create NbtPredicate directly here
                                        .build()))
                        .with(ItemEntry.builder(ModItems.ELECTRIC_DUST))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 4)).build())
                        .build();
                tableBuilder.pool(electric_dust);
                }
        });
    }
}
/*LootPool electric_dust = LootPool.builder()
        .rolls(ConstantLootNumberProvider.create(1))
        .conditionally(RandomChanceLootCondition.builder(1.0f))//100%
        .with(ItemEntry.builder(ModItems.ELECTRIC_DUST))
        .apply(SetCountLootFunction
                .builder(UniformLootNumberProvider.create(1,2))
                .build())
        .build();
                tableBuilder.pool(electric_dust);*/
