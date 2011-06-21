package me.wesnc.lcbuilding;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bukkit.event.Event;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class LCBuilding extends JavaPlugin
{
	
	//Logger
	public final Logger logger = Logger.getLogger("Minecraft");
	
	//block listener
	private final LCBlockListener blockListener = new LCBlockListener(this);
	
	//config related
	final LCConfiguration LCConfiguration = new LCConfiguration(this);
	public String CFGFileString = "plugins/LevelCraftCore/Configs/Building.cfg";
	public File CFGFile = new File("plugins/LevelCraftCore/Configs/Building.cfg");
	
	//thispluginvar
	public Plugin thisPlug;
	
	//Codes
	//public String CodeFileString = "plugins/LevelCraftCore/Configs/Building/codes.txt";
	//public File CodeFile = new File("plugins/LevelCraftCore/Configs/Building/codes.txt");
	
	
	@Override
	public void onDisable()
	{
		logger.log(Level.INFO, "[LC] Level Building unloaded");
		
	}

	@Override
	public void onEnable()
	{
		new File("plugins/LevelCraftCore/Configs").mkdirs();
		//new File("plugins/LevelCraftCore/Configs/Buildings").mkdirs();
		
		try
		{
			/*
			FileInputStream fis = new FileInputStream(CodeFile);
			DataInputStream in = new DataInputStream(fis);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String currLine;
			while((currLine = br.readLine()) != null)
			{
				logger.log(Level.INFO, "[LCB] "+currLine);
			}
			
			*/
			CFGFile.createNewFile();
		} catch(IOException ex) {}
		
		LCConfiguration.loadConfig();
		
		String[] Args = {"Bu", "Building", "Build"};
		getConfiguration().setProperty("ReferenceKeys", Args);
		
		String[] Unlocks = {
				"Tier 0 ="+LCConfiguration.LEVELNEEDEDFOR_TIER0,
				"Tier 1 ="+LCConfiguration.LEVELNEEDEDFOR_TIER1,
				"Tier 2 ="+LCConfiguration.LEVELNEEDEDFOR_TIER2,
				"Tier 2.5 ="+LCConfiguration.LEVELNEEDEDFOR_TIER2point5,
				"Tier 3 ="+LCConfiguration.LEVELNEEDEDFOR_TIER3,
				"Tier 4 ="+LCConfiguration.LEVELNEEDEDFOR_TIER4,
				"Tier 5 ="+LCConfiguration.LEVELNEEDEDFOR_TIER5};
		int[] UnlocksLevel = {LCConfiguration.LEVELNEEDEDFOR_TIER1, LCConfiguration.LEVELNEEDEDFOR_TIER2, LCConfiguration.LEVELNEEDEDFOR_TIER2point5, LCConfiguration.LEVELNEEDEDFOR_TIER3, LCConfiguration.LEVELNEEDEDFOR_TIER4, LCConfiguration.LEVELNEEDEDFOR_TIER5};
		String[] Exp = {
				"Exp Per Placed Dirt (Nongrassed) "+LCConfiguration.PLACED_DIRT_NONGRASSED,
				"Exp Per Placed Dirt (Grassed) "+LCConfiguration.PLACED_DIRT_GRASSED,
				"Exp Per Placed Stone "+LCConfiguration.PLACED_STONE
				};
		
		//setting properties
		getConfiguration().setProperty("LevelExpPer", Exp);
		getConfiguration().setProperty("LevelUnlocksLevel", UnlocksLevel);
		getConfiguration().setProperty("LevelUnlocks", Unlocks);
		getConfiguration().setProperty("LevelName", "Building");
		getConfiguration().setProperty("ReferenceIndex", "Bu");
		getConfiguration().setProperty("Author", "Wesnc");
		
		this.thisPlug = this.getServer().getPluginManager().getPlugin("LCBuilding");
		Plugin LevelCraftCore = this.getServer().getPluginManager().getPlugin("LevelCraftCore");
		
		
		if(LevelCraftCore == null)
		{
			logger.log(Level.SEVERE, "[LC] Could not find LLC, disabling");
			this.getServer().getPluginManager().disablePlugin(this);
		} else {
			logger.log(Level.INFO, "[LC] Level Building Loaded. Private Release");
			registerEvents();
		}
	}
	
	
	public void registerEvents()
	{
		PluginManager pm = getServer().getPluginManager();
		
		pm.registerEvent(Event.Type.BLOCK_PLACE, blockListener, Event.Priority.Highest, this);
	}
}
