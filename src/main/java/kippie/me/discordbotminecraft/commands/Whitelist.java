package kippie.me.discordbotminecraft.commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import okhttp3.internal.http2.Http2Connection;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Whitelist extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        if (event.getName().equals("whitelist")) {
            if (event.getMember().getRoles().contains(event.getGuild().getRoleById("1279151560248791223"))) {
                Player player = Bukkit.getPlayer(event.getOption("user").getAsString());
                if (!player.isWhitelisted()) {
                    player.setWhitelisted(true);
                    EmbedBuilder embed = new EmbedBuilder();
                    embed.setTitle(player.getName() + " has been whitelisted.");
                    event.replyEmbeds(embed.build()).queue();

                } else {
                    event.reply("This player already has a whitelist!").setEphemeral(true).queue();
                }

            } else {
                event.reply("You don't have the permissions for this!").setEphemeral(true).queue();
            }
        }
    }
}
