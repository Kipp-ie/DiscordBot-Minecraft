package kippie.me.discordbotminecraft.listeners;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import java.net.http.WebSocket;

public class onMinecraftDeath implements Listener {
    private final JDA jda;
    public onMinecraftDeath(JDA jda) {
        this.jda = jda;
    }
    @EventHandler
    public void onDeath(PlayerDeathEvent event){
        EmbedBuilder embed = new EmbedBuilder();
        embed.setTitle(event.getEntity().getName() + " has died!");
        embed.setDescription(event.getDeathMessage());

        jda.getTextChannelById("1276589604765700218").sendMessageEmbeds(embed.build()).queue();

    }
}
