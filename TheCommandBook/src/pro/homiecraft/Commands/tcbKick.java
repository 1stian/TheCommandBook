package pro.homiecraft.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class tcbKick implements CommandExecutor {
	public boolean onCommand (CommandSender sender, Command cmd, String commandLabel, String[] args){
		if(sender.hasPermission("tcb.Kick")){
			if(cmd.getName().equalsIgnoreCase("kick")){
				if (args.length < 1){
					sender.sendMessage("Missing the player name.");
					sender.sendMessage("Usage: /kick playerName");
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
					
					target.kickPlayer("Reason: " + msg);
				}else {
					Player player = (Player) sender;
					Player target = player.getServer().getPlayer(args[0]);
						
					target.kickPlayer("Reason: Kicked by staff");
				}
			}
		}
		return false;
	}
}
