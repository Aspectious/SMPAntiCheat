package devs.IAN.smpantic;

import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin {
	
	public static String WEBHOOKURL;
	@SuppressWarnings("static-access")
	public void onEnable() {
	this.getConfig();
	this.WEBHOOKURL = this.getConfig().getString("discord.webhook.url");
	try {
		this.getConfig().getString("discord.webhook.url");
	} catch (Error e) {
		getLogger().warning(ChatColor.RED + "Warning: Alert System Discord Webhook URL Missing! Generating TEMPLATE url. Please put a webhook URL in /Plugins/SMPAntiCheat/config.yml!");
		this.getConfig().set("discord.webhook.url", "PUT WEBHOOK URL HERE");
		this.saveConfig();
	}
	if (WEBHOOKURL == "PUT WEBHOOK URL HERE" || WEBHOOKURL == null) {
		getLogger().warning(ChatColor.RED + "Warning: Alert System Discord Webhook URL Missing! Generating TEMPLATE url. Please put a webhook URL in /Plugins/SMPAntiCheat/config.yml!");
		this.getConfig().set("discord.webhook.url", "PUT WEBHOOK URL HERE");
		this.saveConfig();
		}
	getServer().getPluginManager().registerEvents(new events(), this);
	this.getCommand("anticheatver").setExecutor(new anticheatver(this));
	this.getCommand("anticheatdebug").setExecutor(new anticheatdebug(this));
	Bukkit.getConsoleSender().sendMessage("§eLoaded SMP ANTICHEAT by §lAspect.");
	}
	@SuppressWarnings("static-access")
	public void onDisable() {
		Bukkit.getConsoleSender().sendMessage("§cUnLoaded SMP ANTICHEAT by §lAspect.");
		this.getConfig();
		this.WEBHOOKURL = this.getConfig().getString("discord.webhook.url");
		 if (WEBHOOKURL == "PUT WEBHOOK URL HERE" || WEBHOOKURL == null) {
			Bukkit.getLogger().warning(ChatColor.RED + "Warning: Alert System Discord Webhook URL Missing! Please put a webhook URL in /Plugins/SMPAntiCheat/config.yml!");	
			return;
			}
		  DiscordWebhook webhook = new DiscordWebhook(WEBHOOKURL);
		    webhook.addEmbed(new DiscordWebhook.EmbedObject()
		            .setTitle("ANTICHEAT ALERT")
		            .setDescription("Alert! Plugin has been DISABLED. Either the server is reloading or shutting down. Until next time!"));
		    try {
			webhook.execute();
		} catch (IOException e) {
			getLogger().info("AHHHHHHHHHHHHHHHH EXCEPTION [ " + e + " ] OCCURED!! ");
			}
	}
}
