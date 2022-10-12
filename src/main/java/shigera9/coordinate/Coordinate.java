package shigera9.coordinate;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class Coordinate extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getConsoleSender().sendMessage(ChatColor.YELLOW+"Coordinateプラグインが読み込まれました。");
        getCommand("cie").setExecutor(new CommandClass());
        getServer().getPluginManager().registerEvents(new EventClass(),this);


    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
