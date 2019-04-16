package net.thederpgamerx.fantasyhorses.commands;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.minecraft.server.v1_13_R2.DefinedStructure;
import net.thederpgamerx.fantasyhorses.main.Main;
import net.thederpgamerx.fantasyhorses.structures.StructureHandler;

public class Debug_SaveStructure implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player) {
			Player player = (Player) sender;
			if(args.length == 7) {
				if(player.hasPermission("fantasyhorses.admin") || player.hasPermission("fantasyhorses.debug_savestructure")) {
					World world = player.getWorld();
					int x1 = Integer.parseInt(args[0]);
					int y1 = Integer.parseInt(args[1]);
					int z1 = Integer.parseInt(args[2]);
					int x2 = Integer.parseInt(args[3]);
					int y2 = Integer.parseInt(args[4]);
					int z2 = Integer.parseInt(args[5]);
					Location point1 = new Location(world, x1, y1, z1);
					Location point2 = new Location(world, x2, y2, z2);
					DefinedStructure structure = StructureHandler.createSingleStructure(point1, point2, player.getName());
					try {
						StructureHandler.saveSingleStructure(structure, Main.getPlugin().getDataFolder() + "/structures/" + args[6] + ".nbt");
						player.sendMessage("Structure loaded!");
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
				} else {
					player.sendMessage("You dont have permission to use this!");
				}
			} else if(args.length != 6) {
				player.sendMessage("Improper command usage! Proper usage is /debug_savestructure <x1> <y1> <z1> <x2> <y2> <z2>");
			}
		}
		return false;
	}

}