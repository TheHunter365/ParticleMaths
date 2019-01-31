package org.thehunter365.particlemaths.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.thehunter365.particlemaths.ParticleMaths;
import org.thehunter365.particlemaths.epicycloid.EpiCycle;

public class ParticleCommand implements CommandExecutor {

    private ParticleMaths particleMaths;

    public ParticleCommand(ParticleMaths particleMaths) {
        this.particleMaths = particleMaths;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (label.equalsIgnoreCase("particle"))
        if (sender instanceof Player) {
            Player player = (Player) sender;
            new EpiCycle(player).runTaskTimer(particleMaths, 0, 1);
        }
        return false;
    }
}
