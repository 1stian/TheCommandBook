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
				
				int x = playerConfig.getPlayerConfig(player.getName()).getInt(player.getName() + ".Home." + cworld + ".X");
				int y = playerConfig.getPlayerConfig(player.getName()).getInt(player.getName() + ".Home." + cworld + ".Y");
				int z = playerConfig.getPlayerConfig(player.getName()).getInt(player.getName() + ".Home." + cworld + ".Z");
				float yaw = playerConfig.getPlayerConfig(player.getName()).getInt(player.getName() + ".Home." + cworld + ".yaw");
				float pitch = playerConfig.getPlayerConfig(player.getName()).getInt(player.getName() + ".Home." + cworld + ".pitch");
				
				Location home = new Location(Bukkit.getWorld(cworld), x, y, z);
				player.getLocation().setPitch(pitch);
				player.getLocation().setYaw(yaw);
				player.teleport(home);
				player.sendMessage("You teleported home!");
				return true;
			}
		}
		return false;
	}
}
