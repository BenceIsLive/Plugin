package dev.bence.tutorial;

import dev.bence.tutorial.Commands.*;
import dev.bence.tutorial.Events.*;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class Tutorial extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println(ChatColor.GREEN + "Plugin enabled");


        // COMMANDS
        getCommand("heal").setExecutor(new HealCommand());
        getCommand("geef").setExecutor(new GiveCommand());
        getCommand("kit").setExecutor(new KitCommand());
        getCommand("menu").setExecutor(new MenuCommand());
        getCommand("stats").setExecutor(new StatsCommand());
        getCommand("vlieg").setExecutor(new FlyCommand());
        getCommand("gamemodes").setExecutor(new GamemodeCommand());
        getCommand("selector").setExecutor(new SelectorCommand());
        getCommand("config").setExecutor(new ConfigCommand(this));

        //EVENTS
        this.getServer().getPluginManager().registerEvents(new TestEvent(), this);
        this.getServer().getPluginManager().registerEvents(new JoinEvent(), this);
        this.getServer().getPluginManager().registerEvents(new LeaveEvent(), this);
        this.getServer().getPluginManager().registerEvents(new InventoryEvent(), this);

        // YML FILES
        getConfig().options().copyDefaults();
        saveDefaultConfig();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println(ChatColor.RED + "Plugin disabled");
    }
}
