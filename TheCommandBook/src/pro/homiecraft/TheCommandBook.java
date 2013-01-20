package pro.homiecraft;

import java.util.logging.Logger;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import pro.homiecraft.Commands.*;

public class TheCommandBook extends JavaPlugin{
	public static TheCommandBook pluginST;
	public TheCommandBook plugin;
	public Logger log = Logger.getLogger("Minecraft");
	
	
	public void onDisable() {
		
	}
	
	public void onEnable() {
		//Updater updater = new Updater(this, "TheCommandBook", this.getFile(), Updater.UpdateType.DEFAULT, false);
		
		PluginManager pm = getServer().getPluginManager();
			pm.registerEvents(new Welcome(), this);
			pm.registerEvents(new Chat(), this);
			pm.registerEvents(new Damage(), this);
			pm.registerEvents(new PlayerLeave(), this);
			
		TheCommandBook.pluginST = this;
		
		loadConfiguration();
		getCommand(this);
	}

	private void getCommand(TheCommandBook theCommandBook) {
		this.getCommand("setspawn").setExecutor(new tcbSetSpawn());
		this.getCommand("spawn").setExecutor(new tcbSpawn());
		this.getCommand("sethome").setExecutor(new tcbSethome());
		this.getCommand("home").setExecutor(new tcbHome());
		this.getCommand("tp").setExecutor(new tcbTp());
		this.getCommand("tphere").setExecutor(new tcbTphere());
		this.getCommand("setwarp").setExecutor(new tcbSetwarp());
		this.getCommand("warp").setExecutor(new tcbWarp());
		this.getCommand("delwarp").setExecutor(new tcbDelwarp());
		this.getCommand("warps").setExecutor(new tcbWarps());
		this.getCommand("mute").setExecutor(new tcbMute());
		this.getCommand("kick").setExecutor(new tcbKick());
		this.getCommand("ban").setExecutor(new tcbBan());
		this.getCommand("unban").setExecutor(new tcbUnban());
		this.getCommand("msg").setExecutor(new tcbMsg());
		this.getCommand("time").setExecutor(new tcbTime());
		this.getCommand("weather").setExecutor(new tcbWeather());
		this.getCommand("gm").setExecutor(new tcbGm());
		this.getCommand("god").setExecutor(new tcbGod());
	}
	
	public void loadConfiguration() {
		if(!getDataFolder().exists()){
			getDataFolder().mkdir();
		}		
		
		this.getConfig().options().copyDefaults(true);
		this.saveConfig();
		this.reloadConfig();
	}
}
