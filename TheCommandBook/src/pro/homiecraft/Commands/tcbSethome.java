package pro.homiecraft.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pro.homiecraft.Config.playerConfig;

public class tcbSethome implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if (sender.hasPermission("tcb.Sethome")) {
			if (cmd.getName().equalsIgnoreCase("sethome")) {
				Player player = (Player) sender;
				
				String cworld = player.getWorld().getName();
				
				double x = player.getLocation().getX();
				double y = player.getLocation().getY();
				double z = player.getLocation().getZ();
				float yaw = player.getLocation().getYaw();
				float pitch = player.getLocation().getPitch();
				
				playerConfig.reloadPlayerConfig(player.getName());
				playerConfig.getPlayerConfig(player.getName()).set(player.getName() + ".Home." + cworld + ".X", x);
				playerConfig.getPlayerConfig(player.getName()).set(player.getName() + ".Home." + cworld + ".Y", y);
				playerConfig.getPlayerConfig(player.getName()).set(player.getName() + ".Home." + cworld + ".Z", z);
				playerConfig.getPlayerConfig(player.getName()).set(player.getName() + ".Home." + cworld + ".yaw", yaw);
				playerConfig.getPlayerConfig(player.getName()).set(player.getName() + ".Home." + cworld + ".pitch", pitch);
				playerConfig.savePlayerConfig(player.getName());
				playerConfig.reloadPlayerConfig(player.getName());
				
				player.sendMessage("Your home is set to your current location!");
				return true;
			}
		}
		return false;
	}
}
