package me.allen.playersimulator.command;

import com.google.common.base.Charsets;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import me.allen.playersimulator.bot.DummyNetworkManager;
import me.allen.playersimulator.bot.DummyPlayerConnection;
import me.allen.playersimulator.bot.EntityBot;
import me.allen.playersimulator.util.command.Command;
import me.allen.playersimulator.util.command.param.Parameter;
import net.minecraft.server.v1_8_R3.EntityPlayer;
import net.minecraft.server.v1_8_R3.PlayerInteractManager;
import net.minecraft.server.v1_8_R3.PlayerList;
import net.minecraft.server.v1_8_R3.WorldServer;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_8_R3.CraftServer;
import org.bukkit.craftbukkit.v1_8_R3.CraftWorld;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Random;
import java.util.UUID;

public class CommandSpawnBots {
    @Command(
            names = {
                    "spawnbots",
                    "spawn-bots",
                    "botsspawn",
                    "bots-spawn",
                    "player-simulate",
                    "playersimulate",
            },
            permissionNode = "playersimulator.spawnbots"
    )
    public void execute(CommandSender sender, @Parameter(name = "amount", defaultValue = "1") int amount, @Parameter(name = "range", defaultValue = "-1") int range) {
        for (int i = 0; i < amount; i++)
        {
            Random random = new Random();
            String name = ChatColor.BLUE + "Bot-" + i;
            WorldServer world = ((CraftWorld) (sender instanceof Player ? ( (Player) sender).getWorld() : Bukkit.getWorlds().get(0))).getHandle();
            PlayerList playerList = ((CraftServer)Bukkit.getServer()).getHandle();
            UUID uuid = UUID.nameUUIDFromBytes(("OfflinePlayer:" + name).getBytes(Charsets.UTF_8));
            GameProfile gameProfile = new GameProfile(uuid, name);
            gameProfile.getProperties().put("textures", new Property("textures", EntityBot.BLANK_TEXTURE_VALUE, EntityBot.BLANK_TEXTURE_SIG));


            EntityPlayer entityplayer = new EntityBot(playerList.getServer(), world, gameProfile, new PlayerInteractManager(world));
            new DummyPlayerConnection(playerList.getServer(), new DummyNetworkManager(), entityplayer);

            entityplayer.spawnIn(world);
            entityplayer.playerInteractManager.a((WorldServer)entityplayer.world);
            entityplayer.playerInteractManager.b(world.getWorldData().getGameType());

            if (sender instanceof Player) {
                if (range != -1) {
                    entityplayer.setPosition(random.nextInt(range * 2) - range, 100.0D, random.nextInt(range * 2) - range);
                } else {
                    entityplayer.setPosition(((Player)sender).getLocation().getX(), ((Player)sender).getLocation().getY(), ((Player)sender).getLocation().getZ());
                }
            } else {
                if (range == -1) range = 2000;
                entityplayer.setPosition(random.nextInt(range * 2) - range, 100.0D, random.nextInt(range * 2) - range);
            }

            try {
                PlayerLoginEvent event = new PlayerLoginEvent(entityplayer.getBukkitEntity(), "mc.badlion.net", InetAddress.getByName("127.0.0.1"), InetAddress.getByName("127.0.0.1"));
                Bukkit.getPluginManager().callEvent(event);
                PlayerJoinEvent event1 = new PlayerJoinEvent(entityplayer.getBukkitEntity(), "YOLO");
                Bukkit.getPluginManager().callEvent(event1);
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }

            playerList.players.add(entityplayer);
            world.addEntity(entityplayer);
            playerList.a(entityplayer, (WorldServer) null);

            sender.sendMessage("Added player " + entityplayer.getName() + ChatColor.RESET + " at " + entityplayer.locX + ", " + entityplayer.locY + ", " + entityplayer.locZ + ".");
        }
    }
}
