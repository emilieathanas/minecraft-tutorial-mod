package net.emilieathanas.tutorialmod.trim;

import net.emilieathanas.tutorialmod.TutorialMod;
import net.minecraft.item.equipment.trim.ArmorTrimPattern;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

public class ModTrimPatterns {
    public static final RegistryKey<ArmorTrimPattern> BLOOMINGMAROON = of("bloomingmaroon");

    private static RegistryKey<ArmorTrimPattern> of(String id){
        return RegistryKey.of(RegistryKeys.TRIM_PATTERN, Identifier.of(TutorialMod.MOD_ID, id));
    }

    public static void register(Registerable<ArmorTrimPattern> registry, RegistryKey<ArmorTrimPattern> key) {
        ArmorTrimPattern armorTrimPattern = new ArmorTrimPattern(key.getValue(), Text.translatable(Util.createTranslationKey("trim_pattern", key.getValue())), false);
        registry.register(key, armorTrimPattern);
    }

    public static void bootstrap(Registerable<ArmorTrimPattern> registerable) {
        register(registerable, BLOOMINGMAROON);
    }

}