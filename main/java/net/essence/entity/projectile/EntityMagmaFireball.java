package net.essence.entity.projectile;

import net.essence.client.render.particles.EntityHellstoneFX;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntitySmallFireball;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.FMLClientHandler;

public class EntityMagmaFireball extends EntitySmallFireball {

	public EntityMagmaFireball(World w) {
		super(w);
	}
	
    public EntityMagmaFireball(World w, EntityLivingBase e, double x, double y, double z) {
        super(w, e, x, y, z);
        this.setSize(0.3125F, 0.3125F);
    }
    
    @Override
    public void onUpdate() {
    	super.onUpdate();
		for(int i = 0; i < 6; ++i) {
			EntityFX effect = new EntityHellstoneFX(this.worldObj, this.posX, this.posY - 1.0F, this.posZ, 0.0D, 0.0D, 0.0D);
			FMLClientHandler.instance().getClient().effectRenderer.addEffect(effect);
		}
    }

	@Override
	protected void onImpact(MovingObjectPosition m) {
		if (!this.worldObj.isRemote) {
            boolean flag;

            if (m.entityHit != null) {
                flag = m.entityHit.attackEntityFrom(DamageSource.causeFireballDamage(this, this.shootingEntity), 5.0F);

                if (flag) {
                    this.func_174815_a(this.shootingEntity, m.entityHit);

                    if (!m.entityHit.isImmuneToFire()) {
                        m.entityHit.setFire(5);
                    }
                }
            } else {
                flag = true;

                if (this.shootingEntity != null && this.shootingEntity instanceof EntityLiving) {
                    flag = this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing");
                }

                if (flag) {
                    BlockPos blockpos = m.getBlockPos().offset(m.sideHit);

                    if (this.worldObj.isAirBlock(blockpos)) {
                        this.worldObj.setBlockState(blockpos, Blocks.fire.getDefaultState());
                    }
                }
            }

            this.setDead();
        }
    }
}