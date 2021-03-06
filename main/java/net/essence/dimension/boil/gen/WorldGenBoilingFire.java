package net.essence.dimension.boil.gen;

import java.util.Random;

import net.essence.EssenceBlocks;
import net.essence.blocks.BlockBoilingFire;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenBoilingFire extends WorldGenerator{

	@Override
	public boolean generate(World w, Random r, BlockPos p) {
		for(int i = 0; i < 100; i++){
			BlockPos pos1 = new BlockPos(p.getX() + r.nextInt(8) - r.nextInt(8), p.getY() + r.nextInt(4) - r.nextInt(4), p.getZ() + r.nextInt(8) - r.nextInt(8));
			if(EssenceBlocks.boilingFire.canBlockStay(w, pos1)) {
				w.setBlockState(pos1, EssenceBlocks.boilingFire.getDefaultState(), 2);
				return true;
			}
		}
		return false;
	}
}