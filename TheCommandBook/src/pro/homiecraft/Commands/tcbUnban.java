package pro.homiecraft.Commands;

import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class tcbUnban implements CommandExecutor {
	public boolean onCommand (CommandSender sender, Command cmd, String commandLabel, String[] args){
		if(sender.hasPermission("tcb.Unban")){
			if(cmd.getName().equalsIgnoreCase("unban")){
				if (args.length < 1){
					sender.sendMessage("Missing the player name.");
					sender.sendMessage("Usage: /ban playerName <reason>");
					return true;
				}else if(args.length > 1){
					sender.sendMessage("To many arguments!");
					sender.sendMessage("Usage: /unban playerName");	
					return true;
				}else {
					Player player = (Player) sender;
					OfflinePlayer ofTarget = player.getServer().getOfflinePlayer(args[0]);
						
					ofTarget.setBanned(false);
					player.sendMessage(ofTarget.getName() + " is now unbanned!");
					return true;
					}
				}
			}
		return false;
	}
}
