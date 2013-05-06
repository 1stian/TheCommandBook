package pro.homiecraft;

import java.io.File;
import java.io.IOException;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import pro.homiecraft.Commands.Resources.damageMap;
import pro.homiecraft.Commands.Resources.muteMap;
import pro.homiecraft.Commands.Resources.timePlayedMap;
import pro.homiecraft.Config.playerConfig;

public class Welcome implements Listener {
	
	@EventHandler
	public void PlayerJoin(PlayerJoinEvent event) throws IOException{
		Player player = event.getPlayer();
		
		//boolean firstWelcome = TheCommandBook.plugin.getConfig().getBoolean("TheCommandBook.Welcome.Enable first time welcome message");
		Boolean enableWelcome = TheCommandBook.pluginST.getConfig().getBoolean("TheCommandBook.Welcome.Enable-welcome-message", true);
		String welcomeMessage = TheCommandBook.pluginST.getConfig().getString("TheCommandBook.Welcome.Welcome-Message");
		
		welcomeMessage = welcomeMessage.replaceAll("&0", ChatColor.BLACK + "");
		welcomeMessage = welcomeMessage.replaceAll("&1", ChatColor.DARK_BLUE + "");
		welcomeMessage = welcomeMessage.replaceAll("&2", ChatColor.DARK_GREEN + "");
		welcomeMessage = welcomeMessage.replaceAll("&3", ChatColor.DARK_AQUA + "");
		welcomeMessage = welcomeMessage.replaceAll("&4", ChatColor.DARK_RED + "");
		welcomeMessage = welcomeMessage.replaceAll("&5", ChatColor.DARK_PURPLE + "");
		welcomeMessage = welcomeMessage.replaceAll("&6", ChatColor.GOLD + "");
		welcomeMessage = welcomeMessage.replaceAll("&7", ChatColor.GRAY + "");
		welcomeMessage = welcomeMessage.replaceAll("&8", ChatColor.DARK_GRAY+ "");
		welcomeMessage = welcomeMessage.replaceAll("&9", ChatColor.BLUE + "");
		welcomeMessage = welcomeMessage.replaceAll("&a", ChatColor.GREEN + "");
		welcomeMessage = welcomeMessage.replaceAll("&b", ChatColor.AQUA + "");
		welcomeMessage = welcomeMessage.replaceAll("&c", ChatColor.RED + "");
		welcomeMessage = welcomeMessage.replaceAll("&d", ChatColor.LIGHT_PURPLE + "");
		welcomeMessage = welcomeMessage.replaceAll("&e", ChatColor.YELLOW + "");
		welcomeMessage = welcomeMessage.replaceAll("&f", ChatColor.WHITE + "");
		welcomeMessage = welcomeMessage.replaceAll("&g", ChatColor.MAGIC + "");
		
		if (enableWelcome == true) {
			player.sendMessage(welcomeMessage);
		}
		
		File playerDir = new File (TheCommandBook.pluginST.getDataFolder() + "/playerdata");
		if (!playerDir.exists()){
			playerDir.mkdir();
		}
		
		File playerfile = new File(TheCommandBook.pluginST.getDataFolder() + "/playerdata/" + player.getName() + ".yml");
		if(!player.hasPlayedBefore() || !playerfile.exists()) {
			playerConfig.reloadPlayerConfig(player.getName());
			playerConfig.getPlayerConfig(player.getName()).set("Name", player.getName());
			playerConfig.savePlayerConfig(player.getName());
			playerConfig.reloadPlayerConfig(player.getName());
		}
		
		playerConfig.reloadPlayerConfig(player.getName());
		
		Boolean muted = playerConfig.getPlayerConfig(player.getName()).getBoolean("muted", false);
		if (muted == true){
			muteMap.mu.put(player, "mute");
		}else{
			muteMap.mu.remove(player);
		}
		
		Boolean god = playerConfig.getPlayerConfig(player.getName()).getBoolean("god", false);
		if(god == true){
			damageMap.dmg.put(player, true);
		}else{
			damageMap.dmg.remove(player);
		}
		
		long conTime = System.currentTimeMillis();
		timePlayedMap.tpl.put(player.getName(), conTime);
	}
	
}
