package me.keycatchupwhy.pvpplugin;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import me.keycatchupwhy.pvpplugin.items.ItemSystem;
import me.keycatchupwhy.pvpplugin.loot.LootSystem;
import me.keycatchupwhy.pvpplugin.loot.LootTable;
import me.keycatchupwhy.pvpplugin.mobkills.ZombieKills;

public class AllEvents implements Listener {
	
	public static ItemSystem itemSystem = new ItemSystem();
	public static LootTable lootTable = new LootTable();
	public static ZombieKills zombieKills = new ZombieKills(0);
	
	@EventHandler
	public static void onBlockBreak(BlockBreakEvent ev) {
		Player player = ev.getPlayer();
		if(player.getGameMode() != GameMode.CREATIVE) {
			if(LootSystem.GetAllowedBlocksList().contains(ev.getBlock().getType())) {
				if(ev.getBlock().getType() == Material.CHEST) {
					ev.setCancelled(true);
					lootTable.GiveLoot(player);
					ev.getBlock().setType(Material.COAL_BLOCK);
				}
			} else {
				ev.setCancelled(true);
				player.sendMessage("ºí·° Æø·Â ¸ØÃç!");
			}
		}
	}
	
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent ev) {
		Player player = ev.getPlayer();
		if(ev.getAction() == Action.RIGHT_CLICK_AIR || ev.getAction() == Action.RIGHT_CLICK_BLOCK) {
			if(ev.getItem().getItemMeta().hasEnchant(Enchantment.ARROW_INFINITE)) {
				if(ev.getMaterial() == Material.SPECTRAL_ARROW) {
					itemSystem.ExplosiveBomb(player);
		    	}
				if(ev.getMaterial() == Material.GLASS_BOTTLE) {
					itemSystem.LevitationBomb(player);
				}
			}
		}
	}
	
	@EventHandler
	public void onEntityDeath(EntityDeathEvent ev) {
		if(ev.getEntityType() == EntityType.ZOMBIE) {
			if(ev.getEntity().getKiller() != null) {
				zombieKills.kills++;
				if(zombieKills.kills >= 10) {
					ev.getEntity().getKiller().getInventory().addItem(new ItemStack(Material.LEVER, 1));
				}
			}
		}
	}
	
}
