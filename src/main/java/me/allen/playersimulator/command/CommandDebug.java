package me.allen.playersimulator.command;

import me.allen.playersimulator.PlayerSimulator;
import me.allen.playersimulator.util.command.Command;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandDebug {
    @Command(
            names = {
                    "botdebug",
                    "simulatordebug"
            },
            permissionNode = "playersimulator.debug"
    )
    public void execute(CommandSender sender) {
        PlayerSimulator.getInstance().setToggle(!PlayerSimulator.getInstance().isToggle());

        float tps = 0.0F;
        for (Long l : PlayerSimulator.getInstance().getTpsCheck().history) {
            if (l != null) {
                tps += (float)(20L / (l / 1000L));
            }
        }

        int size =  PlayerSimulator.getInstance().getTpsCheck().history.size() <= 0 ? 1 :  PlayerSimulator.getInstance().getTpsCheck().history.size();
        tps /= size;

        World world = sender instanceof Player ? ((Player) sender).getWorld() : Bukkit.getWorlds().get(0);

        sender.sendMessage("TPS: " + tps + " Loaded chunks: " + (world.getLoadedChunks().length + " Entities: " + world.getEntities().size()));
    }
}
