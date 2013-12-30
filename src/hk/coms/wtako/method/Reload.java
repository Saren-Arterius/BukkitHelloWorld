package hk.coms.wtako.method;

import hk.coms.wtako.Main;

public class Reload {
    
    private Main plugin;

    public Reload(Main plugin) {
        this.plugin = plugin;
    }
    
    public boolean execute() {
        this.plugin.saveDefaultConfig();
        this.plugin.getConfig().options().copyDefaults(true);
        this.plugin.reloadConfig();
        return true;
    }

}
