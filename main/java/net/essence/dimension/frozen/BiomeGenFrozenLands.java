package net.essence.dimension.frozen;

import net.essence.EssenceBlocks;
import net.minecraft.world.biome.BiomeGenBase;

public class BiomeGenFrozenLands extends BiomeGenBase {

	public BiomeGenFrozenLands(int par1) {
		super(par1);
		this.setBiomeName("Frozen Lands");
		this.topBlock = EssenceBlocks.frozenGrass.getDefaultState();
		this.fillerBlock = EssenceBlocks.frozenDirt.getDefaultState();
		this.spawnableCreatureList.clear();
        this.spawnableMonsterList.clear();
        this.spawnableCaveCreatureList.clear();
        this.spawnableWaterCreatureList.clear();
        rainfall = 0;
        setEnableSnow();
        enableRain = false;
	}
}