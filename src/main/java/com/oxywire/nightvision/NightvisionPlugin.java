package com.oxywire.nightvision;

import com.oxywire.nightvision.Commands.NightVision;
import org.bukkit.plugin.java.JavaPlugin;

public final class NightvisionPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
       this.saveDefaultConfig();
       this.getCommand("nightvision").setExecutor(new NightVision(this));

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
