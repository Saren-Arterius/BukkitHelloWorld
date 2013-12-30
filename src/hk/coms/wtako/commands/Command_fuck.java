package hk.coms.wtako.commands;

import java.text.MessageFormat;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import hk.coms.wtako.Main;
import hk.coms.wtako.method.Fuck;

public class Command_fuck implements CommandExecutor {

    private Main plugin;
    private Player target;
    private int power;
    private int times;
    
    public Command_fuck(Main plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        
        if (cmd.getName().equalsIgnoreCase("fuck")) {
            try {
                target = (Bukkit.getServer().getPlayer(args[0]));
                if (target == null) {
                    throw new Exception("Player is offline");
                }
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
                if (!(sender.hasPermission("fuck.allowsLimitsOverriding"))) {
                    if (times > this.plugin.getConfig().getInt("limit.fuckTimes")) {
                        times = this.plugin.getConfig().getInt("limit.fuckTimes");
                    }
                }
            } catch (Exception ex) {
                times = 1;
            }
            
            try {
                power = Integer.parseInt(args[1]);
                if (!(sender.hasPermission("fuck.allowsLimitsOverriding"))) {
                    if (power > this.plugin.getConfig().getInt("limit.fuckPower")) {
                        power = this.plugin.getConfig().getInt("limit.fuckPower");
                    }
                }
            } catch (Exception ex) {
                power = 1;
            }
            
            Fuck victim = new Fuck(target);

            if (target == sender && sender.hasPermission("fuck.allowsSelfFucking")) {
                target.sendMessage(this.plugin.getConfig().getString("message.canFuckSelf"));
                return (victim.execute(power, times));
            } else if (target != sender) {
                String msg1 = this.plugin.getConfig().getString("message.justBeenFucked");
                msg1 = MessageFormat.format(msg1, this.plugin.getName(), times);
                target.sendMessage(msg1);
                
                String msg2 = this.plugin.getConfig().getString("message.justFuckedSomebody");
                msg2 = MessageFormat.format(msg2, this.plugin.getName(), times);
                sender.sendMessage(msg2);
                
                return (victim.execute(power, times));
            } else {
                target.sendMessage(this.plugin.getConfig().getString("message.canNotFuckSelf"));
                return true;
            }
            
        }
        return false;
    }
    
}
