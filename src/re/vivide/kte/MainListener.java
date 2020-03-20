package re.vivide.kte;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class MainListener implements Listener{

    @EventHandler
    public void onPlayerChangedWorld(PlayerChangedWorldEvent event){
        Player p = event.getPlayer();
        if(p.getWorld().getName().contains("kte")){
            KTE.game.addPlayer(p);
        }else{
            KTE.game.removePlayer(p);
        }
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        Player p = event.getPlayer();
        if(p.getWorld().getName().contains("kte")){
            KTE.game.addPlayer(p);
        }else{
            KTE.game.removePlayer(p);
        }
    }
}