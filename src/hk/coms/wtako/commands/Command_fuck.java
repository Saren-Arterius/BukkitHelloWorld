package hk.coms.wtako.commands;

import java.text.MessageFormat;

import hk.coms.wtako.Main;
import hk.coms.wtako.method.Fuck;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Command_fuck extends CommandHandler {

    public Main plugin;
    private Player target;
    private int power;
    private int times;

    public Command_fuck(Main plugin) {
        super(plugin);
        this.plugin = plugin;
    }
    
    public boolean run(CommandSender sender, Command cmd, String label, String[] args) {
        
        if (cmd.getName().equalsIgnoreCase("fuck")) {
            try {
                target = (Bukkit.getServer().getPlayer(args[0]));
            } catch (Exception ex3) {
                if (args.length == 0) {
                    sender.sendMessage(this.plugin.getConfig().getString("message.playerNotSpecfied"));
                    return false;
                } else {
                    sender.sendMessage(this.plugin.getConfig().getString("message.playerNotFound"));
                    return true;
                }
            } 
            
            try {
                times = Integer.parseInt(args[2]);
            } catch (Exception ex) {
                times = 1;
            }
            
            try {
                power = Integer.parseInt(args[1]);
            } catch (Exception ex) {
                power = 1;
            }
            
            Fuck pair = new Fuck(target);

            if (target == sender && sender.hasPermission("fuck.allowsSelfFucking")) {
                target.sendMessage(this.plugin.getConfig().getString("message.canFuckSelf"));
                return (pair.execute(power, times));
            } else if (target != sender) {
                String msg1 = this.plugin.getConfig().getString("message.justBeenFucked");
                msg1 = MessageFormat.format(msg1, this.plugin.getName(), times);
                target.sendMessage(msg1);
                
                String msg2 = this.plugin.getConfig().getString("message.justFuckedSomebody");
                msg2 = MessageFormat.format(msg2, this.plugin.getName(), times);
                sender.sendMessage(msg2);
                
                return (pair.execute(power, times));
            } else {
                target.sendMessage(this.plugin.getConfig().getString("message.canNotFuckSelf"));
                return true;
            }
            
        }
        return false;
    }
    
}
