package net.thederpgamerx.fantasyhorses.quests.objectives;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import me.blackvein.quests.CustomObjective;
import me.blackvein.quests.Quests;
import net.citizensnpcs.api.npc.NPC;

public class KillMobGroupObjective extends CustomObjective implements Listener {
	
	Quests qp = (Quests)Bukkit.getServer().getPluginManager().getPlugin("Quests");
	public KillMobGroupObjective(int mobcount, String mobType, NPC npcQuestGiver) {
		this.setShowCount(true);
        this.setName("Kill " + mobcount + " " + mobType + " for " + npcQuestGiver.getName() + " and you'll get a reward!");
        this.setDisplay("Kill " + mobcount + " " + mobType + " for " + npcQuestGiver.getName() + " and you'll get a reward!");
        this.setCount(mobcount);
        this.addStringPrompt("Item Name", "Enter the name of the item that the player must drop", "DIRT");
	}
}
