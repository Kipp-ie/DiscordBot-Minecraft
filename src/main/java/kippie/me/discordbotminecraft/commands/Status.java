package kippie.me.discordbotminecraft.commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.bukkit.Bukkit;
import org.jetbrains.annotations.NotNull;

public class Status extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        if (event.getName().equals("status")) {
            EmbedBuilder embed = new EmbedBuilder();
            embed.setTitle("Status Minecraft Server");
            embed.addField("Players", "There are " + Bukkit.getOnlinePlayers().size() + " player(s) online.", false);
            embed.addField("Version", Bukkit.getServer().getVersion(), false);

            event.replyEmbeds(embed.build()).queue();
        }
    }
}
