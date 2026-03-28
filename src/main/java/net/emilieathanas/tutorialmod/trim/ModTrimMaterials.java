package net.emilieathanas.tutorialmod.trim;

import net.emilieathanas.tutorialmod.TutorialMod;
import net.minecraft.item.equipment.trim.ArmorTrimAssets;
import net.minecraft.item.equipment.trim.ArmorTrimMaterial;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.text.TextColor;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.Map;

public class ModTrimMaterials {
    public static final RegistryKey<ArmorTrimMaterial> PINK_GARNET = of("pink_garnet");

    public static RegistryKey<ArmorTrimMaterial> of(String name){
        return RegistryKey.of(RegistryKeys.TRIM_MATERIAL, Identifier.of(TutorialMod.MOD_ID, name));
    }

    private static void register(Registerable<ArmorTrimMaterial> registerable, RegistryKey<ArmorTrimMaterial> key, Style style, ArmorTrimAssets assets) {
        Text text = Text.translatable(Util.createTranslationKey("trim_material", key.getValue())).fillStyle(style);
        registerable.register(key, new ArmorTrimMaterial(assets, text));
    }


    public static void bootstrap(Registerable<ArmorTrimMaterial> registerable) {
        register(registerable, PINK_GARNET, Style.EMPTY.withColor(TextColor.parse("#b03fe0").getOrThrow()), ModTrimAssets.PINK_GARNET);
    }

}
