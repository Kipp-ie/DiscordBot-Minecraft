package kippie.me.discordbotminecraft.listeners;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Activity;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.Objects;

public class onMinecraftLeave implements Listener {
    private final JDA jda;
    public onMinecraftLeave(JDA jda) {
        this.jda = jda;
    }
    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        EmbedBuilder embed = new EmbedBuilder();
        embed.setTitle(event.getPlayer().getName() + " has left the server");

        Objects.requireNonNull(jda.getTextChannelById("1276589604765700218")).sendMessageEmbeds(embed.build()).queue();
        Objects.requireNonNull(jda.getTextChannelById("1276589604765700218")).getManager().setTopic(Bukkit.getOnlinePlayers().size() + " player(s) online").queue();
        if (Bukkit.getOnlinePlayers().isEmpty()) {
            jda.getPresence().setActivity(Activity.playing("TestMC"));

        } else {
            jda.getPresence().setActivity(Activity.watching(Bukkit.getOnlinePlayers().size() + " player(s) online!"));
        }

    }
}
