package net.emilieathanas.tutorialmod.item;

import net.emilieathanas.tutorialmod.TutorialMod;
import net.emilieathanas.tutorialmod.item.custom.ChiselItem;
import net.emilieathanas.tutorialmod.item.custom.HammerItem;
import net.emilieathanas.tutorialmod.item.custom.ModArmorItem;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.item.*;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

import java.util.function.Function;

import static net.minecraft.item.Items.register;

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

    public static final Item PINK_GARNET_HOE = registerItem("pink_garnet_hoe", new HoeItem(
            ModToolMaterials.PINK_GARNET_TOOL_MATERIAL, -3.0F, 0.0F,
            new Item.Settings().registryKey(
                    net.minecraft.registry.RegistryKey.of(
                            net.minecraft.registry.RegistryKeys.ITEM, Identifier.of(
                                    TutorialMod.MOD_ID, "pink_garnet_hoe"
                            )
                    )
            )
    ));

    public static final Item PINK_GARNET_HAMMER = registerItem("pink_garnet_hammer", new HammerItem(
            new Item.Settings().registryKey(
                            net.minecraft.registry.RegistryKey.of(
                                    net.minecraft.registry.RegistryKeys.ITEM, Identifier.of(
                                            TutorialMod.MOD_ID, "pink_garnet_hammer"
                                    )
                            )
                    )
                    .pickaxe(
                            ModToolMaterials.PINK_GARNET_TOOL_MATERIAL, 7, -3.4f
                    )
    ));

    public static final Item PINK_GARNET_HELMET = registerItem("pink_garnet_helmet", new ModArmorItem(
            new Item.Settings().registryKey(
                    net.minecraft.registry.RegistryKey.of(
                            net.minecraft.registry.RegistryKeys.ITEM, Identifier.of(
                                    TutorialMod.MOD_ID, "pink_garnet_helmet"
                            )
                    )
            )
                    .armor(
                            ModArmorMaterials.PINK_GARNET_ARMOR_MATERIAL, EquipmentType.HELMET

                    )
    ));

    public static final Item PINK_GARNET_CHESTPLATE = registerItem("pink_garnet_chestplate", new Item(
            new Item.Settings().registryKey(
                    net.minecraft.registry.RegistryKey.of(
                            net.minecraft.registry.RegistryKeys.ITEM, Identifier.of(
                                    TutorialMod.MOD_ID, "pink_garnet_chestplate"
                            )
                    )
            )
                    .armor(
                            ModArmorMaterials.PINK_GARNET_ARMOR_MATERIAL, EquipmentType.CHESTPLATE

                    )
    ));


    public static final Item PINK_GARNET_LEGGINGS = registerItem("pink_garnet_leggings", new Item(
            new Item.Settings().registryKey(
                    net.minecraft.registry.RegistryKey.of(
                            net.minecraft.registry.RegistryKeys.ITEM, Identifier.of(
                                    TutorialMod.MOD_ID, "pink_garnet_leggings"
                            )
                    )
            )
                    .armor(
                            ModArmorMaterials.PINK_GARNET_ARMOR_MATERIAL, EquipmentType.LEGGINGS

                    )
    ));

    public static final Item PINK_GARNET_BOOTS = registerItem("pink_garnet_boots", new Item(
            new Item.Settings().registryKey(
                    net.minecraft.registry.RegistryKey.of(
                            net.minecraft.registry.RegistryKeys.ITEM, Identifier.of(
                                    TutorialMod.MOD_ID, "pink_garnet_boots"
                            )
                    )
            )
                    .armor(
                            ModArmorMaterials.PINK_GARNET_ARMOR_MATERIAL, EquipmentType.BOOTS

                    )
    ));


    public static final Item PINK_GARNET_HORSE_ARMOR = registerItem("pink_garnet_horse_armor", new Item(
            new Item.Settings().registryKey(
                    net.minecraft.registry.RegistryKey.of(
                            net.minecraft.registry.RegistryKeys.ITEM, Identifier.of(
                                    TutorialMod.MOD_ID, "pink_garnet_horse_armor"
                            )
                    )
            )
                    .horseArmor(ModArmorMaterials.PINK_GARNET_ARMOR_MATERIAL)

    ));


    public static final SmithingTemplateItem BLOOMINGMAROON_ARMOR_TRIM_SMITHING_TEMPLATE = registerSmithingTemplate("bloomingmaroon_armor_trim_smithing_template", settings -> SmithingTemplateItem.of(settings.rarity(Rarity.RARE)));


    private static SmithingTemplateItem registerSmithingTemplate(String name, Function<Item.Settings, SmithingTemplateItem> function){
        Identifier id = Identifier.of(TutorialMod.MOD_ID, name);
        return Registry.register(Registries.ITEM, id,
                function.apply(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, id))));

    }

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
