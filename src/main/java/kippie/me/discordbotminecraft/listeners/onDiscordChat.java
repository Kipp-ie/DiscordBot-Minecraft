package kippie.me.discordbotminecraft.listeners;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class onDiscordChat extends ListenerAdapter {
    private final FileConfiguration config;
    public onDiscordChat(FileConfiguration config) {
        this.config = config;
    }
    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
            if (!event.getAuthor().isBot()) {
                if (!event.getAuthor().isSystem()) {
                    if (event.getChannel().equals(event.getJDA().getTextChannelById(config.getInt("chatID")))) {
                        var mm = MiniMessage.miniMessage();
                        Component parsed = mm.deserialize("<bold><blue>Discord</bold></blue> - ");
                        Bukkit.broadcastMessage(parsed + event.getMessage().getContentDisplay());
                    }

                }

            }
    }
}
