package net.essence.proxy;

import net.essence.*;
import net.essence.blocks.tileentity.*;
import net.essence.dimension.*;
import net.essence.event.*;
import net.essence.misc.*;
import net.essence.util.*;
import net.essence.util.*;
import net.essence.util.EntityRegistry;
import net.essence.util.recipes.RecipeHelper;
import net.minecraftforge.oredict.*;
import net.slayer.api.*;
import cpw.mods.fml.common.event.*;
import cpw.mods.fml.common.registry.*;

public class CommonProxy {

	public void registerClient(){ }
	public void clientInit(FMLInitializationEvent event){ }
	
	public static void preInit(FMLPreInitializationEvent event){
		Config.init();
		EntityRegistry.init();
		RecipeHelper.init();
		DimensionHelper.init();
		DimensionHelper.addSpawns();
		EssenceTabs.init();
		addOreDictionary();
		SlayerAPI.addEventBus(new ArmorAbilityEvent());
		SlayerAPI.addForgeEventBus(new ArmorAbilityEvent());
		SlayerAPI.addEventBus(new PlayerEvent());
		SlayerAPI.addForgeEventBus(new PlayerEvent());
		SlayerAPI.addEventBus(new LevelsEvent());
		GameRegistry.registerTileEntity(TileEntityStatue.class, "Statue");
		GameRegistry.registerTileEntity(TileEntityEnrichedTable.class, "Enriched table");
		GameRegistry.registerTileEntity(TileEntityIncubator.class, "incubator");
	}
	
	public static void init(FMLInitializationEvent event){
		GameRegistry.registerWorldGenerator(new WorldGenEssence(), 10);
	}
	
	public static void postInit(FMLPostInitializationEvent event){ }
	
	public static void serverStarting(FMLServerStartingEvent event){
		SlayerAPI.registerCommand(new EssenceCommands());
	}
	
	private static void addOreDictionary(){
		OreDictionary.registerOre("oreAshual", EssenceBlocks.ashual);
		OreDictionary.registerOre("oreCelestium", EssenceBlocks.celestiumOre);
		OreDictionary.registerOre("oreLunium", EssenceBlocks.luniumOre);
		OreDictionary.registerOre("oreShadium", EssenceBlocks.shadiumOre);
		OreDictionary.registerOre("oreFlairium", EssenceBlocks.flairiumOre);
		OreDictionary.registerOre("ash", EssenceItems.ash);
		OreDictionary.registerOre("ingotCelestium", EssenceItems.celestiumIngot);
		OreDictionary.registerOre("ingotLunium", EssenceItems.luniumIngot);
		OreDictionary.registerOre("ingotShadium", EssenceItems.shadiumIngot);
		OreDictionary.registerOre("ingotFlairium", EssenceItems.flairiumIngot);
	}
}