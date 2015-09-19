package net.essence.entity.mob.cloudia;

import net.essence.EssenceItems;
import net.essence.entity.MobStats;
import net.essence.enums.EnumSounds;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import net.slayer.api.entity.EntityPeacefullUntillAttacked;

public class EntityStarlightTransporter extends EntityPeacefullUntillAttacked {

	public EntityStarlightTransporter(World w) {
		super(w);
	}

	@Override
	public double setAttackDamage(MobStats s) {
		return MobStats.starlightGolemDamage;
	}

	@Override
	public double setMaxHealth(MobStats s) {
		return MobStats.starlightGolemHealth;
	}

	@Override
	public EnumSounds setLivingSound() {
		return EnumSounds.EMPTY;
	}

	@Override
	public EnumSounds setHurtSound() {
		return EnumSounds.EMPTY;
	}

	@Override
	public EnumSounds setDeathSound() {
		return EnumSounds.EMPTY;
	}
	
	@Override
	protected void dropFewItems(boolean b, int j) {
		if(rand.nextInt(30) == 0) dropItem(EssenceItems.cloudiaOrb, 1);
		super.dropFewItems(b, j);
		
	}

	@Override
	public Item getItemDropped() {
		return EssenceItems.cloudiaOrb;
	}

}