package net.thederpgamerx.fantasyhorses.main;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.CommandExecutor;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Horse;
import net.thederpgamerx.fantasyhorses.horses.HorseGUI;
import net.thederpgamerx.fantasyhorses.horses.HorseHandler;

public class Main extends org.bukkit.plugin.java.JavaPlugin implements CommandExecutor {
	
  private static Main plugin;
  private String NAME = "FantasyHorses";
  private String VERSION = "0.10";
  private String AUTHOR = "TheDerpGamerX";
  
  private String pluginfile = NAME + "v" + VERSION;
  
  private static File horsesFile;
  private static FileConfiguration horsesConfig;

  
  @Override
  public void onEnable() {
	plugin = this;
    System.out.println("Loading Fantasy Horses...");
    
    
    saveDefaultConfig();
    saveHorseConfig();
    saveStructuresFolder();
    saveHorsesToMap();
    
    getServer().getPluginManager().registerEvents(new HorseGUI(), this);
    getServer().getPluginManager().registerEvents(new HorseHandler(), this);

    getCommand("horse").setExecutor(new HorseGUI());
  }

public void onDisable() {
    System.out.println("Disabling Fantasy Horses...");
  }
  
  public void saveHorseConfig() {
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
  
  public static FileConfiguration getHorsesConfig() {
      return horsesConfig;
  }
  
  public static File getHorsesFile() {
	  return horsesFile;
  }
  
  private void saveHorsesToMap() {
	  for(String key : horsesConfig.getKeys(false)) {
		UUID playerUUID = UUID.fromString(key);
		  for(World world : Bukkit.getWorlds()) {
			  for (Entity entity : world.getEntities()) {
				  if(entity.getType().equals(EntityType.HORSE)) {
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
				  }
		      }
		  }
	  }
  }
  
  public static Main getPlugin() {
	  return plugin;
  }
}
