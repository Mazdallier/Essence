package net.essence.blocks.tileentity.container;

import java.util.List;
import java.util.Random;

import net.essence.EssenceBlocks;
import net.minecraft.enchantment.EnchantmentData;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotCrafting;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ContainerEnrichedTable extends Container {

	public InventoryCrafting craftMatrix = new InventoryCrafting(this, 2, 2);
	public InventoryCrafting bigCraftMatrix = new InventoryCrafting(this, 3, 3);
	public IInventory craftResult = new InventoryCraftResult();
	public BlockPos pos;
	
	public IInventory tableInventory = new InventoryBasic("Enriched Table", true, 1) {
		public int getInventoryStackLimit() {
			return 1;
		}

		public void markDirty() {
			super.markDirty();
			ContainerEnrichedTable.this.onCraftMatrixChanged(this);
		}
	};

	private World worldPointer;
	private EntityPlayer thePlayer;
	private int posX;
	private int posY;
	private int posZ;
	private Random rand = new Random();
	public long nameSeed;
	public int[] enchantLevels = new int[3];

	public ContainerEnrichedTable(InventoryPlayer par1InventoryPlayer, World par2World, BlockPos pos, final EntityPlayer player) {
		thePlayer = player;
		this.pos = pos;
		this.worldPointer = par2World;
		this.posX = pos.getX();
		this.posY = pos.getY();
		this.posZ = pos.getZ();
		this.addSlotToContainer(new SlotCrafting(player, this.craftMatrix, this.craftResult, 0, 170, 142));
		this.addSlotToContainer(new Slot(this.tableInventory, 0, -19, 46) {
			@Override
			public boolean isItemValid(ItemStack par1ItemStack) {
				return true;
			}
		});
		int l;

		for (l = 0; l < 3; ++l) {
			for (int i1 = 0; i1 < 9; ++i1) {
				this.addSlotToContainer(new Slot(par1InventoryPlayer, i1 + l * 9 + 9, 8 + i1 * 18 - 28, 84 + l * 18));
			}
		}

		for (l = 0; l < 9; ++l) {
			this.addSlotToContainer(new Slot(par1InventoryPlayer, l, 8 + l * 18 - 28, 142));
		}
		
        for(int i = 0; i < 2; ++i) {
            for(int j = 0; j < 2; ++j) {
                this.addSlotToContainer(new Slot(this.craftMatrix, j + i * 2, 88 + j * 18 + 73, 26 + i * 18 + 58));
            }
        }
        
        /*for(int i = 0; i < 3; ++i) {
            for(int j = 0; j < 3; ++j) {
                this.addSlotToContainer(new Slot(this.bigCraftMatrix, j + i * 2, 88 + j * 18 + 64, 26 + i * 18 + 159));
            }
        }*/
        
        for(int i = 0; i < 4; ++i) {
            final int k = i;
            this.addSlotToContainer(new Slot(par1InventoryPlayer, par1InventoryPlayer.getSizeInventory() - 1 - i, 137, 8 + i * 18) {
                
            	@Override
                public int getSlotStackLimit() {
                    return 1;
                }

                @Override
                public boolean isItemValid(ItemStack p_75214_1_) {
                    if (p_75214_1_ == null) return false;
                    return p_75214_1_.getItem().isValidArmor(p_75214_1_, k, player);
                }
                
                @Override
                @SideOnly(Side.CLIENT)
                public String getSlotTexture() {
                	return ItemArmor.EMPTY_SLOT_NAMES[k];
                }
            });
        }
	}

	@Override
	public void addCraftingToCrafters(ICrafting par1ICrafting) {
		super.addCraftingToCrafters(par1ICrafting);
		par1ICrafting.sendProgressBarUpdate(this, 0, this.enchantLevels[0]);
		par1ICrafting.sendProgressBarUpdate(this, 1, this.enchantLevels[1]);
		par1ICrafting.sendProgressBarUpdate(this, 2, this.enchantLevels[2]);
	}

	@Override
	public void detectAndSendChanges() {
		super.detectAndSendChanges();
		for(int i = 0; i < this.crafters.size(); ++i) {
			ICrafting icrafting = (ICrafting)this.crafters.get(i);
			icrafting.sendProgressBarUpdate(this, 0, this.enchantLevels[0]);
			icrafting.sendProgressBarUpdate(this, 1, this.enchantLevels[1]);
			icrafting.sendProgressBarUpdate(this, 2, this.enchantLevels[2]);
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void updateProgressBar(int par1, int par2) {
		if(par1 >= 0 && par1 <= 2) {
			this.enchantLevels[par1] = par2;
		} else {
			super.updateProgressBar(par1, par2);
		}
	}

	@Override
	public void onCraftMatrixChanged(IInventory par1IInventory) {
		if (par1IInventory == this.tableInventory) {
			ItemStack itemstack = par1IInventory.getStackInSlot(0);
			int i;

			if (itemstack != null && itemstack.isItemEnchantable()) {
				this.nameSeed = this.rand.nextLong();

				if (!this.worldPointer.isRemote) {
					i = 0;
					int j;
					float power = 0;

					for (j = -1; j <= 1; ++j) {
						for (int k = -1; k <= 1; ++k) {
							if ((j != 0 || k != 0)) {
								power += 2;

								if (k != 0 && j != 0) {
                                    power += net.minecraftforge.common.ForgeHooks.getEnchantPower(worldPointer, pos.add(k * 2, 0, j));
                                    power += net.minecraftforge.common.ForgeHooks.getEnchantPower(worldPointer, pos.add(k * 2, 1, j));
                                    power += net.minecraftforge.common.ForgeHooks.getEnchantPower(worldPointer, pos.add(k, 0, j * 2));
                                    power += net.minecraftforge.common.ForgeHooks.getEnchantPower(worldPointer, pos.add(k, 1, j * 2));
								}
							}
						}
					}

					for (j = 0; j < 3; ++j) {
						this.enchantLevels[j] = EnchantmentHelper.calcItemStackEnchantability(this.rand, j, (int)power, itemstack);
					}

					this.detectAndSendChanges();
				}
			} else {
				for (i = 0; i < 3; ++i) {
					this.enchantLevels[i] = 0;
				}
			}
		}
		this.craftResult.setInventorySlotContents(0, CraftingManager.getInstance().findMatchingRecipe(this.craftMatrix, this.worldPointer));
	}

	@Override
	public boolean enchantItem(EntityPlayer par1EntityPlayer, int par2) {
		ItemStack itemstack = this.tableInventory.getStackInSlot(0);

		if (this.enchantLevels[par2] > 0 && itemstack != null && (par1EntityPlayer.experienceLevel >= this.enchantLevels[par2] || par1EntityPlayer.capabilities.isCreativeMode)) {
			if (!this.worldPointer.isRemote) {
				List list = EnchantmentHelper.buildEnchantmentList(this.rand, itemstack, this.enchantLevels[par2]);
				boolean flag = itemstack.getItem() == Items.book;

				if (list != null) {
					par1EntityPlayer.addExperienceLevel(-this.enchantLevels[par2]);

					if (flag) {
						itemstack.setItem(Items.enchanted_book);
					}

					int j = flag && list.size() > 1 ? this.rand.nextInt(list.size()) : -1;

					for (int k = 0; k < list.size(); ++k){ 
						EnchantmentData enchantmentdata = (EnchantmentData)list.get(k);
						if (!flag || k != j) {
							if (flag) {
								Items.enchanted_book.addEnchantment(itemstack, enchantmentdata);
							} else {
								itemstack.addEnchantment(enchantmentdata.enchantmentobj, enchantmentdata.enchantmentLevel);
							}
						}
					}
					this.onCraftMatrixChanged(this.tableInventory);
				}
			}
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void onContainerClosed(EntityPlayer par1EntityPlayer) {
		super.onContainerClosed(par1EntityPlayer);

		if (!this.worldPointer.isRemote) {
			ItemStack itemstack = this.tableInventory.getStackInSlotOnClosing(0);
			
			for (int i = 0; i < 4; ++i){
				ItemStack stack = this.craftMatrix.getStackInSlotOnClosing(i);
				if(stack != null)
					par1EntityPlayer.dropPlayerItemWithRandomChoice(stack, false);
			}
			if(itemstack != null) {
				par1EntityPlayer.dropPlayerItemWithRandomChoice(itemstack, false);
				
			}
		}
	}

	@Override
	public boolean canInteractWith(EntityPlayer par1EntityPlayer) {
		//return this.worldPointer.getBlockState(pos) != EssenceBlocks.enrichedEnchantmentTable ? false : par1EntityPlayer.getDistanceSq((double)this.posX + 0.5D, (double)this.posY + 0.5D, (double)this.posZ + 0.5D) <= 64.0D;
		return false;
	}
 
	@Override
	public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2) {
		ItemStack itemstack = null;
        Slot slot = (Slot)this.inventorySlots.get(par2);

        if (slot != null && slot.getHasStack()) {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (par2 == 0) {
                if (!this.mergeItemStack(itemstack1, 10, 46, true)) {
                    return null;
                }

                slot.onSlotChange(itemstack1, itemstack);
            }
            else if (par2 >= 10 && par2 < 37) {
                if (!this.mergeItemStack(itemstack1, 37, 46, false)) {
                    return null;
                }
            }
            else if (par2 >= 37 && par2 < 46) {
                if (!this.mergeItemStack(itemstack1, 10, 37, false)) {
                    return null;
                }
            }
            else if (!this.mergeItemStack(itemstack1, 10, 46, false)) {
                return null;
            }

            if (itemstack1.stackSize == 0) {
                slot.putStack((ItemStack)null);
            } else {
                slot.onSlotChanged();
            }

            if (itemstack1.stackSize == itemstack.stackSize) {
                return null;
            }

            slot.onPickupFromSlot(par1EntityPlayer, itemstack1);
        }
		
		return itemstack;
	}
}