package net.thederpgamerx.fantasyhorses.structures;

import java.util.ArrayList;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.event.Listener;
import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.npc.NPC;

public class StableHandler implements Listener {

	public static ArrayList<NPC> NPCs = new ArrayList <NPC>();
	public static void generate(Location location, String stableType) {
		if(stableType == "plainsStable") {
			NPC stableKeeper = CitizensAPI.getNPCRegistry().createNPC(EntityType.PLAYER, "StableKeeper");
			Location stableKeepLoc = null;
			stableKeeper.spawn(stableKeepLoc);
			
		} else if(stableType == "desertStable") {
		
		} else if(stableType == "savannaStable") {
			
		} else if(stableType == "forestStable") {
			
		} else if(stableType == "birchForestStable") {
			
		} else if(stableType == "snowyTaigaStable") {
			
		}
	}

}
