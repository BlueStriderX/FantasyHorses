package net.thederpgamerx.fantasyhorses.main;

import net.thederpgamerx.fantasyhorses.horses.FantasyHorse;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Horse;
import org.bukkit.entity.Player;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;
import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class Utilities {

	private File playerFile;

	public List<FantasyHorse> getHorses(Player player) {
		List<FantasyHorse> fHorses = null;
		UUID playerUUID = player.getUniqueId();
		String playerDataPath = Main.getPlugin().getDataFolder() + "/horses/" + playerUUID + ".yml";

		Yaml yaml = new Yaml(new Constructor(PlayerData.class));
		InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(playerDataPath);
		PlayerData playerData = yaml.load(inputStream);

		for(int l = 0; l < playerData.getHorses().size(); l ++) {
			List<String> horseData = playerData.getHorses().get("horse" + l);

			String name = horseData.get(0);
			UUID uuid = UUID.fromString(horseData.get(1));
			int level = Integer.parseInt(horseData.get(2));
			float health = Float.parseFloat(horseData.get(3));
			float maxHealth = Float.parseFloat(horseData.get(4));
			float armor = Float.parseFloat(horseData.get(5));
			float speed = Float.parseFloat(horseData.get(6));
			float jump = Float.parseFloat(horseData.get(7));
			String styleString = horseData.get(8);
			String colorString = horseData.get(9);

			Horse horseEntity = null;
			Boolean horseFound = false;

			for(World world : Bukkit.getWorlds()) {
				for(Entity entity : world.getEntities()) {
					if(entity.getType() == EntityType.HORSE && entity.getUniqueId() == uuid) {
						horseFound = true;
						horseEntity = (Horse) entity;
						break;
					}
				}
				break;
			}

			if(!horseFound) {
				System.out.println("[FantasyHorses]: Tried to get a player's horse but the horse was not found on server! Marking the horse as killed...");
				//deleteHorseFromConfig(player, l);
			} else if (horseFound){
				FantasyHorse fantasyHorse = new FantasyHorse(player, horseEntity, name);
				fHorses.add(fantasyHorse);
			}
		}
		return fHorses;
	}

	public void saveHorse(Player player, FantasyHorse Horse) {

		UUID playerUUID = player.getUniqueId();
		String playerDataPath = Main.getPlugin().getDataFolder() + "/horses/" + playerUUID + ".yml";

		try {
			File playerFile = new File(Main.getPlugin().getDataFolder(), "/horses/" + playerUUID + ".yml");

			if(!(playerFile.exists())) {
				playerFile.getParentFile().mkdirs();
				Main.getPlugin().saveResource(playerDataPath, false);
			}


		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("[FantasyHorses]: Encountered an error while trying to create save data for " + player.getName() + "!");
		}
	}

	public static void createConfigs() {

	}
}
