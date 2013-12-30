package hk.coms.wtako;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class BukkitHelloWorld extends JavaPlugin {

	public void onEnable() {
	    this.saveDefaultConfig();
	    this.getConfig().options().copyDefaults(true);
	    this.getLogger().info("Hello bloody java world!");
	}
	
	public void onDisable() {
	    this.getLogger().info("Good-bye bloody chalon!");
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("fuck")) {
			try {
				Player target = (Bukkit.getServer().getPlayer(args[0]));
				fuck pair = new fuck(this, sender, target);
				try {
					return (pair.execute(Integer.parseInt(args[1]), Integer.parseInt(args[2])));
				} catch (Exception ex1) {
					try {
						return (pair.execute(Integer.parseInt(args[1]), 1));
					} catch (Exception ex2) {
						return (pair.execute(1, 1));
					}
				}
			} catch (Exception ex3) {
				if (args.length == 0) {
					sender.sendMessage(getConfig().getString("message.playerNotSpecfied"));
				} else {
					sender.sendMessage(getConfig().getString("message.playerNotFound"));
					return true;
				}
	        } 
		} else if (cmd.getName().equalsIgnoreCase("reloadfuck")) {
		    this.saveDefaultConfig();
	        this.getConfig().options().copyDefaults(true);
		    this.reloadConfig();
		    this.getLogger().info(getConfig().getString("message.pluginReloadedConsole"));
		    if (sender instanceof Player) {
		        sender.sendMessage(getConfig().getString("message.pluginReloadedPlayer"));
		    }
		    return true;
		}
		return false;
	}
	
}
