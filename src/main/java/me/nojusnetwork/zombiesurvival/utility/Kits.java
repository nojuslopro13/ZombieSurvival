package me.nojusnetwork.zombiesurvival.utility;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Kits {
    public static void giveKit(Player player) {
        Inventory playerInv = player.getInventory();

        ItemStack sword = new ItemStack(Material.STONE_SWORD);
        ItemStack helmet = new ItemStack(Material.IRON_HELMET);
        ItemStack chestplate = new ItemStack(Material.IRON_CHESTPLATE);
        ItemStack leggings = new ItemStack(Material.IRON_LEGGINGS);
        ItemStack boots = new ItemStack(Material.IRON_BOOTS);


        ItemMeta swordMeta = sword.getItemMeta();
        ItemMeta helmetMeta = helmet.getItemMeta();
        ItemMeta chestplateMeta = chestplate.getItemMeta();
        ItemMeta leggingsMeta = leggings.getItemMeta();
        ItemMeta bootsMeta = boots.getItemMeta();

        swordMeta.setUnbreakable(true);
        helmetMeta.setUnbreakable(true);
        chestplateMeta.setUnbreakable(true);
        leggingsMeta.setUnbreakable(true);
        bootsMeta.setUnbreakable(true);

        sword.setItemMeta(swordMeta);
        helmet.setItemMeta(helmetMeta);
        chestplate.setItemMeta(chestplateMeta);
        leggings.setItemMeta(leggingsMeta);
        boots.setItemMeta(bootsMeta);

        playerInv.setItem(0, sword);
        player.getInventory().setHelmet(helmet);
        player.getInventory().setChestplate(chestplate);
        player.getInventory().setLeggings(leggings);
        player.getInventory().setBoots(boots);
    }
}
