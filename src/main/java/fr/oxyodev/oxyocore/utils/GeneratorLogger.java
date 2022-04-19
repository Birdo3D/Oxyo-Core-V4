package fr.oxyodev.oxyocore.utils;

import fr.oxyodev.oxyocore.OxyoCore;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;

public class GeneratorLogger {

    public static void log(Player player, Material material, int quantity) throws IOException {
        File file = new File(OxyoCore.dataFolderPath + "/GeneratorLogs.txt");
        if (!file.exists())
            file.createNewFile();
        Path fichier = Paths.get(file.getPath());
        Files.write(fichier, Arrays.asList("[" + LocalDate.now() + " " + LocalTime.now().toString().substring(0, 8) + "] [Generator Log]: " + player.getName() + " add " + quantity + " " + material), StandardCharsets.UTF_8, StandardOpenOption.APPEND);
        FileConfiguration cfg = getConfigFile();
        cfg.set(player.getName() + "." + material.toString(), getLog(player, material) + quantity);
        saveFile(cfg);
    }

    public static int getLog(Player player) {
        return getConfigFile().getInt(player.getName());
    }

    public static int getLog(Player player, Material material) {
        return getConfigFile().getInt(player.getName() + "." + material.toString());
    }

    private static FileConfiguration getConfigFile() {
        return YamlConfiguration.loadConfiguration(getFile());
    }

    private static File getFile() {
        return new File(OxyoCore.dataFolderPath + "/GeneratorLogs.json");
    }

    private static void saveFile(FileConfiguration fileConfiguration) {
        try {
            fileConfiguration.save(getFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}