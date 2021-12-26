package me.goryl.bansbygoryl.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class BanMenuUtils {

    public static void openBanMenu(Player p){

        ArrayList<Player> list = new ArrayList<>(p.getServer().getOnlinePlayers());

        Inventory ban = Bukkit.createInventory(p,45, ChatColor.translateAlternateColorCodes('&', "&c&lONLINE PLAYERS"));

        for (Player player : list) {

            ItemStack playerHead = new ItemStack(Material.PLAYER_HEAD, 1);
            ItemMeta meta = playerHead.getItemMeta();

            meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&8" + player.getDisplayName()));
            ArrayList<String> lore = new ArrayList<>();
            lore.add(ChatColor.GREEN + "Player Health: " + ChatColor.RED + player.getHealth());
            lore.add(ChatColor.GOLD + "Player ping: " + ChatColor.RED + player.getPing());
            lore.add(ChatColor.AQUA + "Player EXP: " + ChatColor.RED + player.getExp());
            lore.add(ChatColor.BLUE + "Player UUID: " + ChatColor.RED + player.getUniqueId());
            meta.setLore(lore);
            playerHead.setItemMeta(meta);

            ban.addItem(playerHead);

        }
        p.openInventory(ban);
    }
    public static void openConfirmBanMenu(Player p, Player whoToBan){
        //Player to be banned
        Player toBan = whoToBan;

        //Open up ban menu
        Inventory banPlayerMenu = Bukkit.createInventory(p, 9, "BAN");

        //Ban Option
        ItemStack ban = new ItemStack(Material.WOODEN_AXE, 1);
        ItemMeta ban_meta = ban.getItemMeta();
        ban_meta.setDisplayName(ChatColor.DARK_GREEN + "COFIRM");
        ban.setItemMeta(ban_meta);
        banPlayerMenu.setItem(0, ban);

        //Add player
        ItemStack playerHead = new ItemStack(Material.PLAYER_HEAD, 1);
        ItemMeta player_meta = playerHead.getItemMeta();
        player_meta.setDisplayName(toBan.getDisplayName());
        playerHead.setItemMeta(player_meta);
        banPlayerMenu.setItem(4, playerHead);

        //Cancel option
        ItemStack cancel = new ItemStack(Material.BARRIER, 1);
        ItemMeta cancel_meta = cancel.getItemMeta();
        cancel_meta.setDisplayName(ChatColor.RED + "CANCEL");
        cancel.setItemMeta(cancel_meta);
        banPlayerMenu.setItem(8, cancel);

        p.openInventory(banPlayerMenu);
    }
}
