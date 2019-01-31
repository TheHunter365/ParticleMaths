package org.thehunter365.particlemaths.form;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.scheduler.BukkitRunnable;

public class SphericalSinusoid extends BukkitRunnable {
    private Location location;

    private double time;
    private double period;
    private int duration;
    private int a;

    public SphericalSinusoid(Location location) {
        this.location = location;
        a = 8;
        this.period = 2*Math.PI;
        this.time = 0;
        this.duration = 20*120;

    }

    @Override
    public void run() {
        double k = a/12;
        double n = a*a;

        for (int i = 0; i < 64; i++) {
            this.time += Math.PI/256;

            double sqrt = Math.sqrt(1+k*k+Math.pow(Math.cos(n*time), 2));
            double x = a * (Math.cos(time)/sqrt);
            double y = a * (Math.sin(time)/sqrt);
            double z = a * (k*Math.cos(n*time)/sqrt);

            this.location.add(y, z, x);
            this.location.getWorld().spawnParticle(Particle.FIREWORKS_SPARK, location, 0);
            this.location.subtract(y, z, x);

            if (time > period) this.time = 0;
        }
        this.duration--;

        if (duration % 5 == 0)a--;
        if (a == 0) a = 8;
        if (duration == 0)this.cancel();
    }
}
