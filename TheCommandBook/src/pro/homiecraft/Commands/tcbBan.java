package pro.homiecraft.Commands;

import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class tcbBan implements CommandExecutor {
	public boolean onCommand (CommandSender sender, Command cmd, String commandLabel, String[] args){
		if(sender.hasPermission("tcb.Ban")){
			if(cmd.getName().equalsIgnoreCase("ban")){
				if (args.length < 1){
					sender.sendMessage("Missing the player name.");
					sender.sendMessage("Usage: /ban playerName <reason>");
					return true;
				}else if(args.length > 1){
					Player player = (Player) sender;
					Player target = player.getServer().getPlayer(args[0]);
					OfflinePlayer ofTarget = player.getServer().getOfflinePlayer(args[0]);
					StringBuilder sb = new StringBuilder();
					for(int i = 1; i < args.length; i++)
					{
					    sb.append(args[i]).append(" ");
					}
					String msg = sb.toString().trim();
					
					if(!(target == null)){
						target.setBanned(true);
						target.kickPlayer("Banned reason: " + msg);
						player.sendMessage(target + " is now banned!");
					}else{
						ofTarget.setBanned(true);
						player.sendMessage(ofTarget + " is now banned!");
					}
					
				}else {
					Player player = (Player) sender;
					Player target = player.getServer().getPlayer(args[0]);
					OfflinePlayer ofTarget = player.getServer().getOfflinePlayer(args[0]);
						
					if(!(target == null)){
						target.setBanned(true);
						target.kickPlayer("Banned reason: Banned by a staff member!");
						player.sendMessage(target + " is now banned!");
					}else{
						ofTarget.setBanned(true);
						player.sendMessage(ofTarget + " is now banned!");
					}
				}
			}
		}
		return false;
	}
}
