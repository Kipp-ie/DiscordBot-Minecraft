package kippie.me.DiscordBotMinecraft;

import kippie.me.DiscordBotMinecraft.Listeners.onMinecraftChat;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.sharding.DefaultShardManagerBuilder;
import net.dv8tion.jda.api.sharding.ShardManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import javax.security.auth.login.LoginException;

public final class Main extends JavaPlugin {


    public Main() throws LoginException, InterruptedException {
        JDABuilder builder = JDABuilder.createDefault("MTI3ODcxMzMyNjA5NjA5MzI0Ng.GnFhoY.P7enDYTELP7XT__NnxEqmwTYNQc7HeMy1dRxlE");
        builder.setStatus(OnlineStatus.DO_NOT_DISTURB);
        builder.setActivity(Activity.watching("Hi :)"));
        builder.enableIntents(GatewayIntent.GUILD_MEMBERS, GatewayIntent.GUILD_MESSAGES, GatewayIntent.DIRECT_MESSAGES, GatewayIntent.MESSAGE_CONTENT);
        builder.build();

    }

    public static void main(String[] args) {
        try {

            Main bot = new Main();

        } catch (LoginException e) {
            System.out.println("Bot token invalid!");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new onMinecraftChat(), this);
        // Plugin startup logic

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
