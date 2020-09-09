package me.maocode.spawnparticle;

import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPotionEffectEvent;
import org.bukkit.plugin.java.JavaPlugin;

import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import java.util.Collection;


public final class Spawnparticle extends JavaPlugin implements Listener {
    BukkitTask particle;
    Location particlelocation;


    @Override
    public void onEnable() {

        Bukkit.getServer().getPluginManager().registerEvents(this,this);
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
        else if(command.getName().equalsIgnoreCase("clound")){
            AreaEffectCloud areaeff = (AreaEffectCloud) player.getWorld().spawnEntity(player.getLocation(),EntityType.AREA_EFFECT_CLOUD);
            Particle.DustOptions dustOptions = new Particle.DustOptions(Color.fromBGR(0, 150, 0), 0);
            areaeff.setCustomName(ChatColor.RED + "วาร์ปไปยัง" + ChatColor.GREEN + "หมู่บ้าน");
            areaeff.setCustomNameVisible(true);
            areaeff.setParticle(Particle.REDSTONE,dustOptions);
            areaeff.setDuration(20*10);
            areaeff.addCustomEffect(new PotionEffect(PotionEffectType.JUMP,20*5,5),true);


        }

        return true;

    }

    @EventHandler
    public void onEffect(EntityPotionEffectEvent event){
        Player player = (Player) event.getEntity();
        if(event.getCause() == EntityPotionEffectEvent.Cause.AREA_EFFECT_CLOUD){
            World world = player.getWorld();
            Location location = new Location(world,-473,52,-424);
            player.sendMessage("นี่คือ : " + event.getCause());
            player.teleport(location);

        }


    }





    public class particleEffect extends BukkitRunnable {
        @Override
        public void run() {
            for(Player player : Bukkit.getOnlinePlayers()){


                int maxpoint = 100;
                double radius = 2.0d;
                for(int i = 0; i< maxpoint ; i++) {
                    double angle = 2 * Math.PI * i/maxpoint;

                    Location location = particlelocation.clone().add(radius * Math.sin(angle),radius * Math.cos(angle)+1,0);

                    Particle.DustOptions dustOptions = new Particle.DustOptions(Color.fromBGR(0, 150, 0), 2);
                    player.getWorld().spawnParticle(Particle.REDSTONE, location, 1, dustOptions);
                }
            }
        }
    }

}





