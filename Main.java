package dev.esejj.luckydrop;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.inventory.Inventory;

import java.util.logging.Logger;
import org.bukkit.ChatColor;

public class Main extends JavaPlugin implements CommandExecutor{
	private static Main instance;
	public static List<ItemToDrop> drops = new ArrayList<ItemToDrop>();
	Logger log = Logger.getLogger("Console");
	private String tag = (ChatColor.DARK_GRAY + "[" + ChatColor.DARK_AQUA + "LuckyDrop" + ChatColor.DARK_GRAY + "]");;
	
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
    	if(cmd.getName().equalsIgnoreCase("drop")){ 
            sender.sendMessage(tag + ChatColor.RED + " Tu znajdziesz w przyszlosci informacje o dropie!");
            Bukkit.createInventory();
            Inventory inv = Bukkit.createInventory(null, 5*9, "Drop");
            inv.setItem();
            player.openInventory(inv);
            inv.setItem(8, itemstack);
            return true;
    	}
    	return false;
	}
    @Override
	public void onEnable() {
		instance = this;
		saveDefaultConfig();
		DataLoader.loadBlocks();
		DataLoader.loadMobs();
		Bukkit.getPluginManager().registerEvents(new BlockBreakListener(), this);
		Bukkit.getPluginManager().registerEvents(new EntityDeathListener(), this);
		log.info(tag + " Enabled.");
	}
	@Override
	public void onDisable() {
		log.info(tag + " Disabled.");
	}
	public static Main getInst() {
		return instance;	
	}
	//Tworzysz obiekt Inventory metoda Bukkit.createInventory( ), potem ustawiasz  inv.setItem(), otwierasz player.openInventory(inv)

	//Ixidi Dziś o 12:38
	// i potem cancelujesz event i ustawiasz result na deny w inventoryclickevent

}
