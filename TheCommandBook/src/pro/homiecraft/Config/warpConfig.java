package pro.homiecraft.Config;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Logger;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import pro.homiecraft.TheCommandBook;

public class warpConfig {
	static TheCommandBook plugin;
    public warpConfig(TheCommandBook plugin) {
    	warpConfig.plugin = plugin;
    }
   
    public static FileConfiguration customConfig = null;
    public static File customConfigFile = null;
   
    public static void reloadWarpConfig(String warp) {
            
            customConfigFile = new File(TheCommandBook.pluginST.getDataFolder() + "/data/warps/" + warp + ".yml");
            
            customConfig = YamlConfiguration.loadConfiguration(customConfigFile);
           
            InputStream defConfigStream = TheCommandBook.pluginST.getResource("/data/warps/" + warp + ".yml");
            if (defConfigStream != null) {
                    YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(defConfigStream);
                    customConfig.setDefaults(defConfig);
            }
    }
   
    public static FileConfiguration getWarpConfig(String warp) {
            if (customConfig == null) {
                    reloadWarpConfig(warp);
            }
            return customConfig;
    }
   
    public static void saveWarpConfig(String warp) {
            if (customConfig == null || customConfigFile == null) {
                    return;
            }
           
            try {
                    customConfig.save(customConfigFile);
            } catch (IOException e) {
                    Logger.getLogger("Minecraft").severe("Could not save " + warp);
            }
    }
}
