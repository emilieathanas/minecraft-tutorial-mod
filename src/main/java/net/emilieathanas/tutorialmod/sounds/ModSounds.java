package net.emilieathanas.tutorialmod.sounds;

import net.emilieathanas.tutorialmod.TutorialMod;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {

    public static SoundEvent CHISEL_USE = registerSoundEvent("chisel_use");
    public static SoundEvent MAGIC_BLOCK_BREAK = registerSoundEvent("magic_block_break");
    public static SoundEvent MAGIC_BLOCK_STEP = registerSoundEvent("magic_block_step");
    public static SoundEvent MAGIC_BLOCK_PLACE = registerSoundEvent("magic_block_place");
    public static SoundEvent MAGIC_BLOCK_HIT = registerSoundEvent("magic_block_hit");
    public static SoundEvent MAGIC_BLOCK_FALL = registerSoundEvent("magic_block_fall");

    public static final BlockSoundGroup MAGIC_BLOCK_SOUNDS = new BlockSoundGroup(1f, 1f,
            MAGIC_BLOCK_BREAK, MAGIC_BLOCK_STEP, MAGIC_BLOCK_PLACE, MAGIC_BLOCK_HIT, MAGIC_BLOCK_FALL);

    private static SoundEvent registerSoundEvent(String name){
        Identifier id = Identifier.of(TutorialMod.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void registerSounds(){
        TutorialMod.LOGGER.info("Registering mod sounds for " + TutorialMod.MOD_ID);
    }
}
