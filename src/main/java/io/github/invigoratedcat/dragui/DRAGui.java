package io.github.invigoratedcat.dragui;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public final class DRAGui extends JavaPlugin {
	@Override
	public void onEnable() {
		
	}
	
	@Override
	public void onDisable() {
		
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player) {
			Player player = (Player) sender;
			if(cmd.getName().equalsIgnoreCase("dragtest")) {
				player.sendMessage("test successful");
				return true;
			} else {
				return false;
			}
		} else {
			sender.sendMessage("Only a player can use this plugin's commands.");
			return false;
		}
	}
}
