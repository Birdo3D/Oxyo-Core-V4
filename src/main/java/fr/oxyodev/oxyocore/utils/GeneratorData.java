package fr.oxyodev.oxyocore.utils;

import fr.oxyodev.oxyocore.OxyoCore;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class GeneratorData {

    public static void setGeneratorTier(GeneratorTier generatorTier) {
        FileConfiguration cfg = getConfigFile();
        cfg.set("GeneratorTier", generatorTier.getIndex());
        saveFile(cfg);
    }

    public static void setGeneratorAdvancement(int generatorAdvancement) {
        FileConfiguration cfg = getConfigFile();
        cfg.set("GeneratorAdvancement", generatorAdvancement);
        saveFile(cfg);
    }

    public static int getGeneratorTier() {
        return getConfigFile().getInt("GeneratorTier");
    }

    public static int getGeneratorAdvancement() {
        return getConfigFile().getInt("GeneratorAdvancement");
    }

    public static void createSections() {
        FileConfiguration cfg = getConfigFile();
        cfg.set("GeneratorTier", 0);
        cfg.set("GeneratorAdvancement", 0);
        saveFile(cfg);
    }

    private static FileConfiguration getConfigFile() {
        return YamlConfiguration.loadConfiguration(getFile());
    }

    private static File getFile() {
        return new File(OxyoCore.dataFolderPath + "/GeneratorData.yml");
    }

    private static void saveFile(FileConfiguration fileConfiguration) {
        try {
            fileConfiguration.save(getFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
