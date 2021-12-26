package me.goryl.bansbygoryl;

import me.goryl.bansbygoryl.commands.GuiCommand;
import me.goryl.bansbygoryl.listeners.BanInventoryListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class BansByGoryl extends JavaPlugin {

    private static BansByGoryl plugin;

    @Override
    public void onEnable() {

        System.out.println("Enabling BansByGoryl");

        getCommand("ban").setExecutor(new GuiCommand());

        getServer().getPluginManager().registerEvents(new BanInventoryListener(), this);
    }

    @Override
    public void onDisable() {
        System.out.println("Somethings went wrong! Disabling BansByGoryl plugin...");
    }

    public static BansByGoryl getPlugin(){

        return plugin;
    }
}
