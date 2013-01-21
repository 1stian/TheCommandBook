package pro.homiecraft.Commands;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import pro.homiecraft.TheCommandBook;
import pro.homiecraft.Config.playerConfig;

public class tcbTpl implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if (sender.hasPermission("tcb.Tpl") && (sender instanceof Player)){
			if (cmd.getName().equalsIgnoreCase("tpl")) {
				if (args.length < 1){
					sender.sendMessage("Missing the player name.");
					sender.sendMessage("Usage: /tpl playerName");
					return true;
				}else if(args.length > 1){
					sender.sendMessage("To many arguments!");
					sender.sendMessage("Usage: /tpl playerName");
					return true;
				}else {
					Player player = (Player) sender;
					//OfflinePlayer target = player.getServer().getOfflinePlayer(args[0]);
					
					File playerfile = new File(TheCommandBook.pluginST.getDataFolder() + "/playerdata/" + args[0] + ".yml");
					if(playerfile.exists()){
						playerConfig.reloadPlayerConfig(args[0]);
						double x = playerConfig.getPlayerConfig(args[0]).getDouble("LastLocation.X");
						double y = playerConfig.getPlayerConfig(args[0]).getDouble("LastLocation.Y");
						double z = playerConfig.getPlayerConfig(args[0]).getDouble("LastLocation.Z");
						String cworld = playerConfig.getPlayerConfig(args[0]).getString("LastLocation.World");
						
						Location playerLL = new Location(Bukkit.getWorld(cworld), x, y, z);
						
						player.teleport(playerLL);
						return true;
					}else{
						sender.sendMessage("Can't locate player file.");
						return true;
					}
				}
			}
		}
		
		return false;
	}
}
