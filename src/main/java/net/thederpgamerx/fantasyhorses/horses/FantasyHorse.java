package net.thederpgamerx.fantasyhorses.horses;

import java.util.UUID;
import org.bukkit.Location;
import org.bukkit.entity.Horse;
import org.bukkit.entity.Player;

public class FantasyHorse {
	private UUID horseUUID;
	private UUID playerUUID;
	private Player horseOwner;
	private String horseName;
	private int horseLevel;
	private float horseMaxHealth;
	private float horseHealth;
	private float horseSpeed;
	private float horseJump;
	private Horse.Style horseStyle;
	private Horse.Color horseColor;
	private Location horseLocation;
	private Horse horseEntity;

	public FantasyHorse(Player horseOwner, Horse horseEntity, String horseName) {
		this.horseOwner = horseOwner;
		this.horseEntity = horseEntity;
		this.horseName = horseName;
	}

	public String getStyleString(Horse.Style style) {
		switch(style) {
			case NONE: return "NONE";
			case WHITE: return "WHITE";
			case WHITE_DOTS: return "WHITE_DOTS";
			case WHITEFIELD: return "WHITEFIELD";
			case BLACK_DOTS: return "BLACK_DOTS";
		}
		return null;
	}

	public String getColorString(Horse.Color color) {
		switch(color) {
			case WHITE: return "WHITE";
			case GRAY: return "GRAY";
			case BLACK: return "BLACK";
			case CREAMY: return "CREAMY";
			case CHESTNUT: return "CHESTNUT";
			case BROWN: return "BROWN";
			case DARK_BROWN: return "DARK_BROWN";
		}
		return null;
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

	public Horse.Style getHorseStyle() {
		return horseStyle;
	}

	public void setHorseStyle(Horse.Style horseStyle) {
		this.horseStyle = horseStyle;
	}

	public Horse.Color getHorseColor() {
		return horseColor;
	}

	public void setHorseColor(Horse.Color horseColor) {
		this.horseColor = horseColor;
	}

	public Location getHorseLocation() {
		return horseLocation;
	}

	public void setHorseLocation(Location horseLocation) {
		this.horseLocation = horseLocation;
	}

	public Horse getHorseEntity() {
		return horseEntity;
	}

	public void setHorseEntity(Horse horseEntity) {
		this.horseEntity = horseEntity;
	}
}