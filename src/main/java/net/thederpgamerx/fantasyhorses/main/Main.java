package net.thederpgamerx.fantasyhorses.main;

import java.io.File;
import java.io.IOException;
import java.util.UUID;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.CommandExecutor;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import net.thederpgamerx.fantasyhorses.horses.HorseGUI;
import net.thederpgamerx.fantasyhorses.horses.HorseHandler;
import org.bukkit.entity.Player;

public class Main extends org.bukkit.plugin.java.JavaPlugin implements CommandExecutor {

	//Plugin
	private static Main plugin;
	private String NAME = "FantasyHorses";
	private String VERSION = "0.10";
	private String AUTHOR = "TheDerpGamerX";

	//Files
	private String pluginfile = NAME + "v" + VERSION;
	private File horsesFile;
	private FileConfiguration horsesConfig;

	@Override
	public void onEnable() {
		plugin = this;
		System.out.println("[FantasyHorses]: Enabling...");

		//Config Saving
		saveConfigs();
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

  	private void saveConfigs() {
		try {
			saveDefaultConfig();
			saveHorseConfig();
			saveHorsesToMap();

		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("[FantasyHorses]: Encountered an error while trying to save configs!");
			System.out.println("[FantasyHorses]: Disabling...");
			this.getPluginLoader().disablePlugin(this);
		}
	}
  
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
  
  	private FileConfiguration getHorsesConfig() {
		return horsesConfig;
  }
  
  	private File getHorsesFile() {
		return horsesFile;
	}
  
  	private void saveHorsesToMap() {

		/* Horse Data File Template
		playerUUID + ".yml"
			playerInfo:
				name: <playerName>
				horseSlotsMax: <horseSlotsMax>
				horseSlotsFilled: <horseSlotsFilled>
				horses:
					<horseUUID>:
						name: <horseName>
						level: <horseLevel>
						health: <horseHealth>
						maxHealth: <horseMaxHealth>
						speed: <horseSpeed>
						jump: <horseJump>
						style: <horseStyle>
						color: <horseColor>
						location: <horseLocation>
					<horseUUID>:
						name: <horseName>
						...
		 */

		for(String key : horsesConfig.getKeys(false)) {
			for(World world : Bukkit.getWorlds()) {
				for (Entity entity : world.getEntities()) {
					if(entity.getType().equals(EntityType.HORSE)) {
						for(int x = 0; x < horsesConfig.getStringList(playerUUID.toString()).size(); x ++) {
							String horseUUID = horsesConfig.getStringList(playerUUID.toString()).get(x);
							if(entity.getUniqueId().toString() == horseUUID) {
								String playerUUID = horsesConfig.get;
								Player player = Bukkit.getPlayer(UUID.fromString(playerUUID));
								Global.horseMap.put()
							}
						}


						/* Old code for reference
						String horse1UUID = horsesConfig.getString(playerUUID.toString() + ".1.horse-UUID");
						String horse2UUID = horsesConfig.getString(playerUUID.toString() + ".2.horse-UUID");
						String horse3UUID = horsesConfig.getString(playerUUID.toString() + ".3.horse-UUID");
						if (entity.getUniqueId().toString().equals(horse1UUID)) {
							Horse horse = (Horse) entity;
			        	  fhorses1.put(playerUUID, horse);
			        	  break;
			          } else if(entity.getUniqueId().toString().equals(horse2UUID)) {
			              Horse horse = (Horse) entity;
			              fhorses2.put(playerUUID, horse);
			              break;
			          } else if(entity.getUniqueId().toString().equals(horse3UUID)) {
			              Horse horse = (Horse) entity;
			              fhorses3.put(playerUUID, horse);
			              break;
			          }
						 */
					}
				}
		  	}
	  	}
  	}
  
  	public static Main getPlugin() {
	  	return plugin;
  	}
}
