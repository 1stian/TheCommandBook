package pro.homiecraft.Commands;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import pro.homiecraft.TheCommandBook;
import pro.homiecraft.Config.spawnConfig;

public class tcbSpawn implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if (sender.hasPermission("tcb.Spawn")) {
			if (cmd.getName().equalsIgnoreCase("spawn")) {
				Player player = (Player) sender;
				
				File spawnFile = new File(TheCommandBook.pluginST.getDataFolder() + "/data/" + "spawn" + ".yml");
				if(spawnFile.exists()){
					String cworld = player.getWorld().getName();
					double x = spawnConfig.getSpawnConfig("spawn").getDouble(cworld + ".spawn.X");
					double y = spawnConfig.getSpawnConfig("spawn").getDouble(cworld + ".spawn.Y");
					double z = spawnConfig.getSpawnConfig("spawn").getDouble(cworld + ".spawn.Z");
					double yaw = spawnConfig.getSpawnConfig("spawn").getDouble(cworld + ".spawn.yaw");
					double pitch = spawnConfig.getSpawnConfig("spawn").getDouble(cworld + ".spawn.pitch");
					
					float yawF = (float) yaw;
					float pitchF = (float) pitch;
					
					Location spawn = new Location(Bukkit.getWorld(cworld), x, y, z, yawF, pitchF);
					player.teleport(spawn);
					sender.sendMessage("Teleported to spawn!");
					return true;
					
				}else{
					double x = player.getWorld().getSpawnLocation().getX();
					double y = player.getWorld().getSpawnLocation().getY();
					double z = player.getWorld().getSpawnLocation().getZ();
					double yaw = player.getWorld().getSpawnLocation().getYaw();
					double pitch = player.getWorld().getSpawnLocation().getPitch();
					
					float yawF = (float) yaw;
					float pitchF = (float) pitch;
					
					String cworld = player.getWorld().getName();
					Location spawn = new Location(Bukkit.getWorld(cworld), x, y, z, yawF, pitchF);
					
					player.teleport(spawn);
					sender.sendMessage("Teleported to spawn!");
					return true;
				}
			}
		}
		return false;		
	}
}
