package net.maxmag_change.newstory.item.custom;

import net.maxmag_change.newstory.block.ModBlocks;
import net.maxmag_change.newstory.block.custom.Cauldron;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;

import static net.minecraft.block.Blocks.*;

public class Wand extends Item {
    public Wand(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
            BlockPos pos = context.getBlockPos();
            PlayerEntity player = context.getPlayer();
            Block block = context.getWorld().getBlockState(pos).getBlock();
            if(block != BEDROCK || block != OBSIDIAN || block != BARRIER) {
                if (block != ModBlocks.CAULDRON){
                    context.getWorld().breakBlock(pos,true);
                }
            }
        return super.useOnBlock(context);
    }
}
