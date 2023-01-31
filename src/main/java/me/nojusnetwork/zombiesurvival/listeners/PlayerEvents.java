package me.nojusnetwork.zombiesurvival.listeners;

import me.nojusnetwork.zombiesurvival.Zombiesurvival;
import me.nojusnetwork.zombiesurvival.other.GameModifiers;
import me.nojusnetwork.zombiesurvival.other.Values;
import me.nojusnetwork.zombiesurvival.utility.Kits;
import me.nojusnetwork.zombiesurvival.utility.ScoreboardUtility;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.*;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PlayerEvents implements Listener {
    private Values impValues;
    private GameModifiers modifiers;
    public PlayerEvents(Values impValues, GameModifiers modifiers) {
        this.impValues = impValues;
        this.modifiers = modifiers;
    }

    public void onPlayerKillEntity() {

    }

    @EventHandler
    public void onPlayerTookDamage(EntityDamageEvent event) {
        if (event.getCause() == EntityDamageEvent.DamageCause.FALL) {
            event.setCancelled(true);
        }

    }


    @EventHandler
    public void onPlayerTookDamagebyEntity(EntityDamageByEntityEvent event) {
        if (event.getEntity() instanceof Player) {
            if (event.getDamager() instanceof Player) {
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {

        Player player = event.getPlayer();
        player.teleport(new Location(Bukkit.getWorld("world"), -11, 105,1));
        player.setGameMode(GameMode.ADVENTURE);
        player.getInventory().clear();
        Kits.giveKit(player);
        BukkitRunnable task = new BukkitRunnable() {
            @Override
            public void run() {;
                // ScoreboardUtility scoreboardUtility = new ScoreboardUtility(modifiers);
                //scoreboardUtility.New(player);
                SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
                Date date = new Date(System.currentTimeMillis());
                ScoreboardManager manager = Bukkit.getScoreboardManager();
                Scoreboard board = manager.getNewScoreboard();
                Objective objective = board.registerNewObjective(ChatColor.GREEN + "" + ChatColor.BOLD + "ᴢᴏᴍʙɪų ɪšɢʏᴠᴇɴɪᴍᴀs", "dummy");
                objective.setDisplaySlot(DisplaySlot.SIDEBAR);
                Score emptyScore = objective.getScore(" ");
                Score deaths = objective.getScore(ChatColor.BLUE + "    ᴍɪʀᴛʏs: " + ChatColor.WHITE + "" + player.getStatistic(Statistic.DEATHS));
               // Score datee = objective.getScore(ChatColor.GRAY + "     " + formatter.format(date));
                Score modifier = objective.getScore(ChatColor.BLUE + "      ᴍᴏᴅɪғɪᴋᴀᴄɪᴊᴀ: " + ChatColor.WHITE + modifiers.getModifier());



              //  datee.setScore(0);
                emptyScore.setScore(0);
                modifier.setScore(1);
                deaths.setScore(2);


                player.setScoreboard(board);
            }
        };
        task.runTaskTimer(Zombiesurvival.getPlugin(), 0, 20 * 2);

        event.setJoinMessage(ChatColor.BLUE + player.getName() + ChatColor.LIGHT_PURPLE + " ᴘʀɪsɪᴊᴜɴɢė į ᴛᴇsᴛᴀᴠɪᴍᴏ sᴇᴀɴsą");
        impValues.setTotalPlayerPlayed(impValues.getTotalPlayerPlayed() + 1);
        if (!player.hasPlayedBefore()) {
            setNewFunctionsForNewPlayers(player);
        }



    }

    @EventHandler
    public void entitySpawned(CreatureSpawnEvent event) {
        switch (event.getEntityType()) {
            case ZOMBIE: {
                if (modifiers.getModifier() == "opzombies") {
                    event.getEntity().addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 20 * 6000000, 1));
                    event.getEntity().addPotionEffect(new PotionEffect(PotionEffectType.GLOWING, 20 * 6000000, 1));
                    event.getEntity().addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 20 * 6000000, 1));
                }
            }
        }
    }

    private void setNewFunctionsForNewPlayers(Player player) {
        player.sendMessage(ChatColor.GREEN + "ᴊᴜs ᴘɪʀᴍą ᴋᴀʀᴛą ᴘʀɪsɪᴊᴜɴɢᴇᴛė, ʟɪɴᴋᴍᴀᴜs žᴀɪᴅɪᴍᴏ!");
    }
}