package me.nojusnetwork.zombiesurvival.runnables;

import me.nojusnetwork.zombiesurvival.other.GameModifiers;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.scheduler.BukkitRunnable;

public class ZombieSpawner extends BukkitRunnable {
    private GameModifiers modifiers;

    public ZombieSpawner(GameModifiers modifiers) {
        this.modifiers = modifiers;
    }

    @Override
    public void run() {
        Bukkit.getWorld("world").spawnEntity(new Location(Bukkit.getWorld("world"), 30, 64, -16), EntityType.ZOMBIE);
    }
}
