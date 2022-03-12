package fr.oxyodev.oxyocore.guis;

import fr.birdo.easycraftapi.inventory.GuiScreen;
import fr.birdo.easycraftapi.item.Items;
import fr.oxyodev.oxyocore.utils.GeneratorData;
import fr.oxyodev.oxyocore.utils.GeneratorTier;
import fr.oxyodev.oxyocore.utils.Utils;
import org.bukkit.ChatColor;
import org.bukkit.Material;

public class GuiGenerator extends GuiScreen {

    public GuiGenerator() {
    }

    public void initGui() {
    }

    public void drawScreen() {
        this.setGuiSize(27);
        GeneratorTier generatorTier = Utils.getTierByIndex(GeneratorData.getGeneratorTier());
        int advancement = GeneratorData.getGeneratorAdvancement();
        int t = Math.round((float) advancement / generatorTier.getCount() * 9) + 8;
        if (t == 8)
            t = 9;
        if (advancement == generatorTier.getCount() && generatorTier.getIndex() == 7)
            t++;
        for (int i = 0; i < 27; i++) {
            if (i == 4)
                this.addItem((new Items(generatorTier.getIcon(), -1)).setName(ChatColor.GRAY + "Generator Tier : " + generatorTier.getColor() + generatorTier.getName()), i);
            else if (i >= 9 && i <= 17)
                if (i < t)
                    this.addItem((new Items(Material.GREEN_STAINED_GLASS_PANE, -1)).setName(ChatColor.GREEN + "Unlocked " + ChatColor.DARK_GRAY + "(" + Math.round((float) (i - 8) / 9 * 100) + "%)"), i);
                else if (i == t)
                    this.addItem((new Items(Material.YELLOW_STAINED_GLASS_PANE, -1)).setName(ChatColor.YELLOW + "Unlocking " + ChatColor.DARK_GRAY + "(" + Math.round((float) advancement / generatorTier.getCount() * 100) + "%)"), i);
                else
                    this.addItem((new Items(Material.RED_STAINED_GLASS_PANE, -1)).setName(ChatColor.RED + "Not Unlocked " + ChatColor.DARK_GRAY + "(" + Math.round((float) (i - 8) / 9 * 100) + "%)"), i);
            else if (i == 22)
                this.addItem((new Items(Material.LIGHT_GRAY_STAINED_GLASS_PANE, -1)).setName(" "), i);
            else
                this.addItem((new Items(Material.GRAY_STAINED_GLASS_PANE, -1)).setName(" "), i);
        }
    }

    public String getCustomName() {
        return "Generator Upgrade";
    }
}