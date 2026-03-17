package net.emilieathanas.tutorialmod;

import net.emilieathanas.tutorialmod.block.ModBlocks;
import net.emilieathanas.tutorialmod.component.ModDataComponentTypes;
import net.emilieathanas.tutorialmod.item.ModItems;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.fabricmc.fabric.api.client.rendering.v1.BlockRenderLayerMap;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.input.AbstractInput;
import net.minecraft.client.input.KeyInput;
import net.minecraft.client.render.BlockRenderLayer;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.util.InputUtil;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import org.lwjgl.glfw.GLFW;

import java.util.List;


public class TutorialModClient implements ClientModInitializer {


    @Override
    public void onInitializeClient() {

        ItemTooltipCallback.EVENT.register((stack, context, type, lines) -> {
            boolean shift = InputUtil.isKeyPressed(
                    MinecraftClient.getInstance().getWindow(),
                    GLFW.GLFW_KEY_LEFT_SHIFT
            ) || InputUtil.isKeyPressed(
                    MinecraftClient.getInstance().getWindow(),
                    GLFW.GLFW_KEY_RIGHT_SHIFT
            );

            if(stack.getItem() == ModItems.CHISEL){
                if(shift){
                    lines.add(Text.translatable("tooltip.tutorialmod.chisel.tooltip_shift"));

                } else {
                    lines.add(Text.translatable("tooltip.tutorialmod.chisel.tooltip"));
                }
            }

            if(stack.isOf(ModBlocks.MAGIC_BLOCK.asItem())){
                if(shift){
                    lines.add(Text.translatable("tooltip.tutorialmod.magic_block.tooltip_shift"));
                } else {
                    lines.add(Text.translatable("tooltip.tutorialmod.magic_block.tooltip"));

                }
            }

            if(stack.get(ModDataComponentTypes.COORDINATES) != null){
                lines.add(Text.literal("Last Block Changed at " + stack.get(ModDataComponentTypes.COORDINATES)));
            }

            if(stack.get(ModDataComponentTypes.LAST_BLOCK_CHISELED) != null){
                lines.add(Text.literal("Last Block Chiseled: " + stack.get(ModDataComponentTypes.LAST_BLOCK_CHISELED)));
            }
        });

        BlockRenderLayerMap.putBlock(ModBlocks.PINK_GARNET_DOOR, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.PINK_GARNET_TRAP_DOOR, BlockRenderLayer.CUTOUT);

    }
}
