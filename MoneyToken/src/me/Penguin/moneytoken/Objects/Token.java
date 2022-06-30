package me.Penguin.moneytoken.Objects;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import me.Penguin.SuperPenguinCore.Items.Interactable;
import me.Penguin.SuperPenguinCore.api.PenguinEconomyAPI;
import me.Penguin.SuperPenguinCore.util.MIB;
import me.Penguin.SuperPenguinCore.util.u;

public class Token extends Interactable {
	
	private double amount;
	
	public Token(double amount) {
		this.amount = amount;
	}
	
	@Override
	public ItemStack getItem() {
		return new MIB(Material.SUNFLOWER)
				.setName("&a$" + u.dc(amount))
				.addLores("&7Right-Click to redeem &a$" + u.dc(amount))
				.setLocname("token:" + amount)
				.build();				
	}

	@Override
	public void OnInteract(ItemStack item, Player player) {
		double amount = getAmount(item);
		PenguinEconomyAPI.deposit(player, amount);
		removeOne(item);
		player.sendMessage(u.cc("&7Received &a$" + u.dc(amount)));
	}

	@Override
	public boolean isItem(ItemStack item) {
		return getLocname(item).startsWith("token:");	
	}	
	
	private double getAmount(ItemStack item) {
		return Double.valueOf(getLocname(item).split(":")[1]);	
	}

}
