package org.thehunter365.particlemaths.border;

import org.bukkit.World;
import org.bukkit.WorldBorder;
import org.bukkit.scheduler.BukkitRunnable;

public class WorldBorderTask extends BukkitRunnable {

    private World world;

    public WorldBorderTask(World world) {
        this.world = world;
    }

    @Override
    public void run() {
        WorldBorder border = world.getWorldBorder();
        border.setCenter(world.getSpawnLocation());
        border.setSize(border.getSize()+.1, 20*3600);
    }
}
