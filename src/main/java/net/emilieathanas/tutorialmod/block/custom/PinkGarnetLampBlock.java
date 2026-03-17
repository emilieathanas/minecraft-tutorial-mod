package net.emilieathanas.tutorialmod.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.RedstoneTorchBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.block.WireOrientation;
import org.jetbrains.annotations.Nullable;

public class PinkGarnetLampBlock extends Block {
    public static final BooleanProperty CLICKED = BooleanProperty.of("clicked");
    public static final BooleanProperty LIT = BooleanProperty.of("lit");

    public PinkGarnetLampBlock(Settings settings) {
        super(settings);
        setDefaultState(this.getDefaultState().with(CLICKED, false));
        setDefaultState(this.getDefaultState().with(LIT, false));
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if(!world.isClient()){
            world.setBlockState(pos, state.cycle(CLICKED));

        }
        //action success gives swinging animation
        return ActionResult.SUCCESS;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(CLICKED);
        builder.add(LIT);
    }

    /**
     * run when lamp is initially placed down
     * starts from the block's default state and sets the LIT property
     * based on whether the placement position is currently receiving a redstone power
     * @param ctx contains info about the placement, such as the world and target position
     * @return the initial block state for this lamp at placement time
     */
    @Override
    public @Nullable BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(LIT, ctx.getWorld().isReceivingRedstonePower(ctx.getBlockPos()));
    }

    /**
     * runs when a neighboring block has changed
     * checks the current state of LIT
     * checks if current block is being powered
     * if the lamp is lit but the block is not being powered, a delayed block tick is scheduled so it can turn off
     * after 4 ticks
     * if the lamp is not lit but the block is now powered, it turns on immediately
     * uses scheduleBlockTick to schedule an event to occur in x amount of ticks (4 in this case)
     * @param state current state of this block at this position
     * @param world the world the block is in
     * @param pos the exact coordinates of the block in this world
     * @param sourceBlock the neighboring block that triggers the update
     * @param wireOrientation extra redstone/wire update context
     * @param notify indicates update/notification context
     */
    @Override
    protected void neighborUpdate(BlockState state, World world, BlockPos pos, Block sourceBlock, @Nullable WireOrientation wireOrientation, boolean notify) {
        if(!world.isClient()){
            boolean isLit = (Boolean) state.get(LIT);
            boolean isPowered = world.isReceivingRedstonePower(pos);

            if(isLit && !isPowered){
                world.scheduleBlockTick(pos, this, 4);
            } else if(!isLit && isPowered){
                world.setBlockState(pos, state.cycle(LIT), Block.NOTIFY_LISTENERS);
            }
        }
    }

    /**
     * called when a previously scheduled block tick occurs for this lamp
     * used here to perform a delayed re-check after power is lost
     * @param state current state of this block at this position
     * @param world the world the block lives in
     * @param pos the exact coordinates of the block in this world
     * @param random random source provided for schedule ticks
     */
    @Override
    protected void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if((Boolean) state.get(LIT) && !world.isReceivingRedstonePower(pos)){
            world.setBlockState(pos, state.cycle(LIT), Block.NOTIFY_LISTENERS);
        }
    }
}
