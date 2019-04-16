package net.thederpgamerx.fantasyhorses.horses;

import java.util.UUID;
import org.bukkit.Location;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.entity.Player;

public class FantasyHorse {
	public UUID horseUUID;
	public UUID horseOwnerUUID;
	public Player horseOwner;
	public String horseName;
	public double horseMaxHealth;
	public double horseHealth;
	public String horseColor;
	public String horseStyle;
	public int horseSlot;
	public Location horseLocation;
	public int horseLevel;
	public AttributeInstance horseSpeed;
}