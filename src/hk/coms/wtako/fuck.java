package hk.coms.wtako;

import java.text.MessageFormat;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class fuck {
	
    public BukkitHelloWorld plugin;
	private CommandSender sender;
	private Player target;
    
	public fuck(BukkitHelloWorld plugin, CommandSender sender, Player target) {
		this.sender = sender;
		this.target = target;
		this.plugin = plugin;
	}
	
	public boolean execute(int radius, int times) {
		if (this.sender == this.target && this.sender.hasPermission("fuck.allowsSelfFucking")) {
			for (int i = 0; i<times; i++) {
				this.target.getWorld().createExplosion(this.target.getLocation(), radius);
			}
			this.target.sendMessage(this.plugin.getConfig().getString("message.canFuckSelf"));
		} else if (sender == this.target) {
			this.target.sendMessage(this.plugin.getConfig().getString("message.canNotFuckSelf"));
		} else {
			for (int i = 0; i<times; i++) {
				this.target.getWorld().createExplosion(this.target.getLocation(), radius);
			}
			
			String msg1 = this.plugin.getConfig().getString("message.justBeenFucked");
            msg1 = MessageFormat.format(msg1, this.sender.getName(), Integer.toString(times));
            this.target.sendMessage(msg1);
            
			String msg2 = this.plugin.getConfig().getString("message.justFuckedSomebody");
			msg2 = MessageFormat.format(msg2, this.target.getName(), Integer.toString(times));
			this.sender.sendMessage(msg2);
		}
		return true;
	}
	
}
