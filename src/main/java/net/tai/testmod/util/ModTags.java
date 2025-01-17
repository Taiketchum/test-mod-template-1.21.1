package net.tai.testmod.util;

import net.minecraft.block.Block;
import net.tai.testmod.TestMod;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;


public class ModTags {
    public static class Blocks {

        public static final TagKey<Block> NEEDS_RUBY_TOOL = createTag("needs_ruby_tool");
        public static final TagKey<Block> INCORRECT_FOR_RUBY_TOOL = createTag("incorrect_for_ruby_tool");

        public static final TagKey<Block> NEEDS_STORM_TOOL = createTag("needs_storm_tool");
        public static final TagKey<Block> INCORRECT_FOR_STORM_TOOL = createTag("incorrect_for_storm_tool");

        public static final TagKey<Block> NEEDS_KAIJU_TOOL = createTag("needs_kaiju_tool");
        public static final TagKey<Block> INCORRECT_FOR_KAIJU_TOOL = createTag("incorrect_for_kaiju_tool");

        private static TagKey<Block> createTag(String name){
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(TestMod.MOD_ID, name));
        }
    }
    public static class Items {
        public static final TagKey<Item> TRANSFORMABLE_ITEMS = createTag("transformable_items");

        private static TagKey<Item> createTag(String name){
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(TestMod.MOD_ID, name));
        }
    }
}
