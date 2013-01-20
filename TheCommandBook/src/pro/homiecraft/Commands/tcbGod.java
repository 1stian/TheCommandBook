package pro.homiecraft.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pro.homiecraft.Commands.Resources.damageMap;

public class tcbGod implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		if (sender.hasPermission("tcb.God")){
			if(cmd.getName().equalsIgnoreCase("god")){
				Player player = (Player) sender;
				
				if (args.length == 1){
					Player target = player.getServer().getPlayer(args[0]);
					if (damageMap.dmg.containsKey(target)){
						damageMap.dmg.remove(player);
						player.sendMessage("God Disabled for " + target.getName());
						target.sendMessage("God Disabled!");
						return true;
					}else{
						damageMap.dmg.put(target, true);
						player.sendMessage("God Enabled for " + target.getName());
						target.sendMessage("God Enabled!");
						return true;
					}
				}else if(args.length > 1){
					sender.sendMessage("To many arguments!");
					sender.sendMessage("Usage /god playerName");
					return true;
				}else{
					if (damageMap.dmg.containsKey(player)){
						damageMap.dmg.remove(player);
						player.sendMessage("God Disabled!");
						return true;
					}else{
						damageMap.dmg.put(player, true);
						player.sendMessage("God Enabled!");
						return true;
					}
				}
			}
		}
		return false;
	}
}
