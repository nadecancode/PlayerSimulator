package me.allen.playersimulator.command;

import me.allen.playersimulator.util.command.Command;
import net.minecraft.server.v1_8_R3.EntityPlayer;
import net.minecraft.server.v1_8_R3.PlayerList;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_8_R3.CraftServer;

public class CommandBotLocations {
    @Command(
            names = {
                    "bot-locations",
                    "botlocation",
                    "bot-location",
                    "bots-locations",
                    "bots-location",
                    "botlocations",
                    "botslocation"
            },
            permissionNode = "playersimulator.botlocations"
    )
    public void execute(CommandSender sender) {
        PlayerList playerList = ((CraftServer) Bukkit.getServer()).getHandle();
        for (EntityPlayer entityplayer : playerList.players) {
            if (entityplayer.getName().startsWith(ChatColor.BLUE + "Bot"))
            {
                System.out.println(entityplayer.locX + "," + entityplayer.locY + "," + entityplayer.locZ);
            }
        }
    }
}
