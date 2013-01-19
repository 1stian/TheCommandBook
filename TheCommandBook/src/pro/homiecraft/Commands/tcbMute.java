package pro.homiecraft.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import pro.homiecraft.Config.playerConfig;
import pro.homiecraft.Commands.Resources.muteMap;

public class tcbMute implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		if(sender.hasPermission("tcb.Mute")){
			Player player = (Player) sender;
			if(cmd.getName().equalsIgnoreCase("mute")){
				if(args.length < 1){
					sender.sendMessage("Missing playe name!");
					sender.sendMessage("Usage: /mute playerName");
					return true;
				}else if(args.length > 1){
					sender.sendMessage("To many arguments!");
					sender.sendMessage("Usage: /mute playerName");
					return true;
				}else {
					Player target = player.getServer().getPlayer(args[0]);
					if(target == null){
						player.sendMessage("THe player is not online or does not exist!");
						return true;
					}else if(muteMap.mu.containsKey(target)){
						player.sendMessage(args[0] + " is unmuted!");
						muteMap.mu.remove(player);
						playerConfig.reloadPlayerConfig(args[0]);
						playerConfig.getPlayerConfig(args[0]).set("muted", false);
						playerConfig.savePlayerConfig(args[0]);
						playerConfig.reloadPlayerConfig(args[0]);
						return true;
					}else{
						player.sendMessage(args[0] + " is muted!");
						muteMap.mu.put(target, "mute");
						playerConfig.reloadPlayerConfig(args[0]);
						playerConfig.getPlayerConfig(args[0]).set("muted", true);
						playerConfig.savePlayerConfig(args[0]);
						playerConfig.reloadPlayerConfig(args[0]);
						return true;
					}
				}
			}
		}
		return false;	
	}
}
