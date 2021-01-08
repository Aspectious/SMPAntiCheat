package devs.IAN.smpantic;

import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerGameModeChangeEvent;
import org.bukkit.event.server.ServerCommandEvent;

public class events implements Listener {
	@EventHandler
	public void changgm(PlayerGameModeChangeEvent event) throws IOException {
		if (event.getNewGameMode() == GameMode.valueOf("SURVIVAL")) {
		return;
		}
		String WEBHOOKURL = main.WEBHOOKURL;
		Bukkit.getLogger().info("[AntiCheat] Alert: User <" + event.getPlayer().getDisplayName() + "> Changed gamemode to " + event.getNewGameMode());
		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "tellraw @a \"" + ChatColor.RED + "[AntiCheat] Alert: User <" + event.getPlayer().getDisplayName() + "> Changed gamemode to " + event.getNewGameMode() + "! Reverting Gamemode to SURVIVAL..." + '\"');
		event.getPlayer().sendMessage(ChatColor.RED + "Cheating is not Allowed on this Server!");
		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "gamemode survival " + event.getPlayer().getDisplayName());
		if (WEBHOOKURL == "PUT WEBHOOK URL HERE") {
		Bukkit.getLogger().warning(ChatColor.RED + "Warning: Alert System Discord Webhook URL Missing! Please put a webhook URL in /Plugins/SMPAntiCheat/config.yml!");	
		return;
		}
		
		  DiscordWebhook webhook = new DiscordWebhook(WEBHOOKURL);
		    webhook.addEmbed(new DiscordWebhook.EmbedObject()
		            .setTitle("ANTICHEAT ALERT")
		            .setDescription(event.getPlayer().getDisplayName() + " Changed their gamemode to " + event.getNewGameMode()));
		    webhook.execute();
		    return;
	}
    @EventHandler
    public void onServerCommand(ServerCommandEvent e) {
    	if (e.getCommand().startsWith("whitelist")) return;
    	if (e.getCommand().startsWith("scoreboard")) return;
    	if (e.getCommand().startsWith("ban")) return;
    	if (e.getCommand().startsWith("pardon")) return;
    	if (e.getCommand().startsWith("kick")) return;
    	if (e.getCommand().startsWith("deop")) return;
    	if (e.getCommand().startsWith("reload")) return;
    	if (e.getCommand().startsWith("stop")) return;
    	if (e.getCommand().startsWith("help")) return;
    	if (e.getCommand().startsWith("ver")) return;
    	if (e.getCommand().startsWith("version")) return;
    	if (e.getCommand().startsWith("pl")) return;
    	if (e.getCommand().startsWith("plugins")) return;
    	if (e.getCommand().startsWith("tellraw")) return;
    	if (e.getCommand().startsWith("anticheatver")) return;
    	if (e.getCommand().startsWith("anticheatdebug")) return;
    	
        e.setCommand("");
    return;
    }
}
