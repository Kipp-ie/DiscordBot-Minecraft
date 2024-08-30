package kippie.me.discordbotminecraft.managers;

import net.dv8tion.jda.api.events.guild.GuildReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class slashCommandManager extends ListenerAdapter {
    @Override
    public void onGuildReady(@NotNull GuildReadyEvent event) {
        List<CommandData> commands = new ArrayList<>();
        commands.add(Commands.slash("status", "Get the status from the Minecraft Server"));
        commands.add(Commands.slash("whitelist", "Whitelist a Minecraft player by their IGN")
                .addOption(OptionType.STRING, "user", "Put the player name here.", true));
        event.getGuild().updateCommands().addCommands(commands).queue();
    }
}
