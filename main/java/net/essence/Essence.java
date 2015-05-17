package net.essence;

import java.util.ArrayList;

import net.essence.event.message.MessageDarkEnergyBar;
import net.essence.event.message.MessageEssenceBar;
import net.essence.event.message.MessagePowerBar;
import net.essence.misc.EnchantmentHotTouch;
import net.essence.misc.EnchantmentWaterWalk;
import net.essence.misc.FluidTropical;
import net.essence.proxy.CommonProxy;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.enchantment.Enchantment;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;
import net.slayer.api.SlayerAPI;

@Mod(name = SlayerAPI.MOD_NAME, modid = SlayerAPI.MOD_ID, version = SlayerAPI.MOD_VERSION)
public class Essence {

	@Instance(SlayerAPI.MOD_ID)
	public static Essence instance;

	@SidedProxy(clientSide = "net.essence.proxy.ClientProxy", serverSide = "net.essence.proxy.CommonProxy")
	public static CommonProxy proxy;

	public static final Enchantment hotTouch = new EnchantmentHotTouch(165, 3);
	public static final Enchantment waterWalk = new EnchantmentWaterWalk(164, 3);
	
	public static final Fluid tropicalWater = new FluidTropical("tropicalWaterFluid");
	public static final Material tropicalMat = new Material(MapColor.waterColor);
	
	public static SimpleNetworkWrapper wrapper;
	
	@EventHandler
	public static void preInit(FMLPreInitializationEvent event) {
		wrapper = NetworkRegistry.INSTANCE.newSimpleChannel("EssenceNetwork");
		wrapper.registerMessage(MessageDarkEnergyBar.DarkEnergyHandler.class, MessageDarkEnergyBar.class, 0, Side.CLIENT);
		wrapper.registerMessage(MessageEssenceBar.EssenceHandler.class, MessageEssenceBar.class, 1, Side.CLIENT);
		wrapper.registerMessage(MessagePowerBar.PowerHandler.class, MessagePowerBar.class, 2, Side.CLIENT);
		FluidRegistry.registerFluid(Essence.tropicalWater);
		proxy.preInit(event);
		proxy.registerClient();
		proxy.clientPreInit();
		ArrayList<String> author = new ArrayList<String>();
		author.add("The_SlayerMC");
		event.getModMetadata().autogenerated = false;
		event.getModMetadata().credits = "The_SlayerMC - Owner/Creator/Code/Ideas, DizzlePop12 - Texturer/Models/Ideas, Eternaldoom - Ideas/Code Helper";
		event.getModMetadata().description = "A mod with natural progression, a mod full of excitement with great added game play!";
		event.getModMetadata().modId = SlayerAPI.MOD_ID;
		event.getModMetadata().url = "https://essence-of-the-gods.net/";
		event.getModMetadata().name = SlayerAPI.MOD_NAME;
		event.getModMetadata().version = SlayerAPI.MOD_VERSION;
		event.getModMetadata().logoFile = "assets/essence/textures/logo.png";
		event.getModMetadata().authorList = author;
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
