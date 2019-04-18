package net.thederpgamerx.fantasyhorses.npc;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.inventory.ItemStack;

import net.citizensnpcs.api.event.NPCRightClickEvent;
import net.citizensnpcs.api.npc.NPC;
import net.thederpgamerx.fantasyhorses.horses.HorseGUI;
import net.thederpgamerx.fantasyhorses.main.Main;

public class NPCRightClickManager {
	
	@EventHandler
	public void onNPCRightClickEvent(NPCRightClickEvent e) {
		Player player = e.getClicker();
		NPC npc = e.getNPC();
		if(Main.stableKeepers.contains(npc)) {
			HorseGUI.createHorseSelection(player);
		} else if(Main.stableShopKeepers.contains(npc)) {
			openStableKeepShopGUI(player);
		}
	}
	
	private static void openStableKeepShopGUI(Player player) {
		StableKeepShopGUI shop = new StableKeepShopGUI("Horse Shop");  
		ItemStack goldenCarrot = new ItemStack(Material.GOLDEN_CARROT);
		ItemStack enderPearl = new ItemStack(Material.ENDER_PEARL, 5);
		ItemStack saddle = new ItemStack(Material.SADDLE);
        shop.addTrade(new ItemStack(Material.EMERALD, 5), goldenCarrot);
        shop.addTrade(new ItemStack(Material.EMERALD, 7), saddle);
        shop.addTrade(new ItemStack(Material.EMERALD, 3), enderPearl);
        shop.openTrade(player);
	}
}
