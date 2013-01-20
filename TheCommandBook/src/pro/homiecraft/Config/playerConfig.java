package pro.homiecraft.Config;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.InputStream;
 

import pro.homiecraft.TheCommandBook;
 
public class playerConfig {
        static TheCommandBook plugin;
        public playerConfig(TheCommandBook plugin) {
                playerConfig.plugin = plugin;
        }
       
        public static FileConfiguration customConfig = null;
        public static File customConfigFile = null;
       
        public static void reloadPlayerConfig(String player) {
                customConfigFile = new File(TheCommandBook.pluginST.getDataFolder() + "/playerdata/" + player + ".yml");
                customConfig = YamlConfiguration.loadConfiguration(customConfigFile);
               
                InputStream defConfigStream = TheCommandBook.pluginST.getResource("/playerdata/" + player + ".yml");
                if (defConfigStream != null) {
                        YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(defConfigStream);
                        customConfig.setDefaults(defConfig);
                }
        }
       
        public static FileConfiguration getPlayerConfig(String player) {
                reloadPlayerConfig(player);
                return customConfig;
        }
       
        public static void savePlayerConfig(String player) {
                if (customConfig == null || customConfigFile == null) {
                        return;
                }
               
                try {
                        customConfig.save(customConfigFile);
                } catch (IOException e) {
                        Logger.getLogger("Minecraft").severe("Could not save " + player + "'s config to the disk!");
                }
        }
}