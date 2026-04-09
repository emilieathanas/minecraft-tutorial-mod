package net.emilieathanas.tutorialmod.mixin;

import net.emilieathanas.tutorialmod.TutorialMod;
import net.minecraft.server.MinecraftServer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftServer.class)
abstract class TutorialFirstMixin {

	/**
	 * CallBackInfo - parameter used for injecting into a void method
	 * CallbackInfoReturnable<T> cir - used for injecting into a method with a return value
	 */
	@Inject(method = "loadWorld", at = @At(value = "HEAD"))
	private void logOnLoadWorld(CallbackInfo ci){
		TutorialMod.LOGGER.info("MinecraftServer$loadLevel has started!");

	}

}