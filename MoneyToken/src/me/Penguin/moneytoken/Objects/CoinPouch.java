package me.Penguin.moneytoken.Objects;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import me.Penguin.SuperPenguinCore.API.PenguinEconomyAPI;
import me.Penguin.SuperPenguinCore.Items.Redeemable;
import me.Penguin.SuperPenguinCore.Util.MIB;
import me.Penguin.SuperPenguinCore.Util.u;
import me.Penguin.moneytoken.Main;

public class CoinPouch extends Redeemable {

	private int tier;

	public CoinPouch(int tier) {
		this.tier = tier;
	}

	@Override
	public ItemStack getItem() {
		MIB m = new MIB(Material.JUKEBOX)
				.setName("&a&nCoin Vault&7 (Tier " + tier + ")")
				.addLores("&7Right-Click to Redeem")
				.setLocname("cp:" + tier);
		if (tier >= 4) m.setGlowing(true);
		return m.build();
	}

	@Override
	public void OnRedeem(ItemStack item, Player player) {
		int amount = Main.CoinVaultLevels.get(getTier(item)).getRandom();
		PenguinEconomyAPI.deposit(player, amount);
		removeOne(item);
		player.sendMessage(u.cc("&7Received &a$" + u.dc(amount)));
	}

	@Override
	public boolean isItem(ItemStack item) {
		return getLocname(item).startsWith("cp:");
	}

	private int getTier(ItemStack item) {
		return Integer.parseInt(getLocname(item).split(":")[1]);
	}

}
