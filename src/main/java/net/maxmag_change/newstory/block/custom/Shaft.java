package net.maxmag_change.newstory.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import org.jetbrains.annotations.Nullable;

public class Shaft extends Block {

    public static final DirectionProperty FACING = Properties.FACING;

    public Shaft(Settings settings) {
        super(settings);
    }

    public static VoxelShape SHAPE_E = Block.createCuboidShape(7, 7, 0, 2, 2, 7);

    public static VoxelShape SHAPE_N = Block.createCuboidShape(0, 7, 7, 7, 2, 2);

    public static VoxelShape SHAPE_W = Block.createCuboidShape(7, 7, 0, 2, 2, 7);

    public static VoxelShape SHAPE_S = Block.createCuboidShape(0, 7, 7, 7, 2, 2);

    public static VoxelShape DOWN = Block.createCuboidShape(7, 0, 7, 2, 7, 2);

    public static VoxelShape UP = Block.createCuboidShape(7, 0, 7, 2, 7, 2);

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        switch (state.get(FACING)) {
            case NORTH:
                return SHAPE_N;
            case SOUTH:
                return SHAPE_S;
            case WEST:
                return SHAPE_W;
            case EAST:
                return SHAPE_E;
            case UP:
                return UP;
            case DOWN:
                return DOWN;
            default:
                return SHAPE_N;
        }
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getPlayerFacing().getOpposite());
    }

    @Override
    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate(mirror.getRotation(state.get(FACING)));
    }

    @Override
    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return state.with(FACING, rotation.rotate(state.get(FACING)));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

}
