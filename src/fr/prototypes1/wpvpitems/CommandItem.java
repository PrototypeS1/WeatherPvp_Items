package fr.prototypes1.wpvpitems;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CommandItem implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd_item, String msg, String[] args) {
		
		if (sender instanceof Player) {
			
			Player player = (Player)sender;
			
			if (args.length < 1) return false;
			
			if (args[0].equalsIgnoreCase("info")) {
				
				player.sendMessage("§§3[WeatherPvP Items]§r Cette commande permet d'intéragir avec le plugin StormPvp Items.");
			
			}
			
			if (args[0].equalsIgnoreCase("compass") || args[0].equalsIgnoreCase("cmp")) {
				
				player.sendMessage("§3[WeatherPvP Items]§r Gave §1§l[1]§r §4§l[Traveler's Compass]§r to player.");
				
				ItemStack compass = new ItemStack(Material.COMPASS);
				ItemMeta cm = compass.getItemMeta();
				
				cm.setDisplayName("§4§lTraveler's Compass");
				cm.addEnchant(Enchantment.ARROW_DAMAGE, 1, false);
				cm.addItemFlags(ItemFlag.HIDE_ENCHANTS);
				
				compass.setItemMeta(cm);
			
				player.getInventory().addItem(compass);
				player.updateInventory();
				
			}
			
			return true;
		}
		
		return false;
	}

}
