package fr.oxyodev.oxyocore.guis;

import fr.birdo.easycraftapi.inventory.GuiScreen;
import fr.birdo.easycraftapi.item.Items;
import fr.oxyodev.oxyocore.utils.GeneratorTier;
import org.bukkit.ChatColor;
import org.bukkit.Material;

public class GuiGenerator extends GuiScreen {

    private GeneratorTier generatorTier = GeneratorTier.COAL;
    private int advancement = 63;

    public GuiGenerator() {
    }

    public void initGui() {
    }

    public void drawScreen() {
        this.setGuiSize(27);
        int t = Math.round((float) advancement / generatorTier.getCount() * 9) + 8;
        for (int i = 0; i < 27; i++) {
            if (i == 4)
                this.addItem((new Items(generatorTier.getMaterial(), -1)).setName(ChatColor.DARK_GRAY + "Unlocking tier : " + generatorTier.getColor() + generatorTier.getName()), i);
            else if (i >= 9 && i <= 17)
                if (i < t)
                    this.addItem((new Items(Material.GREEN_STAINED_GLASS_PANE, -1)).setName(ChatColor.GREEN + "Unlocked " + ChatColor.DARK_GRAY + "(" + Math.round((float) (i - 8) / 9 * 100) + "/100)"), i);
                else if (i == t)
                    this.addItem((new Items(Material.YELLOW_STAINED_GLASS_PANE, -1)).setName(ChatColor.YELLOW + "Unlocking " + ChatColor.DARK_GRAY + "(" + Math.round((float) advancement / generatorTier.getCount() * 100) + "/100)"), i);
                else
                    this.addItem((new Items(Material.RED_STAINED_GLASS_PANE, -1)).setName(ChatColor.RED + "Not Unlocked " + ChatColor.DARK_GRAY + "(" + Math.round((float) (i - 8) / 9 * 100) + "/100)"), i);
            else if (i != 22)
                this.addItem((new Items(Material.GRAY_STAINED_GLASS_PANE, -1)).setName(" "), i);
        }
        this.setItemPickable(22);
    }

    public String getCustomName() {
        return "Generator Upgrade";
    }

    public void onButtonPressed(int buttonIndex) {
    }
}