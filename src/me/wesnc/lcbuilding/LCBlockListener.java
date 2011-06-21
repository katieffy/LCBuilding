package me.wesnc.lcbuilding;

import me.samkio.levelcraftcore.LCChat;
import me.samkio.levelcraftcore.LevelFunctions;
import me.samkio.levelcraftcore.Whitelist;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockListener;
import org.bukkit.event.block.BlockPlaceEvent;

public class LCBlockListener extends BlockListener
{
	public LCBuilding plugin;
	
	public LCBlockListener(LCBuilding instance)
	{
		plugin = instance;
	}
	
	public void onBlockPlace(BlockPlaceEvent event)
	{
		if(event.isCancelled())
			return;
		
		if(!Whitelist.worldCheck(event.getBlock().getWorld()))
			return;
		
		Player player = event.getPlayer();
		Material m = event.getBlock().getType();
		int level = LevelFunctions.getLevel(player, this.plugin.thisPlug);
		
		//for halfblocks
		Block b = event.getBlock();
		byte halfblock_cob = (byte) 3;
		byte halfblock_wood = (byte) 2;
		byte halfblock_sandstone = (byte) 1;
		byte halfblock_slab = (byte) 0;
		
		
		
		if(!Whitelist.hasLevel(player, this.plugin.thisPlug))
			return;
		
		double gained = 0.0D;
		
		//Tier 1 items
		//NEEDING WOOD AND SLAB HALFBLOCKS ADDED
		//Tier 0 	= Dirt, Workbenches, Chests
		//Teir 1 	= Stone, Halfblocks(Cobble, Wood), Forge
		//Teir 2 	= Sandstone, Trunks, Halfblocks(Stone/slabs), Snow, Pumpkins, 
		//Tier 2.5 	= Halfblocks(Sandstone), Cloth
		//Tier 3 	= Glass, Bookcases, Bricks, Stairs
		//Tier 4 	= Gold, diamond and iron blocks, and ore blocks
		//Tier 5    = Netherrack tier, Obsidian
		//0/default = SLAB
		// 1 = sandstone slab
		//2 = wooden slab
		//3 = cobblestone slab
		if((level < this.plugin.LCConfiguration.LEVELNEEDEDFOR_TIER1) && (m == Material.STONE) || (m == Material.FURNACE) )
		{
			LCChat.warn(player, this.plugin.LCConfiguration.LEVELNEEDEDFOR_TIER1_MESSAGE);
			event.setCancelled(true);
			return;
		}
		
		//TIER 1 HALFBLOCKS
		if((level < this.plugin.LCConfiguration.LEVELNEEDEDFOR_TIER1) && (b.getType() == Material.STEP && b.getData() == halfblock_cob) || (b.getType() == Material.STEP && b.getData() == halfblock_wood))
		{
			LCChat.warn(player, this.plugin.LCConfiguration.LEVELNEEDEDFOR_TIER1_MESSAGE);
			event.setCancelled(true);
			return;
		}
		
		//tier 2 items
		if((level < this.plugin.LCConfiguration.LEVELNEEDEDFOR_TIER2) && (m == Material.SANDSTONE) || (m == Material.FURNACE) || (m == Material.SNOW_BLOCK) || (m == Material.PUMPKIN))
		{
			LCChat.warn(player, this.plugin.LCConfiguration.LEVELNEEDEDFOR_TIER2_MESSAGE);
			event.setCancelled(true);
			return;	
		}
		//tier 2 HALFBLOCKS
		if((level < this.plugin.LCConfiguration.LEVELNEEDEDFOR_TIER2) && (b.getType() == Material.STEP && b.getData() == halfblock_slab))
		{
			LCChat.warn(player, this.plugin.LCConfiguration.LEVELNEEDEDFOR_TIER2_MESSAGE);
			event.setCancelled(true);
			return;
		}
		
		//tier 2.5
		if((level < this.plugin.LCConfiguration.LEVELNEEDEDFOR_TIER2point5) && (m == Material.WOOL))
		{
			LCChat.warn(player, this.plugin.LCConfiguration.LEVELNEEDEDFOR_TIER2point5_MESSAGE);
			event.setCancelled(true);
			return;
		}
		//Tier 2.5 halfblocks
		if((level < this.plugin.LCConfiguration.LEVELNEEDEDFOR_TIER2point5) && (b.getType() == Material.STEP && b.getData() == halfblock_sandstone))
		{
			LCChat.warn(player, this.plugin.LCConfiguration.LEVELNEEDEDFOR_TIER2point5_MESSAGE);
			event.setCancelled(true);
			return;
		}
		
		//Tier 3
		if((level < this.plugin.LCConfiguration.LEVELNEEDEDFOR_TIER3) && (m == Material.GLASS) || (m == Material.BOOKSHELF) || (m == Material.BRICK) || (m == Material.WOOD_STAIRS) || (m == Material.COBBLESTONE_STAIRS))
		{
			LCChat.warn(player, this.plugin.LCConfiguration.LEVELNEEDEDFOR_TIER3_MESSAGE);
			event.setCancelled(true);
			return;	
		}
		
		
		
		//TIER 0 ITEMS XP
		if(m == Material.DIRT)
			gained = this.plugin.LCConfiguration.PLACED_DIRT_NONGRASSED;
		
		if(m == Material.GRASS)
			gained = this.plugin.LCConfiguration.PLACED_DIRT_GRASSED;
		
		if(m == Material.WORKBENCH)
			gained = this.plugin.LCConfiguration.PLACED_CRAFTING_BENCH;
		
		if(m == Material.CHEST)
			gained = this.plugin.LCConfiguration.PLACED_CRAFTING_CHEST;
		
		if(m == Material.WOOD)
			gained = this.plugin.LCConfiguration.PLACED_PLANK;
		
		
		//Tier 1 items
		if(m == Material.STONE)
			gained = this.plugin.LCConfiguration.PLACED_STONE;
		
		if(m == Material.SNOW_BLOCK)
			gained = this.plugin.LCConfiguration.PLACED_SNOWBLOCKS;
		
		if(m == Material.PUMPKIN)
			gained = this.plugin.LCConfiguration.PLACED_PUMPKINS;
		
		//tier 2
		if(m == Material.SANDSTONE)
			gained = this.plugin.LCConfiguration.PLACED_SANDSTONE;
		
		//tier 2.5
		if(m == Material.WOOL)
			gained = this.plugin.LCConfiguration.PLACED_WOOL;
		
		//tier 3
		if(m == Material.GLASS)
			gained = this.plugin.LCConfiguration.PLACED_GLASS;
		
		if(m == Material.BOOKSHELF)
			gained = this.plugin.LCConfiguration.PLACED_BOOKCASE;
		
		if(m == Material.BRICK)
			gained = this.plugin.LCConfiguration.PLACED_BRICK;
		
		//to implement STAIRS
		
		//tier 4
		if(m == Material.GOLD_BLOCK)
			gained = this.plugin.LCConfiguration.PLACED_GOLD;
		
		if(m == Material.DIAMOND_BLOCK)
			gained = this.plugin.LCConfiguration.PLACED_DIAMOND;
		
		if(m == Material.IRON_BLOCK)
			gained = this.plugin.LCConfiguration.PLACED_IRON;
		
		if(m == Material.IRON_ORE)
			gained = this.plugin.LCConfiguration.PLACED_ORE_IRON;
		
		if(m == Material.GOLD_ORE)
			gained = this.plugin.LCConfiguration.PLACED_ORE_GOLD;
		
		//tier 5 - final tier
		if(m == Material.NETHERRACK)
			gained = this.plugin.LCConfiguration.PLACED_NETHER_NETHERRACK;
		
		if(m == Material.SOUL_SAND)
			gained = this.plugin.LCConfiguration.PLACED_NETHER_SOULSAND;
		
		if(m == Material.GLOWSTONE)
			gained = this.plugin.LCConfiguration.PLACED_NETHER_GLOWSTONE;
		
		if(m == Material.OBSIDIAN)
			gained = this.plugin.LCConfiguration.PLACED_OBSIDIAN;
		
		
		//ALL HALFBLOCK TYPES
		if(m == Material.STEP)
			gained = this.plugin.LCConfiguration.PLACED_HALFBLOCK;
		
		
		
		LevelFunctions.addExp(player, this.plugin.thisPlug, gained);
		
		
		
	}
}
