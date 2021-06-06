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
import org.bukkit.event.entity.EntityPickupItemEvent;
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
			if(ev.getItem() != null) {
				if(ev.getItem().getItemMeta().hasEnchant(Enchantment.ARROW_INFINITE)) {
					if(ev.getMaterial() == Material.WHITE_DYE) {
						itemSystem.ExplosiveBomb(player);
			    	}
					else if(ev.getMaterial() == Material.GRAY_DYE) {
						itemSystem.LevitationBomb(player);
					}
					else if(ev.getMaterial() == Material.GREEN_DYE) {
						itemSystem.PoisenBomb(player);
					}
					else if(ev.getMaterial() == Material.INK_SAC) {
						itemSystem.BlindnessBomb(player);
					}
					else if(ev.getMaterial() == Material.PURPLE_DYE) {
						itemSystem.AdvancedGrenade(player);
					}
					else if(ev.getMaterial() == Material.RED_DYE) {
						itemSystem.FlameGrenade(player);
					}
					else if(ev.getMaterial() == Material.LIME_DYE) {
						itemSystem.FastGrenade(player);
					}
				}
			}
		}
	}
	
	@EventHandler
	public void onEntityPickupItem(EntityPickupItemEvent ev) {
		if(ev.getItem() != null) {
			if(!ev.getItem().getItemStack().getItemMeta().hasEnchant(Enchantment.ARROW_INFINITE)) {
				if(ev.getItem().getItemStack().getType() == Material.INK_SAC) {
					ev.setCancelled(true);
				}
				else if(ev.getItem().getItemStack().getType() == Material.WHITE_DYE) {
					ev.setCancelled(true);
				}
				else if(ev.getItem().getItemStack().getType() == Material.GREEN_DYE) {
					ev.setCancelled(true);
				}
				else if(ev.getItem().getItemStack().getType() == Material.GRAY_DYE) {
					ev.setCancelled(true);
				}
				else if(ev.getItem().getItemStack().getType() == Material.RED_DYE) {
					ev.setCancelled(true);
				}
				else if(ev.getItem().getItemStack().getType() == Material.PURPLE_DYE) {
					ev.setCancelled(true);
				}
				else if(ev.getItem().getItemStack().getType() == Material.LIME_DYE) {
					ev.setCancelled(true);
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
					zombieKills.kills = 0;
					ev.getEntity().getKiller().sendMessage("10 Zombie Kills? Awsome!");
				}
			}
		}
	}
	
}
