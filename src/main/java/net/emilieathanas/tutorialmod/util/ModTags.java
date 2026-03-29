package net.emilieathanas.tutorialmod.util;

import net.emilieathanas.tutorialmod.TutorialMod;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import javax.swing.text.html.HTML;

public class ModTags {
    public static class Blocks{
        public static final TagKey<Block> INCORRECT_FOR_PINK_GARNET_TOOL = createTag("incorrect_for_pink_garnet_tool");
        private static TagKey<Block> createTag(String name){
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(TutorialMod.MOD_ID, name));
        }

    }

    public static class Items{
        public static final TagKey<Item> TRANSFORMABLE_ITEMS = createTag("transformable_items");
        public static final TagKey<Item> REPAIRS_PINK_GARNET_TOOLS = createTag("repairs_pink_garnet_tools");
        public static final TagKey<Item> REPAIRS_PINK_GARNET_ARMOR = createTag("repairs_pink_garnet_armor");
        public static final TagKey<Item> NETHERITE_ARMOR = createTag("netherite_armor");
        private static TagKey<Item> createTag(String name){
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(TutorialMod.MOD_ID, name));
        }

    }
}
