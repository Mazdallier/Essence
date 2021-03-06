package net.essence.entity.mob.vanilla;

import net.essence.entity.MobStats;
import net.essence.enums.EnumSounds;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import net.slayer.api.SlayerAPI;
import net.slayer.api.entity.EntityModMob;

public class EntityBigHongo extends EntityModMob {

	public EntityBigHongo(World par1World) {
		super(par1World);
		addAttackingAI();
		this.setSize(1.0F, 2.0F);
	}

	@Override
	public double setAttackDamage(MobStats s) {
		return s.bigHongoDamage;
	}

	@Override
	public double setMaxHealth(MobStats s) {
		return s.bigHongoHealth;
	}

	@Override
	public String setLivingSound() {
		return EnumSounds.HONGO.getPrefixedName();
	}

	@Override
	public String setHurtSound() {
		return EnumSounds.HONGO_HURT.getPrefixedName();
	}

	@Override
	public String setDeathSound() {
		return EnumSounds.HONGO_HURT.getPrefixedName();
	}

	@Override
	public Item getItemDropped() {
		return SlayerAPI.toItem(Blocks.brown_mushroom);
	}
}