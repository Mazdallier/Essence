package net.essence.dimension.depths.gen;

import java.util.Random;

import net.essence.EssenceBlocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.chunk.ChunkPrimer;

public class WorldGenSpike {

	public boolean generate(ChunkPrimer c, Random r, BlockPos p) {
		int x = p.getX(), y = p.getY(), z = p.getZ();
		int width = r.nextInt(4) + 3;
		int height = 70;
		for(int j = 0; j < height; j++) placeCircle(c, x, j + y, z, Math.abs(((height / 2) - j)) / 5 + width);
		return true;
	}
	
	public void placeCircle(ChunkPrimer c, int x, int y, int z, int r) {
		if(r >= 6) r = 5;
		for(float i = 0; i < r; i += 0.5) {
			for(float j = 0; j < 2 * Math.PI * i; j += 0.5) {
				c.setBlockState((int)Math.floor(x + Math.sin(j) * i), y, (int)Math.floor(z + Math.cos(j) * i), EssenceBlocks.depthsStone.getDefaultState());
			}
		}
	}
}