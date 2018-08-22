package io.github.invigoratedcat.dragui;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerListener implements Listener{

	public boolean settingChest;
	
	@EventHandler(priority=EventPriority.LOW)
	public void onInteract(PlayerInteractEvent e) {
		
	}
}
