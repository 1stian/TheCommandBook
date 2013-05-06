package pro.homiecraft;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import pro.homiecraft.Commands.Resources.muteMap;

@SuppressWarnings("deprecation")
public class Chat implements Listener {
	@EventHandler
	public void onChat(AsyncPlayerChatEvent event){
		Player target = event.getPlayer();
		if (muteMap.mu.containsKey(target)) {
			if (muteMap.mu.containsValue("mute")) {
				event.setCancelled(true);
				target.sendMessage("You are muted!");
			}
		}
	}
}
