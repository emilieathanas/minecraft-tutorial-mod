package net.emilieathanas.tutorialmod.item;

import net.emilieathanas.tutorialmod.TutorialMod;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
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
