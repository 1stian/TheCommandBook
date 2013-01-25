package pro.homiecraft.Commands;

import java.io.File;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import pro.homiecraft.TheCommandBook;
import pro.homiecraft.Config.playerConfig;

public class tcbSeen implements CommandExecutor {
	
	public String convertTime(long time){
	    Date date = new Date(time);
	    Format format = new SimpleDateFormat("dd-MM HH:mm:ss");
	    return format.format(date).toString();
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		if(sender.hasPermission("tcbSeen")){
			if(cmd.getName().equalsIgnoreCase("seen")){
				Player player = (Player) sender;
				OfflinePlayer target = player.getServer().getOfflinePlayer(args[0]);
				
				File playerfile = new File(TheCommandBook.pluginST.getDataFolder() + "/playerdata/" + target.getName() + ".yml");
				if(playerfile.exists()){
					if (args.length < 1){
						sender.sendMessage("Missing the playerName!");
						sender.sendMessage("Usage: /seen playerName");
						return true;
					}else if(args.length > 1){
						sender.sendMessage("To many arguments!");
						sender.sendMessage("Usage: /seen playerName");
						return true;
					}else{
						playerConfig.reloadPlayerConfig(target.getName());
						long lastSeen = playerConfig.getPlayerConfig(target.getName().trim()).getLong("LastSeen");
						sender.sendMessage(target.getName() + " was last seen: " + convertTime(lastSeen));
						return true;
					}
				}else{
					sender.sendMessage("Can't locate playerfile");
					return true;
				}
			}
		}
	return true;
	}
}
