package net.essence.client;

import java.util.List;

import net.essence.EssenceItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ArmorDescription {

	public static void add(ItemStack item, EntityPlayer player, List<String> list) {
		Item i = item.getItem();
		if(i == EssenceItems.hellstoneHelmet || i == EssenceItems.hellstoneChest || i == EssenceItems.hellstoneLegs || i == EssenceItems.hellstoneBoots)
			list.add("Full set: Fire Protection");

		if(i == EssenceItems.shadiumHelmet || i == EssenceItems.shadiumChest || i == EssenceItems.shadiumLegs || i == EssenceItems.shadiumBoots)
			list.add("Full set: Water Breathing");

		if(i == EssenceItems.celestiumHelmet || i == EssenceItems.celestiumChest || i == EssenceItems.celestiumLegs || i == EssenceItems.celestiumBoots) {
			list.add("Full set: Jump 3 Blocks High");
			list.add("Full set: Run Faster");
			list.add("Full set: No Fall Damage");
		}
		
		if(i == EssenceItems.luniumHelmet || i == EssenceItems.luniumChest || i == EssenceItems.luniumLegs || i == EssenceItems.luniumBoots)
			list.add("Full set: Adds 4 Melee Damage");
		
		if(i == EssenceItems.flairiumHelmet || i == EssenceItems.flairiumChest || i == EssenceItems.flairiumLegs || i == EssenceItems.flairiumBoots)
			list.add("Full set: Lets You Fly");
		
		if(i == EssenceItems.sapphireHelmet || i == EssenceItems.sapphireChest || i == EssenceItems.sapphireLegs || i == EssenceItems.sapphireBoots)
			list.add("Full set: Water breathing");
		
		if(i == EssenceItems.flameHelmet || i == EssenceItems.flameChest || i == EssenceItems.flameLegs || i == EssenceItems.flameBoots)
			list.add("Full set: Sets foe on fire when hit");
		
		if(i == EssenceItems.twilightHelmet || i == EssenceItems.twilightChest || i == EssenceItems.twilightLegs || i == EssenceItems.twilightBoots)
			list.add("Full set: Grants the player Night Vision");
		
		if(i == EssenceItems.snakeskinHelmet || i == EssenceItems.snakeskinChest || i == EssenceItems.snakeskinLegs || i == EssenceItems.snakeskinBoots)
			list.add("Full set: Grants speed and fire resistance while in lava");
		
		if(i == EssenceItems.leapersHelmet || i == EssenceItems.leapersChest || i == EssenceItems.leapersLegs || i == EssenceItems.leapersBoots)
			list.add("Full set: Grants increased jump hight");
		
		if(i == EssenceItems.treehuggersHelmet || i == EssenceItems.treehuggersChest || i == EssenceItems.treehuggersLegs || i == EssenceItems.treehuggersBoots)
			list.add("Full set: Grants increased farming drops");

		if(i == EssenceItems.charskullHelmet || i == EssenceItems.charskullChest || i == EssenceItems.charskullLegs || i == EssenceItems.charskullBoots)
			list.add("Full set: Grants resistance and haste");
	}
}