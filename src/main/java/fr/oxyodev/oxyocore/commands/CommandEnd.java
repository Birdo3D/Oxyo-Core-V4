package fr.oxyodev.oxyocore.commands;

import fr.birdo.easycraftapi.command.Command;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class CommandEnd extends Command {

    public CommandEnd(int index) {
        super("/end", index);
    }

    public Boolean onCommandExecuted(Player player, String[] args, int variantIndex, int argsIndex) {
        if (variantIndex == -1 && argsIndex == -1) {
            player.teleport(new Location(Bukkit.getWorld("world_the_end"), 100.5, 49, 0.5));
            player.sendMessage("Vous avez été téléporté dans l'end !");
            return true;
        }
        return false;
    }
}
