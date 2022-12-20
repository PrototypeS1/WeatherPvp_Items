package fr.prototypes1.wpvpitems;

import org.bukkit.plugin.java.JavaPlugin;


public class main extends JavaPlugin {

	@Override
	public void onEnable() {
		System.out.println("§3[WeatherPvP Items]§r The plugin has started.");
		getCommand("items").setExecutor(new CommandItem());
		getServer().getPluginManager().registerEvents(new wpvpitemsListners(), this);
	}
	@Override
	public void onDisable() {
		System.out.println("§3[WeatherPvP Items]§r The plugin has stopped.");
	}
	
}
