package net.thederpgamerx.fantasyhorses.main;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
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
import me.blackvein.quests.Quest;
import net.citizensnpcs.api.npc.NPC;
import net.thederpgamerx.fantasyhorses.commands.Debug_HorseReload;
import net.thederpgamerx.fantasyhorses.commands.Debug_LoadStructure;
import net.thederpgamerx.fantasyhorses.commands.Debug_RemoveHorse;
import net.thederpgamerx.fantasyhorses.commands.Debug_SaveStructure;
import net.thederpgamerx.fantasyhorses.horses.HorseGUI;
import net.thederpgamerx.fantasyhorses.horses.HorseHandler;
import net.thederpgamerx.fantasyhorses.npc.QuestNPC;
import net.thederpgamerx.fantasyhorses.quests.objectives.KillTracker;
import net.thederpgamerx.fantasyhorses.structures.StableGenerator;
import net.thederpgamerx.fantasyhorses.structures.StableHandler;

public class Main extends org.bukkit.plugin.java.JavaPlugin implements CommandExecutor {
	
  private static Main plugin;
  public String NAME = "FantasyHorses";
  public String VERSION = "0.9";
  public String AUTHOR = "TheDerpGamerX";
  
  public String pluginfile = NAME + "v" + VERSION;
  
  private static File horsesFile;
  private static FileConfiguration horsesConfig;
  
  public static HashMap<UUID, Horse> fhorses1 = new HashMap<>();
  public static HashMap<UUID, Horse> fhorses2 = new HashMap<>();
  public static HashMap<UUID, Horse> fhorses3 = new HashMap<>();
  public static HashMap<QuestNPC, Quest> questNPCs = new HashMap<>();
  public static HashMap<UUID, Quest> questTracker = new HashMap<>();
  public static HashMap<UUID, Entity> killMobsObjective = new HashMap<>();
  
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
    getServer().getPluginManager().registerEvents(new StableGenerator(), this);
    getServer().getPluginManager().registerEvents(new StableHandler(), this);
    getServer().getPluginManager().registerEvents(new KillTracker(), this);


    getCommand("horse").setExecutor(new HorseGUI());
    getCommand("debug_savestructure").setExecutor(new Debug_SaveStructure());
    getCommand("debug_loadstructure").setExecutor(new Debug_LoadStructure());
    getCommand("debug_horsereload").setExecutor(new Debug_HorseReload());
    getCommand("debug_removehorse").setExecutor(new Debug_RemoveHorse());
  }
  

  public void saveStructuresFolder() {
	  try {
		  File structures = new File(Main.getPlugin().getDataFolder() + "/structures");
		  if(!(structures.exists())) {
			  structures.mkdir();
		  }
		  Path structuresDir = Paths.get(Main.getPlugin().getDataFolder() + "/structures");
		  File plainsStable = new File(Main.getPlugin().getDataFolder() + "/structures/plainsStable.nbt");
		  File desertStable = new File(Main.getPlugin().getDataFolder() + "/structures/desertStable.nbt");
		  File savannaStable = new File(Main.getPlugin().getDataFolder() + "/structures/savannaStable.nbt");
		  File forestStable = new File(Main.getPlugin().getDataFolder() + "/structures/forestStable.nbt");
		  File birchForestStable = new File(Main.getPlugin().getDataFolder() + "/structures/birchForestStable.nbt");
		  File snowyTaigaStable = new File(Main.getPlugin().getDataFolder() + "/structures/snowyTaigaStable.nbt");
		  
		  if(!(plainsStable.exists())) {
			  Path plainsStablePath = Paths.get("/structures/plainsStable.nbt");
			  Files.copy(plainsStablePath, structuresDir);
		  }
		  if(!(desertStable.exists())) {
			  Path desertStablePath = Paths.get("/structures/desertStable.nbt");
			  Files.copy(desertStablePath, structuresDir);
		  }
		  if(!(savannaStable.exists())) {
			  Path savannaStablePath = Paths.get("/structures/savannaStable.nbt");
			  Files.copy(savannaStablePath, structuresDir);
		  }
		  if(!(forestStable.exists())) {
			  Path forestStablePath = Paths.get("/structures/forestStable.nbt");
			  Files.copy(forestStablePath, structuresDir);
		  }
		  if(!(birchForestStable.exists())) {
			  Path birchForestStablePath = Paths.get("/structures/birchForestStable.nbt");
			  Files.copy(birchForestStablePath, structuresDir);
		  }
		  if(!(snowyTaigaStable.exists())) {
			  Path snowyTaigaStablePath = Paths.get("/structures/snowyTaigaStable.nbt");
			  Files.copy(snowyTaigaStablePath, structuresDir);
		  }
	  } catch (IOException e) {
		  e.printStackTrace();
	  }
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
