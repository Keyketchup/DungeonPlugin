package me.keycatchupwhy.pvpplugin.items;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import me.keycatchupwhy.pvpplugin.Main;

public class ItemSystem {
	
	@SuppressWarnings("deprecation")
	public void ExplosiveBomb(Player player) {
		player.getItemInHand().setAmount(player.getItemInHand().getAmount() - 1);
		
		final Item grenade = player.getWorld().dropItem(player.getEyeLocation(), new ItemStack(Material.SPECTRAL_ARROW));
        grenade.setVelocity(player.getLocation().getDirection().multiply(0.8D));
    
         Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
             @Override
             public void run() {
                 grenade.getWorld().createExplosion(grenade.getLocation().getX(), grenade.getLocation().getY(), grenade.getLocation().getZ(), 3.6f, false, false);
             }
         }, 20*3);
	}
	
}