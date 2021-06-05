package me.keycatchupwhy.pvpplugin;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import me.keycatchupwhy.pvpplugin.items.ItemSystem;
import me.keycatchupwhy.pvpplugin.loot.LootSystem;
import me.keycatchupwhy.pvpplugin.loot.LootTable;

public class AllEvents implements Listener {
	
	public static ItemSystem itemSystem = new ItemSystem();
	public static LootTable lootTable = new LootTable();
	
	@EventHandler
	public static void onBlockBreak(BlockBreakEvent ev) {
		Player player = ev.getPlayer();
		if(player.getGameMode() != GameMode.CREATIVE) {
			if(LootSystem.GetAllowedBlocksList().contains(ev.getBlock().getType())) {
				if(ev.getBlock().getType() == Material.CHEST) {
					lootTable.GiveLoot(player);
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
		if(ev.getAction() == Action.RIGHT_CLICK_AIR) {
		    if(ev.getMaterial() == Material.SPECTRAL_ARROW) {
		    	if(ev.getItem().getItemMeta().hasEnchant(Enchantment.ARROW_INFINITE)) {
		    		itemSystem.ExplosiveBomb(player);
		    	}
		    }
		}
	}
	
}
