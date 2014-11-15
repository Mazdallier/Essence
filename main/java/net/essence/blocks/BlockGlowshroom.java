package net.essence.blocks;

import java.util.List;
import java.util.Random;

import net.essence.EssenceBlocks;
import net.essence.EssenceTabs;
import net.essence.items.block.ItemBlockGlowshroom;
import net.essence.items.block.ItemBlockMetadata;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import net.slayer.api.EnumMaterialTypes;
import net.slayer.api.SlayerAPI;
import cpw.mods.fml.common.registry.GameRegistry;

public class BlockGlowshroom extends Block {

	public static String[] names = {"glowshroom_bottom", "glowshroom_top"};
	private String[] textures = {SlayerAPI.PREFIX + "glowshroom_bottom", SlayerAPI.PREFIX + "glowshroom_top"};
	private IIcon[] icons;

	public BlockGlowshroom(String name) {
		super(EnumMaterialTypes.PLANT.getMaterial());
		setStepSound(EnumMaterialTypes.PLANT.getSound());
		setCreativeTab(EssenceTabs.decoraton);
		setHardness(0.0F);
		setLightLevel(0.6F);
		setTickRandomly(true);
		GameRegistry.registerBlock(this, ItemBlockGlowshroom.class, name);
	}

	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World w, int x, int y, int z) {
		return null;
	}

	@Override
	public void registerBlockIcons(IIconRegister i) {
		icons = new IIcon[2];
		icons[0] = i.registerIcon(textures[0]);
		icons[1] = i.registerIcon(textures[1]);
	}

	@Override
	public void getSubBlocks(Item it, CreativeTabs c, List l) {
		l.add(new ItemStack(it, 1, 0));
		l.add(new ItemStack(it, 1, 1));
	}

	@Override
	public int getRenderBlockPass() {
		return 1;
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}

	@Override
	public int getRenderType() {
		return 1;
	}

	@Override
	public void onBlockPlacedBy(World w, int x, int y, int z, EntityLivingBase e, ItemStack i) {
		w.setBlock(x, y, z, this, i.getItemDamage(), 2);
	}

	@Override
	public int getMixedBrightnessForBlock(IBlockAccess w, int x, int y, int z) {
		return 1000;
	}

	@Override
	public void onBlockDestroyedByPlayer(World w, int x, int y, int z, int m) {
		if(m == 0 && w.getBlock(x, y + 1, z) == this) {
			w.setBlock(x, y + 1, z, Blocks.air);
		}
		if(m == 1 && w.getBlock(x, y - 1, z) == this) {
			w.setBlock(x, y - 1, z, Blocks.air);
		}
	}

	@Override
	public boolean canPlaceBlockAt(World w, int x, int y, int z)  {
		return w.getBlock(x, y - 1, z) == Blocks.stone || w.getBlock(x, y - 1, z) == this;
	}

	@Override
	public boolean canBlockStay(World w, int x, int y, int z) {
		return canPlaceBlockAt(w, x, y, z);
	}

	@Override
	public IIcon getIcon(int s, int m) {
		return m == 0 ? icons[0] : m == 1 ? icons[1] : icons[0];
	}
	
	@Override
	public int damageDropped(int m) {
		return 1;
	}
}