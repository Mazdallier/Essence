package net.essence.dimension.corba.gen.maze;

import net.minecraft.block.Block;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class MazeChunk {

	public void setBlock(World w, int x, int y, int z, Block b) {
		w.setBlockState(new BlockPos(x, y, z), b.getDefaultState());
	}
	
	public void setBlock(World w, int x, int y, int z, Block b, int meta) {
		w.setBlockState(new BlockPos(x, y, z), b.getStateFromMeta(meta));
	}
}