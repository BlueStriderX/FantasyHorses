package net.thederpgamerx.fantasyhorses.horses;

import org.bukkit.ChatColor;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Horse;
import org.bukkit.entity.Player;

import net.thederpgamerx.fantasyhorses.main.Main;
import net.wesjd.anvilgui.AnvilGUI;

public class RegisterHorse {
	
	public static void main (Player p, Horse horse, int slot) {
		if(slot == 1) {
			new AnvilGUI(Main.getPlugin(), p, "Enter horse name:", (player, reply) -> {
				FantasyHorse fhorse1 = new FantasyHorse();
			    fhorse1.horseName = reply.toString();
			    fhorse1.horseOwnerUUID = p.getUniqueId();
				fhorse1.horseUUID = horse.getUniqueId();
				fhorse1.horseOwner = p;
				fhorse1.horseStyle = horse.getStyle().toString();
				fhorse1.horseColor = horse.getColor().toString();
				fhorse1.horseSlot = 1;
				fhorse1.horseHealth = horse.getHealth();
				fhorse1.horseMaxHealth = horse.getMaxHealth();
				fhorse1.horseLocation = horse.getLocation();
				fhorse1.horseLevel = 1;
				fhorse1.horseSpeed = horse.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED);		
				HorseHandler.saveHorse(p, fhorse1, 1);
				p.sendMessage(ChatColor.AQUA + fhorse1.horseName + " has been registered to slot 1!");
				horse.setCustomName(fhorse1.horseName);
				horse.setCustomNameVisible(true);
				if(Main.getPlugin().getConfig().getString("invulnerable-horses").equals("true")) {
					horse.setInvulnerable(true);
				} else if(Main.getPlugin().getConfig().getString("invulnerable-horses").equals("false")) {
					horse.setInvulnerable(false);
				}
				return null;
			});
			Main.fhorses1.put(p.getUniqueId(), horse);
		} else if(slot == 2) {
			new AnvilGUI(Main.getPlugin(), p, "Enter horse name:", (player, reply) -> {
				FantasyHorse fhorse2 = new FantasyHorse();
			    fhorse2.horseName = reply.toString();
			    fhorse2.horseOwnerUUID = p.getUniqueId();
				fhorse2.horseUUID = horse.getUniqueId();
				fhorse2.horseOwner = p;
				fhorse2.horseStyle = horse.getStyle().toString();
				fhorse2.horseColor = horse.getColor().toString();
				fhorse2.horseSlot = 2;
				fhorse2.horseHealth = horse.getHealth();
				fhorse2.horseMaxHealth = horse.getMaxHealth();
				fhorse2.horseLocation = horse.getLocation();
				fhorse2.horseLevel = 1;
				fhorse2.horseSpeed = horse.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED);		
				HorseHandler.saveHorse(p, fhorse2, 2);
				p.sendMessage(ChatColor.AQUA + fhorse2.horseName + " has been registered to slot 2!");
				horse.setCustomName(fhorse2.horseName);
				horse.setCustomNameVisible(true);
				if(Main.getPlugin().getConfig().getString("invulnerable-horses").equals("true")) {
					horse.setInvulnerable(true);
				} else if(Main.getPlugin().getConfig().getString("invulnerable-horses").equals("false")) {
					horse.setInvulnerable(false);
				}
				return null;
			});
			Main.fhorses2.put(p.getUniqueId(), horse);
		} else if(slot == 3) {
			new AnvilGUI(Main.getPlugin(), p, "Enter horse name:", (player, reply) -> {
				FantasyHorse fhorse3 = new FantasyHorse();
			    fhorse3.horseName = reply.toString();
			    fhorse3.horseOwnerUUID = p.getUniqueId();
				fhorse3.horseUUID = horse.getUniqueId();
				fhorse3.horseOwner = p;
				fhorse3.horseStyle = horse.getStyle().toString();
				fhorse3.horseColor = horse.getColor().toString();
				fhorse3.horseSlot = 3;
				fhorse3.horseHealth = horse.getHealth();
				fhorse3.horseMaxHealth = horse.getMaxHealth();
				fhorse3.horseLocation = horse.getLocation();
				fhorse3.horseLevel = 1;
				fhorse3.horseSpeed = horse.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED);		
				HorseHandler.saveHorse(p, fhorse3, 3);
				p.sendMessage(ChatColor.AQUA + fhorse3.horseName + " has been registered to slot 3!");
				horse.setCustomName(fhorse3.horseName);
				horse.setCustomNameVisible(true);
				if(Main.getPlugin().getConfig().getString("invulnerable-horses").equals("true")) {
					horse.setInvulnerable(true);
				} else if(Main.getPlugin().getConfig().getString("invulnerable-horses").equals("false")) {
					horse.setInvulnerable(false);
				}
				return null;
			});
			Main.fhorses3.put(p.getUniqueId(), horse);

		}
			
	}
}