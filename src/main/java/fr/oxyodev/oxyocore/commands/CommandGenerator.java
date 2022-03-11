package fr.oxyodev.oxyocore.commands;

import fr.birdo.easycraftapi.command.Command;
import fr.birdo.easycraftapi.entity.PlayerHelper;
import org.bukkit.entity.Player;

public class CommandGenerator extends Command {

    public CommandGenerator(int index) {
        super("/generator", index);
    }

    public Boolean onCommandExecuted(Player player, String[] args, int variantIndex, int argsIndex) {
        if (argsIndex == -1 && variantIndex == -1) {
            PlayerHelper.displayGui(player, 1);
            return true;
        }
        return false;
    }
}