package net.essence.util;

import net.minecraft.util.ResourceLocation;
import net.slayer.api.SlayerAPI;

public class Textures {
	
	public static final String prefix = SlayerAPI.PREFIX + "textures/models/mobs/";
    public static final String projectilePrefix = SlayerAPI.PREFIX + "textures/projectile/";
    public static final String modelPrefix = SlayerAPI.PREFIX + "textures/models/";
    public static final String slotPrefix = SlayerAPI.PREFIX + "textures/gui/slot";

    public static final ResourceLocation basic = addProjectile("gray");
    public static final ResourceLocation bouncingProjectile = addProjectile("bouncing");
    public static final ResourceLocation magmaBall = addProjectile("magmaBall");
    public static final ResourceLocation grindstone = addModel("blocks/grindstone");
    public static final ResourceLocation empty = addProjectile("empty");

    public static final ResourceLocation robot = addMob("robot");
    public static final ResourceLocation blank = addMob("blank");
    public static final ResourceLocation spyclops = addMob("spyclops");
    public static final ResourceLocation spikedBeast = addMob("spikedBeast");
    public static final ResourceLocation magmaGiant = addMob("magmaGiant");
    public static final ResourceLocation insecto = addMob("insecto");
    public static final ResourceLocation psyollom = addMob("psyollom");
    public static final ResourceLocation depthsBeast = addMob("depthsBeast");
    public static final ResourceLocation darknessCrawler = addMob("darknessCrawler");
    public static final ResourceLocation netherBeast = addMob("netherBeast");
    public static final ResourceLocation witheringBeast = addMob("witheringBeast");
    public static final ResourceLocation calcia = addMob("calcia");
    public static final ResourceLocation eudor = addMob("eudor");

    public static final ResourceLocation boom = addMob("boom");
    public static final ResourceLocation boomArmor = addMob("boomArmor");
    public static final ResourceLocation wraith = addMob("wraith");
    public static final ResourceLocation bigHongo = addMob("bigHongo");
    public static final ResourceLocation mediumHongo = addMob("mediumHongo");
    public static final ResourceLocation smallHongo = addMob("smallHongo");
    public static final ResourceLocation eucaFighter = addMob("eucaFighter");    
    public static final ResourceLocation eucaHopper = addMob("eucaHopper");
    public static final ResourceLocation eucaHopperTamed = addMob("eucaHopperTamed");
    public static final ResourceLocation magmaBlaze = addMob("magmaBlaze");
    public static final ResourceLocation crisp = addMob("crisp");
    public static final ResourceLocation burntMiner = addMob("burntMiner");
    public static final ResourceLocation exposedFlame = addMob("exposedFlame");
    public static final ResourceLocation burningLight = addMob("burningLight");
    public static final ResourceLocation ashHoarder = addMob("ashHoarder");
    public static final ResourceLocation burntAsh = addMob("burntAsh");
    public static final ResourceLocation reaper = addMob("reaper");
    public static final ResourceLocation depthsHunter = addMob("depthsHunter");
    public static final ResourceLocation eucaCharger = addMob("eucaCharger");
    public static final ResourceLocation bunny = addMob("bunny");
    public static final ResourceLocation sandCrawler = addMob("sandCrawler");
    public static final ResourceLocation turtle = addMob("turtle");
    public static final ResourceLocation waterFisherman = addMob("waterFisherman");
    public static final ResourceLocation fireMage = addMob("fireMage");
    public static final ResourceLocation iceMage = addMob("iceMage");

    private static ResourceLocation addMob(String tex){
    	return new ResourceLocation(prefix + tex + ".png");
    }
    
    private static ResourceLocation addProjectile(String tex){
    	return new ResourceLocation(projectilePrefix + tex + ".png");
    }
    
    private static ResourceLocation addModel(String tex){
    	return new ResourceLocation(modelPrefix + tex + ".png");
    }
    
    private static ResourceLocation addSlot(String tex){
    	return new ResourceLocation(slotPrefix + tex + ".png");
    }
}