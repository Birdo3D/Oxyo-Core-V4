package fr.oxyodev.oxyocore.utils;

import org.bukkit.ChatColor;
import org.bukkit.Material;

public enum GeneratorTier {

    COAL(0, Material.COAL_ORE, Material.COAL, "Coal", ChatColor.DARK_GRAY, Utils.getConfig("Coal.upgrade"), Utils.getConfig("Coal.spawn")),//Spawn chance %
    COPPER(1, Material.COPPER_ORE, Material.COPPER_INGOT, "Copper", ChatColor.GOLD, Utils.getConfig("Copper.upgrade"), Utils.getConfig("Copper.spawn")),//Spawn chance %
    LAPIS(2, Material.LAPIS_ORE, Material.LAPIS_LAZULI, "Lapis Lazuli", ChatColor.BLUE, Utils.getConfig("Lapis.upgrade"), Utils.getConfig("Lapis.spawn")),//Spawn chance %
    IRON(3, Material.IRON_ORE, Material.IRON_INGOT, "Iron", ChatColor.WHITE, Utils.getConfig("Iron.upgrade"), Utils.getConfig("Iron.spawn")),//Spawn chance %
    GOLD(4, Material.GOLD_ORE, Material.GOLD_INGOT, "Gold", ChatColor.YELLOW, Utils.getConfig("Gold.upgrade"), Utils.getConfig("Gold.spawn")),//Spawn chance %
    REDSTONE(5, Material.REDSTONE_ORE, Material.REDSTONE, "Redstone", ChatColor.RED, Utils.getConfig("Redstone.upgrade"), Utils.getConfig("Redstone.spawn")),//Spawn chance %
    DIAMOND(6, Material.DIAMOND_ORE, Material.DIAMOND, "Diamond", ChatColor.AQUA, Utils.getConfig("Diamond.upgrade"), Utils.getConfig("Diamond.spawn")),//Spawn chance %
    EMERALD(7, Material.EMERALD_ORE, Material.EMERALD, "Emerald", ChatColor.DARK_GREEN, Utils.getConfig("Emerald.upgrade"), Utils.getConfig("Emerald.spawn"));//Spawn chance %

    private final Material icon;
    private final Material material;
    private final String name;
    private final int count;
    private final ChatColor color;
    private final int index;
    private final int spawnChance;

    GeneratorTier(int index, Material icon, Material material, String name, ChatColor color, int count, int spawnChance) {
        this.icon = icon;
        this.name = name;
        this.count = count;
        this.color = color;
        this.index = index;
        this.material = material;
        this.spawnChance = spawnChance;
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

    public int getSpawnChance() {
        return this.spawnChance;
    }
}
