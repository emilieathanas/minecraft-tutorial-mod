package net.emilieathanas.tutorialmod.trim;
import net.emilieathanas.tutorialmod.TutorialMod;
import net.minecraft.item.equipment.EquipmentAsset;
import net.minecraft.item.equipment.EquipmentAssetKeys;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

public class ModEquipmentAssetKeys {
    public static final RegistryKey<EquipmentAsset> PINK_GARNET = register("pink_garnet");

    static RegistryKey<EquipmentAsset> register(String name) {
        return RegistryKey.of(EquipmentAssetKeys.REGISTRY_KEY, Identifier.of(TutorialMod.MOD_ID, name));
    }
}
