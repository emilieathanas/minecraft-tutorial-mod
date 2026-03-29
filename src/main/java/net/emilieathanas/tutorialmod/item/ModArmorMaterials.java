package net.emilieathanas.tutorialmod.item;

import com.google.common.collect.Maps;
import net.emilieathanas.tutorialmod.TutorialMod;
import net.emilieathanas.tutorialmod.trim.ModEquipmentAssetKeys;
import net.emilieathanas.tutorialmod.util.ModTags;
import net.minecraft.item.equipment.*;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;

import java.util.Map;

public class ModArmorMaterials {

    public static final ArmorMaterial PINK_GARNET_ARMOR_MATERIAL = new ArmorMaterial(
            35,
            createDefenseMap(3, 6, 8, 3, 11),
            12,
            SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE,
            2.0F,
            0.0F,
            ModTags.Items.REPAIRS_PINK_GARNET_ARMOR,
            ModEquipmentAssetKeys.PINK_GARNET);

    private static Map<EquipmentType, Integer> createDefenseMap(int bootsDefense, int leggingsDefense, int chestplateDefense, int helmetDefense, int bodyDefense) {
        return Maps.newEnumMap(
                Map.of(
                        EquipmentType.BOOTS,
                        bootsDefense,
                        EquipmentType.LEGGINGS,
                        leggingsDefense,
                        EquipmentType.CHESTPLATE,
                        chestplateDefense,
                        EquipmentType.HELMET,
                        helmetDefense,
                        EquipmentType.BODY,
                        bodyDefense
                )
        );
    }

    static RegistryKey<EquipmentAsset> register(String name) {
        return RegistryKey.of(EquipmentAssetKeys.REGISTRY_KEY, Identifier.of(TutorialMod.MOD_ID, name));
    }

}
