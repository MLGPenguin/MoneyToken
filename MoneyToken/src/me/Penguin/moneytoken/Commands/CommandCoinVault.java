package me.Penguin.moneytoken.Commands;

import java.util.List;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.Penguin.SuperPenguinCore.Commands.Handlers.CustomCommand;
import me.Penguin.SuperPenguinCore.util.m;
import me.Penguin.moneytoken.Main;
import me.Penguin.moneytoken.Objects.CoinPouch;

public class CommandCoinVault extends CustomCommand {

	public CommandCoinVault() {
		super("coinvault", "moneytokens.admin");		
	}

	@Override
	public void run(CommandSender sender, String[] args) {
		if (!checker.isLabel("give")) return;
		if (!checker.checkLength(3)) return;
		if (!checker.isPlayer(1)) return;
		if (!checker.isInt(2)) return;
		
		int tier = helper.getInt(2);
		Player target = helper.getPlayer(1);
		
		if (!Main.CoinVaultLevels.containsKey(tier)) {
			sender.sendMessage(m.invalid("tier", String.valueOf(tier)));
			return;
		}
		
		target.getInventory().addItem(new CoinPouch(tier).getItem());
		send(sender, "&bGiven " + target.getName() + " a tier " + tier + " Coin Vault!");

	}

	@Override
	public List<String> getTabCompleteOptions(int arg, String[] args) {
		switch(arg) {
		case 0: return list("give");
		case 2: return list("1", "2", "3", "4", "5");
		}
		return null;		
	}
	

}
