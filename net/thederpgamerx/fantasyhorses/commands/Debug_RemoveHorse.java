package net.thederpgamerx.fantasyhorses.commands;

import java.io.File;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Horse;
import org.bukkit.entity.Player;

import net.thederpgamerx.fantasyhorses.main.Main;

public class Debug_RemoveHorse implements CommandExecutor {
	
	static FileConfiguration horsesConfig = Main.getHorsesConfig();
	static File horsesFile = Main.getHorsesFile();

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player admin = (Player) sender;
		Player player = Bukkit.getPlayer(args[1]);
		if(sender instanceof Player) {
			if(args.length == 2) {
				if(admin.hasPermission("fantasyhorses.admin") || admin.hasPermission("fantasyhorses.debug_removehorse")) {
					if(args[1] == "1") {
						Horse horse = Main.fhorses1.get(player.getUniqueId());
						Main.fhorses1.remove(player.getUniqueId(), horse);
						horsesConfig.set(player.getUniqueId().toString() + ".1.horse-name", null);
						horsesConfig.set(player.getUniqueId().toString() + ".1.horse-color", null);
						horsesConfig.set(player.getUniqueId().toString() + ".1.horse-style", null);
						horsesConfig.set(player.getUniqueId().toString() + ".1.horse-max-health", null);
						horsesConfig.set(player.getUniqueId().toString() + ".1.horse-level", null);
						horsesConfig.set(player.getUniqueId().toString() + ".1.horse-speed", null);
						horsesConfig.set(player.getUniqueId().toString() + ".1.horse-UUID", null);
						horsesConfig.set(player.getUniqueId().toString() + ".1.horse-slot", null);
						horsesConfig.set(player.getUniqueId().toString() + ".1.horse-owner-name", null);
						admin.sendMessage(horse.getCustomName() + " has been removed from " + player.getName() + "!");
					} else if(args[1] == "2") {
						Horse horse = Main.fhorses2.get(player.getUniqueId());
						Main.fhorses2.remove(player.getUniqueId(), horse);
						horsesConfig.set(player.getUniqueId().toString() + ".2.horse-name", null);
						horsesConfig.set(player.getUniqueId().toString() + ".2.horse-color", null);
						horsesConfig.set(player.getUniqueId().toString() + ".2.horse-style", null);
						horsesConfig.set(player.getUniqueId().toString() + ".2.horse-max-health", null);
						horsesConfig.set(player.getUniqueId().toString() + ".2.horse-level", null);
						horsesConfig.set(player.getUniqueId().toString() + ".2.horse-speed", null);
						horsesConfig.set(player.getUniqueId().toString() + ".2.horse-UUID", null);
						horsesConfig.set(player.getUniqueId().toString() + ".2.horse-slot", null);
						horsesConfig.set(player.getUniqueId().toString() + ".2.horse-owner-name", null);
						admin.sendMessage(horse.getCustomName() + " has been removed from " + player.getName() + "!");
					} else if(args[1] == "3") {
						Horse horse = Main.fhorses3.get(player.getUniqueId());
						Main.fhorses3.remove(player.getUniqueId(), horse);
						horsesConfig.set(player.getUniqueId().toString() + ".3.horse-name", null);
						horsesConfig.set(player.getUniqueId().toString() + ".3.horse-color", null);
						horsesConfig.set(player.getUniqueId().toString() + ".3.horse-style", null);
						horsesConfig.set(player.getUniqueId().toString() + ".3.horse-max-health", null);
						horsesConfig.set(player.getUniqueId().toString() + ".3.horse-level", null);
						horsesConfig.set(player.getUniqueId().toString() + ".3.horse-speed", null);
						horsesConfig.set(player.getUniqueId().toString() + ".3.horse-UUID", null);
						horsesConfig.set(player.getUniqueId().toString() + ".3.horse-slot", null);
						horsesConfig.set(player.getUniqueId().toString() + ".3.horse-owner-name", null);
						admin.sendMessage(horse.getCustomName() + " has been removed from " + player.getName() + "!");
					} else {
						admin.sendMessage(args[1] + " is not a valid horse slot!");
					}
				} else {
					admin.sendMessage("You don't have permission to use this!");
				}
			} else {
				admin.sendMessage("Improper command usage! Proper usage is /debug_removehorse <playerName> <slot>");
			}
		}
		return true;
	}
}