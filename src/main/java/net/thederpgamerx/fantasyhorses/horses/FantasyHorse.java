package net.thederpgamerx.fantasyhorses.horses;

import java.util.UUID;
import org.bukkit.Location;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.entity.Player;

public class FantasyHorse {
	private UUID horseUUID;
	private Player horseOwner;
	private String horseName;
	private double horseMaxHealth;
	private double horseHealth;
	private String horseColor;
	private String horseStyle;
	private int horseSlot;
	private Location horseLocation;
	private int horseLevel;
	private AttributeInstance horseSpeed;

	public FantasyHorse(UUID horseUUID, Player horseOwner, double horseMaxHealth, double horseHealth, String horseColor, String horseStyle, int horseSlot, Location horseLocation, int horseLevel, AttributeInstance horseSpeed) {
		this.horseUUID = horseUUID;
		this.horseOwner = horseOwner;
		this.horseMaxHealth = horseMaxHealth;
		this.horseHealth = horseHealth;
		this.horseColor = horseColor;
		this.horseStyle = horseStyle;
		this.horseSlot = horseSlot;
		this.horseLocation = horseLocation;
		this.horseLevel = horseLevel;
		this.horseSpeed = horseSpeed;
	}

	public UUID getHorseUUID() {
		return horseUUID;
	}

	public void setHorseUUID(UUID horseUUID) {
		this.horseUUID = horseUUID;
	}

	public Player getHorseOwner() {
		return horseOwner;
	}

	public void setHorseOwner(Player horseOwner) {
		this.horseOwner = horseOwner;
	}

	public String getHorseName() {
		return horseName;
	}

	public void setHorseName(String horseName) {
		this.horseName = horseName;
	}

	public double getHorseMaxHealth() {
		return horseMaxHealth;
	}

	public void setHorseMaxHealth(double horseMaxHealth) {
		this.horseMaxHealth = horseMaxHealth;
	}

	public double getHorseHealth() {
		return horseHealth;
	}

	public void setHorseHealth(double horseHealth) {
		this.horseHealth = horseHealth;
	}

	public String getHorseColor() {
		return horseColor;
	}

	public void setHorseColor(String horseColor) {
		this.horseColor = horseColor;
	}

	public String getHorseStyle() {
		return horseStyle;
	}

	public void setHorseStyle(String horseStyle) {
		this.horseStyle = horseStyle;
	}

	public int getHorseSlot() {
		return horseSlot;
	}

	public void setHorseSlot(int horseSlot) {
		this.horseSlot = horseSlot;
	}

	public Location getHorseLocation() {
		return horseLocation;
	}

	public void setHorseLocation(Location horseLocation) {
		this.horseLocation = horseLocation;
	}

	public int getHorseLevel() {
		return horseLevel;
	}

	public void setHorseLevel(int horseLevel) {
		this.horseLevel = horseLevel;
	}

	public AttributeInstance getHorseSpeed() {
		return horseSpeed;
	}

	public void setHorseSpeed(AttributeInstance horseSpeed) {
		this.horseSpeed = horseSpeed;
	}
}