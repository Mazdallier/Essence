package net.essence.dimension.euca;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.essence.EssenceBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSand;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.NoiseGeneratorOctaves;
import net.minecraft.world.gen.NoiseGeneratorPerlin;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.ChunkProviderEvent;
import net.minecraftforge.fml.common.eventhandler.Event.Result;

public class ChunkProviderEuca implements IChunkProvider {

	private Random rand;
	private NoiseGeneratorOctaves noiseGen1, noiseGen2, noiseGen3, field_909_n, noiseGen4, noiseGen5, noiseGen6;
	private World worldObj;
	private double[] noiseArray, stoneNoise = new double[256];
	private BiomeGenBase[] biomesForGeneration;
	private double[] noise3, noise1, noise2, noise5, noise6;
	private NoiseGeneratorPerlin field_147430_m;
	private int[][] field_914_i = new int[32][32];
	private double[] generatedTemperatures;
	private ArrayList<WorldGenerator> trees;

	public ChunkProviderEuca(World var1, long var2){
		this.worldObj = var1;
		this.rand = new Random(var2);
		this.noiseGen1 = new NoiseGeneratorOctaves(this.rand, 16);
		this.noiseGen2 = new NoiseGeneratorOctaves(this.rand, 16);
		this.noiseGen3 = new NoiseGeneratorOctaves(this.rand, 8);
		this.field_909_n = new NoiseGeneratorOctaves(this.rand, 4);
		this.field_147430_m = new NoiseGeneratorPerlin(this.rand, 4);
		this.noiseGen4 = new NoiseGeneratorOctaves(this.rand, 4);
		this.noiseGen5 = new NoiseGeneratorOctaves(this.rand, 10);
		this.noiseGen6 = new NoiseGeneratorOctaves(this.rand, 16);

		/*trees = new ArrayList(9);
		trees.add(new WorldGenBigEucaTree());
		trees.add(new WorldGenSmallEucaTree());
		trees.add(new WorldGenHugeEucaSpruceTree(true, true));
		trees.add(new WorldGenEucaSpruceTree());
		trees.add(new WorldGenEucaSpruceTree1());
		trees.add(new WorldGenEucaPyramidTree());
		trees.add(new WorldGenEucaSmallRectangleTree());
		trees.add(new WorldGenEucaSmallSphereTree());
		trees.add(new WorldGenEucaTallPine());
		trees.add(new WorldGenSmallEucaTree2());*/
	}

	@Override
	public boolean chunkExists(int i, int j) {
		return true;
	}

	@Override
	public Chunk provideChunk(int par1, int par2) {
		this.rand.setSeed((long)par1 * 391279128714L + (long)par2 * 132894987741L);
		ChunkPrimer primer = new ChunkPrimer();
		this.biomesForGeneration = this.worldObj.getWorldChunkManager().loadBlockGeneratorData(this.biomesForGeneration, par1 * 16, par2 * 16, 16, 16);
		this.generateTerrain(par1, par2, primer);
		this.replaceBlocksForBiome(worldObj, rand, primer, new Block[32768], par1, par2);
		Chunk chunk = new Chunk(this.worldObj, primer, par1, par2);
		byte[] abyte = chunk.getBiomeArray();
		for(int k = 0; k < abyte.length; ++k)
			abyte[k] = (byte)this.biomesForGeneration[k].biomeID;
		chunk.generateSkylightMap();
		return chunk;
	}

	public void generateTerrain(int var1, int var2, ChunkPrimer primer) {
		byte b0 = 2;
		int k = b0 + 1;
		byte b1 = 33;
		int l = b0 + 1;
		this.noiseArray = this.initializeNoiseField(this.noiseArray, var1 * b0, 0, var2 * b0, k, b1, l);

		for (int i1 = 0; i1 < b0; ++i1)
		{
			for (int j1 = 0; j1 < b0; ++j1)
			{
				for (int k1 = 0; k1 < 32; ++k1)
				{
					double d0 = 0.25D;
					double d1 = this.noiseArray[((i1 + 0) * l + j1 + 0) * b1 + k1 + 0];
					double d2 = this.noiseArray[((i1 + 0) * l + j1 + 1) * b1 + k1 + 0];
					double d3 = this.noiseArray[((i1 + 1) * l + j1 + 0) * b1 + k1 + 0];
					double d4 = this.noiseArray[((i1 + 1) * l + j1 + 1) * b1 + k1 + 0];
					double d5 = (this.noiseArray[((i1 + 0) * l + j1 + 0) * b1 + k1 + 1] - d1) * d0;
					double d6 = (this.noiseArray[((i1 + 0) * l + j1 + 1) * b1 + k1 + 1] - d2) * d0;
					double d7 = (this.noiseArray[((i1 + 1) * l + j1 + 0) * b1 + k1 + 1] - d3) * d0;
					double d8 = (this.noiseArray[((i1 + 1) * l + j1 + 1) * b1 + k1 + 1] - d4) * d0;

					for (int l1 = 0; l1 < 4; ++l1)
					{
						double d9 = 0.125D;
						double d10 = d1;
						double d11 = d2;
						double d12 = (d3 - d1) * d9;
						double d13 = (d4 - d2) * d9;

						for (int i2 = 0; i2 < 8; ++i2)
						{
							double d14 = 0.125D;
							double d15 = d10;
							double d16 = (d11 - d10) * d14;

							for (int j2 = 0; j2 < 8; ++j2)
							{
								IBlockState iblockstate = null;

								if (d15 > 0.0D)
								{
									iblockstate = Blocks.stone.getDefaultState();
								}

								int k2 = i2 + i1 * 8;
								int l2 = l1 + k1 * 4;
								int i3 = j2 + j1 * 8;
								primer.setBlockState(k2, l2, i3, iblockstate);
								d15 += d16;
							}

							d10 += d12;
							d11 += d13;
						}

						d1 += d5;
						d2 += d6;
						d3 += d7;
						d4 += d8;
					}
				}
			}
		}
	}

