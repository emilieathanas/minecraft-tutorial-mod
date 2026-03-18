package net.emilieathanas.tutorialmod.util;

import net.emilieathanas.tutorialmod.item.custom.HammerItem;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.HashSet;
import java.util.Set;

public class HammerUsageEvent implements PlayerBlockBreakEvents.Before{
    private static final Set<BlockPos> HARVESTED_BLOCKS = new HashSet<>();

    /**
     * beforeBlockBreak is called before a block is fully broken
     * @param world the world in which the block is broken
     * @param playerEntity the player breaking the block
     * @param blockPos the position at which the block is broken
     * @param blockState the block state <strong>before</strong> the block is broken
     * @param blockEntity the block entity <strong>before</strong> the block is broken, can be {@code null}
     * @return
     */
    @Override
    public boolean beforeBlockBreak(World world, PlayerEntity playerEntity, BlockPos blockPos, BlockState blockState, @Nullable BlockEntity blockEntity) {
        ItemStack mainHandItem = playerEntity.getMainHandStack();

        if(mainHandItem.getItem() instanceof HammerItem hammerItem && playerEntity instanceof ServerPlayerEntity serverPlayer){
            if(HARVESTED_BLOCKS.contains(blockPos)){
                return true;
            }
            for(BlockPos position : HammerItem.getBlocksToBeDestroyed(1, blockPos, serverPlayer) ){
                if(blockPos.equals(position) || !hammerItem.isCorrectForDrops(mainHandItem, world.getBlockState(position))){
                    continue;
                }
                HARVESTED_BLOCKS.add(position);
                serverPlayer.interactionManager.tryBreakBlock(position);
                HARVESTED_BLOCKS.remove(position);
            }
        }
        return true;
    }
}
