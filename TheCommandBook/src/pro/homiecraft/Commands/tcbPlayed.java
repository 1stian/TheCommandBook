package pro.homiecraft.Commands;

import java.io.File;

import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import pro.homiecraft.TheCommandBook;
import pro.homiecraft.Config.playerConfig;

public class tcbPlayed implements CommandExecutor {
	public static String convertMillis(long milliseconds){
		long seconds, minutes, hours;
		   seconds = milliseconds / 1000;
		   minutes = seconds / 60;
		   seconds = seconds % 60;
		   hours = minutes / 60;
		   minutes = minutes % 60;
		   return("H:" + hours + " M:" + minutes + " S:" + seconds);
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		if(sender.hasPermission("tcbPlayed")){
			if(cmd.getName().equalsIgnoreCase("played")){
				Player player = (Player) sender;
				OfflinePlayer target = player.getServer().getOfflinePlayer(args[0]);
				
				File playerfile = new File(TheCommandBook.pluginST.getDataFolder() + "/playerdata/" + target.getName() + ".yml");
				if(playerfile.exists()){
					if (args.length < 1){
						sender.sendMessage("Missing the playerName!");
						sender.sendMessage("Usage: /played playerName");
					}else if(args.length > 1){
						sender.sendMessage("To many arguments!");
						sender.sendMessage("Usage: /played playerName");
					}else{
						playerConfig.reloadPlayerConfig(target.getName());
						long timePlayed = playerConfig.getPlayerConfig(target.getName().trim()).getLong("TimePlayed");
						player.sendMessage(target.getName() + " has played for " + convertMillis(timePlayed));
						return true;
					}
				}else{
					player.sendMessage("Can't locate playerfile");
					return true;
				}
			}
		}
		return false;
	}
}
