package re.vivide.kte;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

import java.util.ArrayList;


public class Game {
    private KTE kte;
    Scoreboard kte_scoreboard;
    private ArrayList<Player> players = new ArrayList<>();
    boolean active;

    public Game(KTE instance){
        active = true;
        kte = instance;
        kte_scoreboard = kte.getServer().getScoreboardManager().getNewScoreboard();
        Objective obj = kte_scoreboard.registerNewObjective("KTE_board", "dummy");
        obj.setDisplaySlot(DisplaySlot.SIDEBAR);
        obj.setDisplayName(ChatColor.DARK_PURPLE + "Kill The EALD 2");
        obj.getScore(" ").setScore(10);
        Timer timer = new Timer(obj);
        timer.start();
    }

    public void addPlayer(Player p){
        players.add(p);
        p.setScoreboard(kte_scoreboard);
    }

    public void removePlayer(Player p ){
        players.remove(p);
        p.setScoreboard(Bukkit.getScoreboardManager().getNewScoreboard());
    }
}
