package net.essence;

import java.util.ArrayList;

import net.essence.blocks.*;
import net.essence.blocks.machines.BlockGrindstone;
import net.essence.client.*;
import net.essence.client.render.mob.model.statue.*;
import net.essence.enums.EnumSounds;
import net.essence.items.block.*;
import net.minecraft.block.*;
import net.minecraftforge.fml.common.registry.*;
import net.slayer.api.*;
import net.slayer.api.block.*;

public class EssenceBlocks {

	public static ArrayList<String> blockName = new ArrayList<String>();
	
	public static final Block hellstoneOre = new BlockModOre("hellstoneOre", 3.0F).setHarvestLevel(EnumToolType.DIAMOND_PICK);
	public static final Block celestiumOre = new BlockModOre("celestiumOre", 2.0F).setHarvestLevel(EnumToolType.DIAMOND_PICK);
	public static final Block luniumOre = new BlockModOre("luniumOre", 2.0F).setHarvestLevel(EnumToolType.DIAMOND_PICK);
	public static final Block shadiumOre = new BlockModOre("shadiumOre", 2.0F).setHarvestLevel(EnumToolType.DIAMOND_PICK);
	public static final Block flairiumOre = new BlockModOre("flairiumOre", 2.0F).setHarvestLevel(EnumToolType.DIAMOND_PICK);
	public static final Block ashual = new BlockModOre("ashual", 2.0F);
	public static final Block sapphireOre = new BlockModOre("sapphireOre", 2.0F).setHarvestLevel(EnumToolType.IRON_PICK);
	public static final Block enderilliumOre = new BlockModOre("enderilliumOre", 2.0F).setHarvestLevel(EnumToolType.DIAMOND_PICK);

	public static final Block hellstoneBlock = new BlockModOre("hellstoneBlock", 3.0F).setHarvestLevel(EnumToolType.IRON_PICK);
	public static final Block celestiumBlock = new BlockModOre("celestiumBlock", 2.0F).setHarvestLevel(EnumToolType.IRON_PICK);
	public static final Block luniumBlock = new BlockModOre("luniumBlock", 2.0F).setHarvestLevel(EnumToolType.IRON_PICK);
	public static final Block shadiumBlock = new BlockModOre("shadiumBlock", 2.0F).setHarvestLevel(EnumToolType.IRON_PICK);
	public static final Block flairiumBlock = new BlockModOre("flairiumBlock", 2.0F).setHarvestLevel(EnumToolType.IRON_PICK);
	public static final Block sapphireBlock = new BlockModOre("sapphireBlock", 2.0F).setHarvestLevel(EnumToolType.IRON_PICK);
	public static final Block enderilliumBlock = new BlockModOre("enderilliumBlock", 2.0F).setHarvestLevel(EnumToolType.IRON_PICK);

	/*public static final Block hellstoneBlockOverlay = new BlockModOre("hellstoneBlock_overlay", -1).setCreativeTab(null);
	public static final Block celestiumBlockOverlay = new BlockModOre("celestiumBlock_overlay", -1).setCreativeTab(null);
	public static final Block luniumBlockOverlay = new BlockModOre("luniumBlock_overlay", -1).setCreativeTab(null);
	public static final Block shadiumBlockOverlay = new BlockModOre("shadiumBlock_overlay", -1).setCreativeTab(null);
	public static final Block flairiumBlockOverlay = new BlockModOre("flairiumBlock_overlay", -1).setCreativeTab(null);*/

	public static final BlockModSlab eucaSlab = new BlockModSlab(false, "eucaSlab");
	//public static final BlockModDoubleSlab eucaFullSlab = new BlockModDoubleSlab(true, "eucaDoubleSlab");
	
	public static final BlockModSlab depthsSlab = new BlockModSlab(false, "depthsSlab");
	//public static final BlockModDoubleSlab depthsFullSlab = new BlockModDoubleSlab(true, "depthsDoubleSlab");
	
	public static final BlockMod eucaDirt = new BlockMod(EnumMaterialTypes.DIRT, "eucaDirt", 2.0F);
	public static final Block eucaGrass = new BlockModGrass(eucaDirt, "eucaGrass", 2.0F, "eucaDirt");
	public static final Block eucaStone = new BlockMod("eucaStone", 2.0F);
	public static final Block eucaLog = new BlockModLog("eucaLog");
	public static final Block eucaPlank = new BlockMod(EnumMaterialTypes.WOOD, "eucaPlank", 1.0F);
	public static final Block eucaStairs = new BlockModStairs(eucaPlank, "eucaStairs");
	public static final Block redEucaLeaves = new BlockModLeaves("redEucaLeaves", 1.0F);
	public static final Block greenEucaLeaves = new BlockModLeaves("greenEucaLeaves", 1.0F);
	public static final Block blueEucaLeaves = new BlockModLeaves("blueEucaLeaves", 1.0F);
	public static final Block eucaSapling = new BlockEucaSapling("eucaSapling");
	
