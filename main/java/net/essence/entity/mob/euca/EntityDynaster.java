package net.essence.entity.mob.euca;

import net.essence.EssenceItems;
import net.essence.entity.MobStats;
import net.essence.enums.EnumSounds;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.slayer.api.entity.EntityModMob;

public class EntityDynaster extends EntityModMob{

	public static final int ENTITY_TYPE = 23;
	
	public EntityDynaster(World par1World) {
		super(par1World);
		addAttackingAI();
		setSize(1.0F, 1.7F);
		dataWatcher.updateObject(ENTITY_TYPE, rand.nextInt(4));
	}
	
	@Override
	protected void entityInit() {
		super.entityInit();
		dataWatcher.addObject(ENTITY_TYPE, (int)0);
	}

	@Override
	public double setAttackDamage(MobStats s) {
		return s.dynasterDamage;
	}

	@Override
	public double setMaxHealth(MobStats s) {
		return s.dynasterHealth;
	}

	@Override
	public EnumSounds setLivingSound() {
		return EnumSounds.ROBOT;
	}

	@Override
	public EnumSounds setHurtSound() {
		return EnumSounds.ROBOT_HURT;
	}

	@Override
	public EnumSounds setDeathSound() {
		return EnumSounds.ROBOT_HURT;
	}
	
	@Override
	public boolean attackEntityFrom(DamageSource e, float a) {
		if(e.getSourceOfDamage() instanceof EntityPlayer)
			((EntityPlayer)e.getSourceOfDamage()).addPotionEffect(new PotionEffect(Potion.poison.id, 60, 1));
		return super.attackEntityFrom(e, a);
	}
	
	@Override
	public Item getItemDropped() {
		return EssenceItems.eucaMeat;
	}
	
	@Override
	protected void dropFewItems(boolean b, int j) {
		if(rand.nextInt(70) == 0) dropItem(EssenceItems.eucaTablet, 1);
		super.dropFewItems(b, j);
	}
}