package me.keycatchupwhy.pvpplugin;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener{
	
	public static Plugin instance;
	
	public void onEnable() {
		instance = this;
		Bukkit.getServer().getPluginManager().registerEvents(new AllEvents(), this);
		this.getCommand("task").setExecutor(new TaskCommand());
	}

}
