package net.essence.entity.mob.euca;

import net.essence.Sounds;
import net.essence.entity.MobStats;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import net.slayer.api.entity.EntityModMob;

public class EntityPsyollom extends EntityModMob {

	public EntityPsyollom(World par1World) {
		super(par1World);
		addAttackingAI();
		setSize(1.7F, 2.7F);
	}

	@Override
	public double setAttackDamage(MobStats s) {
		return s.psyollomDamage;
	}

	@Override
	public double setMaxHealth(MobStats s) {
		return s.psyollomHealth;
	}

	@Override
	public String setLivingSound(Sounds s) {
		return s.psyollom;
	}

	@Override
	public String setHurtSound(Sounds s) {
		return s.psyollomHurt;
	}

	@Override
	public String setDeathSound(Sounds s) {
		return s.psyollomHurt;
	}
	
	@Override
	public Item getItemDropped() {
		return null;
	}
}