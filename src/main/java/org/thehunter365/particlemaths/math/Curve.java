package org.thehunter365.particlemaths.math;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.World;
import org.bukkit.scheduler.BukkitRunnable;

public abstract class Curve extends BukkitRunnable implements ParametricEquation {

    private Location location;

    private World world;

    private int duration;
    private double t;

    public Curve(Location location) {
        this.location = location;

        this.world = location.getWorld();

        this.duration = duration();
        this.t = 0;
    }

    public void run() {

        for (int i = 0; i < loopPerTicks(); i++) {
            t += timeInc();
            double x = getX(t), y = getY(t), z = getZ(t);
            location.add(x, z, y);
            this.world.spawnParticle(Particle.FIREWORKS_SPARK, location, 0);
            location.subtract(x, z, y);
        }
        this.duration--;
        if (duration == 0) this.cancel();
    }

    public abstract int duration();

    public abstract int loopPerTicks();

    public abstract double timeInc();
}
