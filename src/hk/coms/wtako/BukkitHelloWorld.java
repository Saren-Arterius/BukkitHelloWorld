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

	public boolean fuck(CommandSender sender, Player target) {
		if (sender == target) {
			sender.sendMessage("You can not fuck yourself!");
		} else if (sender.hasPermission("fuck.qualifiedToFuck")) {
			target.getWorld().createExplosion(target.getLocation(), 1);
			target.sendMessage("You have just been fucked by "+sender.getName()+"!");
			sender.sendMessage("You have just fucked "+target.getName());
		} else {
			sender.sendMessage("You are not qualified to fuck somebody!");
		}
		return true;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("fuck")) {
			try {
				Player target = (Bukkit.getServer().getPlayer(args[0]));
				return (fuck(sender, target));
			} catch (Exception ex) {
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
