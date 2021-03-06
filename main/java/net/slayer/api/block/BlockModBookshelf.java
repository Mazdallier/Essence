package net.slayer.api.block;

import net.essence.EssenceTabs;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBookshelf;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockModBookshelf extends BlockBookshelf {
	
    public BlockModBookshelf(String name) {
        setUnlocalizedName(name);
        setCreativeTab(EssenceTabs.blocks);
        setStepSound(Block.soundTypeWood);
        GameRegistry.registerBlock(this, name);
    }
}