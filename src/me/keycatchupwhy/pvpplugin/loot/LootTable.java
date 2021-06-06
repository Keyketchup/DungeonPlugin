package me.keycatchupwhy.pvpplugin.loot;

import java.util.ArrayList;
import java.util.Random;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

class Loot {
	
	String name;
	Material material;
	int amount;
	
	public Loot(String _name, Material _material, int _amount) {
		name = _name;
		material = _material;
		amount = _amount;
	}
	
}

public class LootTable {
	
	public LootTable() {
		
		AddLoot("����ź", Material.WHITE_DYE, 1);
		AddLoot("���ߺξ� ��ź", Material.GRAY_DYE, 1);
		AddLoot("�� ����ź", Material.GREEN_DYE, 1);
		AddLoot("����ź", Material.INK_SAC, 1);
		
	}
	
	public ArrayList<Loot> lootTable = new ArrayList<Loot>();
	
	public void AddLoot(String name, Material itemMaterial, int amount) {
		
		Loot loot = new Loot(name, itemMaterial, amount);
		lootTable.add(loot);
		
	}
	
	public Loot GetRandomLoot() {
		
		Random rand = new Random();
		Loot res = lootTable.get(rand.nextInt(lootTable.size()));
		return res;
		
	}
	
	public ItemStack GetRandomItemStack() {
		
		Random rand = new Random();
		Loot loot = lootTable.get(rand.nextInt(lootTable.size()));
		
		ItemStack res = new ItemStack(loot.material, loot.amount);
		ItemMeta meta = res.getItemMeta();
		meta.setDisplayName(loot.name);
		meta.setUnbreakable(true);
		meta.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
		res.setItemMeta(meta);
		
		return res;
		
	}
	
	public void GiveLoot(Player player) {
		
		player.getInventory().addItem(GetRandomItemStack());
		
	}
	
}
