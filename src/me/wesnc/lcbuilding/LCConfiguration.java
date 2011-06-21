package me.wesnc.lcbuilding;

import java.io.IOException;
import java.util.logging.Level;

import me.samkio.levelcraftcore.util.Properties;

public class LCConfiguration
{
	public LCBuilding plugin;
	
	//-------------------BLOCKS XP----------------
	double PLACED_DIRT_NONGRASSED = 1;
	double PLACED_DIRT_GRASSED = 1;
	
	double PLACED_STONE = 2;
	double PLACED_COBBLESTONE = 2;
	double PLACED_COBBLESTONE_MOSSY = 2;
	
	double PLACED_STAIRS = 2;
	
	double PLACED_HALFBLOCK = 2;
	
	double PLACED_BOOKCASE = 3;
	
	double PLACED_SNOWBLOCKS = 2;
	
	double PLACED_PUMPKINS = 2;
	
	double PLACED_PLANK = 2;
	double PLACED_TRUNK_REG = 2;
	double PLACED_TRUNK_RED = 2;
	double PLACED_TRUNK_BIRCH = 2;
	
	double PLACED_SAND = 2;
	double PLACED_SANDSTONE = 2;
	
	double PLACED_GLASS = 6;
	
	//ores
	double PLACED_ORE_GOLD = 5;
	double PLACED_ORE_IRON = 4;
	
	double PLACED_DIAMOND = 6;
	double PLACED_IRON = 4;
	double PLACED_GOLD = 4;
	
	double PLACED_OBSIDIAN = 300;
	
	double PLACED_CRAFTING_BENCH = 2;
	double PLACED_CRAFTING_FORGE = 3;
	double PLACED_CRAFTING_CHEST = 2;
	
	double PLACED_BRICK = 4;
	
	//nether
	double PLACED_NETHER_NETHERRACK = 8;
	double PLACED_NETHER_SOULSAND = 6;
	double PLACED_NETHER_GLOWSTONE = 4;
	
	double PLACED_LADDER = 4;
	double PLACED_WOOL = 2;
	//-------------------BLOCKS XP----------------
	
	
	//-------------------Level Unlocks----------------
		//Tier 0 	= Dirt, Workbenches, Chests
		//Teir 1 	= Stone, Halfblocks(Cobble, Wood), Forge
		//Teir 2 	= Sandstone, Trunks, Halfblocks(Stone/slabs), Snow, Pumpkins, 
		//Tier 2.5 	= Halfblocks(Sandstone), Cloth
		//Tier 3 	= Glass, Bookcases, Bricks, Stairs
		//Tier 4 	= Gold, diamond and iron blocks, and ore blocks
		//Tier 5    = Netherrack tier, Obsidian
	int LEVELNEEDEDFOR_TIER0		= 1;
	int LEVELNEEDEDFOR_TIER1 		= 5;
	int LEVELNEEDEDFOR_TIER2 		= 10;
	int LEVELNEEDEDFOR_TIER2point5 	= 13;
	int LEVELNEEDEDFOR_TIER3 		= 20;
	int LEVELNEEDEDFOR_TIER4		= 30;
	int LEVELNEEDEDFOR_TIER5		= 40;
	
	final String LEVELNEEDEDFOR_TIER1_MESSAGE = "Cannot place this block, Level needed "+LEVELNEEDEDFOR_TIER1+". That item is Tier 1.";
	final String LEVELNEEDEDFOR_TIER2_MESSAGE = "Cannot place this block, Level needed "+LEVELNEEDEDFOR_TIER2+". That item is Tier 2.";
	final String LEVELNEEDEDFOR_TIER2point5_MESSAGE = "Cannot place this block, Level needed "+LEVELNEEDEDFOR_TIER2point5+". That item is Tier 2.5.";
	final String LEVELNEEDEDFOR_TIER3_MESSAGE = "Cannot place this block, Level needed "+LEVELNEEDEDFOR_TIER3+". That item is Tier 3.";
	final String LEVELNEEDEDFOR_TIER4_MESSAGE = "Cannot place this block, Level needed "+LEVELNEEDEDFOR_TIER4+". That item is Tier 4.";
	final String LEVELNEEDEDFOR_TIER5_MESSAGE = "Cannot place this block, Level needed "+LEVELNEEDEDFOR_TIER5+". That item is Tier 5.";
	
	
	public LCConfiguration(LCBuilding instance)
	{
		plugin = instance;
	}

