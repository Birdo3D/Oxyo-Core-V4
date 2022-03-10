package fr.oxyodev.oxyocore.utils;

import org.bukkit.ChatColor;
import org.bukkit.Material;

public enum GeneratorTier {

    COAL(0, Material.COAL_ORE, "Coal", ChatColor.BLACK, 100),
    COPPER(1, Material.COPPER_ORE, "Copper", ChatColor.YELLOW, 100),
    LAPIS(2, Material.LAPIS_ORE, "Lapis Lazuli", ChatColor.DARK_BLUE, 100),
    IRON(3, Material.IRON_ORE, "Iron", ChatColor.GRAY, 100),
    GOLD(4, Material.GOLD_ORE, "Gold", ChatColor.GOLD, 100),
    REDSTONE(5, Material.REDSTONE_ORE, "Redstone", ChatColor.RED, 100),
    DIAMOND(6, Material.DIAMOND_ORE, "Diamond", ChatColor.BLUE, 100),
    EMERALD(7, Material.EMERALD_ORE, "Emerald", ChatColor.GREEN, 100);

    private final Material material;
    private final String name;
    private final int count;
    private final ChatColor color;
    private final int index;

    GeneratorTier(int index, Material material, String name, ChatColor color, int count) {
        this.material = material;
        this.name = name;
        this.count = count;
        this.color = color;
        this.index = index;
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
