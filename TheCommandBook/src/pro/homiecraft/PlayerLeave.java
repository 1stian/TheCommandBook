package pro.homiecraft;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import pro.homiecraft.Config.playerConfig;

import pro.homiecraft.Commands.Resources.*;

public class PlayerLeave implements Listener {
	
	//static String CurrentSysTimeMillis;
	static String days;
	static String hours;
	static String min;
	static String sec;
	
	public static String convertMillis(long milliseconds){
		long seconds, minutes, hours, days;
		   seconds = milliseconds / 1000;
		   minutes = seconds / 60;
		   seconds = seconds % 60;
		   hours = minutes / 60;
		   minutes = minutes % 60;
		   days = hours / 24;
		   hours = hours % 24;
		   return(days + " " + hours + " " + minutes + " " + seconds);
	}
	
	@EventHandler
	public void OnPlayerLeave(PlayerQuitEvent event){
		long CurrentSysTime = System.currentTimeMillis();
		Player player = event.getPlayer();
		
		String cworld = player.getWorld().getName();
		playerConfig.reloadPlayerConfig(player.getName());
		long lastseen = player.getLastPlayed();
				
		
		
		double x = player.getLocation().getX();
		double y = player.getLocation().getY();
	 	double z = player.getLocation().getZ();
		
		long timeAlreadyPlayed = playerConfig.getPlayerConfig(player.getName()).getLong("TimePlayed", 0);
		long conTime = timePlayedMap.tpl.get(player.getName());
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
		timePlayedMap.tpl.remove(player.getName());
	}
}
