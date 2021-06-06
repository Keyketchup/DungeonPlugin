package me.keycatchupwhy.pvpplugin.items;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.keycatchupwhy.pvpplugin.Main;

@SuppressWarnings("deprecation")
public class ItemSystem {
	
	public void ExplosiveBomb(Player player) {
		player.getItemInHand().setAmount(player.getItemInHand().getAmount() - 1);
		
		final Item grenade = player.getWorld().dropItem(player.getEyeLocation(), new ItemStack(Material.WHITE_DYE));
        grenade.setVelocity(player.getLocation().getDirection().multiply(0.8D));
    
         Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
             @Override
             public void run() {
                 grenade.getWorld().createExplosion(grenade.getLocation(), 3.6f, false, false);
             }
         }, 20*3);
	}
	
	public void LevitationBomb(Player player) {
		player.getItemInHand().setAmount(player.getItemInHand().getAmount() - 1);
		
		final Item grenade = player.getWorld().dropItem(player.getEyeLocation(), new ItemStack(Material.GRAY_DYE));
        grenade.setVelocity(player.getLocation().getDirection().multiply(0.8D));
    
         Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
             @Override
             public void run() {
                 grenade.getWorld().createExplosion(grenade.getLocation(), 3f, false, false);
                 List<Entity> nearbyMobs = grenade.getNearbyEntities(3, 3, 3);
         		 for(int i=0; i<nearbyMobs.size(); i++) {
         			Entity tmp = nearbyMobs.get(i);
         			if(tmp instanceof LivingEntity) {
         				LivingEntity entity = (LivingEntity)tmp;
         				entity.addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, 20*4, 0));
         			}
         		 }
             }
         }, 20*3);
	}
	
	public void PoisenBomb(Player player) {
		player.getItemInHand().setAmount(player.getItemInHand().getAmount() - 1);
		
		final Item grenade = player.getWorld().dropItem(player.getEyeLocation(), new ItemStack(Material.GREEN_DYE));
        grenade.setVelocity(player.getLocation().getDirection().multiply(0.8D));
    
         Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
             @Override
             public void run() {
                 grenade.getWorld().createExplosion(grenade.getLocation(), 0.8f, false, false);
                 List<Entity> nearbyMobs = grenade.getNearbyEntities(3, 3, 3);
         		 for(int i=0; i<nearbyMobs.size(); i++) {
         			Entity tmp = nearbyMobs.get(i);
         			if(tmp instanceof LivingEntity) {
         				LivingEntity entity = (LivingEntity)tmp;
         				entity.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 20*6, 0));
         			}
         		 }
             }
         }, 20*3);
	}
	
	public void BlindnessBomb(Player player) {
		player.getItemInHand().setAmount(player.getItemInHand().getAmount() - 1);
		
		final Item grenade = player.getWorld().dropItem(player.getEyeLocation(), new ItemStack(Material.INK_SAC));
        grenade.setVelocity(player.getLocation().getDirection().multiply(0.8D));
    
         Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
             @Override
             public void run() {
                 grenade.getWorld().createExplosion(grenade.getLocation(), 1.2f, false, false);
                 List<Entity> nearbyMobs = grenade.getNearbyEntities(3, 3, 3);
         		 for(int i=0; i<nearbyMobs.size(); i++) {
         			Entity tmp = nearbyMobs.get(i);
         			if(tmp instanceof LivingEntity) {
         				LivingEntity entity = (LivingEntity)tmp;
         				entity.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 20*6, 0));
         			}
         		 }
             }
         }, 20*3);
	}
	
}
