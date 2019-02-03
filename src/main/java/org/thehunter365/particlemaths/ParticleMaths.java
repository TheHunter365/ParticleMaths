package org.thehunter365.particlemaths;

import org.bukkit.plugin.java.JavaPlugin;
import org.thehunter365.particlemaths.command.BorderCommand;
import org.thehunter365.particlemaths.command.FormCommand;
import org.thehunter365.particlemaths.command.ParticleCommand;

public class ParticleMaths extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("particle").setExecutor(new ParticleCommand(this));
        getCommand("form").setExecutor(new FormCommand(this));
        getCommand("border").setExecutor(new BorderCommand());
    }

    @Override
    public void onDisable() {

    }
}
