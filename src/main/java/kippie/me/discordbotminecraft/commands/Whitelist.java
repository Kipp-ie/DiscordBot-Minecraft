package kippie.me.discordbotminecraft.commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class Whitelist extends ListenerAdapter {
    private final FileConfiguration config;
    public Whitelist(FileConfiguration config) {
        this.config = config;
    }

    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        if (event.getName().equals("whitelist")) {
            if (Objects.requireNonNull(event.getMember()).getRoles().contains(Objects.requireNonNull(event.getGuild()).getRoleById(Objects.requireNonNull(config.getString("whitelistRole"))))) {
                Player player = Bukkit.getPlayer(Objects.requireNonNull(event.getOption("user")).getAsString());
                assert player != null;
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
