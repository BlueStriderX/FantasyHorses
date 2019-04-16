package net.thederpgamerx.fantasyhorses.npc;

import java.util.ArrayList;
import java.util.Random;
import org.bukkit.Bukkit;
import org.bukkit.entity.EntityType;
import me.blackvein.quests.Quest;
import me.blackvein.quests.Quests;
import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.npc.NPC;

public class NPCGenerator {

	public static NPC generateNPC() {
		ArrayList<String> npcNames = new ArrayList<>();

    	//Possible Names
    	npcNames.add("John");
    	npcNames.add("Samantha");
    	npcNames.add("Sally");
    	npcNames.add("Julia");
    	npcNames.add("Jack");
    	npcNames.add("Alex");
    	npcNames.add("Sarah");
    	npcNames.add("Thomas");
    	npcNames.add("Matt");
    	npcNames.add("Pete");
    	
    	Random randomNameGen = new Random();
        String npcName = npcNames.get(randomNameGen.nextInt(npcNames.size()));
        NPC npc = CitizensAPI.getNPCRegistry().createNPC(EntityType.PLAYER, npcName);
		return npc;
	}
	
	public static Quest generateQuest(NPC npc, String stableType) {
		Quest quest = new Quest();
		Quests qp = (Quests)Bukkit.getServer().getPluginManager().getPlugin("Quests");

		ArrayList<String> questType = new ArrayList<>();
		
		//Possible quest types
		questType.add("killMobs");
		questType.add("killNPC");
		questType.add("gatherItems");
		questType.add("findTreasure");
		questType.add("findNPC");
		questType.add("explore");
		questType.add("killMobGroup");
		
		Random randomQuestTypeGen = new Random();
        String randomQuestType = questType.get(randomQuestTypeGen.nextInt(questType.size()));
        
        if(randomQuestType == "killMobs") {        	
        	ArrayList<String> questKill = new ArrayList<>();
        	
        	//Quest Kills
        	questKill.add("x7 Zombies");
        	questKill.add("x7 Skeletons");
        	questKill.add("x1 Witch");
        	questKill.add("x5 Creepers");
        	questKill.add("x5 Spiders");
        	questKill.add("x2 CaveSpiders");
        	
        	Random questKillRandomGen = new Random();
            String questKillRandom = questKill.get(questKillRandomGen.nextInt(questKill.size()));
            
            if(questKillRandom == "x7 Zombies") {
            	
            } else if(questKillRandom == "x7 Skeletons") {
            	
            } else if(questKillRandom == "x1 Witch") {
            	
            } else if(questKillRandom == "x5 Creepers") {
            	            	
            } else if(questKillRandom == "x5 Spiders") {
            	
            } else if(questKillRandom == "x2 CaveSpiders") {
            	
            }
        	
        } else if(randomQuestType == "killNPC") {
        	
        } else if(randomQuestType == "gatherItems") {
        	
        } else if(randomQuestType == "findTreasure") {
        	
        } else if(randomQuestType == "findNPC") {
        	
        } else if(randomQuestType == "explore") {
        	
        } else if(randomQuestType == "killMobGroup") {
        	
        }
		
		quest.setNpcStart(npc);
		return quest;
		
	}
}
