package pro.homiecraft.Commands;

import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pro.homiecraft.Config.spawnConfig;

public class tcbSetSpawn implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if (sender.hasPermission("tcb.Setspawn") && (sender instanceof Player)) {
			if (cmd.getName().equalsIgnoreCase("setspawn")) {
				Player player = (Player) sender;
				World world = player.getWorld();
				
				double x = player.getLocation().getX();
				double y = player.getLocation().getY();
				double z = player.getLocation().getZ();
				float yaw = player.getLocation().getYaw();
				float pitch = player.getLocation().getPitch();
				String cworld = player.getWorld().getName();
				
				spawnConfig.reloadSpawnConfig("spawn");
				spawnConfig.getSpawnConfig("spawn").set(cworld + ".spawn.X", x);
				spawnConfig.getSpawnConfig("spawn").set(cworld + ".spawn.Y", y);
				spawnConfig.getSpawnConfig("spawn").set(cworld + ".spawn.Z", z);
				spawnConfig.getSpawnConfig("spawn").set(cworld + ".spawn.yaw", yaw);
				spawnConfig.getSpawnConfig("spawn").set(cworld + ".spawn.pitch", pitch);
				spawnConfig.saveSpawnConfig("spawn");
				spawnConfig.reloadSpawnConfig("spawn");
				
				int xI = (int)x;
				int yI = (int)y;
				int zI = (int)z;
				
				world.setSpawnLocation(xI, yI, zI);
				sender.sendMessage("Spawn is set to your current location!");
				return true;
			}
		}
		
		return false;
	}
}
