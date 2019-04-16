package net.thederpgamerx.fantasyhorses.quests;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;

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
		int maxDistX = 100;
		int minDistX = -100;
		int maxDistZ = 100;
		int minDistZ = -100;
        int xrange = maxDistX - minDistX + 1;
        int zrange = maxDistZ - minDistZ + 1;
		int npcX = npcLocation.getBlockX();
		int npcZ = npcLocation.getBlockZ();
		boolean goodLoc = false;
		while(goodLoc = false) {
	        int x = (int)(Math.random() * xrange) + minDistX;
	        int z = (int)(Math.random() * zrange) + minDistZ;
	        int locX = npcLocation.getBlockX() - x;
	        int locZ = npcLocation.getBlockZ() - z;
	        int locY = world.getHighestBlockYAt(locX, locZ) + 1;
	        Block testBlock = world.getBlockAt(locX, locY, locZ);
	        
		}
		
		return mobSpawnLocation;
	}
}
