package fr.oxyodev.oxycore;

import fr.birdo.easycraftapi.command.Command;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class PvpCommand extends Command {

    private static final Map<UUID, Boolean> attackablePlayers = new HashMap<>();

    public PvpCommand(int index) {
        super("/pvp", index);
        addVariant(0, "on");
        addVariant(1, "off");
    }

    public Boolean onCommandExecuted(Player player, String[] args, int variantIndex, int argsIndex) {
        if (argsIndex == -1) {
            switch (variantIndex) {
                case -1:
                    player.sendMessage(ChatColor.GOLD + "Please, add an argument (on / off) !");
                    return true;
                case 0:
                    if (isAttackable(player))
                        player.sendMessage(ChatColor.RED + "You are already attackable !");
                    else
                        setAttackable(player, true);
                    return true;
                case 1:
                    if (!isAttackable(player))
                        player.sendMessage(ChatColor.GREEN + "You are already not attackable !");
                    else
                        setAttackable(player, false);
                    return true;
            }
        }
        return false;
    }

    public static void setAttackable(Player player, Boolean attackable) {
        attackablePlayers.put(player.getUniqueId(), attackable);
        if (attackable)
            player.sendMessage(ChatColor.RED + "Other players can attack you !");
        else
            player.sendMessage(ChatColor.GREEN + "Other players can no longer attack you !");
    }

    public static Boolean isAttackable(Player player) {
        return attackablePlayers.get(player.getUniqueId());
    }
}