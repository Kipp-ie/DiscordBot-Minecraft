package kippie.me.discordbotminecraft.listeners;

import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.bukkit.Bukkit;
import org.jetbrains.annotations.NotNull;

public class onDiscordJoin extends ListenerAdapter {
    @Override
    public void onGuildMemberJoin(@NotNull GuildMemberJoinEvent event) {
        Bukkit.broadcastMessage(event.getUser().getName() + " has joined the Discord Server!");

    }
}
