package fr.oxyodev.oxyocore.utils;

import org.bukkit.ChatColor;
import org.bukkit.Material;

public enum GeneratorTier {

    COAL(0, Material.COAL_ORE, Material.COAL, "Coal", ChatColor.DARK_GRAY, 100),
    COPPER(1, Material.COPPER_ORE, Material.COPPER_INGOT, "Copper", ChatColor.GOLD, 100),
    LAPIS(2, Material.LAPIS_ORE, Material.LAPIS_LAZULI, "Lapis Lazuli", ChatColor.BLUE, 100),
    IRON(3, Material.IRON_ORE, Material.IRON_INGOT, "Iron", ChatColor.WHITE, 100),
    GOLD(4, Material.GOLD_ORE, Material.GOLD_INGOT, "Gold", ChatColor.YELLOW, 100),
    REDSTONE(5, Material.REDSTONE_ORE, Material.REDSTONE, "Redstone", ChatColor.RED, 100),
    DIAMOND(6, Material.DIAMOND_ORE, Material.DIAMOND, "Diamond", ChatColor.AQUA, 100),
    EMERALD(7, Material.EMERALD_ORE, Material.EMERALD, "Emerald", ChatColor.DARK_GREEN, 100);

    private final Material icon;
    private final Material material;
    private final String name;
    private final int count;
    private final ChatColor color;
    private final int index;

    GeneratorTier(int index, Material icon, Material material, String name, ChatColor color, int count) {
        this.icon = icon;
        this.name = name;
        this.count = count;
        this.color = color;
        this.index = index;
        this.material = material;
    }

    public Material getIcon() {
        return this.icon;
    }

    public Material getMaterial() {
        return this.material;
    }

    public String getName() {
        return this.name;
    }

    public int getCount() {
        return this.count;
    }

    public ChatColor getColor() {
        return this.color;
    }

    public int getIndex() {
        return this.index;
    }
}
