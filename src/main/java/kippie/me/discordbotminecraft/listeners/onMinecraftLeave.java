package kippie.me.discordbotminecraft.listeners;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class onMinecraftLeave implements Listener {
    private final JDA jda;
    public onMinecraftLeave(JDA jda) {
        this.jda = jda;
    }
    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        EmbedBuilder embed = new EmbedBuilder();
        embed.setTitle(event.getPlayer().getName() + " has left the server");

        jda.getTextChannelById("1276589604765700218").sendMessageEmbeds(embed.build()).queue();

    }
}
