package me.penguin.moneytoken.Objects;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import me.Penguin.SuperPenguinCore.API.PenguinEconomyAPI;
import me.Penguin.SuperPenguinCore.Items.Held.Redeemable;
import me.Penguin.SuperPenguinCore.Util.MIB;
import me.Penguin.SuperPenguinCore.Util.NumberFormatter;
import me.Penguin.SuperPenguinCore.Util.u;

public class Token extends Redeemable {

	private double amount;

	public Token(double amount) {
		this.amount = amount;
	}

	@Override
	public ItemStack getItem() {
		return new MIB(Material.SUNFLOWER)
				.setName("&a$" + NumberFormatter.getFormatted(amount))
				.addLores("&7Right-Click to redeem &a$" + NumberFormatter.addDelimiters(amount))
				.setLocname("token:" + amount)
				.build();
	}

	@Override
	public void OnRedeem(ItemStack item, Player player) {
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
		return Double.parseDouble(getLocname(item).split(":")[1]);
	}

}
