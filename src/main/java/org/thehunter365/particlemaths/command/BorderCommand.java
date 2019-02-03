package org.thehunter365.particlemaths.command;

import org.bukkit.World;
import org.bukkit.WorldBorder;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BorderCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (label.equalsIgnoreCase("border"))
        if (sender instanceof Player) {
            if (args.length == 1) {
                String param = args[0];
                Player player = (Player) sender;
                World world = player.getWorld();
                WorldBorder border = world.getWorldBorder();
                border.setCenter(player.getLocation());
                border.setSize(128);

                double size = 0;

                switch (param) {
                    case "green":
                        size = border.getSize()+.1;
                        break;
                    case "red":
                        size = border.getSize()-.1;
                        break;
                    case "reset":
                        border.reset();
                        break;
                        default:size = border.getSize()+.1;break;
                }
                border.setSize(size, 20*3600);

            }

        }

        return false;
    }
}
