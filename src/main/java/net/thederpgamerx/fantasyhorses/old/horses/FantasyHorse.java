package net.thederpgamerx.fantasyhorses.old.horses;

import java.util.Arrays;
import java.util.UUID;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Horse;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

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
	private ItemStack horseIcon;

	public FantasyHorse(Player horseOwner, Horse horseEntity, String horseName) {
		this.horseOwner = horseOwner;
		this.horseEntity = horseEntity;
		this.horseName = horseName;
		horseIcon = new ItemStack(Material.CARROT, 1);
	}

	public String getStyleString(Horse.Style style) {
		switch(style) {
			case NONE: return "None";
			case WHITE: return "White";
			case WHITE_DOTS: return "White Dots";
			case WHITEFIELD: return "Whitefield";
			case BLACK_DOTS: return "Black Dots";
		}
		return null;
	}

	public String getColorString(Horse.Color color) {
		switch(color) {
			case WHITE: return "White";
			case GRAY: return "Gray";
			case BLACK: return "Black";
			case CREAMY: return "Creamy";
			case CHESTNUT: return "Chestnut";
			case BROWN: return "Brown";
			case DARK_BROWN: return "Dark Brown";
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

	public ItemStack getHorseIcon() {
		return horseIcon;
	}

	public void setHorseIcon(Material material) {
		ItemStack newIcon = new ItemStack(material, horseLevel);
		ItemMeta newIconMeta = newIcon.getItemMeta();
		newIconMeta.setDisplayName(ChatColor.AQUA + horseName);
		newIconMeta.setLore(Arrays.asList(
				"Location: (" + horseLocation.getBlockX() + "," + horseLocation.getBlockY() + "," + horseLocation.getBlockZ() + ")",
				"Level: " + horseLevel,
				"Health: " + horseHealth + " / " + horseMaxHealth,
				"Speed: " + (int) horseSpeed,
				"Jump: " + (int) horseJump
		));
		newIcon.setItemMeta(newIconMeta);
	}
}