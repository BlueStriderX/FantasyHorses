package net.thederpgamerx.fantasyhorses.old.horses;

import java.io.File;
import java.io.IOException;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Horse;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

import net.thederpgamerx.fantasyhorses.old.main.Main;

public class HorseHandler implements Listener {
	
	static File horsesFile = Main.getHorsesFile();
	static FileConfiguration horsesConfig = Main.getHorsesConfig();
	
	public static void saveHorse(Player player, FantasyHorse fhorse, int slot) {
		if(slot == 1) {
			horsesConfig.set(player.getUniqueId().toString() + ".1.horse-UUID", fhorse.horseUUID.toString());
			horsesConfig.set(player.getUniqueId().toString() + ".1.horse-name", fhorse.horseName);
			horsesConfig.set(player.getUniqueId().toString() + ".1.horse-speed", fhorse.horseSpeed.getBaseValue());
			horsesConfig.set(player.getUniqueId().toString() + ".1.horse-color", fhorse.horseColor.toString());
			horsesConfig.set(player.getUniqueId().toString() + ".1.horse-style", fhorse.horseStyle.toString());
			horsesConfig.set(player.getUniqueId().toString() + ".1.horse-slot", 1);
			horsesConfig.set(player.getUniqueId().toString() + ".1.horse-max-health", fhorse.horseMaxHealth);
			horsesConfig.set(player.getUniqueId().toString() + ".1.horse-level", 1);
			horsesConfig.set(player.getUniqueId().toString() + ".1.horse-owner-name", player.getName());
		} else if(slot == 2) {
			horsesConfig.set(player.getUniqueId().toString() + ".2.horse-UUID", fhorse.horseUUID.toString());
			horsesConfig.set(player.getUniqueId().toString() + ".2.horse-name", fhorse.horseName);
			horsesConfig.set(player.getUniqueId().toString() + ".2.horse-speed", fhorse.horseSpeed.getBaseValue());
			horsesConfig.set(player.getUniqueId().toString() + ".2.horse-color", fhorse.horseColor.toString());
			horsesConfig.set(player.getUniqueId().toString() + ".2.horse-style", "" + fhorse.horseStyle.toString());
			horsesConfig.set(player.getUniqueId().toString() + ".2.horse-slot", 2);
			horsesConfig.set(player.getUniqueId().toString() + ".2.horse-max-health", fhorse.horseMaxHealth);
			horsesConfig.set(player.getUniqueId().toString() + ".2.horse-level", 1);
			horsesConfig.set(player.getUniqueId().toString() + ".2.horse-owner-name", player.getName());
		} else if(slot == 3) {
			horsesConfig.set(player.getUniqueId().toString() + ".3.horse-UUID", fhorse.horseUUID.toString());
			horsesConfig.set(player.getUniqueId().toString() + ".3.horse-name", fhorse.horseName);
			horsesConfig.set(player.getUniqueId().toString() + ".3.horse-speed", fhorse.horseSpeed.getBaseValue());
			horsesConfig.set(player.getUniqueId().toString() + ".3.horse-color", fhorse.horseColor.toString());
			horsesConfig.set(player.getUniqueId().toString() + ".3.horse-style", fhorse.horseStyle.toString());
			horsesConfig.set(player.getUniqueId().toString() + ".3.horse-slot", 3);
			horsesConfig.set(player.getUniqueId().toString() + ".3.horse-max-health", fhorse.horseMaxHealth);
			horsesConfig.set(player.getUniqueId().toString() + ".3.horse-level", 1);
			horsesConfig.set(player.getUniqueId().toString() + ".3.horse-owner-name", player.getName());

		}
		try {
			horsesConfig.save(horsesFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void summon(Player player, int slot) {
		if(slot == 1) {
			Horse horse = Main.fhorses1.get(player.getUniqueId());
			Location playerLocation = player.getLocation();
			Location spawnLocation = playerLocation.add(0, 1, 0);
			horse.teleport(spawnLocation);
		} else if(slot == 2) {
			Horse horse = Main.fhorses2.get(player.getUniqueId());
			Location playerLocation = player.getLocation();
			Location spawnLocation = playerLocation.add(0, 1, 0);
			horse.teleport(spawnLocation);
		} else if(slot == 3) {
			Horse horse = Main.fhorses2.get(player.getUniqueId());
			Location playerLocation = player.getLocation();
			Location spawnLocation = playerLocation.add(0, 1, 0);
			horse.teleport(spawnLocation);
		}
	}
	
	@SuppressWarnings("deprecation")
	public static void upgrade(Player player, int slot) {
		if(slot == 1) {
			int horseLevel = horsesConfig.getInt(player.getUniqueId().toString() + ".1.horse-level");
			if(horseLevel < 5) {
				double horseMaxHealth = horsesConfig.getDouble(player.getUniqueId().toString() + ".1.horse-max-health");
				//double horseSpeed = horsesConfig.getDouble(player.getUniqueId().toString() + ".1.horse-speed");
				double maxHealthConfig = Main.getPlugin().getConfig().getDouble("horse-upgrade-max-health-multiplier");
				//double speedConfig = Main.getPlugin().getConfig().getDouble("horse-upgrade-speed-multiplier");
				
				double upgradedHorseMaxHealth = horseMaxHealth * maxHealthConfig;
				//double upgradedHorseSpeed = horseSpeed * speedConfig;
				int newHorseLevel = horseLevel + 1;
				
				horsesConfig.set(player.getUniqueId().toString() + ".1.horse-max-health", upgradedHorseMaxHealth);
				//horsesConfig.set(player.getUniqueId().toString() + ".1.horse-speed", upgradedHorseSpeed);
				horsesConfig.set(player.getUniqueId().toString() + ".1.horse-level", newHorseLevel);
				
				Horse horse = Main.fhorses1.get(player.getUniqueId());
				horse.setMaxHealth(upgradedHorseMaxHealth);
				horse.setHealth(upgradedHorseMaxHealth);
				//horse.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(upgradedHorseSpeed);
				Main.fhorses1.put(player.getUniqueId(), horse);
				try {
					horsesConfig.save(horsesFile);
				} catch (IOException e) {
					e.printStackTrace();
				}
				player.sendMessage(horse.getCustomName() + " has been upgraded!");
				
			} else if(horsesConfig.getInt(player.getUniqueId().toString() + ".1.horse-level") >= 5) {
				player.sendMessage("Horse is already max level!");
			}
		} else if(slot == 2) {
			int horseLevel = horsesConfig.getInt(player.getUniqueId().toString() + ".2.horse-level");
			if(horseLevel < 5) {
				double horseMaxHealth = horsesConfig.getDouble(player.getUniqueId().toString() + ".2.horse-max-health");
				//double horseSpeed = horsesConfig.getDouble(player.getUniqueId().toString() + ".2.horse-speed");
				double maxHealthConfig = Main.getPlugin().getConfig().getDouble("horse-upgrade-max-health-multiplier");
				//double speedConfig = Main.getPlugin().getConfig().getDouble("horse-upgrade-speed-multiplier");
				
				double upgradedHorseMaxHealth = horseMaxHealth * maxHealthConfig;
				//double upgradedHorseSpeed = horseSpeed * speedConfig;
				int newHorseLevel = horseLevel + 1;
				
				horsesConfig.set(player.getUniqueId().toString() + ".2.horse-max-health", upgradedHorseMaxHealth);
				//horsesConfig.set(player.getUniqueId().toString() + ".2.horse-speed", upgradedHorseSpeed);
				horsesConfig.set(player.getUniqueId().toString() + ".2.horse-level", newHorseLevel);
				
				Horse horse = Main.fhorses2.get(player.getUniqueId());
				horse.setMaxHealth(upgradedHorseMaxHealth);
				horse.setHealth(upgradedHorseMaxHealth);				
				//horse.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(upgradedHorseSpeed);
				Main.fhorses2.put(player.getUniqueId(), horse);
				try {
					horsesConfig.save(horsesFile);
				} catch (IOException e) {
					e.printStackTrace();
				}
				player.sendMessage(horse.getCustomName() + " has been upgraded!");
				
			} else if(horsesConfig.getInt(player.getUniqueId().toString() + ".2.horse-level") >= 5) {
				player.sendMessage("Horse is already max level!");
			}
		} else if(slot == 3) {
			int horseLevel = horsesConfig.getInt(player.getUniqueId().toString() + ".3.horse-level");
			if(horseLevel < 5) {
				double horseMaxHealth = horsesConfig.getDouble(player.getUniqueId().toString() + ".3.horse-max-health");
				//double horseSpeed = horsesConfig.getDouble(player.getUniqueId().toString() + ".3.horse-speed");
				double maxHealthConfig = Main.getPlugin().getConfig().getDouble("horse-upgrade-max-health-multiplier");
				//double speedConfig = Main.getPlugin().getConfig().getDouble("horse-upgrade-speed-multiplier");
				
				double upgradedHorseMaxHealth = horseMaxHealth * maxHealthConfig;
				//double upgradedHorseSpeed = horseSpeed * speedConfig;
				int newHorseLevel = horseLevel + 1;
				
				horsesConfig.set(player.getUniqueId().toString() + ".3.horse-max-health", upgradedHorseMaxHealth);
				//horsesConfig.set(player.getUniqueId().toString() + ".3.horse-speed", upgradedHorseSpeed);
				horsesConfig.set(player.getUniqueId().toString() + ".3.horse-level", newHorseLevel);
				
				Horse horse = Main.fhorses3.get(player.getUniqueId());
				horse.setMaxHealth(upgradedHorseMaxHealth);
				horse.setHealth(upgradedHorseMaxHealth);
				//horse.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(upgradedHorseSpeed);
				Main.fhorses3.put(player.getUniqueId(), horse);
				try {
					horsesConfig.save(horsesFile);
				} catch (IOException e) {
					e.printStackTrace();
				}
				player.sendMessage(horse.getCustomName() + " has been upgraded!");

			} else if(horsesConfig.getInt(player.getUniqueId().toString() + ".3.horse-level") >= 5) {
				player.sendMessage("Horse is already max level!");
			}
		}
	}
	
	@EventHandler
	public static void onEntityDeathEvent(EntityDeathEvent e) {
		if(Main.getPlugin().getConfig().getString("invulnerable-horses").equals("false")) {
			Entity entity = e.getEntity();
			EntityType etype = entity.getType();
			if(etype == EntityType.HORSE) {
				Horse horse = (Horse) entity;
				for(Player player : Bukkit.getServer().getOnlinePlayers()) {
					if(Main.fhorses1.containsKey(player.getUniqueId())) {
						if(horse == Main.fhorses1.get(player.getUniqueId())) {
							Main.fhorses1.remove(player, horse);
							horsesConfig.set(player.getUniqueId().toString() + ".1.horse-name", null);
							horsesConfig.set(player.getUniqueId().toString() + ".1.horse-color", null);
							horsesConfig.set(player.getUniqueId().toString() + ".1.horse-style", null);
							horsesConfig.set(player.getUniqueId().toString() + ".1.horse-max-health", null);
							horsesConfig.set(player.getUniqueId().toString() + ".1.horse-level", null);
							horsesConfig.set(player.getUniqueId().toString() + ".1.horse-speed", null);
							horsesConfig.set(player.getUniqueId().toString() + ".1.horse-UUID", null);
							horsesConfig.set(player.getUniqueId().toString() + ".1.horse-slot", null);
							horsesConfig.set(player.getUniqueId().toString() + ".1.horse-owner-name", null);
							player.sendMessage("Oh no! It appears " + horse.getCustomName() + " has died!");
						}
					} else if(Main.fhorses2.containsKey(player.getUniqueId())) {
						if(horse == Main.fhorses2.get(player.getUniqueId())) {
							Main.fhorses2.remove(player, horse);
							horsesConfig.set(player.getUniqueId().toString() + ".2.horse-name", null);
							horsesConfig.set(player.getUniqueId().toString() + ".2.horse-color", null);
							horsesConfig.set(player.getUniqueId().toString() + ".2.horse-style", null);
							horsesConfig.set(player.getUniqueId().toString() + ".2.horse-max-health", null);
							horsesConfig.set(player.getUniqueId().toString() + ".2.horse-level", null);
							horsesConfig.set(player.getUniqueId().toString() + ".2.horse-speed", null);
							horsesConfig.set(player.getUniqueId().toString() + ".2.horse-UUID", null);
							horsesConfig.set(player.getUniqueId().toString() + ".2.horse-slot", null);
							horsesConfig.set(player.getUniqueId().toString() + ".2.horse-owner-name", null);
							player.sendMessage("Oh no! It appears " + horse.getCustomName() + " has died!");
						}
					} else if(Main.fhorses3.containsKey(player.getUniqueId())) {
						if(horse == Main.fhorses3.get(player.getUniqueId())) {
							Main.fhorses3.remove(player, horse);
							horsesConfig.set(player.getUniqueId().toString() + ".3.horse-name", null);
							horsesConfig.set(player.getUniqueId().toString() + ".3.horse-color", null);
							horsesConfig.set(player.getUniqueId().toString() + ".3.horse-style", null);
							horsesConfig.set(player.getUniqueId().toString() + ".3.horse-max-health", null);
							horsesConfig.set(player.getUniqueId().toString() + ".3.horse-level", null);
							horsesConfig.set(player.getUniqueId().toString() + ".3.horse-speed", null);
							horsesConfig.set(player.getUniqueId().toString() + ".3.horse-UUID", null);
							horsesConfig.set(player.getUniqueId().toString() + ".3.horse-slot", null);
							horsesConfig.set(player.getUniqueId().toString() + ".3.horse-owner-name", null);
							player.sendMessage("Oh no! It appears " + horse.getCustomName() + " has died!");
						}
					}
				}
			}
		}
	}
 }