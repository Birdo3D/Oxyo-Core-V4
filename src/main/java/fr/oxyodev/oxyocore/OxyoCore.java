package fr.oxyodev.oxyocore;

import fr.birdo.easycraftapi.registry.GameRegistry;
import fr.oxyodev.oxyocore.commands.CommandGenerator;
import fr.oxyodev.oxyocore.commands.CommandPvP;
import fr.oxyodev.oxyocore.guis.GuiGenerator;
import fr.oxyodev.oxyocore.utils.GeneratorData;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public class OxyoCore extends JavaPlugin {

    public static String dataFolderPath;

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new EventHandler(this), this);
        GameRegistry.registerCommand(this, new CommandPvP(1));
        GameRegistry.registerCommand(this, new CommandGenerator(2));
        GameRegistry.registerGui("oxyocore", new GuiGenerator(), 1);
        dataFolderPath = getDataFolder().getAbsolutePath();
        File folder = new File(dataFolderPath);
        if (!folder.exists())
            folder.mkdir();
        File generatorDataFile = new File(OxyoCore.dataFolderPath + "/GeneratorData.yml");
        if (!generatorDataFile.exists()) {
            try {
                generatorDataFile.createNewFile();
                GeneratorData.createSections();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}