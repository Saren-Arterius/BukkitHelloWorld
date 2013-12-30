package hk.coms.wtako.method;

import org.bukkit.plugin.java.JavaPlugin;

public class Reload extends JavaPlugin {
    
    public boolean execute() {
        this.saveDefaultConfig();
        this.getConfig().options().copyDefaults(true);
        this.reloadConfig();
        return true;
    }

}