	public static final BlockMod depthsDirt = new BlockMod(EnumMaterialTypes.DIRT, "depthsDirt", 2.0F);
	public static final Block depthsGrass = new BlockModGrass(depthsDirt, "depthsGrass", 2.0F, "depthsDirt");
	public static final Block depthsStone = new BlockMod("depthsStone", 2.0F);
	public static final Block depthsLog = new BlockModLog("depthsLog");
	public static final Block depthsPlank = new BlockMod(EnumMaterialTypes.WOOD, "depthsPlank", 1.0F);
	public static final Block depthsStairs = new BlockModStairs(depthsPlank, "depthsStairs");
	public static final Block depthsLeaves = new BlockModLeaves("depthsLeaves", 1.0F);

	public static final BlockMod godDirt = new BlockMod(EnumMaterialTypes.DIRT, "godDirt", 2.0F);
	public static final Block godGrass = new BlockModGrass(godDirt, "godGrass", 2.0F, "godDirt");
	public static final Block godStone = new BlockMod("godStone", 2.0F);
	
	public static final BlockMod frozenDirt = new BlockMod(EnumMaterialTypes.DIRT, "frozenDirt", 2.0F);
	public static final Block frozenGrass = new BlockModGrass(frozenDirt, "frozenGrass", 2.0F, "frozenDirt");
	public static final Block frozenStone = new BlockMod("frozenStone", 2.0F);
	
	public static final BlockEucaPortal eucaPortal = (BlockEucaPortal)new BlockEucaPortal("eucaPortal");
	public static final Block eucaPortalFrame = new BlockMod("eucaPortalFrame", 3.0F);
	public static final BlockDepthsPortal depthsPortal = (BlockDepthsPortal)new BlockDepthsPortal("depthsPortal");
	public static final Block depthsPortalFrame = new BlockMod("depthsPortalFrame", 3.0F);
	public static final BlockBoilPortal boilPortal = (BlockBoilPortal)new BlockBoilPortal("boilingPortal");
	public static final Block boilPortalFrame = new BlockMod("boilingPortalFrame", 3.0F);
	public static final BlockFrozenPortal frozenPortal = (BlockFrozenPortal)new BlockFrozenPortal("frozenPortal");
	
	public static final Block hotBlock = new BlockMod("hotGround", 2.0F);
	public static final Block ashBlock = new BlockMod(EnumMaterialTypes.STONE, "ash", "ashBlock");

	public static final Block fire = new BlockModFire("fire");
	public static final BlockBoilingFire boilingFire = new BlockBoilingFire("boilingFire");
	
	public static final Block mossyEssenceStone = new BlockMod("mossyEssenceStone", 2.0F);

	public static final Block dungeonBrick = new BlockDungeonBlock("dungeonBrick");
	public static final Block dungeonCrackedBrick = new BlockDungeonBlock("dungeonCrackedBrick");
	public static final Block dungeonChisledBrick = new BlockDungeonBlock("dungeonChiseledBrick");
	public static final Block dungeonBrickCarved = new BlockDungeonBlock("dungeonBrickCarved");
	public static final Block dungeonLamp = new BlockDungeonBlock("dungeonLamp", true);
	
	public static final Block dungeonBrickStairs = new BlockModStairs(dungeonBrick, "dungeonBrickStairs");
	public static final Block dungeonCrackedBrickStairs = new BlockModStairs(dungeonCrackedBrick, "dungeonCrackedBrickStairs");
	public static final Block dungeonChisledBrickStairs = new BlockModStairs(dungeonChisledBrick, "dungeonChiseledBrickStairs");
	public static final Block dungeonBrickCarvedStairs = new BlockModStairs(dungeonBrickCarved, "dungeonBrickCarvedStairs");
	public static final Block dungeonLampStairs = new BlockModStairs(dungeonLamp, "dungeonLampStairs", true);

