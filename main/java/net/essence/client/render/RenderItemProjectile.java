package net.essence.client.render;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderItemProjectile extends Render {
	
    private RenderItem item;
    private Item damage;

    public RenderItemProjectile(RenderManager rm, RenderItem par1Item, Item par2) {
    	super(rm);
        this.item = par1Item;
        this.damage = par2;
    }

    @Override
    public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9) {
    	GlStateManager.pushMatrix();
        GlStateManager.translate((float)par2, (float)par4, (float)par6);
        GlStateManager.enableRescaleNormal();
        GlStateManager.scale(0.5F, 0.5F, 0.5F);
        GlStateManager.rotate(-this.renderManager.playerViewY, 0.0F, 1.0F, 0.0F);
        GlStateManager.rotate(this.renderManager.playerViewX, 1.0F, 0.0F, 0.0F);
        this.bindTexture(TextureMap.locationBlocksTexture);
        this.item.renderItemModel(this.getMeta(par1Entity));
        GlStateManager.disableRescaleNormal();
        GlStateManager.popMatrix();
    }
    
    public ItemStack getMeta(Entity p_177082_1_) {
        return new ItemStack(this.damage, 1, 0);
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity par1Entity) {
        return TextureMap.locationBlocksTexture;
    }
}