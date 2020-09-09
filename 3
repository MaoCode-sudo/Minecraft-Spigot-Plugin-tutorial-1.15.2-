package me.spigot.command;


import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.UUID;

public final class Command extends JavaPlugin {


    HashMap<UUID, LocalDateTime> timer = new HashMap<UUID, LocalDateTime>();

    @Override
    public void onEnable() {
        Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "Command : Enable");

    }

    @Override
    public void onDisable() {

    }

    @Override
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command command, String label, String[] args) {
        Player player = (Player) sender;
        if(sender instanceof Player){
            if(command.getName().equalsIgnoreCase("freeitem")){
                if(args.length < 1){
                    player.sendMessage(ChatColor.RED + "กรุณาพิมพ์คำสั่งให้ครบ");
                }
                else if(args.length == 1 ){
                    if(!(timer.containsKey(player.getUniqueId()))) {
                        Material material = Material.getMaterial(args[0].toUpperCase());
                        player.getInventory().addItem(new ItemStack(material, 1));
                        player.sendMessage(ChatColor.GREEN + "ได้รับ " + args[0] + " 1 ชิ้น");
                        timer.put(player.getUniqueId(),LocalDateTime.now().plusHours(1));
                    }
                    else if(LocalDateTime.now().isAfter(timer.get(player.getUniqueId()))){
                        Material material = Material.getMaterial(args[0].toUpperCase());
                        player.getInventory().addItem(new ItemStack(material, 1));
                        player.sendMessage(ChatColor.GREEN + "ได้รับ " + args[0] + " 1 ชิ้น");
                        timer.put(player.getUniqueId(),LocalDateTime.now().plusHours(1));
                    }
                    player.sendMessage(ChatColor.GREEN + "เวลารับของต่อไปคือ : " + timer.get(player.getUniqueId()));


                }



            }
            else if(command.getName().equalsIgnoreCase("heal")){
                if(args.length < 1){
                    player.sendMessage(ChatColor.RED + "กรุณาพิมพ์คำสั่งให้ครบ");
                }
                else if(args.length == 1 ){
                    double dnumber = player.getHealth();
                    double dvalue = Double.parseDouble(args[0]);
                    if(player.getHealth() < 20){
                        player.setHealth(dnumber + dvalue);
                        player.sendMessage(ChatColor.GREEN + "ฮีลจำนวน " + args[0] );
                    }
                    else {
                        player.sendMessage("ไม่ตรงเงื่อนไข");
                    }

                }
            }
            else {
                player.sendMessage(ChatColor.RED + "ไม่มีคำสั่งนี้");
            }



        }
        else {
            sender.sendMessage("คุณไม่มีสิทธิ์!!");
        }




        return true;
    }
}
