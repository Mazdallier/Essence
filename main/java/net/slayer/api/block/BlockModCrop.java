package net.slayer.api.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.IGrowable;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public abstract class BlockModCrop extends BlockBush implements IGrowable {

    public static PropertyInteger AGE;

	public BlockModCrop(String name, int stages) {
		PropertyInteger.create("age", 0, stages);
		this.setTickRandomly(true);
		float f = 0.5F;
		this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 0.25F, 0.5F + f);
		this.setCreativeTab((CreativeTabs)null);
		this.setHardness(0.0F);
		this.setStepSound(soundTypeGrass);
		this.disableStats();
		GameRegistry.registerBlock(this, name);
	}

	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
        super.updateTick(worldIn, pos, state, rand);

        if (worldIn.getLightFromNeighbors(pos.up()) >= 9)
        {
            int i = ((Integer)state.getValue(AGE)).intValue();

            if (i < 7)
            {
                float f = getGrowthChance(this, worldIn, pos);

                if (rand.nextInt((int)(25.0F / f) + 1) == 0)
                {
                    worldIn.setBlockState(pos, state.withProperty(AGE, Integer.valueOf(i + 1)), 2);
                }
            }
        }
    }

    public void growCrops(World worldIn, BlockPos p_176487_2_, IBlockState p_176487_3_)
    {
        int i = ((Integer)p_176487_3_.getValue(AGE)).intValue() + MathHelper.getRandomIntegerInRange(worldIn.rand, 2, 5);

        if (i > 7)
        {
            i = 7;
        }

        worldIn.setBlockState(p_176487_2_, p_176487_3_.withProperty(AGE, Integer.valueOf(i)), 2);
    }

    protected static float getGrowthChance(Block p_180672_0_, World worldIn, BlockPos p_180672_2_)
    {
        float f = 1.0F;
        BlockPos blockpos1 = p_180672_2_.down();

        for (int i = -1; i <= 1; ++i)
        {
            for (int j = -1; j <= 1; ++j)
            {
                float f1 = 0.0F;
                IBlockState iblockstate = worldIn.getBlockState(blockpos1.add(i, 0, j));

                if (iblockstate.getBlock().canSustainPlant(worldIn, blockpos1.add(i, 0, j), net.minecraft.util.EnumFacing.UP, (net.minecraftforge.common.IPlantable)p_180672_0_))
                {
                    f1 = 1.0F;

                    if (iblockstate.getBlock().isFertile(worldIn, blockpos1.add(i, 0, j)))
                    {
                        f1 = 3.0F;
                    }
                }

                if (i != 0 || j != 0)
                {
                    f1 /= 4.0F;
                }

                f += f1;
            }
        }

        BlockPos blockpos2 = p_180672_2_.north();
        BlockPos blockpos3 = p_180672_2_.south();
        BlockPos blockpos4 = p_180672_2_.west();
        BlockPos blockpos5 = p_180672_2_.east();
        boolean flag = p_180672_0_ == worldIn.getBlockState(blockpos4).getBlock() || p_180672_0_ == worldIn.getBlockState(blockpos5).getBlock();
        boolean flag1 = p_180672_0_ == worldIn.getBlockState(blockpos2).getBlock() || p_180672_0_ == worldIn.getBlockState(blockpos3).getBlock();

        if (flag && flag1)
        {
            f /= 2.0F;
        }
        else
        {
            boolean flag2 = p_180672_0_ == worldIn.getBlockState(blockpos4.north()).getBlock() || p_180672_0_ == worldIn.getBlockState(blockpos5.north()).getBlock() || p_180672_0_ == worldIn.getBlockState(blockpos5.south()).getBlock() || p_180672_0_ == worldIn.getBlockState(blockpos4.south()).getBlock();

            if (flag2)
            {
                f /= 2.0F;
            }
        }

        return f;
    }

    public boolean canBlockStay(World worldIn, BlockPos p_180671_2_, IBlockState p_180671_3_)
    {
        return (worldIn.getLight(p_180671_2_) >= 8 || worldIn.canSeeSky(p_180671_2_)) && this.canPlaceBlockOn(worldIn.getBlockState(p_180671_2_.down()).getBlock());
    }

    public abstract Item getSeed();
    public abstract Item getCrop();

    public void dropBlockAsItemWithChance(World worldIn, BlockPos pos, IBlockState state, float chance, int fortune)
    {
        super.dropBlockAsItemWithChance(worldIn, pos, state, chance, 0);
    }

    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return ((Integer)state.getValue(AGE)).intValue() == 7 ? this.getCrop() : this.getSeed();
    }

    public boolean isStillGrowing(World worldIn, BlockPos p_176473_2_, IBlockState p_176473_3_, boolean p_176473_4_)
    {
        return ((Integer)p_176473_3_.getValue(AGE)).intValue() < 7;
    }

    public boolean canUseBonemeal(World worldIn, Random p_180670_2_, BlockPos p_180670_3_, IBlockState p_180670_4_)
    {
        return true;
    }

    @SideOnly(Side.CLIENT)
    public Item getItem(World worldIn, BlockPos pos)
    {
        return this.getSeed();
    }

    public void grow(World worldIn, Random p_176474_2_, BlockPos p_176474_3_, IBlockState p_176474_4_)
    {
        this.growCrops(worldIn, p_176474_3_, p_176474_4_);
    }

    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(AGE, Integer.valueOf(meta));
    }

    public int getMetaFromState(IBlockState state)
    {
        return ((Integer)state.getValue(AGE)).intValue();
    }

    protected BlockState createBlockState()
    {
        return new BlockState(this, new IProperty[] {AGE});
    }

    @Override
    public java.util.List<ItemStack> getDrops(net.minecraft.world.IBlockAccess world, BlockPos pos, IBlockState state, int fortune)
    {
        java.util.List<ItemStack> ret = super.getDrops(world, pos, state, fortune);
        int age = ((Integer)state.getValue(AGE)).intValue();
        Random rand = world instanceof World ? ((World)world).rand : new Random();

        if (age >= 7)
        {
            int k = 3 + fortune;

            for (int i = 0; i < 3 + fortune; ++i)
            {
                if (rand.nextInt(15) <= age)
                {
                    ret.add(new ItemStack(this.getSeed(), 1, 0));
                }
            }
        }
        return ret;
    }
}