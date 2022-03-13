package fr.oxyodev.oxyocore.utils;

import fr.oxyodev.oxyocore.OxyoCore;
import org.bukkit.event.Listener;

public class Utils implements Listener {

    private static OxyoCore instance;

    public Utils(OxyoCore pluginInstance) {
        instance = pluginInstance;
    }

    public static GeneratorTier getTierByIndex(int index) {
        for (GeneratorTier generatorTier : GeneratorTier.values())
            if (generatorTier.getIndex() == index)
                return generatorTier;
        return null;
    }

    public static int getConfig(String path) {
        return instance.getConfig().getInt(path);
    }
}
