package net.wesjd.anvilgui;

import net.wesjd.anvilgui.version.VersionMatcher;
import net.wesjd.anvilgui.version.VersionWrapper;
import org.apache.commons.lang.Validate;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import java.util.function.BiFunction;

public class AnvilGUI {

    private static VersionWrapper WRAPPER = new VersionMatcher().match();
    private final Player holder;
    private final ItemStack insert;
    private final BiFunction<Player, String, String> biFunction;
    private final int containerId;
    private final Inventory inventory;
    private final ListenUp listener = new ListenUp();
    private boolean open;

    public AnvilGUI(Plugin plugin, Player holder, String insert, BiFunction<Player, String, String> biFunction) {
        this.holder = holder;
        this.biFunction = biFunction;

        final ItemStack paper = new ItemStack(Material.PAPER);
        final ItemMeta paperMeta = paper.getItemMeta();
        paperMeta.setDisplayName(insert);
        paper.setItemMeta(paperMeta);
        this.insert = paper;

        WRAPPER.handleInventoryCloseEvent(holder);
        WRAPPER.setActiveContainerDefault(holder);

        Bukkit.getPluginManager().registerEvents(listener, plugin);

        final Object container = WRAPPER.newContainerAnvil(holder);

        inventory = WRAPPER.toBukkitInventory(container);
        inventory.setItem(Slot.INPUT_LEFT, this.insert);

        containerId = WRAPPER.getNextContainerId(holder);
        WRAPPER.sendPacketOpenWindow(holder, containerId);
        WRAPPER.setActiveContainer(holder, container);
        WRAPPER.setActiveContainerId(container, containerId);
        WRAPPER.addActiveContainerSlotListener(container, holder);

        open = true;
    }

    public void closeInventory() {
        Validate.isTrue(open, "You can't close an inventory that isn't open!");
        open = false;

        WRAPPER.handleInventoryCloseEvent(holder);
        WRAPPER.setActiveContainerDefault(holder);
        WRAPPER.sendPacketCloseWindow(holder, containerId);

        HandlerList.unregisterAll(listener);
    }

    public Inventory getInventory() {
        return inventory;
    }

    private class ListenUp implements Listener {

        @EventHandler
        public void onInventoryClick(InventoryClickEvent e) {
            if(e.getInventory().equals(inventory)) {
                e.setCancelled(true);
                final Player clicker = (Player) e.getWhoClicked();
                if(e.getRawSlot() == Slot.OUTPUT) {
                    final ItemStack clicked = inventory.getItem(e.getRawSlot());
                    if(clicked == null || clicked.getType() == Material.AIR) return;
                    final String ret = biFunction.apply(clicker, clicked.hasItemMeta() ? clicked.getItemMeta().getDisplayName() : clicked.getType().toString());
                    if(ret != null) {
                        final ItemMeta meta = clicked.getItemMeta();
                        meta.setDisplayName(ret);
                        clicked.setItemMeta(meta);
                        inventory.setItem(e.getRawSlot(), clicked);
                    } else closeInventory();
                }
            }
        }

        @EventHandler
        public void onInventoryClose(InventoryCloseEvent e) {
            if(open && e.getInventory().equals(inventory)) closeInventory();
        }

    }

    public static class Slot {

        public static final int INPUT_LEFT = 0;
        public static final int INPUT_RIGHT = 1;
        public static final int OUTPUT = 2;

    }

}
