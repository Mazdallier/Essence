package net.essence.entity.mob.overworld.underground;

import net.essence.EssenceItems;
import net.essence.entity.MobStats;
import net.essence.entity.projectile.EntityConjuring;
import net.essence.entity.projectile.EntityFireBall;
import net.essence.enums.EnumSounds;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIArrowAttack;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.slayer.api.entity.EntityModMob;

public class EntityCavurn extends EntityModMob implements IRangedAttackMob {

	private EntityAIArrowAttack aiArrowAttack = new EntityAIArrowAttack(this, this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).getAttributeValue(), 15, 60);

	public EntityCavurn(World par1World) {
		super(par1World);
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false, new Class[0]));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
		if(par1World != null && !par1World.isRemote) {
			this.setCombatTask();
		}
	}

	public void setCombatTask() {
		this.tasks.removeTask(this.aiArrowAttack);
			this.tasks.addTask(4, this.aiArrowAttack);
		}

	@Override
	public void setCurrentItemOrArmor(int par1, ItemStack par2ItemStack) {
		super.setCurrentItemOrArmor(par1, par2ItemStack);
		if(!this.worldObj.isRemote && par1 == 0) {
			this.setCombatTask();
		}
	}

	@Override
	public void attackEntityWithRangedAttack(EntityLivingBase e, float f) {
		EntityConjuring b = new EntityConjuring(this.worldObj, this, 10F);
        b.setThrowableHeading(e.posX-this.posX, e.posY-this.posY, e.posZ-this.posZ, 1.6f, 12);
		EnumSounds.playSound(EnumSounds.SPARKLE, worldObj, this);
		this.worldObj.spawnEntityInWorld(b);
	}

	@Override
	public double setAttackDamage(MobStats s) {
		return 0;
	}

	@Override
	public double setMaxHealth(MobStats s) {
		return s.cavurnHealth;
	}

	@Override
	public EnumSounds setLivingSound() {
		return EnumSounds.INSECTO;
	}

	@Override
	public EnumSounds setHurtSound() {
		return EnumSounds.INSECTO_HURT;
	}

	@Override
	public EnumSounds setDeathSound() {
		return EnumSounds.INSECTO_HURT;
	}

	@Override
	public boolean getCanSpawnHere() {
		return this.posY < 40.0D && super.getCanSpawnHere() && 
				this.worldObj.getBlockState(new BlockPos(this.posX, this.posY-1, this.posZ)).getBlock().getMaterial() == Material.rock; 
	}

	@Override
	public Item getItemDropped() {
		return null;
	}
	
	@Override
	protected void dropFewItems(boolean b, int j) {
		if(rand.nextInt(30) == 0) dropItem(EssenceItems.caveCrystal, 1);
		super.dropFewItems(b, j);
		if(rand.nextInt(2) == 0) dropItem(EssenceItems.caveDust, 1);
		super.dropFewItems(b, j);
		if(rand.nextInt(4) == 0) dropItem(EssenceItems.caveDust, 3);
		super.dropFewItems(b, j);
	}
}