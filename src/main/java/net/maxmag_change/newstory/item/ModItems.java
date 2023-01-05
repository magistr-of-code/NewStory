package net.maxmag_change.newstory.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.maxmag_change.newstory.NewStoryMod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.maxmag_change.newstory.item.custom.Wand;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registry;

public class ModItems {


    public static final Item DIMENSION_POWDER = registerItem("dimension_powder",
            new Item(new FabricItemSettings()), ItemGroups.COMBAT);
    public static final Item WAND = registerItem("wand",
            new Wand(new FabricItemSettings()), ItemGroups.COMBAT);

    private static Item registerItem(String name, Item item, ItemGroup tab) {
        ItemGroupEvents.modifyEntriesEvent(tab).register(entries -> entries.add(item));
        return Registry.register(Registries.ITEM,new Identifier(NewStoryMod.MOD_ID, name),item);
    }

    public static void registerModItems() {
        NewStoryMod.LOGGER.debug("Registering Mod Items for " + NewStoryMod.MOD_ID);
    }
}

