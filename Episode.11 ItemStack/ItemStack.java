package me.maocode.itemstack;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public final class Itemstack extends JavaPlugin {

    @Override
    public void onEnable() {

    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        if(command.getName().equalsIgnoreCase("item")){
            ItemStack itemStack = new ItemStack(Material.DIAMOND_SWORD);

            ItemMeta itemMeta = itemStack.getItemMeta();
            itemMeta.setUnbreakable(true);
            itemMeta.setDisplayName(ChatColor.RED + "SwordFire");
            itemMeta.addEnchant(Enchantment.DAMAGE_ALL,50,true);
            List<String> stringList = new ArrayList<>();
            stringList.add(ChatColor.GOLD + "Line1 ♣");
            stringList.add(ChatColor.GREEN + "Line2♠");
            stringList.add(ChatColor.GRAY + "Line3♀");
            stringList.add(ChatColor.AQUA + "Line4");

            AttributeModifier attributeModifier = new AttributeModifier("Fire",50, AttributeModifier.Operation.ADD_NUMBER);
            itemMeta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE,attributeModifier);

            itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

            itemMeta.setLore(stringList);
            itemStack.setItemMeta(itemMeta);





            player.getInventory().addItem(itemStack);
        }



        return true;
    }

    @Override
    public void onDisable() {

    }
}
