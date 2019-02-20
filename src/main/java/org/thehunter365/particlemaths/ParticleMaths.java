package org.thehunter365.particlemaths;

import org.bukkit.plugin.java.JavaPlugin;
import org.thehunter365.particlemaths.command.FormCommand;
import org.thehunter365.particlemaths.command.ParticleCommand;
import org.thehunter365.particlemaths.data.CurvesManager;
import org.thehunter365.particlemaths.json.JsonManager;

public class ParticleMaths extends JavaPlugin {


    private JsonManager jsonManager;
    private CurvesManager curvesManager;

    @Override
    public void onEnable() {
        getCommand("particle").setExecutor(new ParticleCommand(this));
        getCommand("curves").setExecutor(new FormCommand(this));

        this.jsonManager = new JsonManager();
        this.curvesManager = new CurvesManager(jsonManager, this.getDataFolder());

        this.curvesManager.loadCurves();
    }

    @Override
    public void onDisable() {

    }
}
