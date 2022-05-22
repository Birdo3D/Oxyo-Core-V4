package fr.oxyodev.oxyocore;

import fr.birdo.easycraftapi.registry.GameRegistry;
import fr.oxyodev.oxyocore.commands.CommandEgg;
import fr.oxyodev.oxyocore.commands.CommandEnd;
import fr.oxyodev.oxyocore.commands.CommandGenerator;
import fr.oxyodev.oxyocore.commands.CommandPvP;
import fr.oxyodev.oxyocore.guis.GuiGenerator;
import fr.oxyodev.oxyocore.utils.GeneratorData;
import fr.oxyodev.oxyocore.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public class OxyoCore extends JavaPlugin {

    public static String dataFolderPath;
    public static boolean dragonEgg;

    @Override
    public void onEnable() {
        saveDefaultConfig();
        getServer().getPluginManager().registerEvents(new EventHandler(this), this);
        getServer().getPluginManager().registerEvents(new Utils(this), this);
        GameRegistry.registerCommand(this, new CommandPvP(1));
        GameRegistry.registerCommand(this, new CommandGenerator(2));
        GameRegistry.registerCommand(this, new CommandEgg(3));
        GameRegistry.registerCommand(this, new CommandEnd(4));
        GameRegistry.registerGui("oxyocore", new GuiGenerator(), 1);
        dragonEgg = getConfig().getBoolean("DragonEgg");
        dataFolderPath = getDataFolder().getAbsolutePath();
        File folder = new File(dataFolderPath);
        if (!folder.exists())
            folder.mkdir();
        File generatorDataFile = new File(OxyoCore.dataFolderPath + "/GeneratorData.json");
        File generatorLogFile = new File(OxyoCore.dataFolderPath + "/GeneratorLogs.json");
        if (!generatorDataFile.exists()) {
            try {
                generatorDataFile.createNewFile();
                GeneratorData.createSections();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        if (!generatorLogFile.exists()) {
            try {
                generatorLogFile.createNewFile();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        for(Player player : Bukkit.getOnlinePlayers()){
            CommandPvP.setAttackable(player, false);
        }
    }
}