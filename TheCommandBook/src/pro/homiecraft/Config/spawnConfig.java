package pro.homiecraft.Config;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Logger;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import pro.homiecraft.TheCommandBook;

public class spawnConfig {
	static TheCommandBook plugin;
    public spawnConfig(TheCommandBook plugin) {
    	spawnConfig.plugin = plugin;
    }
   
    public static FileConfiguration customConfig = null;
    public static File customConfigFile = null;
   
    public static void reloadSpawnConfig(String spawn) {
            
            customConfigFile = new File(TheCommandBook.pluginST.getDataFolder() + "/data/" + spawn + ".yml");
            
            customConfig = YamlConfiguration.loadConfiguration(customConfigFile);
           
            InputStream defConfigStream = TheCommandBook.pluginST.getResource("/data/" + spawn + ".yml");
            if (defConfigStream != null) {
                    YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(defConfigStream);
                    customConfig.setDefaults(defConfig);
            }
    }
   
    public static FileConfiguration getSpawnConfig(String spawn) {
            if (customConfig == null) {
                    reloadSpawnConfig(spawn);
            }
            return customConfig;
    }
   
    public static void saveSpawnConfig(String spawn) {
            if (customConfig == null || customConfigFile == null) {
                    return;
            }
           
            try {
                    customConfig.save(customConfigFile);
            } catch (IOException e) {
                    Logger.getLogger("Minecraft").severe("Could not save " + spawn);
            }
    }
}
