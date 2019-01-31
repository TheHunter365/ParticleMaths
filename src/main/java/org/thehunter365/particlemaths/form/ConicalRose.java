package org.thehunter365.particlemaths.form;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.scheduler.BukkitRunnable;

public class ConicalRose extends BukkitRunnable {
    private Location location;

    private double time;
    private int duration;

    public ConicalRose(Location location) {
        this.location = location;
        this.time = 0;
        this.duration = 20*120;
    }

    @Override
    public void run() {
        for (int i = 0; i < 16; i++) {
            this.time += Math.PI/256;

            double n = 1 + time*.2;
            double a = 6 + (time/6);
            double b = 6 - (time/6);

            double x = a * Math.cos(n*time)*Math.cos(time);
            double y = a * Math.cos(n*time)*Math.sin(time);
            double z = b* Math.cos(n*time);

            this.location.add(y, z, x);
            this.location.getWorld().spawnParticle(Particle.FIREWORKS_SPARK, location, 0);
            this.location.subtract(y, z, x);

        }
        this.duration--;

        if (duration == 0)this.cancel();
    }
}
