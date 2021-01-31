package com.oxywire.nightvision.Commands;

import com.oxywire.nightvision.NightvisionPlugin;
import org.bukkit.ChatColor;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class NightVision implements CommandExecutor {

    private final NightvisionPlugin plugin;

    public NightVision(NightvisionPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (p.hasPotionEffect(PotionEffectType.NIGHT_VISION)) {
                p.removePotionEffect(PotionEffectType.NIGHT_VISION);
                p.playSound(p.getLocation(), Sound.valueOf(plugin.getConfig().getString("settings.sound")), 1, 1);
                p.sendActionBar(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("settings.message.disabled")));
                p.spawnParticle(Particle.valueOf(plugin.getConfig().getString("settings.particle")), p.getLocation().add(0, 1, 0), 10, .5, 0, .5);
            } else {
                p.addPotionEffect((new PotionEffect(PotionEffectType.NIGHT_VISION, 999999, 0, false, false, true)));
                p.playSound(p.getLocation(), Sound.valueOf(plugin.getConfig().getString("settings.sound")), 1, 1);
                p.sendActionBar(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("settings.message.enabled")));
                p.spawnParticle(Particle.valueOf(plugin.getConfig().getString("settings.particle")), p.getLocation().add(0, 1, 0), 10, .5, 0, .5);
            }
        }
        return true;
    }
}
