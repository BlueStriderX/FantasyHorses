package net.thederpgamerx.fantasyhorses.structures;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Biome;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.world.ChunkLoadEvent;
import net.minecraft.server.v1_13_R2.DefinedStructure;
import net.minecraft.server.v1_13_R2.EnumBlockRotation;
import net.thederpgamerx.fantasyhorses.main.Main;

public class StableGenerator implements Listener {

	@EventHandler (priority = EventPriority.HIGH)
	public static void onChunkLoadEvent(ChunkLoadEvent e) {
		if(Main.getPlugin().getConfig().getBoolean("enable-stables") == true) {
			if(e.isNewChunk() == true) {
				double stableGenChanceConfig = Main.getPlugin().getConfig().getDouble("stable-gen-chance");
				boolean stableGen = Math.random() < stableGenChanceConfig;
				if(stableGen == true) {
					int spawnX = e.getChunk().getBlock(1, 1, 1).getX();
					int spawnZ = e.getChunk().getBlock(1, 1, 1).getZ();
					Block spawnLocBlock = e.getWorld().getHighestBlockAt(spawnX, spawnZ);
					if(spawnLocBlock.getType().equals(Material.GRASS) || spawnLocBlock.getType().equals(Material.SNOW_BLOCK) || spawnLocBlock.getType().equals(Material.SNOW) || spawnLocBlock.getType().equals(Material.SAND)){
						Location location = spawnLocBlock.getLocation();
						String structuresfolder  = Main.getPlugin().getDataFolder() + "/structures/";
						Biome biome = e.getChunk().getBlock(spawnX, 1, spawnZ).getBiome();
						if(biome.equals(Biome.PLAINS)) {
							File stable = new File(structuresfolder + "plainsStable");
							try {
								DefinedStructure structure = StructureHandler.loadSingleStructure(stable);
								EnumBlockRotation rotation = EnumBlockRotation.NONE;
								StructureHandler.insertSingleStructure(structure, location, rotation);
								StableHandler.generate(location, "plainsStable");
								System.out.println("Horse Stable spawned at " + location.getBlockX() + " " + location.getBlockY() + " " + location.getBlockZ() + " in a plains biome");
							} catch (FileNotFoundException e1) {
								e1.printStackTrace();
							} catch (IOException e1) {
								e1.printStackTrace();
							}
						} else if(biome.equals(Biome.DESERT)) {
							File stable = new File(structuresfolder + "desertStable");
							try {
								DefinedStructure structure = StructureHandler.loadSingleStructure(stable);
								EnumBlockRotation rotation = EnumBlockRotation.NONE;
								StructureHandler.insertSingleStructure(structure, location, rotation);
								StableHandler.generate(location, "desertStable");
								System.out.println("Horse Stable spawned at " + location.getBlockX() + " " + location.getBlockY() + " " + location.getBlockZ() + " in a desert biome");
							} catch (FileNotFoundException e1) {
								e1.printStackTrace();
							} catch (IOException e1) {
								e1.printStackTrace();
							}
						} else if(biome.equals(Biome.SAVANNA)) {
							File stable = new File(structuresfolder + "savannaStable");
							try {
								DefinedStructure structure = StructureHandler.loadSingleStructure(stable);
								EnumBlockRotation rotation = EnumBlockRotation.NONE;
								StructureHandler.insertSingleStructure(structure, location, rotation);
								StableHandler.generate(location, "savannaStable");
								System.out.println("Horse Stable spawned at " + location.getBlockX() + " " + location.getBlockY() + " " + location.getBlockZ() + " in a savanna biome");
							} catch (FileNotFoundException e1) {
								e1.printStackTrace();
							} catch (IOException e1) {
								e1.printStackTrace();
							}
						} else if(biome.equals(Biome.FOREST)) {
							File stable = new File(structuresfolder + "forestStable");
							try {
								DefinedStructure structure = StructureHandler.loadSingleStructure(stable);
								EnumBlockRotation rotation = EnumBlockRotation.NONE;
								StructureHandler.insertSingleStructure(structure, location, rotation);
								StableHandler.generate(location, "forestStable");
								System.out.println("Horse Stable spawned at " + location.getBlockX() + " " + location.getBlockY() + " " + location.getBlockZ() + " in a forest biome");
							} catch (FileNotFoundException e1) {
								e1.printStackTrace();
							} catch (IOException e1) {
								e1.printStackTrace();
							}
						} else if(biome.equals(Biome.BIRCH_FOREST)) {
							File stable = new File(structuresfolder + "birchForestStable");
							try {
								DefinedStructure structure = StructureHandler.loadSingleStructure(stable);
								EnumBlockRotation rotation = EnumBlockRotation.NONE;
								StructureHandler.insertSingleStructure(structure, location, rotation);
								StableHandler.generate(location, "birchForestStable");
								System.out.println("Horse Stable spawned at " + location.getBlockX() + " " + location.getBlockY() + " " + location.getBlockZ() + " in a birch biome");
							} catch (FileNotFoundException e1) {
								e1.printStackTrace();
							} catch (IOException e1) {
								e1.printStackTrace();
							}
						} else if(biome.equals(Biome.SNOWY_TAIGA)) {
							File stable = new File(structuresfolder + "snowyTaigaStable");
							try {
								DefinedStructure structure = StructureHandler.loadSingleStructure(stable);
								EnumBlockRotation rotation = EnumBlockRotation.NONE;
								StructureHandler.insertSingleStructure(structure, location, rotation);
								StableHandler.generate(location, "snowyTaigaStable");
								System.out.println("Horse Stable spawned at " + location.getBlockX() + " " + location.getBlockY() + " " + location.getBlockZ() + " in a snowy taiga biome");
							} catch (FileNotFoundException e1) {
								e1.printStackTrace();
							} catch (IOException e1) {
								e1.printStackTrace();
							}
						} else {
							return;
						}
					}
				}
				else if(stableGen == false) {
					return;
				}
			}
		}
	}
}
