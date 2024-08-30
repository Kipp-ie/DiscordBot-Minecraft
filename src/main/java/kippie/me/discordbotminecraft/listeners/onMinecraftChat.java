package kippie.me.discordbotminecraft.listeners;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import java.util.Objects;


public class onMinecraftChat implements Listener {
    private final JDA jda;
    public onMinecraftChat(JDA jda) {
        this.jda = jda;
    }

    @EventHandler
    public void onMessage(AsyncPlayerChatEvent event) {
        EmbedBuilder embed = new EmbedBuilder();
        embed.setTitle(event.getPlayer().getDisplayName());
        embed.setDescription(event.getMessage());
        Objects.requireNonNull(jda.getTextChannelById("1276589604765700218")).sendMessageEmbeds(embed.build()).queue();
    }


}
