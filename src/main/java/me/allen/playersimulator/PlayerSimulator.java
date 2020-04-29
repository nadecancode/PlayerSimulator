package me.allen.playersimulator;

import lombok.Getter;
import lombok.Setter;
import me.allen.playersimulator.tps.TPSCheck;
import me.allen.playersimulator.util.command.CommandHandler;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
public class PlayerSimulator extends JavaPlugin {
    @Getter
    private static PlayerSimulator instance;

    private TPSCheck tpsCheck;

    @Setter
    private boolean toggle = false;

    @Override
    public void onEnable() {
        instance = this;
        CommandHandler.init(this);
        CommandHandler.registerAll(this);
        this.tpsCheck = new TPSCheck();
        Bukkit.getScheduler().scheduleSyncRepeatingTask(this, this.tpsCheck, 20L, 20L);
    }

    @Override
    public void onDisable() {
        Bukkit.getScheduler().cancelTasks(this);
    }
}
