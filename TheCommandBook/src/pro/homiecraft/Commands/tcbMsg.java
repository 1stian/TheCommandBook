package pro.homiecraft.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class tcbMsg implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		if (sender.hasPermission("tcb.Msg")){
			if(cmd.getName().equalsIgnoreCase("msg")){
				if (args.length < 1){
					sender.sendMessage("Missing the player name.");
					sender.sendMessage("Usage: /msg playerName <message>");
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
						target.sendMessage("[MSG] " + player.getName() + ": " + msg);
						player.sendMessage("[MSG] " + target.getName() + ": " + msg);
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
