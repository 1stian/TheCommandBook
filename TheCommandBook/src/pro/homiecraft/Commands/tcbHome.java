package pro.homiecraft.Commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import pro.homiecraft.Config.playerConfig;

public class tcbHome implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if (sender.hasPermission("tcb.home")) {
			if (cmd.getName().equalsIgnoreCase("home")) {
				Player player = (Player) sender;
				
				String cworld = player.getWorld().getName();
				
				double x = playerConfig.getPlayerConfig(player.getName()).getDouble(player.getName() + ".Home." + cworld + ".X");
				double y = playerConfig.getPlayerConfig(player.getName()).getDouble(player.getName() + ".Home." + cworld + ".Y");
				double z = playerConfig.getPlayerConfig(player.getName()).getDouble(player.getName() + ".Home." + cworld + ".Z");
				double yaw = playerConfig.getPlayerConfig(player.getName()).getDouble(player.getName() + ".Home." + cworld + ".yaw");
				double pitch = playerConfig.getPlayerConfig(player.getName()).getDouble(player.getName() + ".Home." + cworld + ".pitch");
				
				float yawF = (float) yaw;
				float pitchF = (float) pitch;
				
				Location home = new Location(Bukkit.getWorld(cworld), x, y, z, yawF, pitchF);
				player.teleport(home);
				player.sendMessage("You teleported home!");
				return true;
			}
		}
		return false;
	}
}
