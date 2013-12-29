package hk.coms.wtako;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class BukkitHelloWorld extends JavaPlugin {

	@Override
	public void onEnable() {
		getLogger().info("Hello bloody java world!");
	}
	
	public void onDisable() {
		getLogger().info("Good-bye bloody chalon!");
	}

	public boolean fuck(CommandSender sender, Player target, int radius, int times) {
		if (sender == target && sender.hasPermission("fuck.qualifiedToFuck")) {
			for (int i = 0; i<times; i++) {
				target.getWorld().createExplosion(target.getLocation(), radius);
			}
			target.sendMessage("You are awesome enough to fuck yourself and you just fucked yourself! Woohoo.");
		} else if (sender == target) {
			target.sendMessage("You can not fuck yourself you are not awesome enough!");
		} else {
			for (int i = 0; i<times; i++) {
				target.getWorld().createExplosion(target.getLocation(), radius);
			}
			target.sendMessage("You have just been fucked by "+sender.getName()+" for "+Integer.toString(times)+" times!");
			sender.sendMessage("You have just fucked "+target.getName()+" for "+Integer.toString(times)+" times!");
		}
		return true;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("fuck")) {
			try {
				Player target = (Bukkit.getServer().getPlayer(args[0]));
				try {
					return (fuck(sender, target, Integer.parseInt(args[1]), Integer.parseInt(args[2])));
				} catch (Exception ex1) {
					try {
						return (fuck(sender, target, Integer.parseInt(args[1]), 1));
					} catch (Exception ex2) {
						return (fuck(sender, target, 1, 1));
					}
				}
			} catch (Exception ex3) {
				if (args.length == 0) {
					sender.sendMessage("I don't know which player you wanted to fuck");
				} else {
					sender.sendMessage("The player you wanted to fuck with is offline.");
					return true;
				}
	        } 
		}
		return false;
	}
	
}
