package re.vivide.kte;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

public class KTE extends JavaPlugin{
    static Scoreboard kte_scoreboard;

    @Override
    public void onEnable(){
        getServer().getPluginManager().registerEvents(new MainListener(), this);
        kte_scoreboard = getServer().getScoreboardManager().getNewScoreboard();
        Objective obj = kte_scoreboard.registerNewObjective("KTE_board", "dummy");
        obj.setDisplaySlot(DisplaySlot.SIDEBAR);
        obj.setDisplayName("Kill The EALD 2");
        obj.getScore("oui").setScore(2);
    }

    @Override
    public void onDisable(){

    }
}


