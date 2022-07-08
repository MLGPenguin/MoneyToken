package me.Penguin.moneytoken.Commands;

import java.util.List;

import org.bukkit.entity.Player;

import me.Penguin.SuperPenguinCore.Commands.Handlers.CustomCommand;
import me.Penguin.SuperPenguinCore.Util.m;
import me.Penguin.SuperPenguinCore.Util.u;
import me.Penguin.moneytoken.Objects.Token;

public class CommandMoneyToken extends CustomCommand {

	public CommandMoneyToken() {
		super("moneytoken", "moneytokens.admin");
	}

	@Override
	public void run() {
		if (!checker.isLabel("give")) return;
		if (!checker.checkLength(3)) return;
		if (!checker.isPlayer(1)) return;
		if (!checker.isInt(2)) return;

		Player target = helper.getPlayer(1);
		int amount = helper.getInt(2);

		target.getInventory().addItem(new Token(amount).getItem());
		sender.sendMessage(m.Given(target, "a Money Token worth &n$" + u.dc(amount)));
	}

	@Override
	public List<String> getTabCompleteOptions(int arg) {
		switch(arg) {
		case 0: return list("give");
		case 2: return list("10");
		}
		return null;
	}

}
