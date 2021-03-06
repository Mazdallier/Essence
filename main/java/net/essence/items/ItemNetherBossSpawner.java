package net.essence.items;

import java.util.List;

import net.essence.EssenceItems;
import net.essence.EssenceTabs;
import net.essence.entity.mob.boss.EntityCalcia;
import net.essence.entity.mob.boss.EntityNetherBeast;
import net.essence.entity.mob.boss.EntityWitheringBeast;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.slayer.api.SlayerAPI;
import net.slayer.api.item.ItemMod;

public class ItemNetherBossSpawner extends ItemMod {

	public ItemNetherBossSpawner(String name) {
		super(name, EssenceTabs.util);
		setMaxStackSize(1);
	}

	@Override
	public boolean onItemUse(ItemStack i, EntityPlayer p, World w, BlockPos pos, EnumFacing fa, float par8, float par9, float par10) {
		Item item = i.getItem();
		if(!w.isRemote){
			if(w.provider.getDimensionId() == -1) {
				EntityWitheringBeast wither = new EntityWitheringBeast(w);
				EntityCalcia calcia = new EntityCalcia(w);
				EntityNetherBeast nether = new EntityNetherBeast(w);
				if(item == EssenceItems.calciaOrb){
					SlayerAPI.sendMessageToAll("Calcia has been summoned", true);
					calcia.setPosition(pos.getX(), pos.getY() + 1, pos.getZ());
					w.spawnEntityInWorld(calcia);
				}
				if(item == EssenceItems.netherBeastOrb){
					SlayerAPI.sendMessageToAll("The Nether Beast has been summoned", true);
					calcia.setPosition(pos.getX(), pos.getY() + 1, pos.getZ());
					w.spawnEntityInWorld(nether);
				}
				if(item == EssenceItems.witheringBeastOrb){
					SlayerAPI.sendMessageToAll("The Withering Beast has been summoned", true);
					calcia.setPosition(pos.getX(), pos.getY() + 1, pos.getZ());
					w.spawnEntityInWorld(wither);
				}
				if(!p.capabilities.isCreativeMode) i.stackSize--;
			} else {
				SlayerAPI.addChatMessage(p, EnumChatFormatting.GREEN + "Cannot be spawned unless in the Nether.");
			}
		}
		return true;
	}

	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list) {
		Item item = stack.getItem();
		String spawn = "";
		if(item == EssenceItems.calciaOrb)
			spawn = "Calcia";
		if(item == EssenceItems.netherBeastOrb)
			spawn = "Nether Beast";
		if(item == EssenceItems.witheringBeastOrb)
			spawn = "Withering Beast";
		list.add("Spawns the boss: " + spawn);
	}
}