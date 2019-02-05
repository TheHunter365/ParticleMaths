package org.thehunter365.particlemaths.curves;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.thehunter365.particlemaths.math.Curve;

public class Clelia extends Curve {

    private double n;
    private double r;

    public Clelia(Location location) {
        super(location);
        this.n = 9/4;
        this.r = 3;
    }

    @Override
    public int duration() {
        return 120*20;
    }

    @Override
    public int loopPerTicks() {
        return 16;
    }

    @Override
    public double timeInc() {
        return Math.PI/64;
    }

    @Override
    public Particle getParticle() {
        return Particle.FIREWORKS_SPARK;
    }

    @Override
    public double getX(double t) {
        return r * Math.cos(n*t)*Math.cos(t);
    }

    @Override
    public double getY(double t) {
        return r*Math.cos(n*t)*Math.sin(t);
    }

    @Override
    public double getZ(double t) {
        return r*Math.sin(n*t);
    }

    /*private Location location;

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
    }*/
}
