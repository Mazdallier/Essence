package net.essence.entity.projectile;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class EntityChaosProjectile extends EntityBouncingProjectile {

	public EntityChaosProjectile(World w) {
		super(w);
	}
	
	public EntityChaosProjectile(World par1, EntityPlayer par2) {
		super(par1, par2, 2, 2);
	}
}