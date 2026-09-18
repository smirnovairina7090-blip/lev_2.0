package ru.azazel.alchemytable.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;

public class RedstonePulseBlock extends Block {

    private static final int PULSE_DURATION_TICKS = 20;

    public RedstonePulseBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected void onPlace(
            BlockState state,
            Level level,
            BlockPos pos,
            BlockState oldState,
            boolean movedByPiston
    ) {
        super.onPlace(state, level, pos, oldState, movedByPiston);

        if (!level.isClientSide) {
            level.scheduleTick(pos, this, PULSE_DURATION_TICKS);
            level.updateNeighborsAt(pos, this);
        }
    }

    @Override
    protected void tick(
            BlockState state,
            ServerLevel level,
            BlockPos pos,
            RandomSource random
    ) {
        if (level.getBlockState(pos).is(this)) {
            level.removeBlock(pos, false);
            level.updateNeighborsAt(pos, this);
        }
    }

    @Override
    protected boolean isSignalSource(BlockState state) {
        return true;
    }

    @Override
    protected int getSignal(
            BlockState state,
            BlockGetter level,
            BlockPos pos,
            Direction direction
    ) {
        return 15;
    }

    @Override
    protected int getDirectSignal(
            BlockState state,
            BlockGetter level,
            BlockPos pos,
            Direction direction
    ) {
        return 15;
    }

    @Override
    protected RenderShape getRenderShape(BlockState state) {
        return RenderShape.INVISIBLE;
    }
}
