package org.thehunter365.particlemaths.epicycloid;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class EpiCycle extends BukkitRunnable {

    private Player player;

    private double duration;
    private double time;

    public EpiCycle(Player player) {
        this.player = player;
        this.duration = 2*Math.PI;
        this.time = 0;
    }

    @Override
    public void run() {
        if (player == null)cancel();

        for (int i = 0; i < 16; i++) {

            time += Math.PI/256;
            Location location = player.getLocation();

            double y = 2;

            double q = 9;

            double x = ((q-1)*Math.cos(time) + 1/q*Math.cos((q-1)*time));
            double z = ((q-1)*Math.sin(time) + 1/q*Math.sin((q-1)*time));

            location.add(x, y, z);

            player.getWorld().spawnParticle(Particle.FLAME, location, 0);
            location.subtract(x, y, z);
            if (time > duration)this.time = 0;
        }

    }
}



//double x = Math.sin(time) + a * Math.sin(2 * time) + Math.sin(3 * time);
//double z = Math.cos(time) + a * Math.cos(2 * time) + Math.cos(3 * time);

//double z = Math.sin(time) + 4*Math.sin(2*time);

        /*int re = 0;
        int im = 1;

        double expRe = Math.exp(re) * Math.cos(im);
        double expIm = Math.exp(re) * Math.sin(im);

        double x = 0.5*Math.cos(time/2) + Math.cos(time);
        double z = 1.5*Math.sin(time/2) + Math.sin(time);*/
        /* Quadrifolium
        double q = 2;
        double x = 2 * q * Math.pow(Math.sin(time), 2) * Math.cos(time);
        double z = 2 * q * Math.pow(Math.cos(time), 2) * Math.sin(time);
         */
//double x = Math.cos(time) + 2*Math.cos(time+Math.PI/4);