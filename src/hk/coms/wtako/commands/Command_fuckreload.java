package hk.coms.wtako.commands;

import hk.coms.wtako.Main;
import hk.coms.wtako.method.Reload;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Command_fuckreload implements CommandExecutor {

    private Main plugin;
    
    public Command_fuckreload(Main plugin) {
        this.plugin = plugin;
    }
    
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("fuckreload")) {
            Reload reload = new Reload(this.plugin);
            reload.execute();
            this.plugin.getLogger().info(this.plugin.getConfig().getString("message.pluginReloadedConsole"));
            if (sender instanceof Player) {
                sender.sendMessage(this.plugin.getConfig().getString("message.pluginReloadedPlayer"));
            }
            return true;
        }
        return false;
    }

}
