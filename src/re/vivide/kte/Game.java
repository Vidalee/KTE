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
    private String sc_playersCount = "Joueurs : " + ChatColor.AQUA + "0";
    private Objective obj;

    public Game(KTE instance){
        active = true;
        kte = instance;
        kte_scoreboard = kte.getServer().getScoreboardManager().getNewScoreboard();
        obj = kte_scoreboard.registerNewObjective("KTE_board", "dummy");
        obj.setDisplaySlot(DisplaySlot.SIDEBAR);
        obj.setDisplayName(ChatColor.DARK_PURPLE + "Kill The EALD 2");
        obj.getScore(" ").setScore(10);
    }

    public void addPlayer(Player p){
        players.add(p);
        p.setScoreboard(kte_scoreboard);
        updatePlayersCount();
    }

    public void removePlayer(Player p ){
        players.remove(p);
        p.setScoreboard(Bukkit.getScoreboardManager().getNewScoreboard());
        updatePlayersCount();
    }

    private void updatePlayersCount(){
        kte_scoreboard.resetScores(sc_playersCount);
        sc_playersCount = "Joueurs : " + ChatColor.AQUA + players.size();
        obj.getScore(sc_playersCount).setScore(9);
    }
}