	public void loadConfig()
	{
		Properties properties = new Properties(plugin.CFGFileString);
		try
		{
			properties.load();
		} catch(IOException ex) { plugin.logger.log(Level.SEVERE, "[LC] "+ex); }
		
		this.PLACED_DIRT_NONGRASSED = properties.getDouble("PLACED_DIRT_NONGRASSED", 1);
		this.PLACED_DIRT_GRASSED = properties.getDouble("PLACED_DIRT_GRASSED", 1);
		
		this.PLACED_STONE = properties.getDouble("PLACED_STONE", 2);
		this.PLACED_COBBLESTONE = properties.getDouble("PLACED_COBBLESTONE", 2);
		this.PLACED_COBBLESTONE_MOSSY = properties.getDouble("PLACED_COBBLESTONE_MOSSY", 2);
		
		this.PLACED_STAIRS = properties.getDouble("PLACED_STAIRS", 2);
		
		this.PLACED_HALFBLOCK = properties.getDouble("PLACED_HALFBLOCK", 2);
		
		this.PLACED_BOOKCASE = properties.getDouble("PLACED_BOOKCASE", 3);
		
		this.PLACED_SNOWBLOCKS = properties.getDouble("PLACED_SNOWBLOCKS", 2);
		
		this.PLACED_PUMPKINS = properties.getDouble("PLACED_PUMPKINS", 2);
		
		this.PLACED_PLANK = properties.getDouble("PLACED_PLANK", 2);
		this.PLACED_TRUNK_REG = properties.getDouble("PLACED_TRUCK_REG", 2);
		this.PLACED_TRUNK_RED = properties.getDouble("PLACED_TRUCK_RED", 2);
		this.PLACED_TRUNK_BIRCH = properties.getDouble("PLACED_TRUCK_BIRCH", 2);
		
		this.PLACED_SAND = properties.getDouble("PLACED_SAND", 2);
		this.PLACED_SANDSTONE = properties.getDouble("PLACED_SANDSTONE", 2);
		
		this.PLACED_GLASS = properties.getDouble("PLACED_GLASS", 6);
		
		this.PLACED_ORE_GOLD = properties.getDouble("PLACED_ORE_GOLD", 5);
		this.PLACED_ORE_IRON = properties.getDouble("PLACED_ORE_IRON", 4);
		
		this.PLACED_DIAMOND = properties.getDouble("PLACED_DIAMOND", 6);
		this.PLACED_GOLD = properties.getDouble("PLACED_GOLD", 4);
		this.PLACED_IRON = properties.getDouble("PLACED_IRON", 4);
		
		this.PLACED_OBSIDIAN = properties.getDouble("PLACED_OBSIDIAN", 300);
		
		this.PLACED_CRAFTING_BENCH = properties.getDouble("PLACED_CRAFTING_BENCH", 2);
		this.PLACED_CRAFTING_FORGE = properties.getDouble("PLACED_CRAFTING_FORGE", 3);
		this.PLACED_CRAFTING_CHEST = properties.getDouble("PLACED_CRAFTING_CHEST", 2);
		
		this.PLACED_BRICK = properties.getDouble("PLACED_BRICK", 4);
		
		this.PLACED_NETHER_NETHERRACK = properties.getDouble("PLACED_NETHER_NETHERRACK", 8);
		this.PLACED_NETHER_SOULSAND = properties.getDouble("PLACED_NETHER_SOULSAND", 6);
		this.PLACED_NETHER_GLOWSTONE = properties.getDouble("PLACED_NETHER_GLOWSTONE", 4);
		
		this.PLACED_LADDER = properties.getDouble("PLACED_LADDER", 4);
		
		this.PLACED_WOOL = properties.getDouble("PLACED_WOOL", 3);
	}
}
