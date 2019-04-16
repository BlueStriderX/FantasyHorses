package net.thederpgamerx.fantasyhorses.npc;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import me.blackvein.quests.Quest;
import net.citizensnpcs.api.event.NPCRightClickEvent;
import net.citizensnpcs.api.npc.NPC;
import net.thederpgamerx.fantasyhorses.main.Main;

public class NPCManager implements Listener {
	
	@EventHandler
	public static void onNPCRightClickEvent(NPCRightClickEvent e) {
		NPC npc = e.getNPC();
		Player player = e.getClicker();
		if(Main.questNPCs.containsKey(npc)) {
			Quest quest = Main.questNPCs.get(npc);
			if(quest.getName().equals("Kill x7 Zombies for " + npc.getName() + "and you'll get a reward!")) {
				quest.setNpcStart(npc);
			} else if(quest.getName().equals("Kill x7 Skeletons for " + npc.getName() + "and you'll get a reward!")) {
				
			} else if(quest.getName().equals("Kill x1 Witch for " + npc.getName() + "and you'll get a reward!")) {
				
			} else if(quest.getName().equals("Kill x5 Creepers for " + npc.getName() + "and you'll get a reward!")) {
				
			} else if(quest.getName().equals("Kill x5 Spiders for " + npc.getName() + "and you'll get a reward!")) {
				
			} else if(quest.getName().equals("Kill x2 CaveSpiders for " + npc.getName() + "and you'll get a reward!")) {
				
			}
		}
	}
}