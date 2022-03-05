package fr.oxyodev.oxycore;

import fr.birdo.easycraftapi.registry.GameRegistry;
import org.bukkit.plugin.java.JavaPlugin;

public class OxyoCore extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new EventHandler(this), this);
        GameRegistry.registerCommand(this, new PvpCommand(1));
    }
}