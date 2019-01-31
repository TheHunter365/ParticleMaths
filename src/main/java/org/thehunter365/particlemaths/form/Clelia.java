package org.thehunter365.particlemaths.form;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.scheduler.BukkitRunnable;

public class Clelia extends BukkitRunnable {

    private Location location;

    private double time;
    private int duration;

    public Clelia(Location location) {
        this.location = location;
        this.time = 0;
        this.duration = 20*120;

    }

    @Override
    public void run() {
        for (int i = 0; i < 16; i++) {
            this.time += Math.PI/64;

            double n = 9/4;
            double r = 3;

            double x = r * Math.cos(n*time)*Math.cos(time);
            double y = r*Math.cos(n*time)*Math.sin(time);
            double z = r*Math.sin(n*time);

            this.location.add(y, z, x);
            this.location.getWorld().spawnParticle(Particle.FIREWORKS_SPARK, location, 0);
            this.location.subtract(y, z, x);

        }
        this.duration--;

        if (duration == 0)this.cancel();
    }
}
