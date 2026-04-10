package net.emilieathanas.tutorialmod;

import net.emilieathanas.tutorialmod.block.ModBlocks;
import net.emilieathanas.tutorialmod.component.ModDataComponentTypes;
import net.emilieathanas.tutorialmod.item.ModItemGroups;
import net.emilieathanas.tutorialmod.item.ModItems;
import net.emilieathanas.tutorialmod.sounds.ModSounds;
import net.emilieathanas.tutorialmod.util.HammerUsageEvent;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.fabricmc.fabric.api.registry.FuelRegistryEvents;
import net.minecraft.item.FuelRegistry;
import net.minecraft.item.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class TutorialMod implements ModInitializer {
	public static final String MOD_ID = "tutorialmod";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModItemGroups.registerItemGroups();
		ModSounds.registerSounds();

        FuelRegistryEvents.BUILD.register(((builder, context) -> {
			builder.add(ModItems.STARLIGHT_ASHES, 600);
		}));

		ModDataComponentTypes.registerDataComponentTypes();

		PlayerBlockBreakEvents.BEFORE.register(new HammerUsageEvent());

	}
}