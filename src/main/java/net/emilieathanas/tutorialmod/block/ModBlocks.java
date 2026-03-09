package net.emilieathanas.tutorialmod.block;

import net.emilieathanas.tutorialmod.TutorialMod;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {

    public static final Block PINK_GARNET_BLOCK = registerBlock("pink_garnet_block", new Block(
            AbstractBlock.Settings.create()
                    .registryKey(net.minecraft.registry.RegistryKey.of(
                            RegistryKeys.BLOCK,
                            Identifier.of(TutorialMod.MOD_ID, "pink_garnet_block")
                    ))
                    .strength(4f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.AMETHYST_BLOCK)
    ));

    public static final Block RAW_PINK_GARNET_BLOCK = registerBlock("raw_pink_garnet_block", new Block(
            AbstractBlock.Settings.create()
                    .registryKey(net.minecraft.registry.RegistryKey.of(
                            RegistryKeys.BLOCK,
                            Identifier.of(TutorialMod.MOD_ID, "raw_pink_garnet_block")
                    ))
                    .strength(4f)
                    .requiresTool()
    ));

    public static final Block PINK_GARNET_ORE = registerBlock("pink_garnet_ore", new ExperienceDroppingBlock(
            UniformIntProvider.create(2,5), AbstractBlock.Settings.create()
                    .registryKey(net.minecraft.registry.RegistryKey.of(
                            RegistryKeys.BLOCK,
                            Identifier.of(TutorialMod.MOD_ID, "pink_garnet_ore")
                    ))
                    .strength(4f)
                    .requiresTool()
    ));

    public static final Block PINK_GARNET_DEEPSLATE_ORE = registerBlock("pink_garnet_deepslate_ore", new ExperienceDroppingBlock(
            UniformIntProvider.create(2,5), AbstractBlock.Settings.create()
            .registryKey(net.minecraft.registry.RegistryKey.of(
                    RegistryKeys.BLOCK,
                    Identifier.of(TutorialMod.MOD_ID, "pink_garnet_deepslate_ore")
            ))
            .strength(4f)
            .requiresTool()
    ));

    public static void registerModBlocks(){

        TutorialMod.LOGGER.info("Registering Mod Blocks for " + TutorialMod.MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(ModBlocks.PINK_GARNET_BLOCK);
            fabricItemGroupEntries.add(ModBlocks.RAW_PINK_GARNET_BLOCK);

            fabricItemGroupEntries.add(ModBlocks.PINK_GARNET_ORE);
            fabricItemGroupEntries.add(ModBlocks.PINK_GARNET_DEEPSLATE_ORE);

        });
    }

    private static void registerBlockItem(String name, Block block){
        Registry.register(Registries.ITEM, Identifier.of(TutorialMod.MOD_ID, name),
                new BlockItem(block, new Item.Settings().registryKey(
                        RegistryKey.of(RegistryKeys.ITEM, Identifier.of(TutorialMod.MOD_ID, name))
                )));
    }

    private static Block registerBlock(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(TutorialMod.MOD_ID, name), block);
    }
}
