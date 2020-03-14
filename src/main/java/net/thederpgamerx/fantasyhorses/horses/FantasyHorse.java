package net.thederpgamerx.fantasyhorses.horses;

import java.util.UUID;
import org.bukkit.Location;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.entity.Player;

public class FantasyHorse {
	private UUID horseUUID;
	private UUID playerUUID;
	private Player horseOwner;
	private String horseName;
	private double horseMaxHealth;
	private double horseHealth;
	private String horseStyle;
	private String horseColor;
	private Location horseLocation;
	private int horseLevel;
	private AttributeInstance horseSpeed;

	public FantasyHorse(UUID horseUUID, UUID playerUUID, Player horseOwner, double horseMaxHealth, double horseHealth, String horseStyle, String horseColor, Location horseLocation, int horseLevel, AttributeInstance horseSpeed) {
		this.horseUUID = horseUUID;
		this.playerUUID = playerUUID;
		this.horseOwner = horseOwner;
		this.horseMaxHealth = horseMaxHealth;
		this.horseHealth = horseHealth;
		this.horseColor = horseColor;
		this.horseStyle = horseStyle;
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

	public UUID getPlayerUUID() {
		return playerUUID;
	}

	public void setPlayerUUID(UUID playerUUID) {
		this.playerUUID = playerUUID;
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