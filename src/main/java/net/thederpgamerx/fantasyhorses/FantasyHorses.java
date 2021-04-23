package net.thederpgamerx.fantasyhorses;

import org.bukkit.plugin.java.JavaPlugin;

/**
 * FantasyHorses.java
 * <Description>
 * ================================
 * Created: 12/19/2020
 * Author: TheDerpGamerX
 */
public final class FantasyHorses extends JavaPlugin {

    private static FantasyHorses plugin;
    private final String NAME = "FantasyHorses";
    private final String VERSION = "0.11.1";
    private final String AUTHOR = "TheDerpGamerX";

    @Override
    public void onEnable() {
        plugin = this;

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static FantasyHorses getPlugin() {
        return plugin;
    }
}
