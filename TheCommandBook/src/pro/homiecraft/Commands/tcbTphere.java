package pro.homiecraft.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class tcbTphere implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if (sender.hasPermission("tcb.Tphere") && (sender instanceof Player)){
			if (cmd.getName().equalsIgnoreCase("tphere")) {
				if (args.length < 1){
					sender.sendMessage("Missing the player name.");
					sender.sendMessage("Usage: /tphere playerName");
					return true;
				}else if(args.length > 1){
					sender.sendMessage("To many arguments!");
					sender.sendMessage("Usage: /tphere playerName");
					return true;
				}else {
					Player player = (Player) sender;
					Player target = player.getServer().getPlayer(args[0]);
					if(!(target == null)){
						target.teleport(player);
						return true;
					}else{
						sender.sendMessage("Player does not exist. Or is offline.");
						return true;
					}
				}
			}
		}
		
		return false;
	}
}
