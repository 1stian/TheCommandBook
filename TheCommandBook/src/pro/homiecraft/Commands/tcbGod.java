package pro.homiecraft.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pro.homiecraft.Commands.Resources.damageMap;
import pro.homiecraft.Config.playerConfig;

public class tcbGod implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		if (sender.hasPermission("tcb.God") && (sender instanceof Player)){
			if(cmd.getName().equalsIgnoreCase("god")){
				Player player = (Player) sender;
				
				if (args.length == 1){
					Player target = player.getServer().getPlayer(args[0]);
					if (damageMap.dmg.containsKey(target)){
						damageMap.dmg.remove(player);
						player.sendMessage("God Disabled for " + target.getName());
						target.sendMessage("God Disabled!");
						
						playerConfig.reloadPlayerConfig(target.getName());
						playerConfig.getPlayerConfig(target.getName()).set("god", false);
						playerConfig.savePlayerConfig(target.getName());
						playerConfig.reloadPlayerConfig(target.getName());
						return true;
					}else{
						damageMap.dmg.put(target, true);
						player.sendMessage("God Enabled for " + target.getName());
						target.sendMessage("God Enabled!");
						
						playerConfig.reloadPlayerConfig(target.getName());
						playerConfig.getPlayerConfig(target.getName()).set("god", true);
						playerConfig.savePlayerConfig(target.getName());
						playerConfig.reloadPlayerConfig(target.getName());
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
						
						playerConfig.reloadPlayerConfig(player.getName());
						playerConfig.getPlayerConfig(player.getName()).set("god", false);
						playerConfig.savePlayerConfig(player.getName());
						playerConfig.reloadPlayerConfig(player.getName());
						return true;
					}else{
						damageMap.dmg.put(player, true);
						player.sendMessage("God Enabled!");
						
						playerConfig.reloadPlayerConfig(player.getName());
						playerConfig.getPlayerConfig(player.getName()).set("god", true);
						playerConfig.savePlayerConfig(player.getName());
						playerConfig.reloadPlayerConfig(player.getName());
						return true;
					}
				}
			}
		}
		return false;
	}
}
