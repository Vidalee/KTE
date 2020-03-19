package re.vivide.kte;

import org.bukkit.ChatColor;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

import java.io.Console;


public class Timer {
    private int hours = 0;
    private int minutes = 0;
    private int seconds = 0;
    private Objective obj;
    private String last = "";
    public Timer(Objective o, KTE instance){
        obj = o;

        new BukkitRunnable() {

            @Override
            public void run() {
                System.out.println("a");
                if(KTE.game.active){
                    seconds++;
                    if(seconds == 60){
                        seconds = 0;
                        minutes++;
                    }
                    if(minutes == 60){
                        minutes = 0;
                        hours++;
                    }
                    if(last != ""){
                        obj.getScoreboard().resetScores(last);
                        String temp = "Temps : " + ChatColor.RED + hours + ":" + minutes + ":" + seconds;
                        obj.getScore(temp).setScore(9);
                        last = temp;
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        }.runTaskTimer(instance, 0l, 20l);
    }

}
