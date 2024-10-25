package kippie.me.discordbotminecraft.listeners;

import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.jetbrains.annotations.NotNull;

public class onDiscordJoin extends ListenerAdapter {
    @Override
    public void onGuildMemberJoin(@NotNull GuildMemberJoinEvent event) {
        var mm = MiniMessage.miniMessage();
        Component parsed = mm.deserialize("<bold><blue>Discord</bold></blue> - ");
        Bukkit.broadcastMessage(parsed + event.getUser().getName() + " has joined the Discord Server!");

    }
}
