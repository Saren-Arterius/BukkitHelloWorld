package hk.coms.wtako.BukkitHelloWorld.methods;

import org.bukkit.entity.Player;

public class Fuck {

    private Player target;
    
    public Fuck(Player target) {
        this.target = target;
    }
    
    public boolean execute(int radius, int times) {
        for (int i = 0; i<times; i++) {
            this.target.getWorld().createExplosion(this.target.getLocation(), radius);
        }
        return true;
    }
}
