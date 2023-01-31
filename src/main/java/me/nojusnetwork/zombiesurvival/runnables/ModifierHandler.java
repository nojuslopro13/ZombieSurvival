package me.nojusnetwork.zombiesurvival.runnables;

import me.nojusnetwork.zombiesurvival.other.GameModifiers;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Random;

public class ModifierHandler extends BukkitRunnable {
    private GameModifiers modifiers;

    public ModifierHandler(GameModifiers modifiers) {
        this.modifiers = modifiers;
    }


    @Override
    public void run() {
        Random random = new Random();
        int number = random.nextInt(2);
        switch (number) {
            case 0:
                for (Player player : Bukkit.getOnlinePlayers()) {
                    player.sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.GREEN + "žᴀɪᴅɪᴍᴏ ᴍᴏᴅɪғɪᴋᴀᴄɪᴊą: " + ChatColor.RED + "ᴏᴘ ᴢᴏᴍʙɪᴀɪ"));
                    modifiers.setModifier("ᴏᴘ ᴢᴏᴍʙɪᴀɪ");
                    player.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);

                }
                break;
            case 1:
                for (Player player : Bukkit.getOnlinePlayers()) {
                    player.sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.GREEN + "žᴀɪᴅɪᴍᴏ ᴍᴏᴅɪғɪᴋᴀᴄɪᴊą: " + ChatColor.RED + "ɪšᴊᴜɴɢᴛᴀ"));
                    modifiers.setModifier("ɪšᴊᴜɴɢᴛᴀ");
                    player.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);

                }
            case 2:
                for (Player player : Bukkit.getOnlinePlayers()) {
                    player.sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.GREEN + "žᴀɪᴅɪᴍᴏ ᴍᴏᴅɪғɪᴋᴀᴄɪᴊą: " + ChatColor.RED + "ᴅɪᴅᴇsɴɪs žᴀɪᴅėᴊᴏ sᴛɪᴘʀᴜᴍᴀs"));
                    modifiers.setModifier("sᴛɪᴘʀᴜᴍᴀs");
                    player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 100000, 1));

                }
        }
    }
}
