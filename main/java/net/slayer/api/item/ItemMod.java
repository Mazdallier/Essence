package net.slayer.api.item;

import java.util.List;

import net.essence.EssenceTabs;
import net.essence.client.EnumSounds;
import net.essence.util.LangRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.slayer.api.SlayerAPI;
import cpw.mods.fml.common.registry.GameRegistry;

public class ItemMod extends Item {

	protected int healAmount = 0;

	public ItemMod(String name){
		this(name, name, EssenceTabs.items);
	}

	public ItemMod(String name, CreativeTabs tab){
		this(name, name, tab);
	}

	public ItemMod(String name, String textureName, CreativeTabs tab){
		setUnlocalizedName(name);
		setTextureName(SlayerAPI.PREFIX + textureName);
		setCreativeTab(tab);
		GameRegistry.registerItem(this, name);
		LangRegistry.addItem(this);
	}

	public ItemMod setHealAmount(int healAmount){
		this.healAmount = healAmount;
		return this;
	}

	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		if(healAmount != 0){
			if(player.getHealth() < player.getMaxHealth()){
				player.heal(healAmount);
				player.inventory.consumeInventoryItem(this);
			}
		}
		return stack;
	}

	public void spawnEntityIntoWorld(World w, EntityPlayer p, Entity entity, boolean magic, String sound, boolean damage, ItemStack item, int dam) {
		if(!w.isRemote && magic){
			w.spawnEntityInWorld(entity);
			EnumSounds.playSound(sound, w, p);
			if(damage) item.damageItem(dam, p);
		}
	}

	public void spawnEntityIntoWorld(World w, EntityPlayer p, Entity entity, boolean magic, String sound) {
		spawnEntityIntoWorld(w, p, entity, magic, sound, false, null, 0);
	}

	public void addInformation(ItemStack stack, EntityPlayer player, List list){ }

	@Override
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
		addInformation(par1ItemStack, par2EntityPlayer, par3List);
		par3List.add(SlayerAPI.Colour.DARK_AQUA + SlayerAPI.MOD_NAME);
	}
}