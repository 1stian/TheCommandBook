package pro.homiecraft;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import pro.homiecraft.Config.playerConfig;

import pro.homiecraft.Commands.Resources.*;

public class PlayerLeave implements Listener {
	@EventHandler
	public void OnPlayerLeave(PlayerQuitEvent event){
		Player player = event.getPlayer();
		
		String cworld = player.getWorld().getName();
		playerConfig.reloadPlayerConfig(player.getName());
		long lastseen = player.getLastPlayed();
		
		double x = player.getLocation().getX();
		double y = player.getLocation().getY();
		double z = player.getLocation().getZ();
		
		long timeAlreadyPlayed = playerConfig.getPlayerConfig(player.getName()).getLong("TimePlayed", 0);
		long conTime = timePlayedMap.tpl.get(player);
		long leaveTime = System.currentTimeMillis();
		
		long timePlayed = leaveTime - conTime;
		long timeToConfig = timePlayed + timeAlreadyPlayed;
		
		playerConfig.getPlayerConfig(player.getName()).set("LastLocation.World", cworld);
		playerConfig.getPlayerConfig(player.getName()).set("LastLocation.X", x);
		playerConfig.getPlayerConfig(player.getName()).set("LastLocation.Y", y);
		playerConfig.getPlayerConfig(player.getName()).set("LastLocation.Z", z);
		playerConfig.getPlayerConfig(player.getName()).set("Lastseen", lastseen);
		playerConfig.getPlayerConfig(player.getName()).set("TimePlayed", timeToConfig);
		playerConfig.savePlayerConfig(player.getName());
		playerConfig.reloadPlayerConfig(player.getName());
		
		damageMap.dmg.remove(player);
		muteMap.mu.remove(player);
		timePlayedMap.tpl.remove(player);
	}
}
