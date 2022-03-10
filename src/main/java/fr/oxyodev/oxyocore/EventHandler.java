package fr.oxyodev.oxyocore;

import fr.oxyodev.oxyocore.commands.CommandPvP;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
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
}
