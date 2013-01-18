package pro.homiecraft.Commands;

import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class tcbSetSpawn implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if (sender.hasPermission("tcb.Setspawn")) {
			if (cmd.getName().equalsIgnoreCase("setspawn")) {
				Player player = (Player) sender;
				World world = player.getWorld();
				
				int x = player.getLocation().getBlockX();
				int y = player.getLocation().getBlockY();
				int z = player.getLocation().getBlockZ();
				//float yaw = player.getLocation().getYaw();
				//String cworld = player.getWorld().getName();
				//Location spawn = new Location(Bukkit.getWorld(cworld), x, y, z);
				
				world.setSpawnLocation(x,y,z);
				sender.sendMessage("Spawn is set to your current location!");
				return true;
			}
		}
		
		return false;
	}
}
