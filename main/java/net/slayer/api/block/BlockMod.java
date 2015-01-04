package net.slayer.api.block;

import java.util.Random;

import net.essence.EssenceBlocks;
import net.essence.EssenceItems;
import net.essence.EssenceTabs;
import net.essence.client.render.particles.OreParticleFX;
import net.essence.util.Config;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.slayer.api.EnumMaterialTypes;
import net.slayer.api.EnumToolType;
import net.slayer.api.SlayerAPI;

public class BlockMod extends Block{

	protected EnumMaterialTypes blockType;
	protected Item drop = null;
	protected Random rand;
	public int boostBrightnessLow;
	public int boostBrightnessHigh;
	public boolean enhanceBrightness;
	public String name;

	public BlockMod(String name, float hardness) {
		this(EnumMaterialTypes.STONE, name, hardness, EssenceTabs.blocks);
	}
	
	public BlockMod(String name) {
		this(EnumMaterialTypes.STONE, name, 2.0F, EssenceTabs.blocks);
	}
	
	public BlockMod(EnumMaterialTypes type, String name, float hardness) {
		this(type, name, hardness, EssenceTabs.blocks);
	}

	public BlockMod(String name, boolean breakable, CreativeTabs tab) {
		this(EnumMaterialTypes.STONE, name, tab);
	}
	
	public BlockMod(String name, boolean breakable) {
		this(name, breakable, EssenceTabs.blocks);
	}

	public BlockMod(EnumMaterialTypes blockType, String name, CreativeTabs tab) {
		super(blockType.getMaterial());
		this.blockType = blockType;
		setHardness(2.0F);
		rand = new Random();
		setStepSound(blockType.getSound());
		setCreativeTab(tab);
		setUnlocalizedName(name);
		this.name = name; 
		EssenceBlocks.blockName.add(name);
		GameRegistry.registerBlock(this, name);
	}

	public BlockMod(EnumMaterialTypes blockType, String name, float hardness, CreativeTabs tab) {
		super(blockType.getMaterial());
		this.blockType = blockType;
		rand = new Random();
		setStepSound(blockType.getSound());
		setCreativeTab(tab);
		setUnlocalizedName(name);
		setHardness(hardness);
		this.name = name;
		EssenceBlocks.blockName.add(name);
		GameRegistry.registerBlock(this, name);
	}

	public Block addName(String name) {
		EssenceBlocks.blockName.add(name);
		return this;
	}
	
	public String getName() {
		return name;
	}
	
	@Override
	public int getMixedBrightnessForBlock(IBlockAccess worldIn, BlockPos pos) {
		/*if(this == EssenceBlocks.mossyEssenceStone || this == EssenceBlocks.christmasLights) {
			return 900;
		} else {*/
			return super.getMixedBrightnessForBlock(worldIn, pos);
		//}
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		if(drop == null) return SlayerAPI.toItem(this);
		return drop;
	}

	public BlockMod setHarvestLevel(EnumToolType type) {
		setHarvestLevel(type.getType(), type.getLevel());
		return this;
	}
	
	@Override
	public boolean isOpaqueCube() {
		return this != EssenceBlocks.christmasLights;
	}

	/*@Override
	public int getRenderType() {
		return this == EssenceBlocks.mossyEssenceStone ? 173 : 3;
	}*/
	
	@Override
	public int getRenderType() {
		return 3;
	}

    @Override
    public EnumWorldBlockLayer getBlockLayer() {
        return EnumWorldBlockLayer.SOLID;
    }
	
	@Override
	public int quantityDropped(Random rand) {
		return 1;
	}
	
	@Override
	public boolean isNormalCube() {
		return true;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World w, BlockPos pos, IBlockState state, Random random) {
		if(Config.boilBlockSpawnSmoke){
			if(w.getBlockState(pos) == EssenceBlocks.hotBlock){
				int x = pos.getX();
				int y = pos.getY();
				int z = pos.getZ();
				double d0 = 0.0625D;
				for(int l = 0; l < 6; ++l) {
					double d1 = (double)((float)x + random.nextFloat());
					double d2 = (double)((float)y + random.nextFloat());
					double d3 = (double)((float)z + random.nextFloat());
					if(l == 0 && !w.getBlockState(new BlockPos(x, y + 1, z)).getBlock().isOpaqueCube()) d2 = (double)(y + 1) + d0;
					if(l == 1 && !w.getBlockState(new BlockPos(x, y - 1, z)).getBlock().isOpaqueCube()) d2 = (double)(y + 0) - d0;
					if(l == 2 && !w.getBlockState(new BlockPos(x, y, z + 1)).getBlock().isOpaqueCube()) d3 = (double)(z + 1) + d0;    
					if(l == 3 && !w.getBlockState(new BlockPos(x, y, z - 1)).getBlock().isOpaqueCube()) d3 = (double)(z + 0) - d0;
					if(l == 4 && !w.getBlockState(new BlockPos(x + 1, y, z)).getBlock().isOpaqueCube()) d1 = (double)(x + 1) + d0;
					if(l == 5 && !w.getBlockState(new BlockPos(x - 1, y, z)).getBlock().isOpaqueCube()) d1 = (double)(x + 0) - d0;
					if(d1 < (double)x || d1 > (double)(x + 1) || d2 < 0.0D || d2 > (double)(y + 1) || d3 < (double)z || d3 > (double)(z + 1)) {
						OreParticleFX var20 = new OreParticleFX(w, d1, d2, d3, 0, 0, 0);
						FMLClientHandler.instance().getClient().effectRenderer.addEffect(var20);
					}
				}
			}
		}
	}
}