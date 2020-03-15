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
		System.out.println("[FantasyHorses]: Enabling...");

		//Config Saving
		FileHandler.createConfigs();
		System.out.println("[FantasyHorses]: Configs have been successfully saved.");

		//Events
		getServer().getPluginManager().registerEvents(new HorseGUI(), this);
		getServer().getPluginManager().registerEvents(new HorseHandler(), this);
		System.out.println("[FantasyHorses]: Events have registered successfully.");

		//Commands
		getCommand("fhorse").setExecutor(new HorseGUI());
		System.out.println("[FantasyHorses]: Commands have registered successfully.");
  	}

  	public void onDisable() {
    	System.out.println("[FantasyHorses]: Disabling...");
  	}

  	/*
  	private void saveHorseConfig() {
	  horsesFile = new File(getDataFolder(), "horses.yml");
      if(!(horsesFile.exists())) {
          horsesFile.getParentFile().mkdirs();
          saveResource("horses.yml", false);
       }

      horsesConfig = new YamlConfiguration();

      try {
          horsesConfig.load(horsesFile);

      } catch (IOException | InvalidConfigurationException e) {
          e.printStackTrace();
      }
  }

  	 */

  	/*
  	private FileConfiguration getHorsesConfig() {
		return horsesConfig;
  }
  
  	private File getHorsesFile() {
		return horsesFile;
	}


  	 */
  
  	public static Main getPlugin() {
	  	return plugin;
  	}
}
