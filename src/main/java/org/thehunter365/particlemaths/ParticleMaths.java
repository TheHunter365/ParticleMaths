package org.thehunter365.particlemaths;

import org.bukkit.plugin.java.JavaPlugin;
import org.thehunter365.particlemaths.command.FormCommand;
import org.thehunter365.particlemaths.command.ParticleCommand;

public class ParticleMaths extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("particle").setExecutor(new ParticleCommand(this));
        getCommand("curves").setExecutor(new FormCommand(this));
    }

    @Override
    public void onDisable() {

    }
}
