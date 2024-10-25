package kippie.me.discordbotminecraft.listeners;

import net.dv8tion.jda.api.events.guild.member.GuildMemberRemoveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.jetbrains.annotations.NotNull;

public class onDiscordLeave extends ListenerAdapter {
    @Override
    public void onGuildMemberRemove(@NotNull GuildMemberRemoveEvent event) {
        var mm = MiniMessage.miniMessage();
        Component parsed = mm.deserialize("<bold><blue>Discord</bold></blue> - ");
        Bukkit.broadcastMessage(parsed + event.getUser().getName() + " has left the Discord Server.");
    }
}
