package net.maxmag_change.newstory;

import net.fabricmc.api.ModInitializer;
import net.maxmag_change.newstory.block.ModBlocks;
import net.maxmag_change.newstory.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NewStoryMod implements ModInitializer {
	public static final String MOD_ID = "newstory";
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		LOGGER.info("Hello Fabric world!");
	}
}
