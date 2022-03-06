package fr.oxyodev.oxyocore;

import fr.birdo.easycraftapi.inventory.GuiScreen;
import fr.birdo.easycraftapi.item.Items;
import org.bukkit.Bukkit;
import org.bukkit.Material;

public class Gui extends GuiScreen {

    private GeneratorTier generatorTier = GeneratorTier.COAL;
    private int advancement = GeneratorTier.COAL.getCount() / 2;

    public Gui() {
    }

    public void initGui() {
    }

    public void drawScreen() {
        this.setGuiSize(27);
        for (int i = 0; i < 27; i++) {
            if (i == 4)
                this.addItem((new Items(generatorTier.getMaterial(), -1)).setName("Current tier : " + generatorTier.getName()), i);
            else if (i > 8 && i < 18) {
                int t = Math.round((float) advancement / generatorTier.getCount() * 9) + 8;
                if (i < t) {
                    this.addItem((new Items(Material.GREEN_STAINED_GLASS_PANE, -1)).setName(" "), i);
                } else if (i == t) {
                    this.addItem((new Items(Material.YELLOW_STAINED_GLASS_PANE, -1)).setName("Advancement : " + advancement + "/" + generatorTier.getCount()), i);
                } else {
                    this.addItem((new Items(Material.RED_STAINED_GLASS_PANE, -1)).setName(" "), i);
                }
            } else if (i != 22)
                this.addItem((new Items(Material.GRAY_STAINED_GLASS_PANE, -1)).setName(" "), i);
        }
    }

    public String getCustomName() {
        return "Generator Upgrade";
    }

    public void onButtonPressed(int buttonIndex) {
    }
}