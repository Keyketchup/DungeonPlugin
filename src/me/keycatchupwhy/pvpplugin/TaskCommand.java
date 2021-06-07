package me.keycatchupwhy.pvpplugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;

public class TaskCommand implements CommandExecutor  {
	
	@Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(args.length == 3) {
			try {
                @SuppressWarnings("deprecation")
				EntityType entity = EntityType.fromName(args[0].toUpperCase());
                int targetkills = Integer.parseInt(args[1]);
                int kills = Integer.parseInt(args[2]);
                
                if(entity == null) {
                	return false;
                }
                AllEvents.mobKills.entityType = entity;
                AllEvents.mobKills.kills = kills;
                AllEvents.mobKills.targetKills = targetkills;
                
            } catch (NumberFormatException ex) {
                return false;
            }
		} else if(args.length == 2) {
			try {
                @SuppressWarnings("deprecation")
				EntityType entity = EntityType.fromName(args[0].toUpperCase());
                int targetkills = Integer.parseInt(args[1]);
                
                if(entity == null) {
                	return false;
                }
                AllEvents.mobKills.entityType = entity;
                AllEvents.mobKills.targetKills = targetkills;
                
            } catch (NumberFormatException ex) {
                return false;
            }
		} else {
			return false;
		}
		
		return true;
		
	}
	
}
