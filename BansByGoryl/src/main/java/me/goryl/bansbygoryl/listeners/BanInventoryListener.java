package me.goryl.bansbygoryl.listeners;

import me.goryl.bansbygoryl.BansByGoryl;
import me.goryl.bansbygoryl.utils.BanMenuUtils;
import org.bukkit.BanList;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class BanInventoryListener implements Listener {

    public void onMenuClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();

        if (e.getView().getTitle().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', "&c&PLAYER LIST"))) {
            if (e.getCurrentItem().getType() == Material.PLAYER_HEAD) {

                Player whoToBan = BansByGoryl.getPlugin().getServer().getPlayerExact(ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()));
                BanMenuUtils.openConfirmBanMenu(p, whoToBan);
            }

            }else if (e.getView().getTitle().equalsIgnoreCase(ChatColor.DARK_RED + "BAN")){
                switch (e.getCurrentItem().getType()){
                    case BARRIER:
                        BanMenuUtils.openBanMenu(p);
                        break;
                    case WOODEN_AXE:
                        //Get name
                        String name = e.getClickedInventory().getItem(4).getItemMeta().getDisplayName();
                        p.getServer().getBanList(BanList.Type.NAME).addBan(ChatColor.stripColor(name), "BANNED", null, null);
                        p.sendMessage(ChatColor.GREEN + "Banned Player");
                        break;
                }
            }
        e.setCancelled(true);
    }
}
