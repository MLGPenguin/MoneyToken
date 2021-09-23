package me.Penguin.moneytoken;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;



public class u {
	
	private static Main plugin = Main.getPlugin(Main.class);
	public static NamespacedKey key = new NamespacedKey(plugin, "token");

	public static String cc(String s) {
		return ChatColor.translateAlternateColorCodes('&', s);	}
	
	public static String dc(int value) {
		String pattern = "###,###,###,###";
		DecimalFormat decimalFormat = new DecimalFormat(pattern);
		return decimalFormat.format(value); }
	
	public static List<String> TabCompleter(List<String> commands, String Input){
		List<String> wordsThatStartWithArg = new ArrayList<>();
		for (String x : commands) {
			if (x.toLowerCase().startsWith(Input.toLowerCase())) {
				wordsThatStartWithArg.add(x);
			}
		}
		return wordsThatStartWithArg;	
	}
	
	public static String dc(double value) {
		String pattern = "###,###,###,###";
		DecimalFormat decimalFormat = new DecimalFormat(pattern);
		return decimalFormat.format(value); }
	
	public static ItemStack createToken(double amount) {
		ItemStack i = new ItemStack(Material.SUNFLOWER, 1);
		ItemMeta im = i.getItemMeta();
		im.setDisplayName(u.cc("&a$" + u.dc(amount)));
		im.getPersistentDataContainer().set(u.key, PersistentDataType.DOUBLE, amount);
		im.setLore(Arrays.asList(u.cc("&7Right-Click to redeem &a$" + u.dc(amount))));
		i.setItemMeta(im);
		return i;
	}
	


	
	}