	public final void replaceBlocksForBiome(World worldIn, Random p_180628_2_, ChunkPrimer p_180628_3_, Block[] var3, int p_180628_4_, int p_180628_5_)
	{
		byte var5 = 63;
		double var6 = 0.03125D;
		this.stoneNoise = this.noiseGen4.generateNoiseOctaves(this.stoneNoise, p_180628_4_ * 16, p_180628_5_ * 16, 0, 16, 16, 1, var6 * 2.0D, var6 * 2.0D, var6 * 2.0D);
		for(int var8 = 0; var8 < 16; ++var8) {
			for(int var9 = 0; var9 < 16; ++var9) {
				int var12 = (int)(this.stoneNoise[var8 + var9 * 16] / 3.0D + 3.0D + this.rand.nextDouble() * 0.25D);
				int var13 = -1;
				IBlockState var14 = EssenceBlocks.eucaGrass.getDefaultState();
				IBlockState var15 = EssenceBlocks.eucaDirt.getDefaultState();
				for(int var16 = 127; var16 >= 0; --var16) {
					int var17 = (var9 * 16 + var8) * 128 + var16;
					if(var16 <= 0 + this.rand.nextInt(5)) {
						var3[var17] = null;
					} else {
						Block var18 = var3[var17];
						if(var18 == null) var13 = -1;
						else if(var18 == Blocks.stone) {
							if(var13 == -1) {
								if(var12 <= 0) {
									var14 = EssenceBlocks.eucaGrass.getDefaultState();
									var15 = EssenceBlocks.eucaGrass.getDefaultState();
								}
								else if(var16 >= var5 - 4 && var16 <= var5 + 1) {
									var14 = EssenceBlocks.eucaGrass.getDefaultState();
									var15 = EssenceBlocks.eucaStone.getDefaultState();
								}
 
								if(var16 >= var5 - 1) {
									var3[var17] = var14.getBlock();
								} else {
									var3[var17] = var15.getBlock();
								}
							}
							else if(var13 > 0) {
								--var13;
								var3[var17] = var15.getBlock();
 
								if(var13 == 0 && var15 == EssenceBlocks.eucaGrass) {
									var13 = -1;
									var15 = EssenceBlocks.eucaGrass.getDefaultState();
								}
							}
						}
 
						if(var13 > 0) {
							--var13;
							var3[var17] = var15.getBlock();
 
							if(var13 == 0 && var15 == EssenceBlocks.eucaStone) {
								var13 = -1;
								var15 = EssenceBlocks.eucaStone.getDefaultState();
							}
						}
					}
				}
			}
			for(int i = 0; i < 32767; i++) {
				if(var3[i] == EssenceBlocks.eucaGrass && var3[i + 1] != null) var3[i] = EssenceBlocks.eucaDirt;
			}
		}
	}

