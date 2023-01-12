package net.maxmag_change.newstory.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.maxmag_change.newstory.NewStoryMod;
import net.maxmag_change.newstory.block.custom.Cauldron;
import net.maxmag_change.newstory.block.custom.DoorLock;
import net.maxmag_change.newstory.block.custom.Shaft;
import net.minecraft.block.Block;
import net.minecraft.block.CauldronBlock;
import net.minecraft.block.Material;
import net.minecraft.block.Waterloggable;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {

    private static  Block registerBlock(String name, Block block, ItemGroup tab) {
        registerBlockItem(name, block, tab);
        return Registry.register(Registries.BLOCK, new Identifier(NewStoryMod.MOD_ID, name), block);
    }

    public static void registerModBlocks() {
        NewStoryMod.LOGGER.debug("Registering Mod Blocks for " + NewStoryMod.MOD_ID);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup tab) {
        ItemGroupEvents.modifyEntriesEvent(tab).register(entries -> entries.add(block));
        return Registry.register(Registries.ITEM, new Identifier(NewStoryMod.MOD_ID, name), new BlockItem(block, new  FabricItemSettings()));
    }

    public static final Block CAULDRON = registerBlock("cauldron",
                new Cauldron(FabricBlockSettings.of(Material.METAL).strength(2f)), ItemGroups.FUNCTIONAL);
    public static final Block DOOR_LOCK = registerBlock("door_lock",
            new DoorLock(FabricBlockSettings.of(Material.METAL).strength(2f)), ItemGroups.FUNCTIONAL);
    public static final Block SHAFT = registerBlock("shaft",
            new Shaft(FabricBlockSettings.of(Material.METAL).strength(2f)), ItemGroups.FUNCTIONAL);


}
