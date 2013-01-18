package pro.homiecraft.Commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class tcbSpawn implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if (sender.hasPermission("tcb.Spawn")) {
			if (cmd.getName().equalsIgnoreCase("spawn")) {
				Player player = (Player) sender;
				
				int x = player.getWorld().getSpawnLocation().getBlockX();
				int y = player.getWorld().getSpawnLocation().getBlockY();
				int z = player.getWorld().getSpawnLocation().getBlockZ();
				String cworld = player.getWorld().getName();
				Location spawn = new Location(Bukkit.getWorld(cworld), x, y, z);
				
				player.teleport(spawn);
				sender.sendMessage("Teleported to spawn!");
				return true;
			}
		}
		return false;		
	}
}
