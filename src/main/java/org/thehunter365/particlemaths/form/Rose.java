package org.thehunter365.particlemaths.form;

import org.bukkit.Location;
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
        return 16;
    }

    @Override
    public double timeInc() {
        return Math.PI/128;
    }

    @Override
    public double getX(double t) {
        double n = 1+t*.2;
        double a = 6+t/6;
        return a * Math.cos(n*t)*Math.cos(t);
    }

    @Override
    public double getY(double t) {
        double n = 1+t*.2;
        double a = 6+t/6;
        return a * Math.cos(n*t)*Math.sin(t);
    }

    @Override
    public double getZ(double t) {
        double n = 1+t*.2;
        double b = 6-t/6;
        return b* Math.cos(n*t);
    }
}
