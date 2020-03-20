package re.vivide.kte;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.spigotmc.event.entity.EntityDismountEvent;

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

    @EventHandler
    public void onInteractEvent(PlayerInteractEvent event){
        Player p = event.getPlayer();
        Block b = event.getClickedBlock();
        if(event.getAction().equals(Action.RIGHT_CLICK_BLOCK) && event.getClickedBlock().getType() == Material.PINK_CARPET){
            Arrow arrow = p.getWorld().spawn(b.getLocation().add(0.5D, 0.2D, 0.5D), Arrow.class);
            arrow.addPassenger(p);
        }
    }

    @EventHandler
    public void onEntityDismountEvent(EntityDismountEvent event){
        Entity entity = event.getEntity();
        Entity dismounted = event.getDismounted();
        if(entity.getType().equals(EntityType.PLAYER) && dismounted.getType().equals(EntityType.ARROW)) {
            dismounted.remove();
        }
    }
}