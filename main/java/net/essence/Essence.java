package net.essence;

import java.util.Random;

import net.essence.misc.EnchantmentHotTouch;
import net.essence.misc.EnchantmentLavaWalk;
import net.essence.misc.EnchantmentWaterWalk;
import net.essence.network.PacketHandler;
import net.essence.network.PacketOpenGui;
import net.essence.proxy.CommonProxy;
import net.minecraft.enchantment.Enchantment;
import net.slayer.api.SlayerAPI;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;

@Mod(name = SlayerAPI.MOD_NAME, modid = SlayerAPI.MOD_ID, version = SlayerAPI.MOD_VERSION)
public class Essence {

	public static Random rand = new Random();
	public static final PacketHandler packetHandler = new PacketHandler();
	
	@Instance(SlayerAPI.MOD_ID)
	public static Essence instance;
	
	@SidedProxy(clientSide = "net.essence.proxy.ClientProxy", serverSide = "net.essence.proxy.CommonProxy")
	public static CommonProxy proxy;
	
	public static final Enchantment hotTouch = new EnchantmentHotTouch(165, 3);
	public static final Enchantment waterWalk = new EnchantmentWaterWalk(166, 3);

	@EventHandler
	public static void preInit(FMLPreInitializationEvent event) {
		proxy.preInit(event);
		proxy.registerClient();
		event.getModMetadata().autogenerated = false;
		event.getModMetadata().credits = "The_SlayerMC";
		event.getModMetadata().description = "A mod with natural progression, a mod full of excitement with great added game play!";
		event.getModMetadata().modId = SlayerAPI.MOD_ID;
		event.getModMetadata().name = SlayerAPI.MOD_NAME;
		event.getModMetadata().version = SlayerAPI.MOD_VERSION;
	}
	
	@EventHandler
	public static void init(FMLInitializationEvent event) {
		proxy.init(event);
		proxy.clientInit(event);
		packetHandler.init();
	}
	
	@EventHandler
	public static void postInit(FMLPostInitializationEvent event) {
		proxy.postInit(event);
		packetHandler.registerPacket(PacketOpenGui.class);
		packetHandler.postInit();
	}
	
	@EventHandler
	public static void serverStarting(FMLServerStartingEvent event) {
		proxy.serverStarting(event);
	}
}