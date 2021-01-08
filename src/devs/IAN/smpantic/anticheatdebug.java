package devs.IAN.smpantic;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class anticheatdebug implements CommandExecutor {
	@SuppressWarnings ("unused")
	private final main plugin;
	
	public anticheatdebug(main plugin) {
		this.plugin = plugin;
	}
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		String WEBHOOKURL = main.WEBHOOKURL;
		sender.sendMessage("§c- SMP Anticheat Debug System - ");
		sender.sendMessage("Defined Webhook URL: " + WEBHOOKURL);
		sender.sendMessage("");
		sender.sendMessage("");
		sender.sendMessage("");
		sender.sendMessage("§c-------------------------------");
	return true;
	}
}
