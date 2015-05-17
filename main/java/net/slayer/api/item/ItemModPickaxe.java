package net.slayer.api.item;

import java.util.List;

import net.essence.EssenceItems;
import net.essence.EssenceTabs;
import net.essence.util.EssenceToolMaterial;
import net.essence.util.LangHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.slayer.api.SlayerAPI;

public class ItemModPickaxe extends ItemPickaxe {
	
	protected EssenceToolMaterial mat;

    public ItemModPickaxe(String name, EssenceToolMaterial tool) {
		super(tool.getToolMaterial());
		mat = tool;
        setUnlocalizedName(name);
        setCreativeTab(EssenceTabs.tools);
        setHarvestLevel("pickaxe", tool.getHarvestLevel());
        EssenceItems.itemNames.add(name);
        GameRegistry.registerItem(this, name);
    }
    
	@Override
	public boolean isItemTool(ItemStack i) {
		return true;
	}
    
	@Override
	public boolean getIsRepairable(ItemStack i, ItemStack i1) {
		boolean canRepair = mat.getRepairItem() != null;
		if(canRepair) return mat.getRepairItem() == i1.getItem() ? true : super.getIsRepairable(i, i1);
		return super.getIsRepairable(i, i1);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack item, EntityPlayer player, List infoList, boolean par4) {
		infoList.add(SlayerAPI.Colour.BLUE + LangHelper.getEfficiency() + ": " + toolMaterial.getEfficiencyOnProperMaterial());
		if(item.getMaxDamage() != -1) infoList.add(item.getMaxDamage() - item.getItemDamage() + " " + LangHelper.getUsesRemaining());
		else infoList.add(SlayerAPI.Colour.GREEN + LangHelper.getInfiniteUses());
	}
}