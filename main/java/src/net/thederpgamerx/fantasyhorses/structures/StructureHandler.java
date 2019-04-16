package net.thederpgamerx.fantasyhorses.structures;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_13_R2.CraftWorld;
import net.minecraft.server.v1_13_R2.Block;
import net.minecraft.server.v1_13_R2.BlockPosition;
import net.minecraft.server.v1_13_R2.Blocks;
import net.minecraft.server.v1_13_R2.ChunkCoordIntPair;
import net.minecraft.server.v1_13_R2.DefinedStructure;
import net.minecraft.server.v1_13_R2.DefinedStructureInfo;
import net.minecraft.server.v1_13_R2.EnumBlockMirror;
import net.minecraft.server.v1_13_R2.EnumBlockRotation;
import net.minecraft.server.v1_13_R2.NBTCompressedStreamTools;
import net.minecraft.server.v1_13_R2.NBTTagCompound;
import net.minecraft.server.v1_13_R2.WorldServer;
import net.thederpgamerx.fantasyhorses.main.Utilities;

public class StructureHandler {
	
	public static DefinedStructure createSingleStructure(Location corner1, Location corner2, String author) {
	    Location[] normalized = Utilities.normalizeEdges(corner1, corner2);
	    WorldServer world = ((CraftWorld) normalized[0].getWorld()).getHandle();
	    int[] dimensions = Utilities.getDimensions(normalized);
	    if (dimensions[0] > 32 || dimensions[1] > 32 || dimensions[2] > 32) throw new IllegalArgumentException("A single structure can only be 32x32x32!");
	    DefinedStructure structure = new DefinedStructure();
	    structure.a(world, new BlockPosition(normalized[0].getBlockX(), normalized[0].getBlockY(), normalized[0].getBlockZ()), new BlockPosition(dimensions[0], dimensions[1], dimensions[2]), true, Blocks.STRUCTURE_VOID);
	    structure.a(author);
	    return structure;
	}
	
	public static void saveSingleStructure(DefinedStructure structure, String file) throws FileNotFoundException, IOException {
	    NBTTagCompound fileTag = new NBTTagCompound();
	    fileTag = structure.a(fileTag);
	    NBTCompressedStreamTools.a(fileTag, new FileOutputStream(new File(file)));
	}
	
	public static DefinedStructure loadSingleStructure(File source) throws FileNotFoundException, IOException {
	    DefinedStructure structure = new DefinedStructure();
	    structure.b(NBTCompressedStreamTools.a(new FileInputStream(source)));
	    return structure;
	}
	
	public static void insertSingleStructure(DefinedStructure structure, Location startEdge, EnumBlockRotation rotation) {
	    WorldServer world = ((CraftWorld) startEdge.getWorld()).getHandle();
	    DefinedStructureInfo structInfo = new DefinedStructureInfo().a(EnumBlockMirror.NONE).a(rotation).a(false).a((ChunkCoordIntPair) null).a((Block) null).c(false).a(1.0f).a(new Random());
	    structure.a(world, new BlockPosition(startEdge.getBlockX(), startEdge.getBlockY(), startEdge.getBlockZ()), structInfo);
	}
}
