package pro.homiecraft.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class tcbKick implements CommandExecutor {
	public boolean onCommand (CommandSender sender, Command cmd, String commandLabel, String[] args){
		if(sender.hasPermission("tcb.Kick") && (sender instanceof Player)){
			if(cmd.getName().equalsIgnoreCase("kick")){
				if (args.length < 1){
					sender.sendMessage("Missing the player name.");
					sender.sendMessage("Usage: /kick playerName <reason>");
					return true;
				}else if(args.length > 1){
					Player player = (Player) sender;
					Player target = player.getServer().getPlayer(args[0]);
					StringBuilder sb = new StringBuilder();
					for(int i = 1; i < args.length; i++)
					{
					    sb.append(args[i]).append(" ");
					}
					String msg = sb.toString().trim();
					if(!(target == null)){
						target.kickPlayer("Reason: " + msg);
						return true;
					}else{
						player.sendMessage("Player is not online!");
						return true;
					}
				}else {
					Player player = (Player) sender;
					Player target = player.getServer().getPlayer(args[0]);
					
					if(!(target == null)){
						target.kickPlayer("Reason: Kicked by staff");
						return true;
					}else{
						player.sendMessage("Player is not online!");
						return true;
					}
				}
			}
		}
		return false;
	}
}
