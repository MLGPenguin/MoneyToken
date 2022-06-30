package me.Penguin.moneytoken;


import java.util.HashMap;

import me.Penguin.SuperPenguinCore.api.PenguinPlugin;
import me.Penguin.moneytoken.Commands.CommandCoinVault;
import me.Penguin.moneytoken.Commands.CommandMoneyToken;
import me.Penguin.moneytoken.Objects.CoinPouch;
import me.Penguin.moneytoken.Objects.Token;
import me.Penguin.moneytoken.util.Range;

public class Main extends PenguinPlugin {

	@Override
	public void OnEnable() {}
	
	@Override
	public void onDisable() {}

	@Override
	public void register() {
		new Token(0);
		new CoinPouch(0);
		
		new CommandMoneyToken();
		new CommandCoinVault();
	}
	
	@SuppressWarnings("serial")
	public static HashMap<Integer, Range> CoinVaultLevels = new HashMap<Integer, Range>() {{
		put(1, new Range(25_000, 100_000));
		put(2, new Range(100_000, 500_000));
		put(3, new Range(500_000, 2_500_000));
		put(4, new Range(2_500_000, 10_000_000));
		put(5, new Range(10_000_000, 50_000_000));
	}};



}
