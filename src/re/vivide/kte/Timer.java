package re.vivide.kte;

import org.bukkit.ChatColor;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

public class Timer extends Thread {
    private int hours = 0;
    private int minutes = 0;
    private int seconds = 0;
    private Objective obj;
    private String last = "";
    public Timer(Objective o){
        obj = o;
    }

    public void run(){
        while(KTE.game.active){
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
}
