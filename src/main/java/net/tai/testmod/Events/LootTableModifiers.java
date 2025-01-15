package net.tai.testmod.Events;

import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.entity.EntityType;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.EntityPropertiesLootCondition;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.entity.EntityPredicate;
import net.minecraft.registry.RegistryKey;
import net.tai.testmod.item.ModItems;
import org.apache.commons.compress.archivers.Lister;

import java.net.http.WebSocket;
import java.util.List;

public class LootTableModifiers {

    private static final RegistryKey<LootTable> CREEPER_KEY = EntityType.CREEPER.getLootTableId();

    public LootTableModifiers(){
        throw new AssertionError();
    }

    public static void register() {
        LootTableEvents.MODIFY.register((key, tableBuilder, source, registries)->{
            if (key.equals(CREEPER_KEY)){
                LootPool electric_dust = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1.0f))//100%
                        .with(ItemEntry.builder(ModItems.ELECTRIC_DUST))
                        .apply(SetCountLootFunction
                                .builder(UniformLootNumberProvider.create(1,2))
                                .build())
                        .build();
                LootPool storm_heart = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(.01f))//1%
                        .with(ItemEntry.builder(ModItems.HEART_OF_THE_STORM))
                        .apply(SetCountLootFunction
                                .builder(UniformLootNumberProvider.create(1,1))
                                .build())
                        .build();
                tableBuilder.pools(List.of(electric_dust,storm_heart));
            }
        });
    }
}
