package net.thederpgamerx.fantasyhorses.main;

import org.bukkit.command.CommandExecutor;
import net.thederpgamerx.fantasyhorses.horses.HorseGUI;
import net.thederpgamerx.fantasyhorses.horses.HorseHandler;

public class Main extends org.bukkit.plugin.java.JavaPlugin implements CommandExecutor {

	private static Main plugin;
	private String NAME = "FantasyHorses";
	private String VERSION = "0.10";
	private String AUTHOR = "TheDerpGamerX";
	private String pluginfile = NAME + "v" + VERSION;

	@Override
	public void onEnable() {
		plugin = this;
		System.out.println("[FantasyHorses]: Loading...");

		//Config Saving
		Utilities.createConfigs();
		System.out.println("[FantasyHorses]: Configs have been successfully saved.");

		//Events
		getServer().getPluginManager().registerEvents(new HorseGUI(), this);
		getServer().getPluginManager().registerEvents(new HorseHandler(), this);
		System.out.println("[FantasyHorses]: Events have registered successfully.");

		//Commands
		getCommand("fhorse").setExecutor(new HorseGUI());
		System.out.println("[FantasyHorses]: Commands have registered successfully.");

		System.out.println("");
		System.out.println("[FantasyHorses]: Loading complete!");
	}

  	public void onDisable() {
    	System.out.println("[FantasyHorses]: Disabling...");
  	}
  
  	public static Main getPlugin() {
	  	return plugin;
  	}
}
