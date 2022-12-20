package fr.prototypes1.wpvpitems;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class wpvpitemsListners implements Listener {
	
	@EventHandler
	public void onInteract(PlayerInteractEvent event) {
		
		Player player = event.getPlayer();
		Action action = event.getAction();
		ItemStack it = event.getItem();
		
		if (it == null) return;
		
		if (it.getType() == Material.COMPASS && it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equalsIgnoreCase("§4§lTraveler's Compass")) {
			
			if (action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK) {
			
				Inventory inv = Bukkit.createInventory(player, 54, "§3§lStorm PvP Items");
				
				inv.setItem(0, getItem(Material.DIAMOND_AXE, "§6§lTimberer's Axe", "§rThis Axe gives §e§lHaste IV§r", "§rwhen digging with it.", "§7Efficiency VI", "§7Unbreaking L", Enchantment.DIG_SPEED, 6, Enchantment.DURABILITY, 50));
				
				inv.setItem(1, getItem(Material.DIAMOND_PICKAXE, "§6§lDigger's Pickaxe", "§rThis pickaxe gives §e§lHaste IV§r", "§rwhen digging with it.", "§7Efficiency VI", "§7Unbreaking L", Enchantment.DIG_SPEED, 6, Enchantment.DURABILITY, 50));
				
				inv.setItem(2, getItem(Material.DIAMOND_SWORD, "§6§lHunter's Sword", "§rThis sword gives §8§lWither III", "§rto the opponent it hit.", "§7Sharpness VI", "§7Unbreaking L", Enchantment.DAMAGE_ALL, 6, Enchantment.DURABILITY, 50));
				
				player.openInventory(inv);
				
			}
		}
		
		if (it.getType() == Material.DIAMOND_AXE && it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equalsIgnoreCase("§6§lTimberer's Axe")) {
			
			if (action == Action.LEFT_CLICK_BLOCK) {
				
				player.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 600, 3));
			}
		
		}
			
		if (it.getType() == Material.DIAMOND_PICKAXE && it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equalsIgnoreCase("§6§lDigger's Pickaxe")) {
				
			if (action == Action.LEFT_CLICK_BLOCK) {
				
				player.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 600, 3));
			}
		}
	}
	
	@EventHandler
	public void onHit(EntityDamageByEntityEvent event) {
		
		Entity damager = event.getDamager();
		
		if (damager instanceof Player) { 
			
			Player player = (Player) damager;
			
			if (player.getItemInHand().hasItemMeta() && player.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§6§lHunter's Sword")) {
				
				((LivingEntity) event.getEntity()).addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 100, 3));
				player.sendMessage("Triggered Wither III on your opponent !");

			}
			
		}
		
		
		
	}
	
	public ItemStack getItem(Material material, String customName, String customLore1, String customLore2, String customLore3, String customLore4, Enchantment enchant1, int enchant_level1, Enchantment enchant2, int enchant_level2){
		
		ItemStack item = new ItemStack(material);
		ItemMeta cm = item.getItemMeta();
		
		cm.setDisplayName(customName);
		cm.setLore(Arrays.asList(customLore1, customLore2, customLore3, customLore4));
		cm.addEnchant(enchant1, enchant_level1, true);
		cm.addEnchant(enchant2, enchant_level2, true);
		cm.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		
		item.setItemMeta(cm);
		
		return item;
		
	}
	
	
}
