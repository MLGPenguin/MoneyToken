package me.Penguin.moneytoken;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class MainListener implements Listener{

	private Main plugin;

	public MainListener(Main plugin) {
		this.plugin = plugin;
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}

	@EventHandler
	public void redeem(PlayerInteractEvent e) {
		if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			Player p = e.getPlayer();
			ItemStack i = p.getInventory().getItemInMainHand();
			if (i != null) {				
				if (i.hasItemMeta()) {
					if (i.getType() == Material.SUNFLOWER) {
						ItemMeta im = i.getItemMeta();
						if (im.getPersistentDataContainer().has(u.key, PersistentDataType.DOUBLE)) {
							PersistentDataContainer c = im.getPersistentDataContainer();
							int times = i.getAmount();
							double amount = c.get(u.key, PersistentDataType.DOUBLE);
							double total = amount * times;
							p.getInventory().setItemInMainHand(new ItemStack(Material.AIR, 1));
							plugin.eco.depositPlayer(p, total);
							p.sendMessage(u.cc("&7Received &a$" + u.dc(total)));							
						}
					}
				}
			}
		}
	}







}
