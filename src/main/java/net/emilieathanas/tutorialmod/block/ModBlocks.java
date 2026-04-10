package net.emilieathanas.tutorialmod.block;

import net.emilieathanas.tutorialmod.TutorialMod;
import net.emilieathanas.tutorialmod.block.custom.MagicBlock;
import net.emilieathanas.tutorialmod.block.custom.PinkGarnetLampBlock;
import net.emilieathanas.tutorialmod.sounds.ModSounds;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
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
    public static final Block MAGIC_BLOCK = registerBlock("magic_block", new MagicBlock(
            AbstractBlock.Settings.create()
            .registryKey(net.minecraft.registry.RegistryKey.of(
                    RegistryKeys.BLOCK,
                    Identifier.of(TutorialMod.MOD_ID, "magic_block")
            ))
            .strength(1f)
            .requiresTool()
                    .sounds(ModSounds.MAGIC_BLOCK_SOUNDS)
    ));

    public static final Block PINK_GARNET_STAIRS = registerBlock("pink_garnet_stairs", new StairsBlock(
            ModBlocks.PINK_GARNET_BLOCK.getDefaultState(), AbstractBlock.Settings.create()
            .registryKey(net.minecraft.registry.RegistryKey.of(
                    RegistryKeys.BLOCK,
                    Identifier.of(TutorialMod.MOD_ID, "pink_garnet_stairs")
            ))
            .strength(2f)
            .requiresTool()
    ));
    public static final Block PINK_GARNET_SLAB = registerBlock("pink_garnet_slab", new SlabBlock(
            AbstractBlock.Settings.create()
            .registryKey(net.minecraft.registry.RegistryKey.of(
                    RegistryKeys.BLOCK,
                    Identifier.of(TutorialMod.MOD_ID, "pink_garnet_slab")
            ))
            .strength(2f)
            .requiresTool()
    ));


    public static final Block PINK_GARNET_BUTTON = registerBlock("pink_garnet_button", new ButtonBlock(
            BlockSetType.IRON, 20, AbstractBlock.Settings.create()
            .registryKey(net.minecraft.registry.RegistryKey.of(
                    RegistryKeys.BLOCK,
                    Identifier.of(TutorialMod.MOD_ID, "pink_garnet_button")
            ))
            .strength(2f)
            .requiresTool()
            .noCollision()
    ));
    public static final Block PINK_GARNET_PRESSURE_PLATE = registerBlock("pink_garnet_pressure_plate", new PressurePlateBlock(
            BlockSetType.IRON, AbstractBlock.Settings.create()
            .registryKey(net.minecraft.registry.RegistryKey.of(
                    RegistryKeys.BLOCK,
                    Identifier.of(TutorialMod.MOD_ID, "pink_garnet_pressure_plate")
            ))
            .strength(2f)
            .requiresTool()
    ));
    public static final Block PINK_GARNET_FENCE = registerBlock("pink_garnet_fence", new FenceBlock(
            AbstractBlock.Settings.create()
            .registryKey(net.minecraft.registry.RegistryKey.of(
                    RegistryKeys.BLOCK,
                    Identifier.of(TutorialMod.MOD_ID, "pink_garnet_fence")
            ))
            .strength(2f)
            .requiresTool()
    ));
    public static final Block PINK_GARNET_FENCE_GATE = registerBlock("pink_garnet_fence_gate", new FenceGateBlock(
            WoodType.ACACIA, AbstractBlock.Settings.create()
            .registryKey(net.minecraft.registry.RegistryKey.of(
                    RegistryKeys.BLOCK,
                    Identifier.of(TutorialMod.MOD_ID, "pink_garnet_fence_gate")
            ))
            .strength(2f)
            .requiresTool()
    ));
    public static final Block PINK_GARNET_WALL = registerBlock("pink_garnet_wall", new WallBlock(
            AbstractBlock.Settings.create()
            .registryKey(net.minecraft.registry.RegistryKey.of(
                    RegistryKeys.BLOCK,
                    Identifier.of(TutorialMod.MOD_ID, "pink_garnet_wall")
            ))
            .strength(2f)
            .requiresTool()
    ));
    public static final Block PINK_GARNET_DOOR = registerBlock("pink_garnet_door", new DoorBlock(
            BlockSetType.IRON, AbstractBlock.Settings.create()
            .registryKey(net.minecraft.registry.RegistryKey.of(
                    RegistryKeys.BLOCK,
                    Identifier.of(TutorialMod.MOD_ID, "pink_garnet_door")
            ))
            .strength(2f)
            .requiresTool()
            .nonOpaque()
    ));
    public static final Block PINK_GARNET_TRAP_DOOR = registerBlock("pink_garnet_trap_door", new TrapdoorBlock(
            BlockSetType.IRON, AbstractBlock.Settings.create()
            .registryKey(net.minecraft.registry.RegistryKey.of(
                    RegistryKeys.BLOCK,
                    Identifier.of(TutorialMod.MOD_ID, "pink_garnet_trap_door")
            ))
            .strength(2f)
            .requiresTool()
            .nonOpaque()
    ));

    public static final Block PINK_GARNET_LAMP = registerBlock("pink_garnet_lamp", new PinkGarnetLampBlock(
            AbstractBlock.Settings.create()
                    .registryKey(net.minecraft.registry.RegistryKey.of(
                            RegistryKeys.BLOCK,
                            Identifier.of(TutorialMod.MOD_ID, "pink_garnet_lamp")
                    ))
                    .strength(1f)
                    .requiresTool()
                    .luminance(state ->
                            (state.get(PinkGarnetLampBlock.CLICKED) && !state.get(PinkGarnetLampBlock.LIT)) ||
                                    (!state.get(PinkGarnetLampBlock.CLICKED) && state.get(PinkGarnetLampBlock.LIT)) ? 15 : 0)

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
