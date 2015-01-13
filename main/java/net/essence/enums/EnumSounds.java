package net.essence.enums;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public enum EnumSounds {

	ROBOT("essence:robot"),
	ROBOT_HURT("essence:robotHurt"),
	PSYOLLOM("essence:psyollom"),
	PSYOLLOM_HURT("essence:psyollomHurt"),
	INSECTO("essence:insecto"),
	INSECTO_HURT("essence:turtleHurt"),
	SPIKED_BEAST("essence:spikedBeast"),
	SPIKED_BEAST_HURT("essence:spikedBeastHurt"),
	MAGMA_GIANT("essence:magmaGiant"),
	MAGMA_GIANT_HURT("essence:magmaGiantHurt"),
	SPYCLOPS("essence:spyclops"),
	SPYCLOPS_HURT("essence:spyclopsHurt"),
	TURTLE("essence:turtle"),
	TURTLE_HURT("essence:turtleHurt"),
	BUNNY("essence:bunny"),
	BUNNY_HURT("essence:bunnyHurt"),
	HONGO("essence:hongo"),
	SMALL_HONGO("essence:smallHongo"),
	SMALL_HONGO_HURT("essence:smallHongoHurt"),
	HONGO_HURT("essence:hongoHurt"),
	REAPER("essence:reaper"),
	REAPER_HURT("essence:reaperHurt"),
	SAND_CRAWLER("essence:sandCrawler"),
	DEPTHS_HUNTER("essence:depthsHunter"),
	DEPTHS_HUNTER_HURT("essence:depthsHunterHurt"),
	NETHER_BEAST("essence:netherBeast"),
	NETHER_BEAST_HURT("essence:netherBeastHurt"),
	CALCIA("essence:calcia"),
	CALCIA_HURT("essence:calciaHurt"),
	IRON_GOLEM_HURT("mob.irongolem.hit"),
	IRON_GOLEM_DEATH("mob.irongolem.death"),
	BLAZE("mob.blaze.breathe"),
	BLAZE_HURT("mob.blaze.hit"),
	BLAZE_DEATH("mob.blaze.death"),
	WITHER("mob.wither.idle"),
	WITHER_HURT("mob.wither.hurt"),
	WITHER_DEATH("mob.wither.death"),
	STAFF("essence:staff"),
	WRAPPER("essence:wrapper"),
	PAGE_FLIP("essence:pageFlip"),
	SPARKLE("essence:magicSparkle"),
	CANNON("essence:cannon"),
	PLASMA("essence:plasma");
	
	private String sound;

	private EnumSounds(String sound) {
		this.sound = sound;
	}
	
	public String getPrefixedName() {
		return sound;
	}
	
	public String getNonPrefixedName() {
		return sound;
	}
	
	public static void playSound(String sound, World w, EntityLivingBase e){
		w.playSoundAtEntity(e, sound, 1.0F, 1.0F);
	}
	
	public static void playSound(String sound, World w, EntityLivingBase e, float volume, float pitch){
		w.playSoundAtEntity(e, sound, volume, pitch);
	}
	
	public static void playSound(EnumSounds sound, World w, EntityLivingBase e){
		w.playSoundAtEntity(e, sound.getNonPrefixedName(), 1.0F, 1.0F);
	}
	
	public static void playSound(EnumSounds sound, World w, EntityLivingBase e, float volume, float pitch){
		w.playSoundAtEntity(e, sound.getNonPrefixedName(), volume, pitch);
	}
	
	public static void playSound(String sound, World w, TileEntity e){
		w.playSound((double)e.getPos().getX(), (double)e.getPos().getY(), (double)e.getPos().getZ(), sound, 1.0F, 1.0F, true);
	}
	
	public static void playSound(String sound, World w, TileEntity e, float volume, float pitch){
		w.playSound((double)e.getPos().getX(), (double)e.getPos().getY(), (double)e.getPos().getZ(), sound, volume, pitch, true);
	}
}