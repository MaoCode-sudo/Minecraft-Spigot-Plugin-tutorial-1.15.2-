package me.spigot.config;




import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public final class Config extends JavaPlugin  {
    @Override
    public void onEnable() {

        saveDefaultConfig();
        getServer().getPluginManager().registerEvents(new PlayerJoin(this),this);

    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;

        if(command.getName().equalsIgnoreCase("read")){
            List<String> stringList = getConfig().getStringList("List");
            for(String s : getConfig().getStringList("List")){
                player.sendMessage("ค่าที่อ่านได้จาก stringList : " + s);
            }



        }
        else if(command.getName().equalsIgnoreCase("write")){
            //int x = Integer.parseInt(args[1]);
            /*List<String> stringList = new ArrayList<>();
            stringList.add(args[0]);
            stringList.add(args[1]);
            stringList.add(args[2]);
            */

            getConfig().set("Line1",args[0]);
            saveConfig();

            //player.sendMessage("ค่าที่บันทึกใน : " + stringList);
        }

        return true;
    }

    @Override
    public void onDisable() {

    }


}
