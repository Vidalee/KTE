package re.vivide.kte;

import org.bukkit.plugin.java.JavaPlugin;


public class KTE extends JavaPlugin{
    static Game game;
    @Override
    public void onEnable(){
        getServer().getPluginManager().registerEvents(new MainListener(), this);
        game = new Game(this);
    }

    @Override
    public void onDisable(){

    }
}


