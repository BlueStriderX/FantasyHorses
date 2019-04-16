package net.thederpgamerx.fantasyhorses.structures;

import java.util.ArrayList;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.event.Listener;

import me.blackvein.quests.Quest;
import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.npc.NPC;
import net.thederpgamerx.fantasyhorses.npc.NPCGenerator;

public class StableHandler implements Listener {

	public static ArrayList<NPC> NPCs = new ArrayList <NPC>();
	public static void generate(Location location, String stableType) {
		if(stableType == "plainsStable") {
		} else if(stableType == "desertStable") {
			NPC stableKeeper = CitizensAPI.getNPCRegistry().createNPC(EntityType.PLAYER, "StableKeeper");
			NPCs.add(stableKeeper);
			
			
			Location stableKeepLoc = null;
			stableKeeper.spawn(stableKeepLoc);
			
			
			int max = 5; 
	        int min = 1; 
	        int range = max - min + 1; 
	        int n = (int)(Math.random() * range) + min;
	        for(int i = 0; i >= n; i ++) {
	        	NPC npc = NPCGenerator.generateNPC();
	        	NPCs.add(npc);
	        	int qmax = 3; 
		        int qmin = 1; 
		        int qrange = qmax - qmin + 1; 
	        	int q = (int)(Math.random() * qrange) + qmin;
	        	if(q == 1) {
	        		Quest quest = NPCGenerator.generateQuest(npc, stableType);
	        	} else {
	        		return;
	        	}
	        }
		} else if(stableType == "savannaStable") {
			
		} else if(stableType == "forestStable") {
			
		} else if(stableType == "birchForestStable") {
			
		} else if(stableType == "snowyTaigaStable") {
			
		}
	}

}
