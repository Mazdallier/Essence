package net.essence.client;

import java.util.Random;

import net.essence.util.Helper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerChangedDimensionEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedOutEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerRespawnEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.Phase;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.RenderTickEvent;
import net.slayer.api.SlayerAPI;

import org.lwjgl.opengl.GL11;

public class BarTickHandler {

	private Minecraft mc = Minecraft.getMinecraft();
	private int ticks = 100;

	@SubscribeEvent
	public void onTick(PlayerTickEvent event){
		if(event.phase == Phase.END) tickEnd();
	}

	@SubscribeEvent
	public void onRender(RenderTickEvent event){
		onTickRender();
	}

	private void onTickRender() {
		if(mc.currentScreen == null) {
			if(!mc.thePlayer.capabilities.isCreativeMode) {
				GL11.glPushMatrix();
				GlStateManager.enableBlend();
				GlStateManager.enableAlpha();
				GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
				GuiIngame gig = mc.ingameGUI;
				ScaledResolution scaledresolution = new ScaledResolution(mc, mc.displayWidth, mc.displayHeight);
				this.mc.getTextureManager().bindTexture(new ResourceLocation(SlayerAPI.MOD_ID, "textures/gui/misc.png"));
				//int sw = scaledresolution.getScaledWidth(), sh = scaledresolution.getScaledHeight();
				int y = scaledresolution.getScaledHeight() - 30, x = 10, x1 = 10;
				gig.drawTexturedModalRect(x - 10, y + 10, 0, 177, 117, 19);
				gig.drawTexturedModalRect(x - 10, y - 5, 0, 177, 117, 19);
				y = y - 0;
				gig.drawTexturedModalRect(x - 6, y - 2, 0, 39, 109, 13);
				for(int i = 0; i < (int)EssenceBar.instance.getBarValue(); i++) {
					if(!(i >= 10)) {
						x += 11;
						gig.drawTexturedModalRect(x - 17, y - 2, 0, 0, 10, 13);
					}
				}
				y += 15;
				gig.drawTexturedModalRect(x1 - 6, y - 2, 0, 26, 109, 13);
				for(int i = 0; i < (int)DarkEnergyBar.instance.getBarValue(); i++) {
					x1 += 11;
					gig.drawTexturedModalRect(x1 - 17, y - 2, 0, 13, 10, 13);
				}
				GlStateManager.disableAlpha();
				GlStateManager.disableBlend();
				GL11.glPopMatrix();
			}
		}
	}

	private void tickEnd() {
		ticks--;
		if(ticks <= 0) ticks = 100;
		if(ticks >= 100) {
			DarkEnergyBar.instance.updateAllBars();
			EssenceBar.instance.updateAllBars();
		}
		DarkEnergyBar.instance.mainUpdate();
		EssenceBar.instance.mainUpdate();
	}
}