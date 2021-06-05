package me.keycatchupwhy.pvpplugin.loot;

import java.util.ArrayList;

import org.bukkit.Material;

public class LootSystem {
	
	public static Material[] allowedBlocks = {
			Material.CHEST,
			Material.GLASS
	};
	
	public static ArrayList<Material> GetAllowedBlocksList() {
		
		ArrayList<Material> list = new ArrayList<Material>();
		
		for(int i=0; i<allowedBlocks.length; i++) {
			list.add(allowedBlocks[i]);
		}
		
		return list;
		
	}
	
}