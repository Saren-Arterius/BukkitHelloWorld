package hk.coms.wtako.BukkitHelloWorld;

import hk.coms.wtako.BukkitHelloWorld.commands.Command_fuck;
import hk.coms.wtako.BukkitHelloWorld.commands.Command_fuckreload;

import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

	public void onEnable() {
	    this.saveDefaultConfig();
	    this.getConfig().options().copyDefaults(true);
	    this.getLogger().info("Hello bloody java world!");
	    
	    getCommand("fuck").setExecutor(new Command_fuck(this));
	    getCommand("fuckreload").setExecutor(new Command_fuckreload(this));
	}
	
	public void onDisable() {
	    this.getLogger().info("Good-bye bloody chalon!");
	}
    
}
