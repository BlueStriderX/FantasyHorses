package net.wesjd.anvilgui.version;

import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public interface VersionWrapper {

    int getNextContainerId(Player player);
    void handleInventoryCloseEvent(Player player);
    void sendPacketOpenWindow(Player player, int containerId);
    void sendPacketCloseWindow(Player player, int containerId);
    void setActiveContainerDefault(Player player);
    void setActiveContainer(Player player, Object container);
    void setActiveContainerId(Object container, int containerId);
    void addActiveContainerSlotListener(Object container, Player player);
    Inventory toBukkitInventory(Object container);
    Object newContainerAnvil(Player player);
}
