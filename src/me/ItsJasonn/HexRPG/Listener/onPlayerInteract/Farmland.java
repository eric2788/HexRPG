package me.ItsJasonn.HexRPG.Listener.onPlayerInteract;

import me.ItsJasonn.HexRPG.Main.Core;
import me.ItsJasonn.HexRPG.Main.Plugin;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class Farmland implements Listener {
	@SuppressWarnings("static-access")
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		
		if(event.getAction() == Action.PHYSICAL || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
			for(ItemStack items : Plugin.getCore().itemList) {
                if (player.getInventory().getItemInMainHand() != null && player.getInventory().getItemInMainHand().getType() == items.getType() && Core.getDurability(player.getInventory().getItemInMainHand()) == Core.getDurability(items)) {
					event.setCancelled(true);
				}
			}
		}
	}
}
