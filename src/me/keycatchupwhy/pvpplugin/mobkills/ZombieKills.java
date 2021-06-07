package me.keycatchupwhy.pvpplugin.mobkills;

import org.bukkit.entity.EntityType;

public class ZombieKills {
	
	public EntityType entityType;
	public int kills;
	public int targetKills;
	
	public ZombieKills(EntityType _entityType, int _targetKills) {
		kills = 0;
		entityType = _entityType;
		targetKills = _targetKills;
	}
	
}
