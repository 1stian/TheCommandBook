package pro.homiecraft.Commands;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class tcbGm implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		if(sender.hasPermission("tcb.Gm")){
			if(cmd.getName().equalsIgnoreCase("gm")){
				Player player = (Player) sender;
				if (args.length > 1){
					Player target = player.getServer().getPlayer(args[0]);
					if (target.getGameMode() == GameMode.SURVIVAL){
						target.setGameMode(GameMode.CREATIVE);
						target.sendMessage("Your gamemode has been changed to Creative.");
						sender.sendMessage("You changed GameMode for " + target.getName() + " to Creative");
						return true;
					}else if(target.getGameMode() == GameMode.CREATIVE){
						target.setGameMode(GameMode.SURVIVAL);
						target.sendMessage("Your gamemode has been changed to Creative.");
						sender.sendMessage("You changed GameMode for " + target.getName() + " to Survival");
						return true;
					}
				}else{
					if(sender instanceof Player){
						if (player.getGameMode() == GameMode.SURVIVAL){
							player.setGameMode(GameMode.CREATIVE);
							player.sendMessage("Your gamemode has been changed to Creative.");
							return true;
						}else if(player.getGameMode() == GameMode.CREATIVE){
							player.setGameMode(GameMode.SURVIVAL);
							player.sendMessage("Your gamemode has been changed to Survival.");
							return true;
						}
					}else{
						sender.sendMessage("You must be a player to use this.");
						sender.sendMessage("Use /gm playerName");
					}
				}
			}
		}
		return false;
	}
}
