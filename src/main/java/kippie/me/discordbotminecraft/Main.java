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
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.time.Duration;
import java.util.Objects;

public final class Main extends JavaPlugin {
    private JDA jda;

    private JDA buildJDA() {
        JDABuilder builder = JDABuilder.createDefault(getConfig().getString("Token"));
        builder.setStatus(OnlineStatus.DO_NOT_DISTURB);
        builder.setActivity(Activity.playing("TestMC"));
        builder.enableIntents(GatewayIntent.GUILD_MEMBERS, GatewayIntent.GUILD_MESSAGES, GatewayIntent.DIRECT_MESSAGES, GatewayIntent.MESSAGE_CONTENT);
        builder.addEventListeners(

                new slashCommandManager(),

                new onDiscordChat(getConfig()),
                new onDiscordJoin(),
                new onDiscordLeave(),

                new Status(),
                new Whitelist(getConfig())
        );
        return builder.build();
    }


    @Override
    public void onEnable() {
        this.saveDefaultConfig();
        this.getConfig();
        FileConfiguration config = this.getConfig();
        config.addDefault("chatID", "Channel ID for all the events.");
        config.addDefault("whitelistRole", "Role ID for the role that can give whitelists.");
        config.addDefault("Token", "Put your Discord Token here!");

        config.options().copyDefaults(true);
        saveConfig();
        jda = buildJDA();

        Bukkit.getPluginManager().registerEvents(new onMinecraftChat(jda, config), this);
        Bukkit.getPluginManager().registerEvents(new onMinecraftDeath(jda, config), this);
        Bukkit.getPluginManager().registerEvents(new onMinecraftJoin(jda, config), this);
        Bukkit.getPluginManager().registerEvents(new onMinecraftLeave(jda, config), this);
        Bukkit.getPluginManager().registerEvents(new onMinecraftAchievement(jda, config), this);
        // Plugin startup logic

    }

    @Override
    public void  onDisable() {
        Objects.requireNonNull(jda.getTextChannelById("1276589604765700218")).getManager().setTopic(Emoji.fromUnicode("U+1F7E2").getFormatted() + " | Server is offline").queue();
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