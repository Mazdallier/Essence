package net.essence;

import java.util.Random;

import net.essence.misc.EnchantmentHotTouch;
import net.essence.misc.EnchantmentWaterWalk;
import net.essence.proxy.CommonProxy;
import net.minecraft.enchantment.Enchantment;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.slayer.api.SlayerAPI;

@Mod(name = SlayerAPI.MOD_NAME, modid = SlayerAPI.MOD_ID, version = SlayerAPI.MOD_VERSION)
public class Essence {

	@Instance(SlayerAPI.MOD_ID)
	public static Essence instance;

	@SidedProxy(clientSide = "net.essence.proxy.ClientProxy", serverSide = "net.essence.proxy.CommonProxy")
	public static CommonProxy proxy;

	public static final Enchantment hotTouch = new EnchantmentHotTouch(165, 3);
	public static final Enchantment waterWalk = new EnchantmentWaterWalk(164, 3);

	@EventHandler
	public static void preInit(FMLPreInitializationEvent event) {
		proxy.preInit(event);
		proxy.registerClient();
		proxy.clientPreInit();
		event.getModMetadata().autogenerated = false;
		event.getModMetadata().credits = "The_SlayerMC";
		event.getModMetadata().description = "A mod with natural progression, a mod full of excitement with great added game play!";
		event.getModMetadata().modId = SlayerAPI.MOD_ID;
		event.getModMetadata().url = "http://www.minecraftforum.net/forums/mapping-and-modding/minecraft-mods/2274016-essence-of-the-gods-1-7-1-7-10-forge-smp-30-mobs-3";
		event.getModMetadata().name = SlayerAPI.MOD_NAME;
		event.getModMetadata().version = SlayerAPI.MOD_VERSION;
	}

	@EventHandler
	public static void init(FMLInitializationEvent event) {
		proxy.init(event);
		proxy.clientInit(event);
		proxy.registerModModels();
	}

	@EventHandler
	public static void postInit(FMLPostInitializationEvent event) {
		proxy.postInit(event);
		proxy.registerSounds();
	}

	@EventHandler
	public static void serverStarting(FMLServerStartingEvent event) {
		proxy.serverStarting(event);
	}
}
