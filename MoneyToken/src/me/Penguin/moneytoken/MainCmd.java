package me.Penguin.moneytoken;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;

public class MainCmd implements TabExecutor {
	
	@SuppressWarnings("unused")
	private Main plugin;
	private String givesyntax = u.cc("&c/mt give <player> <amount>");
	
	public MainCmd(Main plugin) {
		this.plugin = plugin;
		plugin.getCommand("moneytoken").setExecutor(this);
		plugin.getCommand("moneytoken").setTabCompleter(this);
	}

	@Override
	public boolean onCommand( CommandSender s,  Command cmd,  String label, String[] args) {
			if (cmd.getName().equalsIgnoreCase("moneytoken")) {
				if (args.length == 3) {
					if (args[0].equalsIgnoreCase("give")) {
						if (s.hasPermission("moneytoken.give")) {
							if (Bukkit.getPlayer(args[1]) != null) {
								Player np = Bukkit.getPlayer(args[1]);
							try {
								Integer.parseInt(args[2]);
							} catch (NumberFormatException ne) {
								s.sendMessage(givesyntax);
								return true;
							}
							if (np.getInventory().firstEmpty() == -1) {
								s.sendMessage(u.cc("&cPlayers inventory is full"));
								return true;
							}
							double amount = Integer.parseInt(args[2]);
							np.getInventory().addItem(u.createToken(amount));
							np.sendMessage(u.cc("&bReceived token for &a$" + amount ));
							return true;
							}
						}
					}
				}
			}
			
		
		
		return false;
	}

	@Override
	public List<String> onTabComplete( CommandSender s,  Command cmd, String label,  String[] args) {
		if (cmd.getName().equalsIgnoreCase("moneytoken")) {
			List<String> commands = new ArrayList<>();
			if (args.length == 1) {
				commands.clear();
				if (s.hasPermission("moenytoken.give")) commands.add("give");
				return u.TabCompleter(commands, args[0]);				
			} else if (args.length == 2) {
				commands.clear();
				for (Player p : Bukkit.getOnlinePlayers()) {				
					commands.add(p.getName());
				}
				return u.TabCompleter(commands, args[1]);
			} else if (args.length == 3) {
				commands.add("0");
				return u.TabCompleter(commands, args[2]);
			}
		}
		
		return null;
	}
}
