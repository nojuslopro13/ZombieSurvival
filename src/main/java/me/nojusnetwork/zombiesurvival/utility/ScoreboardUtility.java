package me.nojusnetwork.zombiesurvival.utility;

import me.nojusnetwork.zombiesurvival.Zombiesurvival;
import me.nojusnetwork.zombiesurvival.other.GameModifiers;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.*;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ScoreboardUtility {
     private GameModifiers modifiers;
    public ScoreboardUtility(GameModifiers modifiers) {
        this.modifiers = modifiers;
    }

    public void New(Player player) {
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(System.currentTimeMillis());
        ScoreboardManager manager = Bukkit.getScoreboardManager();
        Scoreboard board = manager.getNewScoreboard();
        Objective objective = board.registerNewObjective(ChatColor.GREEN + "" + ChatColor.BOLD + "ᴢᴏᴍʙɪų ɪšɢʏᴠᴇɴɪᴍᴀs", "dummy");

        Score emptyScore = objective.getScore(" ");
        Score deaths = objective.getScore(ChatColor.BLUE + " ᴍɪʀᴛʏs: " + ChatColor.WHITE + "" + player.getStatistic(Statistic.DEATHS));
        Score datee = objective.getScore(ChatColor.GRAY + "     " + formatter.format(date));
        Score modifierop = objective.getScore(ChatColor.BLUE + " ᴍᴏᴅɪғɪᴋᴀᴄɪᴊᴀ: " + ChatColor.WHITE + "ᴏᴘ ᴢᴏᴍʙɪᴀɪ");
        Score modifieroff = objective.getScore(ChatColor.BLUE + " ᴍᴏᴅɪғɪᴋᴀᴄɪᴊᴀ: " + ChatColor.WHITE + "ɪšᴊᴜɴɢᴛᴀ");
        Score modifierstrength = objective.getScore(ChatColor.BLUE + " ᴍᴏᴅɪғɪᴋᴀᴄɪᴊᴀ: " + ChatColor.WHITE + "");

        if (modifiers.getModifier() == "strength") {
            datee.setScore(0);
            emptyScore.setScore(1);
            modifierstrength.setScore(2);
            deaths.setScore(3);
        }

        if (modifiers.getModifier() == "off") {
            datee.setScore(0);
            emptyScore.setScore(1);
            modifieroff.setScore(2);
            deaths.setScore(3);
        }

        if (modifiers.getModifier() == "opzombies") {
            datee.setScore(0);
            emptyScore.setScore(1);
            modifierop.setScore(2);
            deaths.setScore(3);
        }

        if (modifiers.getModifier() == null) {
            Bukkit.getPluginManager().disablePlugin(Zombiesurvival.getPlugin());
        }


        player.setScoreboard(board);
    }


}
