package net.slayer.api.block;

import net.essence.EssenceTabs;
import net.minecraft.block.BlockRotatedPillar;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.slayer.api.SlayerAPI;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockModLog extends BlockRotatedPillar {

	protected IIcon top;
	protected IIcon side;
	protected IIcon[] sideChange;
	protected IIcon[] topChange;
	protected String name;

	public BlockModLog(String name) {
		super(Material.wood);
		this.name = name;
		setBlockName(name);
		setBlockTextureName(SlayerAPI.PREFIX + name);
		setHardness(3.0F);
		setCreativeTab(EssenceTabs.blocks);
		setStepSound(soundTypeWood);
		GameRegistry.registerBlock(this, name);
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister icon) {
		side = icon.registerIcon(getTextureName() + "_side");
		top = icon.registerIcon(getTextureName() + "_top");
	}

	@Override
	public boolean isWood(IBlockAccess world, int x, int y, int z) {
		return true;
	}

	@Override
	public boolean canSustainLeaves(IBlockAccess world, int x, int y, int z) {
		return true;
	}

	@SideOnly(Side.CLIENT)
	protected IIcon getTopIcon(int side) {
		return this.sideChange[side % this.sideChange.length];
	}

	@SideOnly(Side.CLIENT)
	protected IIcon getSideIcon(int side) {
		return this.topChange[side % this.topChange.length];
	}

	@Override
	public int onBlockPlaced(World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ, int meta) {
		int var10 = meta & 3;
		byte var11 = 0;
		switch (side) {
		case 1:
			var11 = 0;
			break;
		case 2:
			var11 = 1;
		case 3:
			var11 = 8;
			break;
		case 4: 
			var11 = 4;
			break;
		case 5:
			var11 = 4;
			break;
		}
		return var11;
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
		int var3 = meta & 12;
		return var3 == 0 && (side == 1 || side == 0) ? this.top : (var3 == 4 && (side == 5 || side == 4) ? this.top : (var3 == 8 && (side == 2 || side == 3) ? top : this.side));
	}
}