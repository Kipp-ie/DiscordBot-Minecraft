package kippie.me.discordbotminecraft;

import kippie.me.discordbotminecraft.commands.Status;
import kippie.me.discordbotminecraft.commands.Whitelist;
import kippie.me.discordbotminecraft.listeners.*;
import kippie.me.discordbotminecraft.managers.slashCommandManager;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.emoji.Emoji;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.time.Duration;

public final class Main extends JavaPlugin {
    private JDA jda;

    private JDA buildJDA() {
        JDABuilder builder = JDABuilder.createDefault("MTI3ODcxMzMyNjA5NjA5MzI0Ng.GPg_ii.96hI6f4FLMolIhWXDXafrgkRmPOjZlpn039QO4");
        builder.setStatus(OnlineStatus.DO_NOT_DISTURB);
        builder.setActivity(Activity.playing("TestMC"));
        builder.enableIntents(GatewayIntent.GUILD_MEMBERS, GatewayIntent.GUILD_MESSAGES, GatewayIntent.DIRECT_MESSAGES, GatewayIntent.MESSAGE_CONTENT);
        builder.addEventListeners(

                new slashCommandManager(),

                new onDiscordChat(),
                new onDiscordJoin(),
                new onDiscordLeave(),

                new Status(),
                new Whitelist()
        );
        return builder.build();
    }


    @Override
    public void onEnable() {
        jda = buildJDA();
        jda.getTextChannelById("1276589604765700218").getManager().setTopic(Emoji.fromUnicode("U+1F7E2").getFormatted() + " | " + Bukkit.getOnlinePlayers().size() + " player(s) online").queue();
        Bukkit.getPluginManager().registerEvents(new onMinecraftChat(jda), this);
        Bukkit.getPluginManager().registerEvents(new onMinecraftDeath(jda), this);
        Bukkit.getPluginManager().registerEvents(new onMinecraftJoin(jda), this);
        Bukkit.getPluginManager().registerEvents(new onMinecraftLeave(jda), this);
        Bukkit.getPluginManager().registerEvents(new onMinecraftAchievement(jda), this);
        // Plugin startup logic

    }

    @Override
    public void  onDisable() {
        jda.getTextChannelById("1276589604765700218").getManager().setTopic(Emoji.fromUnicode("U+1F7E2").getFormatted() + " | Server is offline").queue();
        jda.shutdown();
        try {
            if (!jda.awaitShutdown(Duration.ofSeconds(10))) {
                jda.shutdownNow(); // Cancel all remaining requests
                jda.awaitShutdown(); // Wait until shutdown is complete (indefinitely)
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        // Plugin shutdown logic
    }
}
