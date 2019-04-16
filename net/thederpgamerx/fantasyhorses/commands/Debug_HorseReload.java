package net.thederpgamerx.fantasyhorses.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.thederpgamerx.fantasyhorses.main.Main;

public class Debug_HorseReload implements CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player)sender;
		if(player.hasPermission("fantasyhorses.admin") || player.hasPermission("fantasyhorses.debug_reload")) {
			Main.getPlugin().reloadConfig();
			player.sendMessage("Configs reloaded!");
		} else {
			player.sendMessage("You dont have permission to use this!");
		}
		return true;
	}

}
