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

public class WPvPItemsListners implements Listener {
	
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
				
				inv.setItem(2, getItem(Material.DIAMOND_SWORD, "§c§k|§r §4⚔§r §c§k|§r §8§lWither Sword§r §c§k|§r §4⚔§r §c§k|", "§rThis sword has a chance of giving", "§8§lWither§r to the opponent on hit.", "§7Sharpness II", "§7Unbreaking L", Enchantment.DAMAGE_ALL, 2, Enchantment.DURABILITY, 50));
				
				inv.setItem(9, getItem(Material.DIAMOND_HELMET, "§d§lToughth Helmet", "§rPart of the §c§lEverlasting Armor§r set", "§7Protection II", "§7Unbreaking L", null, Enchantment.PROTECTION_ENVIRONMENTAL, 2, Enchantment.DURABILITY, 50));
				
				inv.setItem(18, getItem(Material.DIAMOND_CHESTPLATE, "§d§lToughth Chestplate", "§rPart of the §c§lEverlasting Armor§r set", "§7Protection II", "§7Unbreaking L", null, Enchantment.PROTECTION_ENVIRONMENTAL, 2, Enchantment.DURABILITY, 50));
				
				inv.setItem(27, getItem(Material.DIAMOND_LEGGINGS, "§d§lToughth Leggings", "§rPart of the §c§lEverlasting Armor§r set", "§7Protection II", "§7Unbreaking L", null, Enchantment.PROTECTION_ENVIRONMENTAL, 2, Enchantment.DURABILITY, 50));
				
				inv.setItem(36, getItem(Material.DIAMOND_BOOTS, "§d§lToughth Boots", "§rPart of the §c§lEverlasting Armor§r set", "§7Protection II", "§7Unbreaking L", null, Enchantment.PROTECTION_ENVIRONMENTAL, 2, Enchantment.DURABILITY, 50));
				
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
	public void onHit(EntityDamageByEntityEvent event){
		
		Entity damager = event.getDamager();
		
		if (damager instanceof Player) { 
			
			Player player = (Player) damager;
			
			if (player.getItemInHand().hasItemMeta() && player.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§c§k|§r §4⚔§r §c§k|§r §8§lWither Sword§r §c§k|§r §4⚔§r §c§k|")) {
				
				Float rand = (float) Math.random();
				
				if (rand < 0.05) { //5% Wither III
												
				((LivingEntity) event.getEntity()).addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 50, 2));

				
				}
				
				if (rand > 0.05 && rand < 0.2) { //15% Wither II
					
				((LivingEntity) event.getEntity()).addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 100, 1));

					
				}
				
				if (rand > 0.2 && rand < 0.7) { //50% Wither I
					
				((LivingEntity) event.getEntity()).addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 250, 0));

					
				}

			}
			
			if (player.getInventory().getHelmet().hasItemMeta() && player.getInventory().getChestplate().hasItemMeta() && player.getInventory().getLeggings().hasItemMeta() && player.getInventory().getBoots().hasItemMeta() && player.getInventory().getHelmet().getItemMeta().getDisplayName().equalsIgnoreCase("§d§lToughth Helmet") && player.getInventory().getChestplate().getItemMeta().getDisplayName().equalsIgnoreCase("§d§lToughth Chestplate") && player.getInventory().getLeggings().getItemMeta().getDisplayName().equalsIgnoreCase("§d§lToughth Leggings") && player.getInventory().getBoots().getItemMeta().getDisplayName().equalsIgnoreCase("§d§lToughth Boots")) {
				
				player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 60, 1));
				player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 200, 0));
				
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
