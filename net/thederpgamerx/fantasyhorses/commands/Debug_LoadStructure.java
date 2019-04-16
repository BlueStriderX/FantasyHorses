package net.thederpgamerx.fantasyhorses.commands;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import net.minecraft.server.v1_13_R2.DefinedStructure;
import net.minecraft.server.v1_13_R2.EnumBlockRotation;
import net.thederpgamerx.fantasyhorses.main.Main;
import net.thederpgamerx.fantasyhorses.structures.StructureHandler;

public class Debug_LoadStructure implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player) {
			Player player = (Player) sender;
			if(args.length == 1) {
				if(player.hasPermission("fantasyhorses.admin") || player.hasPermission("fantasyhorses.debug_loadstructure")) {
					File source = new File(Main.getPlugin().getDataFolder() + "/structures/" + args[0] + ".nbt");
					try {
						DefinedStructure structure = StructureHandler.loadSingleStructure(source);
						EnumBlockRotation rotation = EnumBlockRotation.NONE;
						StructureHandler.insertSingleStructure(structure, player.getLocation(), rotation);
						player.sendMessage("Structure Saved!");
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
				} else {
					player.sendMessage("You dont have permission to use this!");
				}
			} else if(args.length != 1) {
				player.sendMessage("Improper command usage! Proper usage is /debug_loadstructure <file>");
			}
		}
		return false;
	}
}