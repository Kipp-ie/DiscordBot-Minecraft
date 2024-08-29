package kippie.me.DiscordBotMinecraft.Listeners;

import kippie.me.DiscordBotMinecraft.Main;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import javax.security.auth.login.LoginException;
public class onMinecraftChat implements Listener {
    public onMinecraftChat() {
    }

    @EventHandler
    public void onMessage(AsyncPlayerChatEvent event) throws LoginException, InterruptedException {



    }


}