	private double[] initializeNoiseField(double[] var1, int var2, int var3, int var4, int var5, int var6, int var7) {
		if(var1 == null) var1 = new double[var5 * var6 * var7];
		double var8 = 684.412D;
		double var10 = 684.412D;
		this.noise5 = this.noiseGen5.generateNoiseOctaves(this.noise5, var2, var4, var5, var7, 1.121D, 1.121D, 0.5D);
		this.noise6 = this.noiseGen6.generateNoiseOctaves(this.noise6, var2, var4, var5, var7, 200.0D, 200.0D, 0.5D);
		var8 *= 2.0D;
		this.noise3 = this.noiseGen3.generateNoiseOctaves(this.noise3, var2, var3, var4, var5, var6, var7, var8 / 80.0D, var8 / 160.0D, var8 / 80.0D);
		this.noise1 = this.noiseGen1.generateNoiseOctaves(this.noise1, var2, var3, var4, var5, var6, var7, var8, var10, var8);
		this.noise2 = this.noiseGen2.generateNoiseOctaves(this.noise2, var2, var3, var4, var5, var6, var7, var8, var10, var8);
		int var12 = 0;
		int var13 = 0;
		int var14 = 16 / var5;

		for(int var15 = 0; var15 < var5; ++var15) {
			int var16 = var15 * var14 + var14 / 2;
			for(int var17 = 0; var17 < var7; ++var17) {
				int var18 = var17 * var14 + var14 / 2;
				double var19 = (this.noise5[var13] + 256.0D) / 512.0D;
				double var21 = this.noise6[var13] / 8000.0D;
				if(var21 < 0.0D) var21 = -var21 * 0.3D;
				var21 = var21 * 3.0D - 2.0D;
				if(var21 > 1.0D) var21 = 1.0D;
				var21 /= 8.0D;
				var21 = 0.0D;
				if(var19 < 0.0D) var19 = 0.0D;
				var19 += 0.5D;
				var21 = var21 * var6 / 16.0D;
				++var13;
				double var23 = var6 / 2.0D;
				for(int var25 = 0; var25 < var6; ++var25) {
					double var26 = 0.0D;
					double var28 = (var25 - var23) * 8.0D / var19;
					if(var28 < 0.0D) var28 *= -1.0D;
					double var30 = this.noise1[var12] / 512.0D;
					double var32 = this.noise2[var12] / 512.0D;
					double var34 = (this.noise3[var12] / 10.0D + 1.0D) / 2.0D;
					if(var34 < 0.0D) var26 = var30;
					else if(var34 > 1.0D) var26 = var32;
					else var26 = var30 + (var32 - var30) * var34;
					var26 -= 8.0D;
					byte var36 = 32;
					double var37;
					if(var25 > var6 - var36) {
						var37 = (var25 - (var6 - var36)) / (var36 - 1.0F);
						var26 = var26 * (1.0D - var37) + -30.0D * var37;
					}
					var36 = 8;
					if(var25 < var36) {
						var37 = (var36 - var25) / (var36 - 1.0F);
						var26 = var26 * (1.0D - var37) + -30.0D * var37;
					}
					var1[var12] = var26;
					++var12;
				}
			}
		}
		return var1;
	}

	@Override
	public void populate(IChunkProvider ichunkprovider, int i, int j) {
		int x1 = i * 16;
		int z1 = j * 16;
		int x, y, z, times;
		x = x1 + this.rand.nextInt(16);
		z = z1 + this.rand.nextInt(16);

		/*if(rand.nextInt(1) == 0){
			y = (int)this.worldObj.getHorizon();
			x = x1 + this.rand.nextInt(16);
			z = z1 + this.rand.nextInt(16);
			if(worldObj.getBlockState(new BlockPos(x, y, z)) == Blocks.air && worldObj.getBlockState(new BlockPos(x, y - 1, z)) == EssenceBlocks.eucaGrass && worldObj.getBlockState(new BlockPos(x, y + 1, z)) == Blocks.air)
				trees.get(rand.nextInt(trees.size())).generate(worldObj, rand, new BlockPos(x, y, z));
		}

		if(rand.nextInt(5) == 0) {
			x = x1 + this.rand.nextInt(16);
			y = rand.nextInt(250) + 6;
			z = z1 + this.rand.nextInt(16);
			//new WorldGenEucaSphere().generate(worldObj, rand, x, y, z);
		}*/
	}

	@Override
	public boolean saveChunks(boolean par1, IProgressUpdate par2) {
		return true;
	}

	@Override
	public boolean unloadQueuedChunks() {
		return false;
	}

	@Override
	public boolean canSave() {
		return true;
	}

	@Override
	public String makeString() {
		return "Euca";
	}

	@Override
	public int getLoadedChunkCount() {
		return 0;
	}

	@Override
	public void saveExtraData() { }

	@Override
	public Chunk func_177459_a(BlockPos pos) {
		return this.provideChunk(pos.getX() >> 4, pos.getZ() >> 4);
	}

	@Override
	public boolean func_177460_a(IChunkProvider p_177460_1_, Chunk p_177460_2_, int p_177460_3_, int p_177460_4_) {
		return false;
	}

	@Override
	public List func_177458_a(EnumCreatureType p_177458_1_, BlockPos p_177458_2_) {
		BiomeGenBase var5 = this.worldObj.getBiomeGenForCoords(p_177458_2_);
		return var5 == null ? null : var5.getSpawnableList(p_177458_1_);
	}

	@Override
	public BlockPos func_180513_a(World worldIn, String p_180513_2_, BlockPos p_180513_3_) {
		return null;
	}

	@Override
	public void func_180514_a(Chunk p_180514_1_, int p_180514_2_, int p_180514_3_) { }
}