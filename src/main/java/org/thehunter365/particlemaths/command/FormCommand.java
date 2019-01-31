package org.thehunter365.particlemaths.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.thehunter365.particlemaths.ParticleMaths;
import org.thehunter365.particlemaths.form.ConicalRose;
import org.thehunter365.particlemaths.form.SphericalSinusoid;

public class FormCommand implements CommandExecutor {

    private ParticleMaths particleMaths;

    public FormCommand(ParticleMaths particleMaths) {
        this.particleMaths = particleMaths;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (label.equalsIgnoreCase("form"))
        if (sender instanceof Player) {
            Player player = (Player) sender;
            new ConicalRose(player.getLocation()).runTaskTimer(particleMaths, 0, 1);

        }
        return false;
    }
}
