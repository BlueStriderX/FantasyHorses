package net.thederpgamerx.fantasyhorses.quests;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import me.blackvein.quests.Quest;
import net.citizensnpcs.api.npc.NPC;
import net.thederpgamerx.fantasyhorses.main.Main;

public class KillMobGroupQuest extends Quest {
	public static Quest createQuest(NPC questGiver, EntityType targets, Player player) {
		if(questGiver.isSpawned() == true) {
			Location npcLocation = questGiver.getStoredLocation();
			Location mobSpawnLocation = calculateMobSpawn(npcLocation);
			World world = mobSpawnLocation.getWorld();
			if(targets.equals(EntityType.ZOMBIE)) {
				int max = 10;
				int min = 5;
				int range = max - min + 1;
				int targetNum = (int)(Math.random() * range) + min;
				for(int i = 1; i >= targetNum; i ++) {
					Entity e = world.spawnEntity(mobSpawnLocation, EntityType.ZOMBIE);
					Main.killMobGroupQuest.put(player.getUniqueId(), e.getUniqueId());
				}
			} else if(targets.equals(EntityType.SKELETON)) {
				int max = 10;
				int min = 5;
				int range = max - min + 1;
				int targetNum = (int)(Math.random() * range) + min;
				for(int i = 1; i >= targetNum; i ++) {
					Entity e = world.spawnEntity(mobSpawnLocation, EntityType.SKELETON);
					Main.killMobGroupQuest.put(player.getUniqueId(), e.getUniqueId());
				}
			} else if(targets.equals(EntityType.WITCH)) {
				Entity e = world.spawnEntity(mobSpawnLocation, EntityType.WITCH);
				Main.killMobGroupQuest.put(player.getUniqueId(), e.getUniqueId());
			} else if(targets.equals(EntityType.SKELETON)) {
				int max = 7;
				int min = 3;
				int range = max - min + 1;
				int targetNum = (int)(Math.random() * range) + min;
				for(int i = 1; i >= targetNum; i ++) {
					Entity e = world.spawnEntity(mobSpawnLocation, EntityType.CREEPER);
					Main.killMobGroupQuest.put(player.getUniqueId(), e.getUniqueId());
				}
			} else if(targets.equals(EntityType.SPIDER)) {
				int max = 7;
				int min = 3;
				int range = max - min + 1;
				int targetNum = (int)(Math.random() * range) + min;
				for(int i = 1; i >= targetNum; i ++) {
					Entity e = world.spawnEntity(mobSpawnLocation, EntityType.SPIDER);
					Main.killMobGroupQuest.put(player.getUniqueId(), e.getUniqueId());
				}
				
			} else if(targets.equals(EntityType.CAVE_SPIDER)) {
				int max = 5;
				int min = 1;
				int range = max - min + 1;
				int targetNum = (int)(Math.random() * range) + min;
				for(int i = 1; i >= targetNum; i ++) {
					Entity e = world.spawnEntity(mobSpawnLocation, EntityType.CAVE_SPIDER);
					Main.killMobGroupQuest.put(player.getUniqueId(), e.getUniqueId());
				}
			}
			
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
		boolean goodLoc = false;
		while(goodLoc = false) {
	        int x = (int)(Math.random() * xrange) + minDistX;
	        int z = (int)(Math.random() * zrange) + minDistZ;
	        int locX = npcLocation.getBlockX() - x;
	        int locZ = npcLocation.getBlockZ() - z;
	        int locY = world.getHighestBlockYAt(locX, locZ) + 1;
	        Block testBlock = world.getBlockAt(locX, locY, locZ);
	        if(testBlock.getType().equals(Material.AIR)) {
	        	Block test1 = world.getBlockAt(locX - 1, locY, locZ + 1);
	        	Block test2 = world.getBlockAt(locX - 1, locY, locZ);
	        	Block test3 = world.getBlockAt(locX - 1, locY, locZ - 1);
	        	Block test4 = world.getBlockAt(locX, locY, locZ + 1);
	        	Block test5 = world.getBlockAt(locX, locY, locZ - 1);
	        	Block test6 = world.getBlockAt(locX + 1, locY, locZ + 1);
	        	Block test7 = world.getBlockAt(locX + 1, locY, locZ);
	        	Block test8 = world.getBlockAt(locX + 1, locY, locZ - 1);
	        	if(test1.getType() == Material.AIR && test2.getType() == Material.AIR && test3.getType() == Material.AIR && test4.getType() == Material.AIR && test5.getType() == Material.AIR && test6.getType() == Material.AIR && test7.getType() == Material.AIR && test8.getType() == Material.AIR) {
	        		goodLoc = true;
	        		return testBlock.getLocation();
	        	} else {
	        		goodLoc = false;
	        	}
	        }
		}
		return null;
	}
}
