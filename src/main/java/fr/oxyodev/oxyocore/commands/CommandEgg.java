package fr.oxyodev.oxyocore.commands;

import fr.birdo.easycraftapi.command.Command;
import fr.oxyodev.oxyocore.OxyoCore;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class CommandEgg extends Command {

    public CommandEgg(int index) {
        super("/dragonEgg", index);
    }

    public Boolean onCommandExecuted(Player player, String[] args, int variantIndex, int argsIndex) {
        if (variantIndex == -1 && argsIndex == -1) {
            if (player.isOp()) {
                OxyoCore.dragonEgg = !OxyoCore.dragonEgg;
                player.sendMessage(ChatColor.GREEN + "dragonEgg : " + OxyoCore.dragonEgg);
                return true;
            }
        }
        return false;
    }
}
