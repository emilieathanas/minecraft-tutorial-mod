package net.emilieathanas.tutorialmod.component;

import net.emilieathanas.tutorialmod.TutorialMod;
import net.minecraft.block.Block;
import net.minecraft.component.ComponentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

import java.util.function.UnaryOperator;

public class ModDataComponentTypes {
    public static final ComponentType<BlockPos> COORDINATES = register("coorindates", builder -> builder.codec(BlockPos.CODEC));
    public static final ComponentType<Identifier> LAST_BLOCK_CHISELED = register("last_block_chiseled", builder -> builder.codec(Identifier.CODEC));

    public static void registerDataComponentTypes(){
        TutorialMod.LOGGER.info("Registering Data Component Types");
    }

    private static <T>ComponentType<T> register(String name, UnaryOperator<ComponentType.Builder<T>> builderOperator){
        return Registry.register(Registries.DATA_COMPONENT_TYPE, Identifier.of(TutorialMod.MOD_ID, name),
                builderOperator.apply(ComponentType.builder()).build());

    }


}
