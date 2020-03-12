package net.thederpgamerx.fantasyhorses.horses;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Horse;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.citizensnpcs.api.npc.NPC;
import net.thederpgamerx.fantasyhorses.main.Main;

public class HorseGUI implements org.bukkit.event.Listener, CommandExecutor {	
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    Player player = (Player)sender;
    if (sender instanceof Player) {
      createHorseSelection(player);
    }
    return true;
  }
  
  static FileConfiguration horsesConfig = Main.getHorsesConfig();
  static File horsesFile = Main.getHorsesFile();
  
  @EventHandler
  public static void onInventoryClick(InventoryClickEvent e) {
	  if(e.getWhoClicked() instanceof Player) {
      	Player player = (Player)e.getWhoClicked();
      	@SuppressWarnings("deprecation")
		String invName = e.getInventory().getName().toString(); 
      	FantasyHorse fhorse = new FantasyHorse();
      	if(invName.equals(ChatColor.AQUA + "Horse Selection")) {
      		e.setCancelled(true);
      		if(e.getCurrentItem().getType().equals(Material.SADDLE)) {
      			if(e.getSlot() == 3) {
      				Horse horse = Main.fhorses1.get(player.getUniqueId());
      				fhorse.horseName = horse.getCustomName();
      				fhorse.horseUUID = horse.getUniqueId();
      				fhorse.horseSlot = 1;
      				fhorse.horseColor = horse.getColor().toString();
      				fhorse.horseStyle = horse.getStyle().toString();
      				fhorse.horseLevel = Main.getHorsesConfig().getInt(player.getUniqueId().toString() + ".1.horse-level");
      				fhorse.horseMaxHealth = horse.getMaxHealth();
      				player.closeInventory();
      				createHorseMenu(player, fhorse);
      			} else if(e.getSlot() == 4) {
      				Horse horse = Main.fhorses2.get(player.getUniqueId());
      				fhorse.horseName = horse.getCustomName();
      				fhorse.horseUUID = horse.getUniqueId();
      				fhorse.horseSlot = 2;
      				fhorse.horseColor = horse.getColor().toString();
      				fhorse.horseStyle = horse.getStyle().toString();
      				fhorse.horseLevel = Main.getHorsesConfig().getInt(player.getUniqueId().toString() + ".2.horse-level");
      				fhorse.horseMaxHealth = horse.getMaxHealth();
      				player.closeInventory();
      				createHorseMenu(player, fhorse);
      			} else if(e.getSlot() == 5) {
      				Horse horse = Main.fhorses3.get(player.getUniqueId());
      				fhorse.horseName = horse.getCustomName();
      				fhorse.horseUUID = horse.getUniqueId();
      				fhorse.horseSlot = 3;
      				fhorse.horseColor = horse.getColor().toString();
      				fhorse.horseStyle = horse.getStyle().toString();
      				fhorse.horseLevel = Main.getHorsesConfig().getInt(player.getUniqueId().toString() + ".3.horse-level");
      				fhorse.horseMaxHealth = horse.getMaxHealth();
      				player.closeInventory();
      				createHorseMenu(player, fhorse);
      			}
      		} else if(e.getCurrentItem().getType().equals(Material.COAL_BLOCK)) {
      			if(e.getSlot() == 3) {
      				if(player.isInsideVehicle() && player.getVehicle() instanceof Horse) {
      					Horse horse = (Horse) player.getVehicle();
      					if(Main.fhorses1.get(player.getUniqueId()) == horse || Main.fhorses2.get(player.getUniqueId()) == horse || Main.fhorses3.get(player.getUniqueId()) == horse) {
      						player.closeInventory();
      						player.sendMessage(ChatColor.DARK_RED + "You already have that horse registered!");
      					} else if(Main.fhorses1.containsValue(horse)) {
      						player.closeInventory();
      						player.sendMessage(ChatColor.DARK_RED + "Someone already owns that horse!");
      					} else if(Main.fhorses2.containsValue(horse)) {
      						player.closeInventory();
      						player.sendMessage(ChatColor.DARK_RED + "Someone already owns that horse!");
      					} else if(Main.fhorses3.containsValue(horse)) {
      						player.closeInventory();
      						player.sendMessage(ChatColor.DARK_RED + "Someone already owns that horse!");
      					} else if(Main.fhorses1.get(player.getUniqueId()) != horse || Main.fhorses2.get(player.getUniqueId()) != horse || Main.fhorses3.get(player.getUniqueId()) != horse) {
      						RegisterHorse.main(player, horse, 1);
      					}
      				}
      			} else if(e.getSlot() == 4) {
      				if(player.isInsideVehicle() && player.getVehicle() instanceof Horse) {
      					Horse horse = (Horse) player.getVehicle();
      					if(Main.fhorses1.get(player.getUniqueId()) == horse || Main.fhorses2.get(player.getUniqueId()) == horse || Main.fhorses3.get(player.getUniqueId()) == horse) {
      						player.closeInventory();
      						player.sendMessage(ChatColor.DARK_RED + "You already have that horse registered!");
      					} else if(Main.fhorses1.containsValue(horse)) {
      						player.closeInventory();
      						player.sendMessage(ChatColor.DARK_RED + "Someone already owns that horse!");
      					} else if(Main.fhorses2.containsValue(horse)) {
      						player.closeInventory();
      						player.sendMessage(ChatColor.DARK_RED + "Someone already owns that horse!");
      					} else if(Main.fhorses3.containsValue(horse)) {
      						player.closeInventory();
      						player.sendMessage(ChatColor.DARK_RED + "Someone already owns that horse!");
      					} else if(Main.fhorses1.get(player.getUniqueId()) != horse || Main.fhorses2.get(player.getUniqueId()) != horse || Main.fhorses3.get(player.getUniqueId()) != horse) {
      						RegisterHorse.main(player, horse, 2);
      					}
      				}
      			} else if(e.getSlot() == 5) {
      				if(player.isInsideVehicle() && player.getVehicle() instanceof Horse) {
      					Horse horse = (Horse) player.getVehicle();
      					if(Main.fhorses1.get(player.getUniqueId()) == horse || Main.fhorses2.get(player.getUniqueId()) == horse || Main.fhorses3.get(player.getUniqueId()) == horse) {
      						player.closeInventory();
      						player.sendMessage(ChatColor.DARK_RED + "You already have that horse registered!");
      					} else if(Main.fhorses1.containsValue(horse)) {
      						player.closeInventory();
      						player.sendMessage(ChatColor.DARK_RED + "Someone already owns that horse!");
      					} else if(Main.fhorses2.containsValue(horse)) {
      						player.closeInventory();
      						player.sendMessage(ChatColor.DARK_RED + "Someone already owns that horse!");
      					} else if(Main.fhorses3.containsValue(horse)) {
      						player.closeInventory();
      						player.sendMessage(ChatColor.DARK_RED + "Someone already owns that horse!");
      					} else if(Main.fhorses1.get(player.getUniqueId()) != horse || Main.fhorses2.get(player.getUniqueId()) != horse || Main.fhorses3.get(player.getUniqueId()) != horse) {
      						RegisterHorse.main(player, horse, 3);
      					}
      				}
      			}
      			e.setCancelled(true);
      		} else if(e.getCurrentItem().getType().equals(Material.GRAY_STAINED_GLASS_PANE)) {
      			e.setCancelled(true);
      		}
      	} else if(invName.equals(ChatColor.RED + "Horse 1 Menu")) {
    		e.setCancelled(true);
    		if(e.getCurrentItem().getType().equals(Material.ENDER_PEARL)) {
    			player.closeInventory();
    			if(player.getNearbyEntities(10, 10, 10).contains(Main.stableKeepers)) {
    				HorseHandler.summon(player, 1);
    			} else if(!(player.getNearbyEntities(10, 10, 10).contains(Main.stableKeepers))) {
    				if(Main.getPlugin().getConfig().getString("summon-costs-epearls").equals("true")) {
    	    			if(player.getInventory().contains(Material.ENDER_PEARL)) {
    	    				Inventory pInventory = player.getInventory();
    	    				ItemStack[] items = pInventory.getStorageContents();
    	    				for(ItemStack item : items) {
    	    					if(item == null) continue;
    	    					    
    	    					if(item.getType() == Material.ENDER_PEARL) {
    	    					    item.setAmount(item.getAmount() - 1);
    	    					    HorseHandler.summon(player, 1);
    	    					    break;
    	    					}
    	    				}
    	        		} else if(!(player.getInventory().contains(Material.ENDER_PEARL))) {
    	        			player.sendMessage(ChatColor.DARK_RED + "You don't have any ender pearls!");
    	        		}
    	    		} else if(Main.getPlugin().getConfig().getString("summon-costs-epearls").equals("false")) {
    	    			HorseHandler.summon(player, 1);
    	    		}
    			}
    		} else if(e.getCurrentItem().getType().equals(Material.REDSTONE_BLOCK)) {
    			String horseName = horsesConfig.getString(player.getUniqueId().toString() + ".1.horse-name");
    			horsesConfig.set(player.getUniqueId().toString() + ".1.horse-name", null);
				horsesConfig.set(player.getUniqueId().toString() + ".1.horse-color", null);
				horsesConfig.set(player.getUniqueId().toString() + ".1.horse-style", null);
				horsesConfig.set(player.getUniqueId().toString() + ".1.horse-max-health", null);
				horsesConfig.set(player.getUniqueId().toString() + ".1.horse-level", null);
				horsesConfig.set(player.getUniqueId().toString() + ".1.horse-speed", null);
				horsesConfig.set(player.getUniqueId().toString() + ".1.horse-UUID", null);
				horsesConfig.set(player.getUniqueId().toString() + ".1.horse-slot", null);
				horsesConfig.set(player.getUniqueId().toString() + ".1.horse-owner-name", null);
    			player.closeInventory();
				player.sendMessage(horseName + " has been removed from slot 1!");
    		} else if(e.getCurrentItem().getType().equals(Material.GOLDEN_CARROT)) {
    			player.closeInventory();
    			if(player.getInventory().contains(Material.GOLDEN_CARROT)) {
					Inventory pInventory = player.getInventory();
					ItemStack[] items = pInventory.getStorageContents();
					for(ItemStack item : items) {
					    if(item == null) continue;
					    
					    if(item.getType() == Material.GOLDEN_CARROT) {
					    	item.setAmount(item.getAmount() - 1);
					    	HorseHandler.upgrade(player, 1);
					        break;
					    }
					}
    			} else if(!(player.getInventory().contains(Material.GOLDEN_CARROT))) {
    				player.sendMessage(ChatColor.DARK_RED + "You don't have any golden carrots!");
    			}
    		}
      	} else if(invName.equals(ChatColor.RED + "Horse 2 Menu")) {
    		e.setCancelled(true);
    		if(e.getCurrentItem().getType().equals(Material.ENDER_PEARL)) {
    			player.closeInventory();
    			if(player.getNearbyEntities(10, 10, 10).contains(Main.stableKeepers)) {
    				HorseHandler.summon(player, 2);
    			} else if(!(player.getNearbyEntities(10, 10, 10).contains(Main.stableKeepers))) {
    				if(Main.getPlugin().getConfig().getString("summon-costs-epearls").equals("true")) {
    	    			if(player.getInventory().contains(Material.ENDER_PEARL)) {
    	    				Inventory pInventory = player.getInventory();
    	    				ItemStack[] items = pInventory.getStorageContents();
    	    				for(ItemStack item : items) {
    	    					if(item == null) continue;
    	    					    
    	    					if(item.getType() == Material.ENDER_PEARL) {
    	    					    item.setAmount(item.getAmount() - 1);
    	    					    HorseHandler.summon(player, 2);
    	    					    break;
    	    					}
    	    				}
    	        		} else if(!(player.getInventory().contains(Material.ENDER_PEARL))) {
    	        			player.sendMessage(ChatColor.DARK_RED + "You don't have any ender pearls!");
    	        		}
    	    		} else if(Main.getPlugin().getConfig().getString("summon-costs-epearls").equals("false")) {
    	    			HorseHandler.summon(player, 2);
    	    		}
    			}
    		} else if(e.getCurrentItem().getType().equals(Material.REDSTONE_BLOCK)) {
    			String horseName = horsesConfig.getString(player.getUniqueId().toString() + ".2.horse-name");
    			horsesConfig.set(player.getUniqueId().toString() + ".2.horse-name", null);
				horsesConfig.set(player.getUniqueId().toString() + ".2.horse-color", null);
				horsesConfig.set(player.getUniqueId().toString() + ".2.horse-style", null);
				horsesConfig.set(player.getUniqueId().toString() + ".2.horse-max-health", null);
				horsesConfig.set(player.getUniqueId().toString() + ".2.horse-level", null);
				horsesConfig.set(player.getUniqueId().toString() + ".2.horse-speed", null);
				horsesConfig.set(player.getUniqueId().toString() + ".2.horse-UUID", null);
				horsesConfig.set(player.getUniqueId().toString() + ".2.horse-slot", null);
				horsesConfig.set(player.getUniqueId().toString() + ".2.horse-owner-name", null);
    			player.closeInventory();
				player.sendMessage(horseName + " has been removed from slot 2!");
    		} else if(e.getCurrentItem().getType().equals(Material.GOLDEN_CARROT)) {
    			player.closeInventory();
    			if(player.getInventory().contains(Material.GOLDEN_CARROT)) {
					Inventory pInventory = player.getInventory();
					ItemStack[] items = pInventory.getStorageContents();
					for(ItemStack item : items) {
					    if(item == null) continue;
					    
					    if(item.getType() == Material.GOLDEN_CARROT) {
					    	item.setAmount(item.getAmount() - 1);
					    	HorseHandler.upgrade(player, 2);
					        break;
					    }
					}
    			} else if(!(player.getInventory().contains(Material.GOLDEN_CARROT))) {
    				player.sendMessage(ChatColor.DARK_RED + "You don't have any golden carrots!");
    			}
    		}
      	} else if(invName.equals(ChatColor.RED + "Horse 3 Menu")) {
    		e.setCancelled(true);
    		if(e.getCurrentItem().getType().equals(Material.ENDER_PEARL)) {
    			player.closeInventory();
    			if(player.getNearbyEntities(10, 10, 10).contains(Main.stableKeepers)) {
    				HorseHandler.summon(player, 3);
    			} else if(!(player.getNearbyEntities(10, 10, 10).contains(Main.stableKeepers))) {
    				if(Main.getPlugin().getConfig().getString("summon-costs-epearls").equals("true")) {
    	    			if(player.getInventory().contains(Material.ENDER_PEARL)) {
    	    				Inventory pInventory = player.getInventory();
    	    				ItemStack[] items = pInventory.getStorageContents();
    	    				for(ItemStack item : items) {
    	    					if(item == null) continue;
    	    					    
    	    					if(item.getType() == Material.ENDER_PEARL) {
    	    					    item.setAmount(item.getAmount() - 1);
    	    					    HorseHandler.summon(player, 3);
    	    					    break;
    	    					}
    	    				}
    	        		} else if(!(player.getInventory().contains(Material.ENDER_PEARL))) {
    	        			player.sendMessage(ChatColor.DARK_RED + "You don't have any ender pearls!");
    	        		}
    	    		} else if(Main.getPlugin().getConfig().getString("summon-costs-epearls").equals("false")) {
    	    			HorseHandler.summon(player, 3);
    	    		}
    			}
    		} else if(e.getCurrentItem().getType().equals(Material.REDSTONE_BLOCK)) {
    			String horseName = horsesConfig.getString(player.getUniqueId().toString() + ".3.horse-name");
    			horsesConfig.set(player.getUniqueId().toString() + ".3.horse-name", null);
				horsesConfig.set(player.getUniqueId().toString() + ".3.horse-color", null);
				horsesConfig.set(player.getUniqueId().toString() + ".3.horse-style", null);
				horsesConfig.set(player.getUniqueId().toString() + ".3.horse-max-health", null);
				horsesConfig.set(player.getUniqueId().toString() + ".3.horse-level", null);
				horsesConfig.set(player.getUniqueId().toString() + ".3.horse-speed", null);
				horsesConfig.set(player.getUniqueId().toString() + ".3.horse-UUID", null);
				horsesConfig.set(player.getUniqueId().toString() + ".3.horse-slot", null);
				horsesConfig.set(player.getUniqueId().toString() + ".3.horse-owner-name", null);
    			player.closeInventory();
				player.sendMessage(horseName + " has been removed from slot 3!");
    		} else if(e.getCurrentItem().getType().equals(Material.GOLDEN_CARROT)) {
    			player.closeInventory();
    			if(player.getInventory().contains(Material.GOLDEN_CARROT)) {
					Inventory pInventory = player.getInventory();
					ItemStack[] items = pInventory.getStorageContents();
					for(ItemStack item : items) {
					    if(item == null) continue;
					    
					    if(item.getType() == Material.GOLDEN_CARROT) {
					    	item.setAmount(item.getAmount() - 1);
					    	HorseHandler.upgrade(player, 3);
					        break;
					    }
					}
    			} else if(!(player.getInventory().contains(Material.GOLDEN_CARROT))) {
    				player.sendMessage(ChatColor.DARK_RED + "You don't have any golden carrots!");
    			}
    		}
      	}
    }
  }
      	
  @SuppressWarnings("unchecked")
  public static void createHorseSelection(Player player) {
	  
	  @SuppressWarnings("static-access")
	  FileConfiguration horsesConfig = Main.getPlugin().getHorsesConfig();
	  Inventory horseSelection = Bukkit.createInventory(player, 9, ChatColor.AQUA + "Horse Selection");	  
	  String horse1Name = horsesConfig.getString(player.getUniqueId().toString() + ".1.horse-name");
	  String horse2Name = horsesConfig.getString(player.getUniqueId().toString() + ".2.horse-name");
	  String horse3Name = horsesConfig.getString(player.getUniqueId().toString() + ".3.horse-name");
	  
	  Horse horse1 = Main.fhorses1.get(player.getUniqueId());
	  Horse horse2 = Main.fhorses2.get(player.getUniqueId());
	  Horse horse3 = Main.fhorses3.get(player.getUniqueId());
	  
	  if(horse1Name != null && horse2Name != null && horse3Name != null) {
		  horseSelection.setItem(0, createGuiItem(" ", new ArrayList(Arrays.asList(new String[] { "" })), Material.GRAY_STAINED_GLASS_PANE));
		  horseSelection.setItem(1, createGuiItem(" ", new ArrayList(Arrays.asList(new String[] { "" })), Material.GRAY_STAINED_GLASS_PANE));
		  horseSelection.setItem(2, createGuiItem(" ", new ArrayList(Arrays.asList(new String[] { "" })), Material.GRAY_STAINED_GLASS_PANE));
		  horseSelection.setItem(3, createGuiItem(ChatColor.GOLD + horse1Name, new ArrayList(Arrays.asList(new String[] { "Horse is at: (" + horse1.getLocation().getBlockX() + " " +  horse1.getLocation().getBlockY() + " " + horse1.getLocation().getBlockZ() + ")"})), Material.SADDLE));
	      horseSelection.setItem(4, createGuiItem(ChatColor.GOLD + horse2Name, new ArrayList(Arrays.asList(new String[] { "Horse is at: (" + horse2.getLocation().getBlockX() + " " +  horse2.getLocation().getBlockY() + " " + horse2.getLocation().getBlockZ() + ")"})), Material.SADDLE));
	      horseSelection.setItem(5, createGuiItem(ChatColor.GOLD + horse3Name, new ArrayList(Arrays.asList(new String[] { "Horse is at: (" + horse3.getLocation().getBlockX() + " " +  horse3.getLocation().getBlockY() + " " + horse3.getLocation().getBlockZ() + ")" })), Material.SADDLE));
		  horseSelection.setItem(6, createGuiItem(" ", new ArrayList(Arrays.asList(new String[] { "" })), Material.GRAY_STAINED_GLASS_PANE));
		  horseSelection.setItem(7, createGuiItem(" ", new ArrayList(Arrays.asList(new String[] { "" })), Material.GRAY_STAINED_GLASS_PANE));
		  horseSelection.setItem(8, createGuiItem(" ", new ArrayList(Arrays.asList(new String[] { "" })), Material.GRAY_STAINED_GLASS_PANE));

	  } else if(horse1Name == null && horse2Name != null && horse3Name != null) {
		  horseSelection.setItem(0, createGuiItem(" ", new ArrayList(Arrays.asList(new String[] { "" })), Material.GRAY_STAINED_GLASS_PANE));
		  horseSelection.setItem(1, createGuiItem(" ", new ArrayList(Arrays.asList(new String[] { "" })), Material.GRAY_STAINED_GLASS_PANE));
		  horseSelection.setItem(2, createGuiItem(" ", new ArrayList(Arrays.asList(new String[] { "" })), Material.GRAY_STAINED_GLASS_PANE));
		  horseSelection.setItem(3, createGuiItem(ChatColor.RED + "Empty Slot", new ArrayList(Arrays.asList(new String[] { "Click to register a new horse" })), Material.COAL_BLOCK));
	      horseSelection.setItem(4, createGuiItem(ChatColor.GOLD + horse2Name, new ArrayList(Arrays.asList(new String[] { "Horse is at: (" + horse2.getLocation().getBlockX() + " " +  horse2.getLocation().getBlockY() + " " + horse2.getLocation().getBlockZ() + ")" })), Material.SADDLE));
	      horseSelection.setItem(5, createGuiItem(ChatColor.GOLD + horse3Name, new ArrayList(Arrays.asList(new String[] { "Horse is at: (" + horse3.getLocation().getBlockX() + " " +  horse3.getLocation().getBlockY() + " " + horse3.getLocation().getBlockZ() + ")" })), Material.SADDLE));
	      horseSelection.setItem(6, createGuiItem(" ", new ArrayList(Arrays.asList(new String[] { "" })), Material.GRAY_STAINED_GLASS_PANE));
		  horseSelection.setItem(7, createGuiItem(" ", new ArrayList(Arrays.asList(new String[] { "" })), Material.GRAY_STAINED_GLASS_PANE));
		  horseSelection.setItem(8, createGuiItem(" ", new ArrayList(Arrays.asList(new String[] { "" })), Material.GRAY_STAINED_GLASS_PANE));

	  } else if(horse1Name == null && horse2Name == null && horse3Name != null) {
		  horseSelection.setItem(0, createGuiItem(" ", new ArrayList(Arrays.asList(new String[] { "" })), Material.GRAY_STAINED_GLASS_PANE));
		  horseSelection.setItem(1, createGuiItem(" ", new ArrayList(Arrays.asList(new String[] { "" })), Material.GRAY_STAINED_GLASS_PANE));
		  horseSelection.setItem(2, createGuiItem(" ", new ArrayList(Arrays.asList(new String[] { "" })), Material.GRAY_STAINED_GLASS_PANE));
		  horseSelection.setItem(3, createGuiItem(ChatColor.RED + "Empty Slot", new ArrayList(Arrays.asList(new String[] { "Click to register a new horse" })), Material.COAL_BLOCK));
	      horseSelection.setItem(4, createGuiItem(ChatColor.RED + "Empty Slot", new ArrayList(Arrays.asList(new String[] { "Click to register a new horse" })), Material.COAL_BLOCK));
	      horseSelection.setItem(5, createGuiItem(ChatColor.GOLD + horse3Name, new ArrayList(Arrays.asList(new String[] { "Horse is at: (" + horse3.getLocation().getBlockX() + " " +  horse3.getLocation().getBlockY() + " " + horse3.getLocation().getBlockZ() + ")" })), Material.SADDLE));
	      horseSelection.setItem(6, createGuiItem(" ", new ArrayList(Arrays.asList(new String[] { "" })), Material.GRAY_STAINED_GLASS_PANE));
		  horseSelection.setItem(7, createGuiItem(" ", new ArrayList(Arrays.asList(new String[] { "" })), Material.GRAY_STAINED_GLASS_PANE));
		  horseSelection.setItem(8, createGuiItem(" ", new ArrayList(Arrays.asList(new String[] { "" })), Material.GRAY_STAINED_GLASS_PANE));

	  } else if(horse1Name == null && horse2Name == null && horse3Name == null) {
		  horseSelection.setItem(0, createGuiItem(" ", new ArrayList(Arrays.asList(new String[] { "" })), Material.GRAY_STAINED_GLASS_PANE));
		  horseSelection.setItem(1, createGuiItem(" ", new ArrayList(Arrays.asList(new String[] { "" })), Material.GRAY_STAINED_GLASS_PANE));
		  horseSelection.setItem(2, createGuiItem(" ", new ArrayList(Arrays.asList(new String[] { "" })), Material.GRAY_STAINED_GLASS_PANE));
		  horseSelection.setItem(3, createGuiItem(ChatColor.RED + "Empty Slot", new ArrayList(Arrays.asList(new String[] { "Click to register a new horse" })), Material.COAL_BLOCK));
	      horseSelection.setItem(4, createGuiItem(ChatColor.RED + "Empty Slot", new ArrayList(Arrays.asList(new String[] { "Click to register a new horse" })), Material.COAL_BLOCK));
		  horseSelection.setItem(5, createGuiItem(ChatColor.RED + "Empty Slot", new ArrayList(Arrays.asList(new String[] { "Click to register a new horse" })), Material.COAL_BLOCK));
		  horseSelection.setItem(6, createGuiItem(" ", new ArrayList(Arrays.asList(new String[] { "" })), Material.GRAY_STAINED_GLASS_PANE));
		  horseSelection.setItem(7, createGuiItem(" ", new ArrayList(Arrays.asList(new String[] { "" })), Material.GRAY_STAINED_GLASS_PANE));
		  horseSelection.setItem(8, createGuiItem(" ", new ArrayList(Arrays.asList(new String[] { "" })), Material.GRAY_STAINED_GLASS_PANE));

	  } else if(horse1Name != null && horse2Name == null && horse3Name == null) {
		  horseSelection.setItem(0, createGuiItem(" ", new ArrayList(Arrays.asList(new String[] { "" })), Material.GRAY_STAINED_GLASS_PANE));
		  horseSelection.setItem(1, createGuiItem(" ", new ArrayList(Arrays.asList(new String[] { "" })), Material.GRAY_STAINED_GLASS_PANE));
		  horseSelection.setItem(2, createGuiItem(" ", new ArrayList(Arrays.asList(new String[] { "" })), Material.GRAY_STAINED_GLASS_PANE));
		  horseSelection.setItem(3, createGuiItem(ChatColor.GOLD + horse1Name, new ArrayList(Arrays.asList(new String[] { "Horse is at: (" + horse1.getLocation().getBlockX() + " " +  horse1.getLocation().getBlockY() + " " + horse1.getLocation().getBlockZ() + ")" })), Material.SADDLE));
	      horseSelection.setItem(4, createGuiItem(ChatColor.RED + "Empty Slot", new ArrayList(Arrays.asList(new String[] { "Click to register a new horse" })), Material.COAL_BLOCK));
		  horseSelection.setItem(5, createGuiItem(ChatColor.RED + "Empty Slot", new ArrayList(Arrays.asList(new String[] { "Click to register a new horse" })), Material.COAL_BLOCK));
		  horseSelection.setItem(6, createGuiItem(" ", new ArrayList(Arrays.asList(new String[] { "" })), Material.GRAY_STAINED_GLASS_PANE));
		  horseSelection.setItem(7, createGuiItem(" ", new ArrayList(Arrays.asList(new String[] { "" })), Material.GRAY_STAINED_GLASS_PANE));
		  horseSelection.setItem(8, createGuiItem(" ", new ArrayList(Arrays.asList(new String[] { "" })), Material.GRAY_STAINED_GLASS_PANE));

	  } else if(horse1Name != null && horse2Name == null && horse3Name != null) {
		  horseSelection.setItem(0, createGuiItem(" ", new ArrayList(Arrays.asList(new String[] { "" })), Material.GRAY_STAINED_GLASS_PANE));
		  horseSelection.setItem(1, createGuiItem(" ", new ArrayList(Arrays.asList(new String[] { "" })), Material.GRAY_STAINED_GLASS_PANE));
		  horseSelection.setItem(2, createGuiItem(" ", new ArrayList(Arrays.asList(new String[] { "" })), Material.GRAY_STAINED_GLASS_PANE));
		  horseSelection.setItem(3, createGuiItem(ChatColor.GOLD + horse1Name, new ArrayList(Arrays.asList(new String[] { "Horse is at: (" + horse1.getLocation().getBlockX() + " " +  horse1.getLocation().getBlockY() + " " + horse1.getLocation().getBlockZ() + ")" })), Material.SADDLE));
	      horseSelection.setItem(4, createGuiItem(ChatColor.RED + "Empty Slot", new ArrayList(Arrays.asList(new String[] { "Click to register a new horse" })), Material.COAL_BLOCK));
	      horseSelection.setItem(5, createGuiItem(ChatColor.GOLD + horse3Name, new ArrayList(Arrays.asList(new String[] { "Horse is at: (" + horse2.getLocation().getBlockX() + " " +  horse2.getLocation().getBlockY() + " " + horse2.getLocation().getBlockZ() + ")" })), Material.SADDLE));
	      horseSelection.setItem(6, createGuiItem(" ", new ArrayList(Arrays.asList(new String[] { "" })), Material.GRAY_STAINED_GLASS_PANE));
		  horseSelection.setItem(7, createGuiItem(" ", new ArrayList(Arrays.asList(new String[] { "" })), Material.GRAY_STAINED_GLASS_PANE));
		  horseSelection.setItem(8, createGuiItem(" ", new ArrayList(Arrays.asList(new String[] { "" })), Material.GRAY_STAINED_GLASS_PANE));

	  } else if(horse1Name == null && horse2Name != null && horse3Name == null) {
		  horseSelection.setItem(0, createGuiItem(" ", new ArrayList(Arrays.asList(new String[] { "" })), Material.GRAY_STAINED_GLASS_PANE));
		  horseSelection.setItem(1, createGuiItem(" ", new ArrayList(Arrays.asList(new String[] { "" })), Material.GRAY_STAINED_GLASS_PANE));
		  horseSelection.setItem(2, createGuiItem(" ", new ArrayList(Arrays.asList(new String[] { "" })), Material.GRAY_STAINED_GLASS_PANE));
		  horseSelection.setItem(3, createGuiItem(ChatColor.RED + "Empty Slot", new ArrayList(Arrays.asList(new String[] { "Click to register a new horse" })), Material.COAL_BLOCK));
	      horseSelection.setItem(4, createGuiItem(ChatColor.GOLD + horse2Name, new ArrayList(Arrays.asList(new String[] { "Horse is at: (" + horse2.getLocation().getBlockX() + " " +  horse2.getLocation().getBlockY() + " " + horse2.getLocation().getBlockZ() + ")" })), Material.SADDLE));
		  horseSelection.setItem(5, createGuiItem(ChatColor.RED + "Empty Slot", new ArrayList(Arrays.asList(new String[] { "Click to register a new horse" })), Material.COAL_BLOCK));
		  horseSelection.setItem(6, createGuiItem(" ", new ArrayList(Arrays.asList(new String[] { "" })), Material.GRAY_STAINED_GLASS_PANE));
		  horseSelection.setItem(7, createGuiItem(" ", new ArrayList(Arrays.asList(new String[] { "" })), Material.GRAY_STAINED_GLASS_PANE));
		  horseSelection.setItem(8, createGuiItem(" ", new ArrayList(Arrays.asList(new String[] { "" })), Material.GRAY_STAINED_GLASS_PANE));

	  } else if(horse1Name != null && horse2Name != null && horse3Name == null) {
		  horseSelection.setItem(0, createGuiItem(" ", new ArrayList(Arrays.asList(new String[] { "" })), Material.GRAY_STAINED_GLASS_PANE));
		  horseSelection.setItem(1, createGuiItem(" ", new ArrayList(Arrays.asList(new String[] { "" })), Material.GRAY_STAINED_GLASS_PANE));
		  horseSelection.setItem(2, createGuiItem(" ", new ArrayList(Arrays.asList(new String[] { "" })), Material.GRAY_STAINED_GLASS_PANE));
		  horseSelection.setItem(3, createGuiItem(ChatColor.GOLD + horse1Name, new ArrayList(Arrays.asList(new String[] { "Horse is at: (" + horse1.getLocation().getBlockX() + " " +  horse1.getLocation().getBlockY() + " " + horse1.getLocation().getBlockZ() + ")" })), Material.SADDLE));
	      horseSelection.setItem(4, createGuiItem(ChatColor.GOLD + horse2Name, new ArrayList(Arrays.asList(new String[] { "Horse is at: (" + horse2.getLocation().getBlockX() + " " +  horse2.getLocation().getBlockY() + " " + horse2.getLocation().getBlockZ() + ")" })), Material.SADDLE));
		  horseSelection.setItem(5, createGuiItem(ChatColor.RED + "Empty Slot", new ArrayList(Arrays.asList(new String[] { "Click to register a new horse" })), Material.COAL_BLOCK));
		  horseSelection.setItem(6, createGuiItem(" ", new ArrayList(Arrays.asList(new String[] { "" })), Material.GRAY_STAINED_GLASS_PANE));
		  horseSelection.setItem(7, createGuiItem(" ", new ArrayList(Arrays.asList(new String[] { "" })), Material.GRAY_STAINED_GLASS_PANE));
		  horseSelection.setItem(8, createGuiItem(" ", new ArrayList(Arrays.asList(new String[] { "" })), Material.GRAY_STAINED_GLASS_PANE));

	  }
	  player.closeInventory();
	  player.openInventory(horseSelection);
  }
  
  @SuppressWarnings({ "unchecked", "rawtypes" })
  public static void createHorseMenu(Player player, FantasyHorse fhorse) {
	  String horseName = fhorse.horseName;
	  int horseLevel = fhorse.horseLevel;
	  int slot = fhorse.horseSlot;
	  if(slot == 1) {
		  Inventory horse1Menu = Bukkit.createInventory(player, 9, ChatColor.RED + "Horse 1 Menu");
		  horse1Menu.setItem(0, createGuiItem(" ", new ArrayList(Arrays.asList(new String[] { "" })), Material.GRAY_STAINED_GLASS_PANE));
		  horse1Menu.setItem(1, createGuiItem(" ", new ArrayList(Arrays.asList(new String[] { "" })), Material.GRAY_STAINED_GLASS_PANE));
		  horse1Menu.setItem(2, createGuiItem(" ", new ArrayList(Arrays.asList(new String[] { "" })), Material.GRAY_STAINED_GLASS_PANE));
		  horse1Menu.setItem(3, createGuiItem(ChatColor.LIGHT_PURPLE + "Summon Horse", new ArrayList(Arrays.asList(new String[] { "Click to summon " + horseName })), Material.ENDER_PEARL));
		  horse1Menu.setItem(4, createGuiItem(ChatColor.GREEN + "Upgrade Horse", new ArrayList(Arrays.asList(new String[] { horseName + " is currently level " + horseLevel })), Material.GOLDEN_CARROT));
		  horse1Menu.setItem(5, createGuiItem(ChatColor.DARK_RED + "Remove Horse", new ArrayList(Arrays.asList(new String[] { "Click to ungregister " + horseName })), Material.REDSTONE_BLOCK));
		  horse1Menu.setItem(6, createGuiItem(" ", new ArrayList(Arrays.asList(new String[] { "" })), Material.GRAY_STAINED_GLASS_PANE));
		  horse1Menu.setItem(7, createGuiItem(" ", new ArrayList(Arrays.asList(new String[] { "" })), Material.GRAY_STAINED_GLASS_PANE));
		  horse1Menu.setItem(8, createGuiItem(" ", new ArrayList(Arrays.asList(new String[] { "" })), Material.GRAY_STAINED_GLASS_PANE));
		  player.openInventory(horse1Menu);
	  } else if(slot == 2) {
		  Inventory horse2Menu = Bukkit.createInventory(player, 9, ChatColor.RED + "Horse 2 Menu");
		  horse2Menu.setItem(0, createGuiItem(" ", new ArrayList(Arrays.asList(new String[] { "" })), Material.GRAY_STAINED_GLASS_PANE));
		  horse2Menu.setItem(1, createGuiItem(" ", new ArrayList(Arrays.asList(new String[] { "" })), Material.GRAY_STAINED_GLASS_PANE));
		  horse2Menu.setItem(2, createGuiItem(" ", new ArrayList(Arrays.asList(new String[] { "" })), Material.GRAY_STAINED_GLASS_PANE));
		  horse2Menu.setItem(3, createGuiItem(ChatColor.LIGHT_PURPLE + "Summon Horse", new ArrayList(Arrays.asList(new String[] { "Click to summon " + horseName })), Material.ENDER_PEARL));
		  horse2Menu.setItem(4, createGuiItem(ChatColor.GREEN + "Upgrade Horse", new ArrayList(Arrays.asList(new String[] { horseName + " is currently level " + horseLevel })), Material.GOLDEN_CARROT));
		  horse2Menu.setItem(5, createGuiItem(ChatColor.DARK_RED + "Remove Horse", new ArrayList(Arrays.asList(new String[] { "Click to ungregister " + horseName })), Material.REDSTONE_BLOCK));
		  horse2Menu.setItem(6, createGuiItem(" ", new ArrayList(Arrays.asList(new String[] { "" })), Material.GRAY_STAINED_GLASS_PANE));
		  horse2Menu.setItem(7, createGuiItem(" ", new ArrayList(Arrays.asList(new String[] { "" })), Material.GRAY_STAINED_GLASS_PANE));
		  horse2Menu.setItem(8, createGuiItem(" ", new ArrayList(Arrays.asList(new String[] { "" })), Material.GRAY_STAINED_GLASS_PANE));
		  player.openInventory(horse2Menu);
	  } else if(slot == 3) {
		  Inventory horse3Menu = Bukkit.createInventory(player, 9, ChatColor.RED + "Horse 3 Menu");
		  horse3Menu.setItem(0, createGuiItem(" ", new ArrayList(Arrays.asList(new String[] { "" })), Material.GRAY_STAINED_GLASS_PANE));
		  horse3Menu.setItem(1, createGuiItem(" ", new ArrayList(Arrays.asList(new String[] { "" })), Material.GRAY_STAINED_GLASS_PANE));
		  horse3Menu.setItem(2, createGuiItem(" ", new ArrayList(Arrays.asList(new String[] { "" })), Material.GRAY_STAINED_GLASS_PANE));
		  horse3Menu.setItem(3, createGuiItem(ChatColor.LIGHT_PURPLE + "Summon Horse", new ArrayList(Arrays.asList(new String[] { "Click to summon " + horseName })), Material.ENDER_PEARL));
		  horse3Menu.setItem(4, createGuiItem(ChatColor.GREEN + "Upgrade Horse", new ArrayList(Arrays.asList(new String[] { horseName + " is currently level " + horseLevel })), Material.GOLDEN_CARROT));
		  horse3Menu.setItem(5, createGuiItem(ChatColor.DARK_RED + "Remove Horse", new ArrayList(Arrays.asList(new String[] { "Click to ungregister " + horseName })), Material.REDSTONE_BLOCK));
		  horse3Menu.setItem(6, createGuiItem(" ", new ArrayList(Arrays.asList(new String[] { "" })), Material.GRAY_STAINED_GLASS_PANE));
		  horse3Menu.setItem(7, createGuiItem(" ", new ArrayList(Arrays.asList(new String[] { "" })), Material.GRAY_STAINED_GLASS_PANE));
		  horse3Menu.setItem(8, createGuiItem(" ", new ArrayList(Arrays.asList(new String[] { "" })), Material.GRAY_STAINED_GLASS_PANE));
		  player.openInventory(horse3Menu);
	  }
  }
  
  public static ItemStack createGuiItem(String name, ArrayList<String> desc, Material mat) {
	  ItemStack i = new ItemStack(mat, 1);
	  ItemMeta iMeta = i.getItemMeta();
	  iMeta.setDisplayName(name);
	  iMeta.setLore(desc);
	  i.setItemMeta(iMeta);
	  return i;
  }
}