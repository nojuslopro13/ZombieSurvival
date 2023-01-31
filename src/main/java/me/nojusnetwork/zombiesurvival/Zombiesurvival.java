package me.nojusnetwork.zombiesurvival;

import me.nojusnetwork.zombiesurvival.listeners.PlayerEvents;
import me.nojusnetwork.zombiesurvival.other.GameModifiers;
import me.nojusnetwork.zombiesurvival.other.Values;
import me.nojusnetwork.zombiesurvival.runnables.ModifierHandler;
import me.nojusnetwork.zombiesurvival.runnables.ZombieSpawner;
import org.bukkit.GameRule;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;

public final class Zombiesurvival extends JavaPlugin {
    private static Zombiesurvival plugin;
    Values impValues = new Values();
    GameModifiers modifiersValues = new GameModifiers();
    @Override
    public void onEnable() {
        getServer().getWorld("world").setGameRule(GameRule.KEEP_INVENTORY, true);
        modifiersValues.setModifier("ɪšᴊᴜɴɢᴛᴀ");
        getConfig().set("totalPlayed", impValues.getTotalPlayerPlayed());
        saveDefaultConfig();

        getServer().getPluginManager().registerEvents(new PlayerEvents(impValues, modifiersValues), this);

        BukkitTask task = new ModifierHandler(modifiersValues).runTaskTimer(this, 0, 20 * 30);
        BukkitTask zombietask = new ZombieSpawner(modifiersValues).runTaskTimer(this, 0, 20 * 10);

        plugin = this;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Zombiesurvival getPlugin() {
        return plugin;
    }
}
