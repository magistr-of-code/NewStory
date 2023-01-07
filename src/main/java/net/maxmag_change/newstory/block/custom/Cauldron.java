package net.maxmag_change.newstory.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Hand;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.stream.Stream;

public class Cauldron extends HorizontalFacingBlock {
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;

    public Cauldron(Settings settings) {
        super(settings);
    }

    public static VoxelShape shape = Stream.of(
            Block.createCuboidShape(0, 1, 0, 16, 2, 16),
            Block.createCuboidShape(0, 0, 0, 1, 1, 2),
            Block.createCuboidShape(15, 0, 0, 16, 1, 2),
            Block.createCuboidShape(14, 0, 0, 15, 1, 1),
            Block.createCuboidShape(1, 0, 0, 2, 1, 1),
            Block.createCuboidShape(15, 0, 14, 16, 1, 16),
            Block.createCuboidShape(14, 0, 15, 15, 1, 16),
            Block.createCuboidShape(0, 0, 14, 1, 1, 16),
            Block.createCuboidShape(1, 0, 15, 2, 1, 16),
            Block.createCuboidShape(0, 2, 0, 2, 15, 16),
            Block.createCuboidShape(14, 2, 0, 16, 15, 16),
            Block.createCuboidShape(2, 2, 0, 14, 15, 2),
            Block.createCuboidShape(2, 2, 14, 14, 15, 16)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return shape;
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return super.getPlacementState(ctx);
    }

    @Override
    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return super.mirror(state, mirror);
    }

    @Override
    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return super.rotate(state, rotation);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        if (entity instanceof ItemEntity) {
            if (ItemEntity.merge(Items.ACACIA_BOAT.getDefaultStack(),Items.ACACIA_BOAT.getDefaultStack(),1) == Items.ACACIA_BOAT.getDefaultStack()){

            }

        }
        super.onSteppedOn(world, pos, state, entity);
    }
}
