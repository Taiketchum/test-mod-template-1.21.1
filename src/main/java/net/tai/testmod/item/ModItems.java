package net.tai.testmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.tai.testmod.TestMod;
import net.tai.testmod.item.custom.ChiselItem;

public class ModItems {
    public static final Item RUBY_GEM = registerItem("ruby_gem", new Item(new Item.Settings()));
    public static final Item RAW_RUBY = registerItem("raw_ruby", new Item(new Item.Settings()));
    public static final Item TRUFFLE = registerItem("truffle", new Item(new Item.Settings()));

    public static final Item IRON_CHISEL = registerItem("iron_chisel", new ChiselItem(new Item.Settings().maxDamage(32)));
    public static final Item DIAMOND_CHISEL = registerItem("diamond_chisel", new ChiselItem(new Item.Settings().maxDamage(64)));
    public static final Item NETHERITE_CHISEL = registerItem("netherite_chisel", new ChiselItem(new Item.Settings().maxDamage(128)));

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, Identifier.of(TestMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        TestMod.LOGGER.info("Registering Mod Items for "+ TestMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
           entries.add(RUBY_GEM);
           entries.add(RAW_RUBY);
        });
    }
}
