package net.maxmag_change.newstory.item.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;

import static net.minecraft.block.Blocks.*;

public class Wand extends Item {
    public Wand(Settings settings) {
        super(settings);
    }

    BlockState state;

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
            BlockPos pos = context.getBlockPos();
            Block block = context.getWorld().getBlockState(pos).getBlock();
            if (ScrollOfBreak.isSelect) {
                if(block != BEDROCK && block != OBSIDIAN && block != BARRIER) {
                        context.getWorld().breakBlock(pos,true);
                }
            }
            if (ScrollOfFire.isSelect) {
                if(context.getWorld().getBlockState(pos.up(1)).getBlock() == AIR) {
                    context.getWorld().setBlockState(pos.up(1), FIRE.getDefaultState());
                }
            }
            if(ScrollOfCarrying.isSelect){
                if(!context.getWorld().isClient()){
                    if(ScrollOfCarrying.HaveBlock) {
                        if(context.getWorld().getBlockState(pos.up(1)).getBlock() == AIR) {
                            context.getWorld().setBlockState(pos.up(1), state);
                            ScrollOfCarrying.HaveBlock = false;
                        }
                    }
                    else {
                        if (block != BARRIER && block != BEDROCK) {
                            state = context.getWorld().getBlockState(pos);
                            ScrollOfCarrying.HaveBlock = true;
                            context.getWorld().breakBlock(pos, false);
                        }
                    }
                }
            }

        return super.useOnBlock(context);
    }
}
