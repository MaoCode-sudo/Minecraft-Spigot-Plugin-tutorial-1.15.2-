package me.maocode.armorstand;



import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.EulerAngle;

import java.util.Collection;


public final class Armorstand extends JavaPlugin implements Listener {

    ArmorStand armorStand;
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this,this);
    }

    @Override
    public void onDisable() {

    }

    @EventHandler
    public void onMove(PlayerMoveEvent event){
        Player player = event.getPlayer();
        armorStand.teleport(player.getLocation());
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        if(command.getName().equalsIgnoreCase("create")){
            ArmorStand armorStand = (ArmorStand) player.getWorld().spawnEntity(player.getLocation(), EntityType.ARMOR_STAND);
            armorStand.setCustomName(ChatColor.GREEN + "Hello" + ChatColor.RED + "World");
            armorStand.setCustomNameVisible(true);
            //armorStand.setVisible(false);
            armorStand.setGravity(false);
            armorStand.setArms(true);
            armorStand.setLeftArmPose(new EulerAngle(Math.toRadians(249f),0,0));
            armorStand.setRightArmPose(new EulerAngle(Math.toRadians(183f),0,0));
            this.armorStand = armorStand;

        }
        else if(command.getName().equalsIgnoreCase("read")){
            Location loc = player.getLocation();
            Collection<Entity> CollectionEntity = loc.getWorld().getNearbyEntities(loc,5,5,5);
            for(Entity entity : CollectionEntity){
                if(entity instanceof ArmorStand){
                    if(entity.getCustomName().equalsIgnoreCase(ChatColor.AQUA + "MaoCode")) {
                        player.sendMessage("ใช่ มันคือ Armorstand ชื่อ MaoCode");
                        entity.setCustomName(ChatColor.AQUA + args[0]);
                    }
                    else {
                        player.sendMessage("ไม่ใช่ มันไม่ได้ชื่อ MaoCode");
                        entity.setCustomName(ChatColor.GREEN + args[1]);
                    }
                }
                else {
                    player.sendMessage("ไม่ใช่");
                    player.sendMessage(CollectionEntity + "");
                }
            }

        }
        return true;
    }
}
