package fr.oxyodev.oxyocore;

import org.bukkit.Material;

public enum GeneratorTier {

    COAL(Material.COAL_ORE, "Coal", 100),
    COPPER(Material.COPPER_ORE, "Copper", 100),
    LAPIS(Material.LAPIS_ORE, "Lapis Lazuli", 100),
    IRON(Material.IRON_ORE, "Iron", 100),
    GOLD(Material.GOLD_ORE, "Gold", 100),
    REDSTONE(Material.REDSTONE_ORE, "Redstone", 100),
    DIAMOND(Material.DIAMOND_ORE, "Diamond", 100),
    EMERALD(Material.EMERALD_ORE, "Emerald", 100);

    private final Material material;
    private final String name;
    private final int count;

    GeneratorTier(Material material, String name, int count) {
        this.material = material;
        this.name = name;
        this.count = count;
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
}
