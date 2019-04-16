package net.thederpgamerx.fantasyhorses.main;

import org.bukkit.Location;

public class Utilities {
	
	public static int[] getDimensions(Location[] corners) {
	    if (corners.length != 2) throw new IllegalArgumentException("An area needs to be set up by exactly 2 opposite edges!");
	    return new int[] { corners[1].getBlockX() - corners[0].getBlockX() + 1, corners[1].getBlockY() - corners[0].getBlockY() + 1, corners[1].getBlockZ() - corners[0].getBlockZ() + 1 };
	}
	
	public static Location[] normalizeEdges(Location startBlock, Location endBlock) {
	    int xMin, xMax, yMin, yMax, zMin, zMax;
	    if (startBlock.getBlockX() <= endBlock.getBlockX()) {
	        xMin = startBlock.getBlockX();
	        xMax = endBlock.getBlockX();
	    } else {
	        xMin = endBlock.getBlockX();
	        xMax = startBlock.getBlockX();
	    }
	    if (startBlock.getBlockY() <= endBlock.getBlockY()) {
	        yMin = startBlock.getBlockY();
	        yMax = endBlock.getBlockY();
	    } else {
	        yMin = endBlock.getBlockY();
	        yMax = startBlock.getBlockY();
	    }
	    if (startBlock.getBlockZ() <= endBlock.getBlockZ()) {
	        zMin = startBlock.getBlockZ();
	        zMax = endBlock.getBlockZ();
	    } else {
	        zMin = endBlock.getBlockZ();
	        zMax = startBlock.getBlockZ();
	    }
	    return new Location[] { new Location(startBlock.getWorld(), xMin, yMin, zMin), new Location(startBlock.getWorld(), xMax, yMax, zMax) };
	}
}
