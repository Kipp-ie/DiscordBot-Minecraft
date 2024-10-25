package kippie.me.discordbotminecraft.listeners;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Activity;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.awt.*;
import java.time.LocalDateTime;
import java.util.Objects;

public class onMinecraftJoin implements Listener {
    private final JDA jda;
    private final FileConfiguration config;
    public onMinecraftJoin(JDA jda, FileConfiguration config) {
        this.jda = jda;
        this.config = config;
    }
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        EmbedBuilder embed = new EmbedBuilder();
        embed.setDescription(event.getJoinMessage());
        embed.setAuthor(event.getPlayer().getDisplayName()).setImage("https://mc-heads.net/avatar/" + event.getPlayer().getUniqueId() + "/avatar.png");
        embed.setColor(Color.GREEN);
        embed.setFooter("Joined " + Bukkit.getName() );
        embed.setTimestamp(LocalDateTime.now());

        Objects.requireNonNull(jda.getTextChannelById(Objects.requireNonNull(config.getString("chatID")))).sendMessageEmbeds(embed.build()).queue();
        Objects.requireNonNull(jda.getTextChannelById(config.getInt("ChatID"))).getManager().setTopic(Bukkit.getOnlinePlayers().size() + " player(s) online").queue();
        if (Bukkit.getOnlinePlayers().isEmpty()) {
            jda.getPresence().setActivity(Activity.playing(Bukkit.getName()));
        } else {
            jda.getPresence().setActivity(Activity.watching(Bukkit.getOnlinePlayers().size() + " player(s) online!"));
        }


    }
}
