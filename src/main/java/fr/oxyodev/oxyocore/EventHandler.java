package fr.oxyodev.oxyocore;

import fr.birdo.easycraftapi.entity.PlayerHelper;
import fr.oxyodev.oxyocore.commands.CommandPvP;
import fr.oxyodev.oxyocore.guis.GuiGenerator;
import fr.oxyodev.oxyocore.utils.GeneratorData;
import fr.oxyodev.oxyocore.utils.GeneratorTier;
import fr.oxyodev.oxyocore.utils.Utils;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class EventHandler implements Listener {

    public EventHandler(OxyoCore oxyoCore) {
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
}
