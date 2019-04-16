package net.thederpgamerx.fantasyhorses.npc;

import java.util.ArrayList;
import java.util.UUID;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.player.PlayerTeleportEvent.TeleportCause;
import me.blackvein.quests.Quest;
import net.citizensnpcs.api.ai.GoalController;
import net.citizensnpcs.api.ai.Navigator;
import net.citizensnpcs.api.ai.speech.SpeechController;
import net.citizensnpcs.api.event.DespawnReason;
import net.citizensnpcs.api.event.SpawnReason;
import net.citizensnpcs.api.npc.BlockBreaker;
import net.citizensnpcs.api.npc.BlockBreaker.BlockBreakerConfiguration;
import net.citizensnpcs.api.npc.MetadataStore;
import net.citizensnpcs.api.npc.NPC;
import net.citizensnpcs.api.npc.NPCRegistry;
import net.citizensnpcs.api.trait.Trait;
import net.citizensnpcs.api.util.DataKey;

public class QuestNPC implements NPC {
	
	@Override
	public void addTrait(Class<? extends Trait> var1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addTrait(Trait var1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public NPC clone() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MetadataStore data() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean despawn() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean despawn(DespawnReason var1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void faceLocation(Location var1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public BlockBreaker getBlockBreaker(Block var1, BlockBreakerConfiguration var2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GoalController getDefaultGoalController() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SpeechController getDefaultSpeechController() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Entity getEntity() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getFullName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Navigator getNavigator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NPCRegistry getOwningRegistry() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Location getStoredLocation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T extends Trait> T getTrait(Class<T> var1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Trait> getTraits() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UUID getUniqueId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasTrait(Class<? extends Trait> var1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isFlyable() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isProtected() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isSpawned() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void load(DataKey var1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeTrait(Class<? extends Trait> var1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void save(DataKey var1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setBukkitEntityType(EntityType var1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setFlyable(boolean var1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setName(String var1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setProtected(boolean var1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean spawn(Location var1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean spawn(Location var1, SpawnReason var2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void teleport(Location var1, TeleportCause var2) {
		// TODO Auto-generated method stub
		
	}
	
	public static ArrayList<Quest> questsList = new ArrayList <Quest>();
	
	public ArrayList<Quest> getQuests(Quest[] quests) {
		return questsList;
	}
	
	public void addQuest(Quest quest) {
		questsList.add(quest);
	}
	
	public void removeQuest(Quest quest) {
		questsList.remove(quest);
	}
}
