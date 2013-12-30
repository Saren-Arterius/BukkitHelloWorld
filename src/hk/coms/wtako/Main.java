package hk.coms.wtako;

import hk.coms.wtako.commands.Command_fuck;
import hk.coms.wtako.commands.Command_fuckreload;

import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

	public void onEnable() {
	    getCommand("fuck").setExecutor(new Command_fuck(this));
	    getCommand("fuckreload").setExecutor(new Command_fuckreload(this));
	        
	    this.saveDefaultConfig();
	    this.getConfig().options().copyDefaults(true);
	    this.getLogger().info("Hello bloody java world!");
	}
	
	public void onDisable() {
	    this.getLogger().info("Good-bye bloody chalon!");
	}
	 
}
