package net.essence.util.recipes;

import net.essence.EssenceBlocks;
import net.essence.EssenceItems;
import net.essence.blocks.BlockColouredBricks;
import net.essence.blocks.BlockMiniColouredBricks;
import net.essence.blocks.BlockStorageBlocks;
import net.essence.blocks.BlockStorageBlocks1;
import net.essence.blocks.BlockStorageBlocks2;
import net.essence.blocks.BlockStorageBlocks3;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class RecipeHelper {

	public static void init() {
		initCrafting();
	}

	public static void initCrafting() {
		EssenceBlocks b = new EssenceBlocks();
		EssenceItems i = new EssenceItems();
		GameRegistry.addRecipe(new ItemStack(EssenceItems.flameCoin), new Object[] {"iii", "idi", "iii", 'i', Items.gold_ingot, 'd', Items.diamond});
		GameRegistry.addRecipe(new ItemStack(EssenceBlocks.eucaPortalFrame, 3), new Object[] {"iii", "iii", "iii", 'i', EssenceItems.eucaPortalGem});
		GameRegistry.addRecipe(new ItemStack(EssenceBlocks.depthsPortalFrame, 3), new Object[] {"iii", "iii", "iii", 'i', EssenceItems.depthsPortalGem});

		addOre(b.celestiumOre, i.celestiumIngot, b.celestiumBlock, i.celestiumAxe, i.celestiumPickaxe, i.celestiumShovel, i.celestiumHoe, i.celestiumSword, i.celestiumMultiTool, i.celestiumHelmet, i.celestiumChest, i.celestiumLegs, i.celestiumBoots, i.celestiumDust);
		addOre(b.hellstoneOre, i.hellstoneIngot, b.hellstoneBlock, i.hellstoneAxe, i.hellstonePickaxe, i.hellstoneShovel, i.hellstoneHoe, i.hellstoneSword, i.hellstoneMultiTool, i.hellstoneHelmet, i.hellstoneChest, i.hellstoneLegs, i.hellstoneBoots, i.hellstoneDust);
		addOre(b.flairiumOre, i.flairiumIngot, b.flairiumBlock, i.flairiumAxe, i.flairiumPickaxe, i.flairiumShovel, i.flairiumHoe, i.flairiumSword, i.flairiumMultiTool, i.flairiumHelmet, i.flairiumChest, i.flairiumLegs, i.flairiumBoots, i.flairiumDust);
		addOre(b.shadiumOre, i.shadiumIngot, b.shadiumBlock, i.shadiumAxe, i.shadiumPickaxe, i.shadiumShovel, i.shadiumHoe, i.shadiumSword, i.shadiumMultiTool, i.shadiumHelmet, i.shadiumChest, i.shadiumLegs, i.shadiumBoots, i.shadiumDust);
		addOre(b.luniumOre, i.luniumIngot, b.luniumBlock, i.luniumAxe, i.luniumPickaxe, i.luniumShovel, i.luniumHoe, i.luniumSword, i.luniumMultiTool, i.luniumHelmet, i.luniumChest, i.luniumLegs, i.luniumBoots, i.luniumDust);
		addOre(b.sapphireOre, i.sapphire, b.sapphireBlock, i.sapphireAxe, i.sapphirePickaxe, i.sapphireShovel, i.sapphireHoe, i.sapphireSword, i.sapphireMultiTool, i.sapphireHelmet, i.sapphireChest, i.sapphireLegs, i.sapphireBoots, i.sapphireDust);

		addWood(b.eucaLog, b.eucaPlank, b.eucaStairs, 0, true);
		addWood(b.depthsLog, b.depthsPlank, b.depthsStairs, 1, true);

		GameRegistry.addRecipe(new ItemStack(i.condensedDiamondHelmet), new Object[] {"iii", "d d", 'i', Items.diamond, 'd', Blocks.diamond_block});
		GameRegistry.addRecipe(new ItemStack(i.condensedDiamondChest), new Object[] {"d d", "iii", "iii", 'i', Items.diamond, 'd', Blocks.diamond_block});	
		GameRegistry.addRecipe(new ItemStack(i.condensedDiamondLegs), new Object[] {"iii", "i i", "d d", 'i', Items.diamond, 'd', Blocks.diamond_block});
		GameRegistry.addRecipe(new ItemStack(i.condensedDiamondBoots), new Object[] {"i i", "d d", 'i', Items.diamond, 'd', Blocks.diamond_block});
		
		GameRegistry.addRecipe(new ItemStack(b.grindstone), new Object[] {" o ", "bib", "bbb", 'b', Blocks.brick_block, 'o', Blocks.obsidian, 'i', Items.iron_ingot});

		GameRegistry.addRecipe(new ItemStack(i.flameBow), new Object[] {" fs", "f s", " fs", 'f', Items.fire_charge, 's', Items.string});
		GameRegistry.addRecipe(new ItemStack(i.flameArrow, 8), new Object[] {"l", "s", "f", 'f', Items.feather, 's', Items.stick, 'l', Items.flint_and_steel});

		GameRegistry.addRecipe(new ItemStack(b.hotGlassPane, 16), new Object[] {"iii", "iii", 'i', b.hotGlass});
		GameRegistry.addRecipe(new ItemStack(b.smoothGlassPane, 16), new Object[] {"iii", "iii", 'i', b.smoothGlass});
		
		addOPFood(EssenceItems.goldenPork, EssenceItems.goldenPorkOP, Items.porkchop);
		addOPFood(EssenceItems.goldenSteak, EssenceItems.goldenSteakOP, Items.beef);
		addOPFood(EssenceItems.goldenPotato, EssenceItems.goldenPotatoOP, Items.potato);
		GameRegistry.addRecipe(new ItemStack(i.hellstoneClump), new Object[] {"iii", 'i', i.hellstoneIngot});
		GameRegistry.addRecipe(new ItemStack(i.shadiumClump), new Object[] {"iii", 'i', i.shadiumIngot});
		GameRegistry.addRecipe(new ItemStack(i.luniumClump), new Object[] {"iii", 'i', i.luniumIngot});
		GameRegistry.addShapelessRecipe(new ItemStack(i.spawnerClump), new Object[]{i.shadiumClump, i.luniumClump, i.hellstoneClump});
		GameRegistry.addSmelting(i.spawnerClump, new ItemStack(i.spawnerBar), 1.0F);
		GameRegistry.addSmelting(Blocks.glass, new ItemStack(b.smoothGlass), 1.0F);

		GameRegistry.addRecipe(new ItemStack(i.calciaOrb), new Object[] {"iii", "ioi", "iii", 'i', i.spawnerBar, 'o', b.hellstoneBlock});
		GameRegistry.addRecipe(new ItemStack(i.witheringBeastOrb), new Object[] {"iii", "ioi", "iii", 'i', i.spawnerBar, 'o', b.luniumBlock});
		GameRegistry.addRecipe(new ItemStack(i.netherBeastOrb), new Object[] {"iii", "ioi", "iii", 'i', i.spawnerBar, 'o', b.shadiumBlock});

		for(int j = 0; j < 13; j++) {
			GameRegistry.addShapelessRecipe(new ItemStack(EssenceBlocks.colouredBricks, 1, j), new Object[] {Blocks.stonebrick, BlockColouredBricks.crafting[j]});
			GameRegistry.addRecipe(new ItemStack(EssenceBlocks.colouredBricks, 8, j), new Object[] {"bbb", "bdb", "bbb", 'b', Blocks.stonebrick, 'd', BlockColouredBricks.crafting[j]});
			GameRegistry.addShapelessRecipe(new ItemStack(EssenceBlocks.miniColouredBricks, 1, j), new Object[] {Blocks.brick_block, BlockMiniColouredBricks.crafting[j]});
			GameRegistry.addRecipe(new ItemStack(EssenceBlocks.miniColouredBricks, 8, j), new Object[] {"bbb", "bdb", "bbb", 'b', Blocks.brick_block, 'd', BlockMiniColouredBricks.crafting[j]});
		}
		
		for(int j = 0; j < 13; j++) {
			//GameRegistry.addRecipe(new ItemStack(EssenceItems.backpack, 1, j), new Object[] {"lll", "lil", "lll", 'i', ItemBackpack.crafting[j], 'l', Items.leather});
		}
		
		for(int j = 0; j < 16; j++) {
			GameRegistry.addRecipe(new ItemStack(EssenceBlocks.storageBlocks, 1, j), new Object[] {"iii", "iii", "iii", 'i', BlockStorageBlocks.crafting[j]});
			GameRegistry.addRecipe(new ItemStack(EssenceBlocks.storageBlocks1, 1, j), new Object[] {"iii", "iii", "iii", 'i', BlockStorageBlocks1.crafting[j]});
			GameRegistry.addRecipe(new ItemStack(EssenceBlocks.storageBlocks2, 1, j), new Object[] {"iii", "iii", "iii", 'i', BlockStorageBlocks2.crafting[j]});
			
			GameRegistry.addShapelessRecipe(BlockStorageBlocks.getBack[j], new Object[] {new ItemStack(EssenceBlocks.storageBlocks, 1, j)});
			GameRegistry.addShapelessRecipe(BlockStorageBlocks1.getBack[j], new Object[] {new ItemStack(EssenceBlocks.storageBlocks1, 1, j)});
			GameRegistry.addShapelessRecipe(BlockStorageBlocks2.getBack[j], new Object[] {new ItemStack(EssenceBlocks.storageBlocks2, 1, j)});
		}
		
		for(int j = 0; j < 11; j++) {
			GameRegistry.addRecipe(new ItemStack(EssenceBlocks.storageBlocks3, 1, j), new Object[] {"iii", "iii", "iii", 'i', BlockStorageBlocks3.crafting[j]});
			GameRegistry.addShapelessRecipe(BlockStorageBlocks3.getBack[j], new Object[] {new ItemStack(EssenceBlocks.storageBlocks3, 1, j)});
		}
	}
	
	public static void addBlock(Block made, Item used) {
		GameRegistry.addRecipe(new ItemStack(made), new Object[] {"iii", "iii", "iii", 'i', used});
	}
	
	public static void addBlock(Block made, Block used) {
		GameRegistry.addRecipe(new ItemStack(made), new Object[] {"iii", "iii", "iii", 'i', used});
	}
	
	public static void addOPFood(Item nonOP, Item OP, Item base) {
		GameRegistry.addRecipe(new ItemStack(nonOP), new Object[] {"iii", "ibi", "iii", 'i', Items.gold_ingot, 'b', base});
		GameRegistry.addRecipe(new ItemStack(OP), new Object[] {"iii", "ibi", "iii", 'i', Blocks.gold_block, 'b', base});

	}

	public static void addOre(Block ore, Item ingot, Block block, Item axe, Item pick, Item shovel, Item hoe, Item sword, Item multiTool, Item helmet, Item chest, Item legs, Item boots, Item dust) {
		addAxe(axe, ingot);
		addPickaxe(pick, ingot);
		addShovel(shovel, ingot);
		addHoe(hoe, ingot);
		GameRegistry.addRecipe(new ItemStack(sword), new Object[] {"b", "b", "s", 'b', block, 's', Items.stick});
		addBlock(block, ingot);
		addHelmet(helmet, ingot);
		addChestplate(chest, ingot);
		addLeggings(legs, ingot);
		addBoots(boots, ingot);
		GameRegistry.addShapelessRecipe(new ItemStack(multiTool), new Object[] {pick, shovel, hoe, axe});
		GameRegistry.addShapelessRecipe(new ItemStack(ingot, 9), new Object[] {block});
		GameRegistry.addSmelting(ore, new ItemStack(ingot), 0.5F);
		GameRegistry.addSmelting(dust, new ItemStack(ingot), 0.5F);
	}

	private static void addWood(Block log, Block plank, Block stair, int slabMeta, boolean smelt) {
		GameRegistry.addShapelessRecipe(new ItemStack(plank, 4), new Object[] {log});
		GameRegistry.addRecipe(new ItemStack(stair, 4), new Object[] {"i  ", "ii ", "iii", 'i', plank});
		GameRegistry.addRecipe(new ItemStack(Items.stick, 4), new Object[] {"i", "i", 'i', plank});
		//GameRegistry.addRecipe(new ItemStack(EssenceBlocks.halfSlab, 6, slabMeta), new Object[] {"iii", 'i', plank});
		if(smelt) GameRegistry.addSmelting(log, new ItemStack(Items.coal), 0.5F);
	}

	private static void addAxe(Item axe, Item ingot) {
		GameRegistry.addRecipe(new ItemStack(axe), new Object[] {" ii", " si", " s ", 'i', ingot, 's', Items.stick});
	}

	private static void addPickaxe(Item pick, Item ingot) {
		GameRegistry.addRecipe(new ItemStack(pick), new Object[] {"iii", " s ", " s ", 'i', ingot, 's', Items.stick});
	}

	private static void addShovel(Item shovel, Item ingot) {
		GameRegistry.addRecipe(new ItemStack(shovel), new Object[] {" i ", " s ", " s ", 'i', ingot, 's', Items.stick});
	}

	private static void addSword(Item sword, Item ingot) {
		GameRegistry.addRecipe(new ItemStack(sword), new Object[] {" i ", " i ", " s ", 'i', ingot, 's', Items.stick});
	}

	private static void addHoe(Item hoe, Item ingot) {
		GameRegistry.addRecipe(new ItemStack(hoe), new Object[] {" ii", " s ", " s ", 'i', ingot, 's', Items.stick});
	}

	private static void addHelmet(Item helmet, Item ingot) {
		GameRegistry.addRecipe(new ItemStack(helmet), new Object[] {"iii", "i i", 'i', ingot});
	}

	private static void addChestplate(Item chest, Item ingot) {
		GameRegistry.addRecipe(new ItemStack(chest), new Object[] {"i i", "iii", "iii", 'i', ingot});
	}

	private static void addLeggings(Item legs, Item ingot) {
		GameRegistry.addRecipe(new ItemStack(legs), new Object[] {"iii", "i i", "i i", 'i', ingot});
	}

	private static void addBoots(Item boots, Item ingot) {
		GameRegistry.addRecipe(new ItemStack(boots), new Object[] {"i i", "i i", 'i', ingot});
	}
}