package hk.coms.wtako.commands;

import hk.coms.wtako.Main;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class CommandHandler {

    public Main plugin;
    
    public CommandHandler(Main plugin) {
        this.plugin = plugin;
    }
    
    public static boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        // TODO Auto-generated method stub
        return false;
    }

}
