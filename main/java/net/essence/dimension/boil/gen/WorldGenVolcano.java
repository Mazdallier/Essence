package net.essence.dimension.boil.gen;

import java.util.Random;

import net.essence.EssenceBlocks;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.slayer.api.worldgen.WorldGenAPI;

public class WorldGenVolcano extends WorldGenerator{

	private static Random r = new Random();
	public static int height = r.nextInt(25) + 15;
	
	@Override
	public boolean generate(World w, Random r, int x, int y, int z) {
		WorldGenAPI.addCone(w, height, r, x, y, z, EssenceBlocks.ashBlock);
		WorldGenAPI.addRectangle(4, 4, height, w, x - 2, y + 1, z - 2, Blocks.lava);
		return true;
	}
}