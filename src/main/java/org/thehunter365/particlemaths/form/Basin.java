package org.thehunter365.particlemaths.form;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.scheduler.BukkitRunnable;

public class Basin extends BukkitRunnable {

    private Location location;

    private double time;
    private double period;
    private int duration;

    public Basin(Location location) {
        this.location = location;

        this.period = 2*Math.PI;
        this.time = 0;
        this.duration = 20*120;

    }

    @Override
    public void run() {
        for (int i = 0; i < 16; i++) {
            this.time += Math.PI/256;

            double n = 12;
            double a = 8;
            double b = 8;

            double x = a*Math.cos(time)*Math.cos(n*time);
            double y = a*Math.sin(time)*Math.cos(n*time);
            double z = b*Math.pow(Math.cos(n*time), 2);

            this.location.add(y, z, x);
            this.location.getWorld().spawnParticle(Particle.FIREWORKS_SPARK, location, 0);
            this.location.subtract(y, z, x);

            if (time > period) this.time = 0;
        }
        this.duration--;

        if (duration == 0)this.cancel();
    }
}
