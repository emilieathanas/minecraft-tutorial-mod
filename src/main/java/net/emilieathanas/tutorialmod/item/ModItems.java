package net.emilieathanas.tutorialmod.item;

import net.emilieathanas.tutorialmod.TutorialMod;
import net.emilieathanas.tutorialmod.item.custom.ChiselItem;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item PINK_GARNET = registerItem("pink_garnet", new Item(
            new Item.Settings().registryKey(
                net.minecraft.registry.RegistryKey.of(
                        net.minecraft.registry.RegistryKeys.ITEM, Identifier.of(
                                TutorialMod.MOD_ID, "pink_garnet"
                        )
                )
            )
    ));
    public static final Item RAW_PINK_GARNET = registerItem("raw_pink_garnet", new Item(
            new Item.Settings().registryKey(
                net.minecraft.registry.RegistryKey.of(
                        net.minecraft.registry.RegistryKeys.ITEM, Identifier.of(
                                TutorialMod.MOD_ID, "raw_pink_garnet"
                        )
                )
            )
    ));

    public static final Item CHISEL = registerItem("chisel", new ChiselItem(
            new Item.Settings().maxDamage(32).registryKey(
                    net.minecraft.registry.RegistryKey.of(
                            net.minecraft.registry.RegistryKeys.ITEM, Identifier.of(
                                    TutorialMod.MOD_ID, "chisel"
                            )
                    )
            )
    ));

    public static final Item CAULIFLOWER = registerItem("cauliflower", new Item(
            new Item.Settings().component(DataComponentTypes.FOOD, ModFoodComponents.CAULIFLOWER)
                    .component(DataComponentTypes.CONSUMABLE, ModFoodComponents.CAULIFLOWER_CONSUMABLE)
                    .registryKey(
                            net.minecraft.registry.RegistryKey.of(
                                    net.minecraft.registry.RegistryKeys.ITEM, Identifier.of(
                                            TutorialMod.MOD_ID, "cauliflower"
                                    )
                            )
                    )
    ));


    public static final Item STARLIGHT_ASHES = registerItem("starlight_ashes", new Item(
            new Item.Settings().registryKey(
                    net.minecraft.registry.RegistryKey.of(
                            net.minecraft.registry.RegistryKeys.ITEM, Identifier.of(
                                    TutorialMod.MOD_ID, "starlight_ashes"
                            )
                    )
            )
    ));

    public static final Item PINK_GARNET_SWORD = registerItem("pink_garnet_sword", new Item(
            new Item.Settings().registryKey(
                    net.minecraft.registry.RegistryKey.of(
                            net.minecraft.registry.RegistryKeys.ITEM, Identifier.of(
                                    TutorialMod.MOD_ID, "pink_garnet_sword"
                            )
                    )
            )
                    .sword(
                            ModToolMaterials.PINK_GARNET_TOOL_MATERIAL, 1f, 1f
                    )
    ));
    public static final Item PINK_GARNET_PICKAXE = registerItem("pink_garnet_pickaxe", new Item(
            new Item.Settings().registryKey(
                    net.minecraft.registry.RegistryKey.of(
                            net.minecraft.registry.RegistryKeys.ITEM, Identifier.of(
                                    TutorialMod.MOD_ID, "pink_garnet_pickaxe"
                            )
                    )
            )
                    .pickaxe(
                            ModToolMaterials.PINK_GARNET_TOOL_MATERIAL, 1f, 1f
                    )
    ));
    public static final Item PINK_GARNET_AXE = registerItem("pink_garnet_axe", new AxeItem(
            ModToolMaterials.PINK_GARNET_TOOL_MATERIAL, 5.0F, -3.0F,
            new Item.Settings().registryKey(
                    net.minecraft.registry.RegistryKey.of(
                            net.minecraft.registry.RegistryKeys.ITEM, Identifier.of(
                                    TutorialMod.MOD_ID, "pink_garnet_axe"
                            )
                    )
            ))
    );

    public static final Item PINK_GARNET_SHOVEL = registerItem("pink_garnet_shovel", new ShovelItem(
            ModToolMaterials.PINK_GARNET_TOOL_MATERIAL, 1.4F, -3.0F,
            new Item.Settings().registryKey(
                    net.minecraft.registry.RegistryKey.of(
                            net.minecraft.registry.RegistryKeys.ITEM, Identifier.of(
                                    TutorialMod.MOD_ID, "pink_garnet_shovel"
                            )
                    )
            )
    ));

    public static void registerModItems(){
        TutorialMod.LOGGER.info("Registering mod items for: " + TutorialMod.MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(PINK_GARNET);
            fabricItemGroupEntries.add(RAW_PINK_GARNET);
        });
    }

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, Identifier.of(TutorialMod.MOD_ID, name), item);
    }

}
