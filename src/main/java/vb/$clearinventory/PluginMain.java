package vb.$clearinventory;
import java.io.*;
import java.nio.file.*;
import java.util.*;
import org.bukkit.*;
import org.bukkit.command.*;
import org.bukkit.event.*;
import org.bukkit.plugin.java.*;

public class PluginMain extends JavaPlugin implements Listener {

	private static PluginMain instance;

	@Override
	public void onEnable() {
		instance = this;
		getServer().getPluginManager().registerEvents(this, this);
		try {
			((org.bukkit.command.CommandSender) (Object) ((org.bukkit.command.ConsoleCommandSender) org.bukkit.Bukkit
					.getConsoleSender()))
							.sendMessage(ChatColor.translateAlternateColorCodes('&',
									"&7[&6ClearInventory&7] &aPlugin Has Enabled ( Plugin Made By &bQuocNguyen &a)"));
			new Metrics(PluginMain.getInstance(), ((int) (16825d)));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onDisable() {
		try {
			((org.bukkit.command.CommandSender) (Object) ((org.bukkit.command.ConsoleCommandSender) org.bukkit.Bukkit
					.getConsoleSender()))
							.sendMessage(ChatColor.translateAlternateColorCodes('&',
									"&7[&6ClearInventory&7] &cPlugin Has Disabled &a( &aPlugin By &bQuocNguyen &a)"));
			new Metrics(PluginMain.getInstance(), ((int) (16825d)));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean onCommand(CommandSender commandSender, Command command, String label, String[] commandArgs) {
		if (command.getName().equalsIgnoreCase("clearinv")) {
			try {
				((org.bukkit.inventory.Inventory) ((org.bukkit.inventory.InventoryHolder) (Object) commandSender)
						.getInventory()).clear();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return true;
		}
		return true;
	}

	public static void procedure(String procedure, List procedureArgs) throws Exception {
	}

	public static Object function(String function, List functionArgs) throws Exception {
		return null;
	}

	public static List createList(Object obj) {
		if (obj instanceof List) {
			return (List) obj;
		}
		List list = new ArrayList<>();
		if (obj.getClass().isArray()) {
			int length = java.lang.reflect.Array.getLength(obj);
			for (int i = 0; i < length; i++) {
				list.add(java.lang.reflect.Array.get(obj, i));
			}
		} else if (obj instanceof Collection<?>) {
			list.addAll((Collection<?>) obj);
		} else if (obj instanceof Iterator) {
			((Iterator<?>) obj).forEachRemaining(list::add);
		} else {
			list.add(obj);
		}
		return list;
	}

	public static void createResourceFile(String path) {
		Path file = getInstance().getDataFolder().toPath().resolve(path);
		if (Files.notExists(file)) {
			try (InputStream inputStream = PluginMain.class.getResourceAsStream("/" + path)) {
				Files.createDirectories(file.getParent());
				Files.copy(inputStream, file);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static PluginMain getInstance() {
		return instance;
	}
}
