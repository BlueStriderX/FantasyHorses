package net.thederpgamerx.fantasyhorses.quests.objectives;

import java.util.Map;
import java.util.UUID;
import org.bukkit.Bukkit;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import me.blackvein.quests.Quests;
import net.thederpgamerx.fantasyhorses.main.Main;

public class KillTracker implements Listener {
	@EventHandler
	public void onEntityDeathEvent(EntityDeathEvent event) {
		LivingEntity entity = event.getEntity();
		Quests qp = (Quests)Bukkit.getServer().getPluginManager().getPlugin("Quests");
		if(entity.getType() == EntityType.ZOMBIE) {
			if(entity.getKiller() instanceof Player) {
				UUID playerUUID = entity.getKiller().getUniqueId();
				if(Main.killMobsObjective.containsKey(playerUUID)) {
					
				}
			} else {
				return;
			}
		} else if(entity.getType() == EntityType.SKELETON) {
			
		} else if(entity.getType() == EntityType.WITCH) {
			
		} else if(entity.getType() == EntityType.CREEPER) {
			
		} else if(entity.getType() == EntityType.SPIDER) {
			
		} else if(entity.getType() == EntityType.CAVE_SPIDER) {
			
		}
	}
}
