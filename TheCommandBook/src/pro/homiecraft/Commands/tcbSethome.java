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
				
				int x = player.getLocation().getBlockX();
				int y = player.getLocation().getBlockY();
				int z = player.getLocation().getBlockZ();
				
				playerConfig.reloadPlayerConfig(player.getName());
				playerConfig.getPlayerConfig(player.getName()).set(player.getName() + ".Home." + cworld + ".X", x);
				playerConfig.getPlayerConfig(player.getName()).set(player.getName() + ".Home." + cworld + ".Y", y);
				playerConfig.getPlayerConfig(player.getName()).set(player.getName() + ".Home." + cworld + ".Z", z);
				playerConfig.savePlayerConfig(player.getName());
				playerConfig.reloadPlayerConfig(player.getName());
				
				player.sendMessage("Your home is set to your current location!");
				return true;
			}
		}
		return false;
	}
}
