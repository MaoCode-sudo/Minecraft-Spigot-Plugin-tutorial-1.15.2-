package me.spigot.config;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerJoin implements Listener {
    Config plugin;

    public PlayerJoin(Config plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();

        player.sendMessage("ยินดีต้อนรับ" + player.getName() + plugin.getConfig().get("Line1"));
        //event.setJoinMessage("ยินดีต้อนรับกลับคุณ " + player.getName() + "สู่เซิฟเวอร์ของเรา");
        player.sendTitle("",player.getName(),50,50,50);


    }
    @EventHandler
    public void onLeave(PlayerQuitEvent event){

        event.setQuitMessage("ออกจากเกม");


    }


}
