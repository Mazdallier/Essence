package net.essence.dimension.frozen.gen;

import java.util.Random;

import net.essence.EssenceBlocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenLamp2 extends WorldGenerator {

	@Override
	public boolean generate(World world, Random r, BlockPos pos) {
		int i = pos.getX(), j = pos.getY() + 1, k = pos.getZ();
		world.setBlockState(new BlockPos(i + 0, j + 0, k + 1), EssenceBlocks.workshopStone.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 0, j + 3, k + 0), EssenceBlocks.workshopLamp.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 0, j + 3, k + 1), EssenceBlocks.workshopLamp.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 0, j + 3, k + 2), EssenceBlocks.workshopLamp.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 1, j + 0, k + 0), EssenceBlocks.workshopStone.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 1, j + 0, k + 1), EssenceBlocks.workshopStone.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 1, j + 0, k + 2), EssenceBlocks.workshopStone.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 1, j + 1, k + 1), EssenceBlocks.workshopStone.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 1, j + 2, k + 1), EssenceBlocks.workshopStone.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 1, j + 3, k + 0), EssenceBlocks.workshopLamp.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 1, j + 3, k + 1), EssenceBlocks.workshopLamp.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 1, j + 3, k + 2), EssenceBlocks.workshopLamp.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 2, j + 0, k + 1), EssenceBlocks.workshopStone.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 2, j + 3, k + 0), EssenceBlocks.workshopLamp.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 2, j + 3, k + 1), EssenceBlocks.workshopLamp.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 2, j + 3, k + 2), EssenceBlocks.workshopLamp.getDefaultState(), 2);
		return true;
	}
}