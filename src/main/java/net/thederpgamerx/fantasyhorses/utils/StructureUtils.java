package net.thederpgamerx.fantasyhorses.utils;

import org.bukkit.Location;

/**
 * StructureUtils.java
 * <Description>
 * ================================
 * Created: 12/19/2020
 * Author: TheDerpGamerX
 */
public class StructureUtils {

    public static DefinedStructure createSingleStructure(Location[] corners, String author) {
        if (corners.length != 2) throw new IllegalArgumentException("An area needs to be set up by exactly 2 opposite edges!");
        Location[] normalized = StructureService.normalizeEdges(corners[0], corners[1]); // find this method at the end of the tutorial
        // ^^ This is juggling the coordinates, so the first is the Corner with lowest x, y, z and the second has the highest x, y, z.
        WorldServer world = ((CraftWorld) normalized[0].getWorld()).getHandle();
        int[] dimensions = StructureService.getDimensions(normalized); // find this method at the end of the tutorial
        if (dimensions[0] > 32 || dimensions[1] > 32 || dimensions[2] > 32) throw new IllegalArgumentException("A single structure can only be 32x32x32!");
        DefinedStructure structure = new DefinedStructure();
        structure.a(world, new BlockPosition(normalized[0].getBlockX(), normalized[0].getBlockY(), normalized[0].getBlockZ()), new BlockPosition(dimensions[0], dimensions[1], dimensions[2]), true, Blocks.STRUCTURE_VOID);
        structure.a(author); // may not be saved to file anymore since 1.13
        return structure;
    }
}
