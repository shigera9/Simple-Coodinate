package shigera9.coordinate;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.metadata.MetadataValue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static shigera9.coordinate.CommandClass.CIE_KEY;

public class EventClass implements Listener {

    Coordinate coordinate = Coordinate.getPlugin(Coordinate.class);

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){
        Player p = e.getPlayer();
        p.setMetadata(
                CIE_KEY,
                new FixedMetadataValue(
                        coordinate,"on"
                ));
    }


    @EventHandler
    public void onPlayerMove(PlayerMoveEvent e) {
        Player p = e.getPlayer();
        List<MetadataValue> list = p.getMetadata(CIE_KEY);

        if(list.get(0).value().toString().equalsIgnoreCase("on")){
            Location loc = p.getLocation();

            double x = loc.getX();
            double y = loc.getY();
            double z = loc.getZ();
            float yaw = loc.getYaw();
            String yaw_s = null;


            if
            (yaw == 0){
                yaw_s = "+z";
            }
            if(-90 < yaw && yaw < 0 ){
                yaw_s = "+x,+z";
            }
            if(yaw == -90){
                yaw_s = "+x";
            }
            if(-180 < yaw && yaw < -90 ){
                yaw_s = "+x,-z";
            }
            if(yaw == -180){
                yaw_s = "-z";
            }
            if(0 < yaw && yaw < 90 ){
                yaw_s = "-x,+z";
            }
            if(yaw == 90){
                yaw_s = "-x";
            }
            if(90 < yaw && yaw < 180 ){
                yaw_s = "-x,-z";
            }

            String xs = String.valueOf((int)x);
            String ys = String.valueOf((int)y);
            String zs = String.valueOf((int)z);

            TextComponent c = new TextComponent();

            c.setText("座標:" + xs + ", " + ys + ", " + zs + " 向き:" + yaw_s );
            p.spigot().sendMessage(ChatMessageType.ACTION_BAR, c);


        }
    }
}
