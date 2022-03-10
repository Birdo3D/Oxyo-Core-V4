package fr.oxyodev.oxyocore.commands;

import fr.birdo.easycraftapi.command.Command;
import fr.birdo.easycraftapi.entity.PlayerHelper;
import org.bukkit.entity.Player;

public class CommandGenerator extends Command {

    public CommandGenerator(int index) {
        super("/generator", index);
        addVariant(0, "gui");
        addVariant(1, "up");
        addVariant(2, "down");
        addVariant(3, "add");
        addVariant(4, "remove");
    }

    public Boolean onCommandExecuted(Player player, String[] args, int variantIndex, int argsIndex) {
        if (argsIndex == -1) {
            switch (variantIndex) {
                case 0:
                    PlayerHelper.displayGui(player, 1);
                    return true;
                case 1:
                    PlayerHelper.displayGui(player, 1);
                    return true;
                case 2:
                    PlayerHelper.displayGui(player, 1);
                    return true;
                case 3:
                    PlayerHelper.displayGui(player, 1);
                    return true;
                case 4:
                    PlayerHelper.displayGui(player, 1);
                    return true;
            }
        }
        return false;
    }
}