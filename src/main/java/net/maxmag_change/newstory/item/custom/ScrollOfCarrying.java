package net.maxmag_change.newstory.item.custom;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class ScrollOfCarrying extends Item {
    public ScrollOfCarrying(Settings settings) {
        super(settings);
    }
    public static boolean isSelect = false;
    public static boolean HaveBlock = false;

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (!isSelect) {
            isSelect = true;
            ScrollOfFire.isSelect = false;
            ScrollOfBreak.isSelect = false;
        }
        return super.use(world, user, hand);
    }
}
