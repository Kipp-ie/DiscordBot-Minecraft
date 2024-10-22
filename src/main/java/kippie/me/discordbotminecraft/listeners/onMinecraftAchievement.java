package kippie.me.discordbotminecraft.listeners;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerAdvancementDoneEvent;
import java.util.Objects;

public class onMinecraftAchievement implements Listener {
    private final JDA jda;
    private final FileConfiguration config;
    public onMinecraftAchievement(JDA jda, FileConfiguration config) {
        this.jda = jda;
        this.config = config;
    }
    @EventHandler
    public void onPlayerAchievement(PlayerAdvancementDoneEvent event) {
        if(!event.getAdvancement().getKey().getKey().contains("recipes")) {
            EmbedBuilder embed = new EmbedBuilder();
            embed.setTitle(event.getPlayer().getName() + " has gotten an achievement!");
            embed.setDescription(Objects.requireNonNull(event.getAdvancement().getDisplay()).getTitle());
            Objects.requireNonNull(jda.getTextChannelById(Objects.requireNonNull(config.getString("chatID")))).sendMessageEmbeds(embed.build()).queue();
        }

    }
}
