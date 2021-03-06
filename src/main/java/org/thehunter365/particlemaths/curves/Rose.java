package org.thehunter365.particlemaths.curves;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.thehunter365.particlemaths.math.Curve;

public class Rose extends Curve {

    public Rose(Location location) {
        super(location);
    }

    @Override
    public int duration() {
        return 30*120;
    }

    @Override
    public int loopPerTicks() {
        return 12;
    }

    @Override
    public double timeInc() {
        return Math.PI/256;
    }

    @Override
    public Particle getParticle() {
        return Particle.FIREWORKS_SPARK;
    }

    @Override
    public double getX(double t) {
        double n = 1+t*.25;
        double a = 6+t/6;
        return a * Math.cos(n*t)*Math.cos(t);
    }

    @Override
    public double getY(double t) {
        double n = 1+t*.25;
        double a = 6+t/6;
        return a * Math.cos(n*t)*Math.sin(t);
    }

    @Override
    public double getZ(double t) {
        double n = 1+t*.25;
        double b = 6-t/6;
        return b* Math.cos(n*t);
    }
}
