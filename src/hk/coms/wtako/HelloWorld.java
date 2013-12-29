package hk.coms.wtako;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class HelloWorld extends JavaPlugin {

	@Override
	public void onEnable() {
		getLogger().info("Hello bloody java world!");
	}
	
	public void onDisable() {
		getLogger().info("Good-bye bloody chalon!");
	}

	public boolean fuck(CommandSender sender, Player target) {
		if (sender.hasPermission("fuck.qualifiedToFuck")) {
			target.sendMessage("You have just been fucked by "+sender.getName()+"!");
			sender.sendMessage("You have just fucked"+target.getName());
			return true;
		} else {
			sender.sendMessage("You are not qualified to fuck somebody!");
			return false;
		}
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("fuck")) {
			Player target = (Bukkit.getServer().getPlayer(args[0]));
			return (fuck(sender, target));
		}
		return false;
	}
	
}
