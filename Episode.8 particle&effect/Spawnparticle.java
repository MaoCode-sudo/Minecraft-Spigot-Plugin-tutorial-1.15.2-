package me.maocode.spawnparticle;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Particle;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

public final class Spawnparticle extends JavaPlugin implements Listener {
    BukkitTask particle;
    @Override
    public void onEnable() {

        particle = new particleEffect().runTaskTimer(this,0,20);
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


        }

        return true;

    }

    public static class particleEffect extends BukkitRunnable {
        @Override
        public void run() {
            for(Player player : Bukkit.getOnlinePlayers()){
                Particle.DustOptions dustOptions = new Particle.DustOptions(Color.fromBGR(0,255,0),5);
                player.getWorld().spawnParticle(Particle.REDSTONE,player.getLocation().add(0,2,0),100,dustOptions);
                //player.getWorld().playEffect(player.getLocation().add(0,2,0), Effect.DRAGON_BREATH,1);

            }


        }
    }







}
