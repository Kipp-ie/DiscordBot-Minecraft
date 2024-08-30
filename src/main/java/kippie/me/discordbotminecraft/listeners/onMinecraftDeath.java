package kippie.me.discordbotminecraft.listeners;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import java.util.Objects;

public class onMinecraftDeath implements Listener {
    private final JDA jda;
    private final FileConfiguration config;
    public onMinecraftDeath(JDA jda, FileConfiguration config) {
        this.jda = jda;
        this.config =config;
    }
    @EventHandler
    public void onDeath(PlayerDeathEvent event){
        EmbedBuilder embed = new EmbedBuilder();
        embed.setTitle(event.getEntity().getName() + " has died!");
        embed.setDescription(event.getDeathMessage());

        Objects.requireNonNull(jda.getTextChannelById(Objects.requireNonNull(config.getString("chatID")))).sendMessageEmbeds(embed.build()).queue();

    }
}
