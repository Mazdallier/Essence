package net.essence.blocks.machines;

import net.essence.Essence;
import net.essence.EssenceTabs;
import net.essence.blocks.tileentity.TileEntitySummoningTable;
import net.essence.client.GuiHandler.GuiIDs;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.slayer.api.EnumMaterialTypes;
import net.slayer.api.entity.tileentity.container.BlockModContainer;

public class BlockSummoningTable extends BlockModContainer {

	public BlockSummoningTable(String name) {
		super(EnumMaterialTypes.STONE, name, 2.0F, EssenceTabs.blocks);
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ) {
		TileEntitySummoningTable tile = (TileEntitySummoningTable)worldIn.getTileEntity(pos);
		if(!worldIn.isRemote) {
			if(tile != null) { 
				playerIn.openGui(Essence.instance, GuiIDs.SUMMONING.ordinal(), worldIn, pos.getX(), pos.getY(), pos.getZ());
			}
			return true;
		}
		return false;
	}

	@Override
	public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
		TileEntity tileentity = worldIn.getTileEntity(pos);
		if(tileentity instanceof TileEntitySummoningTable)
			InventoryHelper.dropInventoryItems(worldIn, pos, (TileEntitySummoningTable)tileentity);
		super.breakBlock(worldIn, pos, state);
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEntitySummoningTable();
	}
}