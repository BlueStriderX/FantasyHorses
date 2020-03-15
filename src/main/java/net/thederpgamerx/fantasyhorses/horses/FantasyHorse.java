package net.thederpgamerx.fantasyhorses.horses;

import java.util.UUID;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class FantasyHorse {
	private UUID horseUUID;
	private UUID playerUUID;
	private Player horseOwner;
	private String horseName;
	private float horseMaxHealth;
	private float horseHealth;
	private String horseStyle;
	private String horseColor;
	private Location horseLocation;
	private int horseLevel;
	private float horseSpeed;
	private float horseJump;

	public FantasyHorse(UUID horseUUID, UUID playerUUID, Player horseOwner, float horseMaxHealth, float horseHealth, String horseStyle, String horseColor, Location horseLocation, int horseLevel, float horseSpeed, float horseJump) {
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
		this.horseJump = horseJump;
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

	public float getHorseMaxHealth() {
		return horseMaxHealth;
	}

	public void setHorseMaxHealth(float horseMaxHealth) {
		this.horseMaxHealth = horseMaxHealth;
	}

	public float getHorseHealth() {
		return horseHealth;
	}

	public void setHorseHealth(float horseHealth) {
		this.horseHealth = horseHealth;
	}

	public float getHorseSpeed() {
		return horseSpeed;
	}

	public void setHorseSpeed(float horseSpeed) {
		this.horseSpeed = horseSpeed;
	}

	public float getHorseJump() {
		return horseJump;
	}

	public void setHorseJump(float horseJump) {
		this.horseJump = horseJump;
	}
}