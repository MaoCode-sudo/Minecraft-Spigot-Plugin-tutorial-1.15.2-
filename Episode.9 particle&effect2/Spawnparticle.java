package me.maocode.spawnparticle;

import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;


public final class Spawnparticle extends JavaPlugin implements Listener {
    BukkitTask particle;
    Location particlelocation;
    @Override
    public void onEnable() {

        particle = new particleEffect().runTaskTimer(this,0,10);
    }

    @Override
    public void onDisable() {

    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        if(command.getName().equalsIgnoreCase("close")){

            player.sendMessage("particle : Close");
            particle.cancel();


        }
        else if(command.getName().equalsIgnoreCase("start")){

            player.sendMessage("particle : Start");
            particle = new particleEffect().runTaskTimer(this,0,20);
            particlelocation = player.getLocation();

        }

        return true;

    }

    public class particleEffect extends BukkitRunnable {
        @Override
        public void run() {
            for(Player player : Bukkit.getOnlinePlayers()){
                int maxpoint = 100;
                double radius = 2.0d;
                for(int i = 0; i< maxpoint ; i++) {
                    double angle = 2 * Math.PI * i/maxpoint;
                    Location location = particlelocation.clone().add(radius * Math.sin(angle),radius * Math.cos(angle),0);

                    Particle.DustOptions dustOptions = new Particle.DustOptions(Color.fromBGR(0, 150, 0), 2);
                    player.getWorld().spawnParticle(Particle.REDSTONE, location, 1, dustOptions);

                }
            }
        }
    }
}





