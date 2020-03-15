package net.thederpgamerx.fantasyhorses.main;

import net.thederpgamerx.fantasyhorses.horses.FantasyHorse;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

public class FileHandler {

	private File playerFile;
	private FileConfiguration playerFileConfig;

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

	public List<FantasyHorse> getHorses(Player player) {
		/**
		 * Gets a list of horses for a specific Player.
		 */

	}

	private void saveHorse(Player player, FantasyHorse Horse) {

		UUID playerUUID = player.getUniqueId();

		try {
			File playerFile = new File(Main.getPlugin().getDataFolder(), "/horses/" + playerUUID + ".yml");

			if(!(playerFile.exists())) {
				playerFile.getParentFile().mkdirs();
				Main.getPlugin().saveResource("/horses/" + playerUUID + ".yml", false);
			}

			playerFileConfig = new YamlConfiguration();

			try {
				playerFileConfig.load(playerFile);

			} catch(IOException | InvalidConfigurationException e) {
				e.printStackTrace();
				System.err.println("[FantasyHorses]: Encountered an error while trying to load data for " + player.getName() + "!");
			}



		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("[FantasyHorses]: Encountered an error while trying to save data for " + player.getName() + "!");
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
