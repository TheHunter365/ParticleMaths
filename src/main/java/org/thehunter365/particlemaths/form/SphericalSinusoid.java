package org.thehunter365.particlemaths.form;

import org.bukkit.Location;
import org.thehunter365.particlemaths.math.Curve;

public class SphericalSinusoid extends Curve {

    private double a = 8;
    private double k = a/12;
    private double n = a*a;

    public SphericalSinusoid(Location location) {
        super(location);
    }

    @Override
    public int duration() {
        return 120*20;
    }

    @Override
    public int loopPerTicks() {
        return 8;
    }

    @Override
    public double timeInc() {
        return Math.PI/64;
    }

    @Override
    public double getX(double t) {
        double sqrt = Math.sqrt(1+k*k+Math.pow(Math.cos(n*t), 2));
        return a*(Math.cos(t)/sqrt);
    }

    @Override
    public double getY(double t) {
        double sqrt = Math.sqrt(1+k*k+Math.pow(Math.cos(n*t), 2));
        return a * (Math.sin(t)/sqrt);
    }

    @Override
    public double getZ(double t) {
        double sqrt = Math.sqrt(1+k*k+Math.pow(Math.cos(n*t), 2));
        return a * (k*(1/Math.cos(n*t))/sqrt);
    }

}
