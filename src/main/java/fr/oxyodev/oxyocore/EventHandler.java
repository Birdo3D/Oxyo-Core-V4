package fr.oxyodev.oxyocore;

import fr.birdo.easycraftapi.entity.PlayerHelper;
import fr.birdo.easycraftapi.util.Random;
import fr.oxyodev.oxyocore.commands.CommandPvP;
import fr.oxyodev.oxyocore.guis.GuiGenerator;
import fr.oxyodev.oxyocore.utils.GeneratorData;
import fr.oxyodev.oxyocore.utils.GeneratorTier;
import fr.oxyodev.oxyocore.utils.Utils;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockFormEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class EventHandler implements Listener {

    private static OxyoCore instance;

    public EventHandler(OxyoCore pluginInstance) {
        instance = pluginInstance;
    }

    @org.bukkit.event.EventHandler
    public void onEntityDamaged(EntityDamageByEntityEvent event) {
        if (event.getEntityType() == EntityType.PLAYER) {
            Entity damager = null;
            if (event.getDamager().getType() == EntityType.PLAYER) {
                damager = event.getDamager();
            } else if (event.getCause() == EntityDamageEvent.DamageCause.PROJECTILE) {
                Projectile projectile = (Projectile) event.getDamager();
                damager = (Entity) projectile.getShooter();
            }
            if (damager != null && damager.getType() == EntityType.PLAYER && (!CommandPvP.isAttackable((Player) damager) || !CommandPvP.isAttackable((Player) event.getEntity())))
                event.setCancelled(true);
        }
    }

    @org.bukkit.event.EventHandler
    public void onJoin(PlayerJoinEvent event) {
        CommandPvP.setAttackable(event.getPlayer(), false);
    }

    @org.bukkit.event.EventHandler
    public void onGuiClicked(InventoryClickEvent event) {
        if (event.getClickedInventory() != null)
            if (event.getView().getTitle().equalsIgnoreCase("Generator Upgrade"))
                if (event.getClickedInventory().getSize() == 27 && event.getSlot() == 22)
                    if (event.getCursor() != null) {
                        if (event.getCursor().getType() == Utils.getTierByIndex(GeneratorData.getGeneratorTier()).getMaterial()) {
                            if (GeneratorData.getGeneratorAdvancement() + event.getCursor().getAmount() > Utils.getTierByIndex(GeneratorData.getGeneratorTier()).getCount()) {
                                event.getCursor().setAmount(event.getCursor().getAmount() - (Utils.getTierByIndex(GeneratorData.getGeneratorTier()).getCount() - GeneratorData.getGeneratorAdvancement()));
                                if (GeneratorData.getGeneratorTier() < 7) {
                                    GeneratorData.setGeneratorTier(Utils.getTierByIndex(GeneratorData.getGeneratorTier() + 1));
                                    GeneratorData.setGeneratorAdvancement(0);
                                } else if (GeneratorData.getGeneratorAdvancement() < GeneratorTier.EMERALD.getCount())
                                    GeneratorData.setGeneratorAdvancement(GeneratorTier.EMERALD.getCount());
                            } else {
                                GeneratorData.setGeneratorAdvancement(GeneratorData.getGeneratorAdvancement() + event.getCursor().getAmount());
                                event.getCursor().setAmount(0);
                            }
                            PlayerHelper.updateGui((Player) event.getWhoClicked(), new GuiGenerator());
                        }
                        event.setCancelled(true);
                    }
    }

    @org.bukkit.event.EventHandler
    public void onBlockFormEvent(BlockFormEvent e) {
        Block block = e.getBlock();
        if (block.getType() == Material.LAVA && findNearbyLava(block)) {
            if (e.getBlock().getWorld().getEnvironment() == World.Environment.NORMAL) {
                int max = GeneratorData.getGeneratorTier() * 100;
                if (GeneratorData.getGeneratorTier() == 7 && GeneratorData.getGeneratorAdvancement() == GeneratorTier.EMERALD.getCount())
                    max = max + 100;
                int rand = Random.roll(1, max);
                if (rand <= GeneratorTier.COAL.getSpawnChance() && GeneratorData.getGeneratorTier() >= 1) {
                    block.setType(Material.COAL_ORE);
                    e.setCancelled(true);
                } else if (rand > 100 && rand <= GeneratorTier.COPPER.getSpawnChance() + 100 && GeneratorData.getGeneratorTier() >= 2) {
                    block.setType(Material.COPPER_ORE);
                    e.setCancelled(true);
                } else if (rand > 200 && rand <= GeneratorTier.LAPIS.getSpawnChance() + 200 && GeneratorData.getGeneratorTier() >= 3) {
                    block.setType(Material.LAPIS_ORE);
                    e.setCancelled(true);
                } else if (rand > 300 && rand <= GeneratorTier.IRON.getSpawnChance() + 300 && GeneratorData.getGeneratorTier() >= 4) {
                    block.setType(Material.IRON_ORE);
                    e.setCancelled(true);
                } else if (rand > 400 && rand <= GeneratorTier.GOLD.getSpawnChance() + 400 && GeneratorData.getGeneratorTier() >= 5) {
                    block.setType(Material.GOLD_ORE);
                    e.setCancelled(true);
                } else if (rand > 500 && rand <= GeneratorTier.REDSTONE.getSpawnChance() + 500 && GeneratorData.getGeneratorTier() >= 6) {
                    block.setType(Material.REDSTONE_ORE);
                    e.setCancelled(true);
                } else if (rand > 600 && rand <= GeneratorTier.DIAMOND.getSpawnChance() + 600 && GeneratorData.getGeneratorTier() == 7) {
                    block.setType(Material.DIAMOND_ORE);
                    e.setCancelled(true);
                } else if (rand > 700 && rand <= GeneratorTier.EMERALD.getSpawnChance() + 700 && GeneratorData.getGeneratorTier() == 7 && GeneratorData.getGeneratorAdvancement() == GeneratorTier.EMERALD.getCount()) {
                    block.setType(Material.EMERALD_ORE);
                    e.setCancelled(true);
                }
            } else if (e.getBlock().getWorld().getEnvironment() == World.Environment.NETHER) {
                int rand = Random.roll(1, 900);
                if (rand <= Utils.getConfig("Quartz.spawn")) {
                    block.setType(Material.NETHER_QUARTZ_ORE);
                    e.setCancelled(true);
                } else if (rand > 100 && rand <= Utils.getConfig("Ancient_debris.spawn") + 100) {
                    block.setType(Material.ANCIENT_DEBRIS);
                    e.setCancelled(true);
                } else if (rand > 200 && rand <= Utils.getConfig("Glowstone.spawn") + 200) {
                    block.setType(Material.GLOWSTONE);
                    e.setCancelled(true);
                } else if (rand > 300 && rand <= Utils.getConfig("Blackstone.spawn") + 300) {
                    block.setType(Material.BLACKSTONE);
                    e.setCancelled(true);
                } else if (rand > 400 && rand <= Utils.getConfig("Soulsand.spawn") + 400) {
                    block.setType(Material.SOUL_SAND);
                    e.setCancelled(true);
                } else if (rand > 500 && rand <= Utils.getConfig("Soulsoil.spawn") + 500) {
                    block.setType(Material.SOUL_SOIL);
                    e.setCancelled(true);
                } else if (rand > 600 && rand <= Utils.getConfig("Nether_gold.spawn") + 600) {
                    block.setType(Material.NETHER_GOLD_ORE);
                    e.setCancelled(true);
                } else if (rand > 700 && rand <= Utils.getConfig("Magma_block.spawn") + 700) {
                    block.setType(Material.MAGMA_BLOCK);
                    e.setCancelled(true);
                } else if (rand > 800 && rand <= Utils.getConfig("Netherrack.spawn") + 800) {
                    block.setType(Material.NETHERRACK);
                    e.setCancelled(true);
                }
            }
        }
    }

    public static boolean findNearbyLava(Block block) {
        int[][] nearby = new int[][]{{-1, 0, 0}, {0, -1, 0}, {0, 0, -1}, {1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
        int x = block.getX(), y = block.getY(), z = block.getZ();
        World world = block.getWorld();
        for (int[] i : nearby)
            if (world.getBlockAt(x + i[0], y + i[1], z + i[2]).getType() == Material.LAVA)
                return true;
        return false;
    }
}
