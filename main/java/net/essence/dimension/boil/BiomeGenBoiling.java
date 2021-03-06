package net.essence.dimension.boil;

import java.util.Random;

import net.essence.EssenceBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;

public class BiomeGenBoiling extends BiomeGenBase {

	public BiomeGenBoiling(int par1) {
		super(par1);
		this.setBiomeName("Boiling Point");
		this.topBlock = EssenceBlocks.hotBlock.getDefaultState();
		this.fillerBlock = EssenceBlocks.hotBlock.getDefaultState();
		this.spawnableCreatureList.clear();
        this.spawnableMonsterList.clear();
        this.spawnableCaveCreatureList.clear();
        this.spawnableWaterCreatureList.clear();
        rainfall = 0.0F;
        setDisableRain();
        setColor(0xC40600);
	}
	
	/*@Override
	public void genTerrainBlocks(World w, Random r, Block[] b, byte[] by, int x, int z, double d) {
        double d1 = plantNoise.func_151601_a((double)x * 0.25D, (double)z * 0.25D);
        if(d1 > 0.0D) {
            int k = x & 15;
            int l = z & 15;
            int i1 = b.length / 256;
            for(int j1 = 255; j1 >= 0; --j1) {
                int k1 = (l * 16 + k) * i1 + j1;

                if(b[k1] == null || b[k1].getMaterial() != Material.air) {
                    if (j1 == 62 && b[k1] != Blocks.lava) {
                        b[k1] = Blocks.lava;
                    }
                    break;
                }
            }
        }
        this.genBiomeTerrain(w, r, b, by, x, z, d);
    }*/
	
	@Override
	public int getSkyColorByTemp(float par1) {
		return 0xC40600;
	}
}