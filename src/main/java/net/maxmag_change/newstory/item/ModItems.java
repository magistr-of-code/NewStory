package net.maxmag_change.newstory.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.maxmag_change.newstory.NewStoryMod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.maxmag_change.newstory.item.custom.*;
import net.minecraft.item.EnderPearlItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registry;

public class ModItems {


    public static final Item DIMENSION_POWDER = registerItem("dimension_powder",
            new Item(new FabricItemSettings()), ItemGroups.INGREDIENTS);
    public static final Item DIMENSION_PEARL = registerItem("dimension_pearl",
            new EnderPearlItem(new FabricItemSettings()), ItemGroups.INGREDIENTS);
    public static final Item STEEL = registerItem("steel",
            new Item(new FabricItemSettings()), ItemGroups.INGREDIENTS);
    public static final Item MANGROVE_STICK = registerItem("mangrove_stick",
            new Item(new FabricItemSettings()), ItemGroups.INGREDIENTS);
    public static final Item WAND = registerItem("wand",
            new Wand(new FabricItemSettings()), ItemGroups.COMBAT);
    public static final Item TRAINING_WAND = registerItem("training_wand",
            new TrainingWand(new FabricItemSettings()), ItemGroups.COMBAT);
    public static final Item SCROLL_OF_FIRE = registerItem("scroll_of_fire",
            new ScrollOfFire(new FabricItemSettings()), ItemGroups.COMBAT);
    public static final Item SCROLL_OF_BREAK = registerItem("scroll_of_break",
            new ScrollOfBreak(new FabricItemSettings()), ItemGroups.COMBAT);
    public static final Item SCROLL_OF_CARRYING = registerItem("scroll_of_carrying",
            new ScrollOfCarrying(new FabricItemSettings()), ItemGroups.COMBAT);


    private static Item registerItem(String name, Item item, ItemGroup tab) {
        ItemGroupEvents.modifyEntriesEvent(tab).register(entries -> entries.add(item));
        return Registry.register(Registries.ITEM,new Identifier(NewStoryMod.MOD_ID, name),item);
    }

    public static void registerModItems() {
        NewStoryMod.LOGGER.debug("Registering Mod Items for " + NewStoryMod.MOD_ID);
    }
}

