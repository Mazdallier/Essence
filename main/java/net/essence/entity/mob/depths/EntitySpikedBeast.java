package net.essence.entity.mob.depths;

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

public class EntitySpikedBeast extends EntityModMob{

	public EntitySpikedBeast(World par1World) {
		super(par1World);
		addAttackingAI();
		setSize(0.7F, 1.7F);
	}

	@Override
	public double setAttackDamage(MobStats s) {
		return s.spikedBeastDamage;
	}

	@Override
	public double setMaxHealth(MobStats s) {
		return s.spikedBeastHealth;
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
	public boolean attackEntityFrom(DamageSource e, float a) {
		if(e.getSourceOfDamage() instanceof EntityPlayer)
			((EntityPlayer)e.getSourceOfDamage()).addPotionEffect(new PotionEffect(Potion.blindness.id, 60, 1));
		return super.attackEntityFrom(e, a);
	}
	
	@Override
	public Item getItemDropped() {
		return null;
	}
}