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
