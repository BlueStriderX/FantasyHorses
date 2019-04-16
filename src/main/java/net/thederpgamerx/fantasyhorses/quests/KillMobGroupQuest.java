package net.thederpgamerx.fantasyhorses.quests;

import org.bukkit.Location;
import org.bukkit.World;

import me.blackvein.quests.Quest;
import net.citizensnpcs.api.npc.NPC;

public class KillMobGroupQuest extends Quest {
	public static Quest createQuest(NPC questGiver) {
		if(questGiver.isSpawned() == true) {
			Location npcLocation = questGiver.getStoredLocation();
			Location mobSpawnLocation = calculateMobSpawn(npcLocation);
		}
		
		return null;
	}

	private static Location calculateMobSpawn(Location npcLocation) {
		World world = npcLocation.getWorld();
		int maxDistX = 50;
		int maxDistZ = 50;
		int maxDistY = 15;
		int npcX = npcLocation.getBlockX();
		int npcZ = npcLocation.getBlockZ();
		int npcY = npcLocation.getBlockY();
		boolean goodLoc = false;
		while(goodLoc = false) {
			
		}
		
		return mobSpawnLocation;
	}
}
