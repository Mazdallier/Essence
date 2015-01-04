package net.essence.entity.projectile;

import java.util.Random;

import net.essence.client.render.particles.EntityDoomFX;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.FMLClientHandler;

public class EntityDoomsBringer extends EntityBasicProjectile {

	public EntityDoomsBringer(World var1) {
		super(var1);
	}
	
	public EntityDoomsBringer(World var1, EntityLivingBase var3, float dam) {
		super(var1, var3, dam);
	}
	
	@Override
	public void onUpdate() {
		Random rand = new Random();
		super.onUpdate();
		for(int i = 0; i < 6; ++i) {
			EntityFX effect = new EntityDoomFX(this.worldObj, this.posX, this.posY - 1.0F, this.posZ, -this.motionX, -this.motionY + 0.2D, -this.motionZ);
			FMLClientHandler.instance().getClient().effectRenderer.addEffect(effect);
		}
	}
}