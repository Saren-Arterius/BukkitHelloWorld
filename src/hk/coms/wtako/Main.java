package hk.coms.wtako;

import hk.coms.wtako.commands.CommandHandler;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

	public void onEnable() {
	    this.saveDefaultConfig();
	    this.getConfig().options().copyDefaults(true);
	    this.getLogger().info("Hello bloody java world!");
	}
	
	public void onDisable() {
	    this.getLogger().info("Good-bye bloody chalon!");
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        return CommandHandler.onCommand(sender, cmd, label, args);
	}
	 
}
