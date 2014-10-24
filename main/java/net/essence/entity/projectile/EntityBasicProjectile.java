package net.essence.entity.projectile;

import java.util.Random;

import net.essence.client.render.particles.EntityHellstoneFX;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import cpw.mods.fml.client.FMLClientHandler;

public class EntityBasicProjectile extends EntityThrowable {

	private float damage;

	public EntityBasicProjectile(World var1) {
		super(var1);
	}

	public EntityBasicProjectile(World var1, EntityLivingBase var3, float dam) {
		super(var1, var3);
		damage = dam;
	}
	
	@Override
	public void onUpdate() {
		Random rand = new Random();
		super.onUpdate();
		for(int i = 0; i < 6; ++i) {
			EntityFX effect = new EntityHellstoneFX(this.worldObj, this.posX, this.posY - 1.0F, this.posZ, 0.0D, 0.0D, 0.0D);
			FMLClientHandler.instance().getClient().effectRenderer.addEffect(effect);
		}
	}

	@Override
	protected void onImpact(MovingObjectPosition var1) {
		if(var1.entityHit != null) var1.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, getThrower()), damage);
		if(!worldObj.isRemote) this.setDead();
	}

	@Override
	protected float getGravityVelocity() {
		return 0.001F;
	}
}