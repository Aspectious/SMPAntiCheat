package devs.IAN.smpantic;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class anticheatver implements CommandExecutor {
	@SuppressWarnings ("unused")
	private final main plugin;
	
	public anticheatver(main plugin) {
		this.plugin = plugin;
	}
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		sender.sendMessage("Running SMPANTICHEAT Version v1.0.1.");
		return false;
	}
}
