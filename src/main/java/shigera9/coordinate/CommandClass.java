package shigera9.coordinate;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.metadata.FixedMetadataValue;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.bukkit.Bukkit.getLogger;

public class CommandClass implements CommandExecutor, TabCompleter {
    Coordinate coordinate = Coordinate.getPlugin(Coordinate.class);
    protected final static String CIE_KEY = "cie";
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel,String[] args) {
        if(cmd.getName().equalsIgnoreCase("cie")) {
            if(sender instanceof Player){
                Player player =(Player) sender;
                if (args.length > 0) {
                    if(args[0].equalsIgnoreCase("on")){
                        player.setMetadata(
                                CIE_KEY,
                                new FixedMetadataValue(
                                        coordinate,"on"
                                ));
                        player.sendMessage("座標表示をONにしました。");
                    }
                    else if (args[0].equalsIgnoreCase("off")){
                        player.setMetadata(
                                CIE_KEY,
                                new FixedMetadataValue(
                                        coordinate,"off"
                                ));
                        player.sendMessage("座標表示をOFFにしました。");
                    }
                }
                else {
                    player.sendMessage("on/offを指定して下さい。");
                }


            } else {
                getLogger().info("このコマンドはプレイヤーしか実行出来ません。");
            }

        }
        return false;

    }

    public List<String> onTabComplete(CommandSender sender,Command cmd,String alias, String[] args) {
        if (cmd.getName().equalsIgnoreCase("cie")) {
            if (args.length == 1) {
                if (args[0].length() == 0) {
                    return Arrays.asList("off", "on");
                } else {
                    if ("on".startsWith(args[0]) && "off".startsWith(args[0])) {
                        return Arrays.asList("off", "on");
                    } else if ("on".startsWith(args[0])) {
                        return Collections.singletonList("on");
                    } else if ("off".startsWith(args[0])) {
                        return Collections.singletonList("off");
                    }
                }
            }
        }
        return null;
    }


}
