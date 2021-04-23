package net.thederpgamerx.fantasyhorses.horse;

import net.thederpgamerx.fantasyhorses.data.HorseData;
import net.thederpgamerx.fantasyhorses.data.StableData;
import net.thederpgamerx.fantasyhorses.utils.DataUtils;
import net.thederpgamerx.fantasyhorses.utils.SerializationUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Horse;

import java.util.UUID;

/**
 * FantasyHorse.java
 * <Description>
 * ================================
 * Created: 12/19/2020
 * Author: TheDerpGamerX
 */
public class FantasyHorse {

    private String horseId;

    public FantasyHorse() {

    }

    public HorseData getData() {
        return DataUtils.getHorseFromId(horseId);
    }

    public Horse getHorseEntity() {
        return (Horse) Bukkit.getEntity(UUID.fromString(getData().entityId));
    }



    public StableData getLastStable() {
        return DataUtils.getStableFromId(getData().lastStableId);
    }
}
