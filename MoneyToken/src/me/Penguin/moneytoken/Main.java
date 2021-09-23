package me.Penguin.moneytoken;


import org.bukkit.ChatColor;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import net.milkbowl.vault.economy.Economy;

public class Main extends JavaPlugin {

	public Economy eco;

	public void onEnable() {

		new MainListener(this);
		new MainCmd(this);



		if (!setupEconomy()) {
			System.out.println(ChatColor.RED + "Vault and Economy are required!");
			getServer().getPluginManager().disablePlugin(this);
		}		



	}

	private boolean setupEconomy() {
		RegisteredServiceProvider<Economy> economy = 
				getServer().getServicesManager().getRegistration(net.milkbowl.vault.economy.Economy.class);
		if (economy != null) {	eco = economy.getProvider();  }
		return (eco != null);
	}



}
