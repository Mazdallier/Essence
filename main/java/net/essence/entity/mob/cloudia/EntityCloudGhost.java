package net.essence.entity.mob.cloudia;

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

public class EntityCloudGhost extends EntityModMob{

	@SuppressWarnings("do this")
	public EntityCloudGhost(World par1World) {
		super(par1World);
		addAttackingAI();
		setSize(0.7F, 1.0F);
	}

	@Override
	public double setAttackDamage(MobStats s) {
		return s.cloudGhostDamage;
	}

	@Override
	public double setMaxHealth(MobStats s) {
		return s.cloudGhostHealth;
	}

	@Override
	public String setLivingSound() {
		return EnumSounds.SPIKED_BEAST.getPrefixedName();
	}

	@Override
	public String setHurtSound() {
		return EnumSounds.SPIKED_BEAST_HURT.getPrefixedName();
	}

	@Override
	public String setDeathSound() {
		return EnumSounds.SPIKED_BEAST_HURT.getPrefixedName();
	}
	
	@Override
	public Item getItemDropped() {
		return null;
	}
}