package io.github.invigoratedcat.dragui;

import java.util.Set;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.BlockState;
import org.bukkit.block.Chest;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.metadata.FixedMetadataValue;

public class CommandHandler implements CommandExecutor {
	
	private DRAGui plugin;
	
	public CommandHandler(DRAGui draGui) {
		plugin = draGui;
	}
	
	public void printUsage(Player player) {
		player.sendMessage("how to do thing:\n/drag setchest - sets your linked chest");
		player.sendMessage("/drag openchest - opens your linked chest");
		player.sendMessage("/drag fang [NOT IMPLEMENTED YET]");
	}
	
	/**
	 * @author edgemaster619
	 * Handles commands like a tree, where all commands derive from /drag
	 * 
	 */
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player) {
			Player player = (Player) sender;
			try {
				if(args[0].equalsIgnoreCase("test")) {
					player.sendMessage("test successful");
					return true;
				} else if(args[0].equalsIgnoreCase("setchest")) {
					BlockState get = player.getTargetBlock((Set<Material>) null, 100).getState();
					if(get.getType().equals(Material.CHEST)) {
						Chest chest = (Chest) get;
						player.setMetadata("linkedchest", new FixedMetadataValue(plugin, chest.getLocation()));
					}
					player.sendMessage("Chest set.");
					return true;
				} else if(args[0].equalsIgnoreCase("openchest")) {
					if(player.getMetadata("linkedchest").get(0).value()!=null) {
						 Location ch = (Location) player.getMetadata("linkedchest").get(0).value();
						 Chest es = (Chest) ch.getBlock().getState();
						 Inventory t = es.getInventory();
						 player.openInventory(t);
						return true;
					} else {
						player.sendMessage("You have no linked chest!");
						return true;
					} 
				} else  {
					return false;
				}
			} catch(ArrayIndexOutOfBoundsException e) {
				printUsage(player);
				return false;
			}
		} else {
			sender.sendMessage("Only a player can use this plugin's commands.");
			return false;
		}
	}

}
