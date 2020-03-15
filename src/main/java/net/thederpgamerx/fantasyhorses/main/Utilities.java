package net.thederpgamerx.fantasyhorses.main;

import net.thederpgamerx.fantasyhorses.horses.FantasyHorse;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;
import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class FileHandler {

	private File playerFile;

	public List<FantasyHorse> getHorses(Player player) {
		/**
		 * Gets a list of horses for a specific Player.
		 */

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
			float speed = Float.parseFloat(horseData.get(5));
			float jump = Float.parseFloat(horseData.get(6));
			String style = horseData.get(7);
			String color = horseData.get(8);
			String worldString = horseData.get(9);
			String locString = horseData.get(10);
			Scanner scan = new Scanner(locString);
			int x = scan.nextInt();
			scan.skip(",");
			int y = scan.nextInt();
			scan.skip(",");
			int z = scan.nextInt();
			Location location = new Location(Bukkit.getWorld(worldString), x, y, z);

			fHorses.add(new FantasyHorse(uuid, playerUUID, player, maxHealth, health, style, color, location, level, speed, jump));
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

	/*
	public static void saveConfigs() {
		try {

			File playerFile = new File(Main.getPlugin().getDataFolder(), "horses.yml");
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

		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("[FantasyHorses]: Encountered an error while trying to save configs!");
			System.out.println("[FantasyHorses]: Disabling...");
			Main.getPlugin().getPluginLoader().disablePlugin(Main.getPlugin());
		}
	}

	 */

		/*
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

		 */
}
