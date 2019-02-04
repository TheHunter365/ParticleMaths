package org.thehunter365.particlemaths.curves;

import org.bukkit.Location;
import org.thehunter365.particlemaths.math.Curve;

public class Basin extends Curve {

    double n;
    double a;
    double b;

    public Basin(Location location) {
        super(location);
        this.n = 12;
        this.a = 8;
        this.b = 8;
    }

    @Override
    public int duration() {
        return 20*120;
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
    public double getX(double t) {
        return a*Math.cos(t)*Math.cos(n*t);
    }

    @Override
    public double getY(double t) {
        return a*Math.sin(t)*Math.cos(n*t);
    }

    @Override
    public double getZ(double t) {
        return b*Math.pow(Math.cos(n*t), 2);
    }
}
