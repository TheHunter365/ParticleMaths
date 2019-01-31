package org.thehunter365.particlemaths.math;

import org.bukkit.scheduler.BukkitRunnable;

public abstract class Curve extends BukkitRunnable implements ParametricEquation {

    public void run() {

    }

    public abstract int duration();

    public abstract double period();


}
