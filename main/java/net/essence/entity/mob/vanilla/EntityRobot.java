package net.essence.entity.mob.vanilla;

import net.essence.client.EnumSounds;
import net.essence.entity.MobStats;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import net.slayer.api.entity.EntityModMob;

public class EntityRobot extends EntityModMob {

	public EntityRobot(World par1World) {
		super(par1World);
		addAttackingAI();
		setSize(0.7F, 2.3F);
	}

	@Override
	public double setAttackDamage(MobStats s) {
		return s.robotDamage;
	}
	
	@Override
	public double setMaxHealth(MobStats s) {
		return s.robotHealth;
	}

	@Override
	public String setLivingSound() {
		return EnumSounds.ROBOT.getPrefixedName();
	}

	@Override
	public String setHurtSound() {
		return EnumSounds.ROBOT_HURT.getPrefixedName();
	}

	@Override
	public String setDeathSound() {
		return EnumSounds.ROBOT_HURT.getPrefixedName();
	}
	
	@Override
	public Item getItemDropped() {
		return null;
	}
}