package net.emilieathanas.tutorialmod.mixin;

import net.emilieathanas.tutorialmod.item.ModItems;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.util.math.MathHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(AbstractClientPlayerEntity.class)
public class AbstractClientPlayerEntityMixin {

    @Inject(method = "getFovMultiplier", at = @At("TAIL"), cancellable = true)
    private void getFovMultiplierMixin(boolean firstPerson, float fovScale, CallbackInfoReturnable<Float> cir) {
        AbstractClientPlayerEntity player = (AbstractClientPlayerEntity)(Object)this;

        if (player.isUsingItem() && player.getActiveItem().isOf(ModItems.BLOOM_BOW)) {
            float f = 1.0F;
            float h = Math.min(player.getItemUseTime() / 20.0F, 1.0F);
            f *= 1.0F - MathHelper.square(h) * 0.15F;

            float result = MathHelper.lerp(
                    MinecraftClient.getInstance().options.getFovEffectScale().getValue().floatValue(),
                    1.0f,
                    f
            );

            cir.setReturnValue(result);
        }
    }
}
