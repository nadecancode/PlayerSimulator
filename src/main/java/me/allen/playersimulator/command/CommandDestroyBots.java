package me.allen.playersimulator.command;

import me.allen.playersimulator.util.command.Command;
import net.minecraft.server.v1_8_R3.EntityPlayer;
import net.minecraft.server.v1_8_R3.PlayerList;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_8_R3.CraftServer;

public class CommandDestroyBots {
    @Command(
            names = {
                    "destroybots",
                    "destroy-bots",
                    "killbots",
                    "kill-bots",
                    "kill-all-bots",
                    "kill-all-bot"
            },
            permissionNode = "playersimulator.killbots"
    )
    public void execute(CommandSender sender) {
        PlayerList playerList = ((CraftServer) Bukkit.getServer()).getHandle();
        for (EntityPlayer entityplayer : playerList.players) {
            if (entityplayer.getName().startsWith(ChatColor.BLUE + "Bot"))
            {
                entityplayer.playerConnection.disconnect("");
                sender.sendMessage("Disconnected " + entityplayer.getName());
            }
        }
    }
}