	public static final Block dungeonBrickFence = new BlockModFence(dungeonBrick, "dungeonBrick");
	public static final Block dungeonCrackedBrickFence = new BlockModFence(dungeonCrackedBrick, "dungeonCrackedBrick");
	public static final Block dungeonChisledBrickFence = new BlockModFence(dungeonChisledBrick, "dungeonChiseledBrick");
	public static final Block dungeonBrickCarvedFence = new BlockModFence(dungeonBrickCarved, "dungeonBrickCarved");
	public static final Block dungeonLampFence = new BlockModFence(dungeonLamp, "dungeonLamp", true);
	
	public static final Block hotBrick = new BlockMod("hotBrick", 2.0F);
	public static final Block hotBrick_fence = new BlockModFence(hotBrick, "hotBrick");
	public static final Block hotBrick_stairs = new BlockModStairs(hotBrick, "hotBrickStairs");

	public static final Block hotGlass = new BlockJoinedGlass("hotGlass");
	public static final Block smoothGlass = new BlockJoinedGlass("smoothGlass");
	public static final Block hotGlassPane = new BlockJoinedPane("hotGlass");
	public static final Block smoothGlassPane = new BlockJoinedPane("smoothGlass");
	
	public static final Block witheringBeastStatue = new BlockStatue("witheringBeastStatue", new ModelWitheringBeastStatue(), EnumSounds.WITHER);
	public static final Block netherBeastStatue = new BlockStatue("netherBeastStatue", new ModelNetherBeastStatue(), EnumSounds.NETHER_BEAST);
	public static final Block calciaStatue = new BlockStatue("calciaStatue", new ModelCalciaStatue(), EnumSounds.CALCIA);
	public static final Block eudorStatue = new BlockStatue("eudorStatue", new ModelEudorStatue(), EnumSounds.CALCIA);
	//public static final Block enderChampionStatue = new BlockStatue("enderChampionStatue", new ModelEnderChampionStatue());
	//public static final Block wraithStatue = new BlockStatue("wraithStatue", new ModelWraithStatue());

	//public static final Block enrichedEnchantmentTable = new BlockEnrichedEnchantmentTable("enrichedEnchantmentTable");
	
	//public static final Block incubatorIdle = new BlockIncubator("incubator", false);
	//public static final Block incubatorActive = new BlockIncubator("incubatorActive", true);
	
	public static final BlockModDoor hotDoor = new BlockModDoor(EnumMaterialTypes.STONE, 5.0F, "hotDoorBlock");
	
	public static final Block colouredBricks = new BlockColouredBricks();
	public static final Block miniColouredBricks = new BlockMiniColouredBricks();
	public static final Block glowshroom = new BlockGlowshroom("glowshroom");
	public static final Block caveVine = new BlockCaveVine("caveVine");
	
	public static final Block storageBlocks = new BlockStorageBlocks();
	public static final Block storageBlocks1 = new BlockStorageBlocks1();
	public static final Block storageBlocks2 = new BlockStorageBlocks2();
	public static final Block storageBlocks3 = new BlockStorageBlocks3();

	public static final Block christmasLights = new BlockChristmasLights("christmasLights");
	
	public static final Block workshopCarpet = new BlockMod(EnumMaterialTypes.WOOL, "workshopCarpet", 0.5F);
	public static final Block frozenGlass = new BlockJoinedGlass("frozenGlass");
	public static final Block frozenPane = new BlockJoinedPane("frozenGlass");
	public static final Block workshopLamp = new BlockMod(EnumMaterialTypes.GLASS, "workshopLamp", 0.5F).setLightLevel(1.0F);
	public static final Block workshopStone = new BlockMod(EnumMaterialTypes.STONE, "workshopStone", 0.5F);
	public static final Block workshopStoneStair = new BlockModStairs(workshopStone, "workshopStairs");
	public static final Block workshopStoneFence = new BlockModFence(workshopStone, "workshopStone");
	public static final BlockModDoor frozenDoor = new BlockModDoor(EnumMaterialTypes.STONE, 5.0F, "frozenDoorBlock");
	public static final Block candyCane = new BlockMod(EnumMaterialTypes.WOOD, "candyCane", 2.0F);
	public static final Block workshopSlab = new BlockHalfSlab("workshopSlab");
	
	public static final BlockModFlower eucaTallGrass = new BlockModFlower("eucaTallGrass");
	public static final BlockModFlower eucaGreenFlower = new BlockModFlower("eucaGreenFlower");
	public static final BlockModFlower eucaBlueFlower = new BlockModFlower("eucaBlueFlower");
	
	public static final Block grindstone = new BlockGrindstone("grindstone");
}