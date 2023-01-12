package net.maxmag_change.newstory;


import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.maxmag_change.newstory.block.ModBlocks;
import net.minecraft.client.render.RenderLayer;

public class NewStoryClient implements ClientModInitializer {


    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DOOR_LOCK, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CAULDRON, RenderLayer.getTranslucent());
    }
}
