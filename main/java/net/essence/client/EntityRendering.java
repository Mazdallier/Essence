package net.essence.client;

import net.essence.EssenceBlocks;
import net.essence.EssenceItems;
import net.essence.blocks.tileentity.TileEntityCorbaPortal;
import net.essence.blocks.tileentity.TileEntityEssenceSign;
import net.essence.blocks.tileentity.TileEntityGrindstone;
import net.essence.blocks.tileentity.TileEntityKnowledgeTable;
import net.essence.blocks.tileentity.TileEntityStatue;
import net.essence.blocks.tileentity.TileEntitySummoningTable;
import net.essence.client.render.RenderBoss;
import net.essence.client.render.RenderItemProjectile;
import net.essence.client.render.RenderModArrow;
import net.essence.client.render.RenderModMob;
import net.essence.client.render.RenderProjectile;
import net.essence.client.render.RenderSizeable;
import net.essence.client.render.RenderStaffProjectile;
import net.essence.client.render.block.CorbaPortalRenderer;
import net.essence.client.render.block.EssenceSignRenderer;
import net.essence.client.render.block.GrindstoneRenderer;
import net.essence.client.render.block.KnowledgeTableRenderer;
import net.essence.client.render.block.ModeledBlockInventoryRenderer;
import net.essence.client.render.block.SummoningTableRenderer;
import net.essence.client.render.mob.RenderBoomBoom;
import net.essence.client.render.mob.RenderCalcia;
import net.essence.client.render.mob.RenderDragonEgg;
import net.essence.client.render.mob.RenderEucaFighter;
import net.essence.client.render.mob.RenderEucaHopper;
import net.essence.client.render.mob.RenderEudor;
import net.essence.client.render.mob.RenderFish;
import net.essence.client.render.mob.RenderFourfa;
import net.essence.client.render.mob.RenderInsecto;
import net.essence.client.render.mob.RenderMage;
import net.essence.client.render.mob.RenderModBiped;
import net.essence.client.render.mob.RenderPsyollom;
import net.essence.client.render.mob.RenderReaper;
import net.essence.client.render.mob.RenderShatterer;
import net.essence.client.render.mob.RenderSpyclops;
import net.essence.client.render.model.mob.boil.ModelBlazier;
import net.essence.client.render.model.mob.boil.ModelBoilTrader;
import net.essence.client.render.model.mob.boil.ModelEscapedConvict;
import net.essence.client.render.model.mob.boil.ModelMagmaGiant;
import net.essence.client.render.model.mob.boss.ModelBeastOfTheNether;
import net.essence.client.render.model.mob.boss.ModelClacia;
import net.essence.client.render.model.mob.boss.ModelEudor;
import net.essence.client.render.model.mob.boss.ModelSentryKing;
import net.essence.client.render.model.mob.boss.ModelThunderbird;
import net.essence.client.render.model.mob.boss.ModelWitheringBeast;
import net.essence.client.render.model.mob.cloudia.ModelCloudGhost;
import net.essence.client.render.model.mob.corba.ModelLeafBlower;
import net.essence.client.render.model.mob.corba.ModelOverseer;
import net.essence.client.render.model.mob.corba.ModelOverseerElder;
import net.essence.client.render.model.mob.corba.ModelTordo;
import net.essence.client.render.model.mob.corba.ModelTreeGolem;
import net.essence.client.render.model.mob.corba.ModelWoodCreature;
import net.essence.client.render.model.mob.depths.ModelDarknessCrawler;
import net.essence.client.render.model.mob.depths.ModelDepthsBeast;
import net.essence.client.render.model.mob.depths.ModelDepthsHunter;
import net.essence.client.render.model.mob.depths.ModelRoc;
import net.essence.client.render.model.mob.depths.ModelSpikedBeast;
import net.essence.client.render.model.mob.depths.ModelStaringGuardian;
import net.essence.client.render.model.mob.euca.ModelAlloyMender;
import net.essence.client.render.model.mob.euca.ModelDynaster;
import net.essence.client.render.model.mob.euca.ModelEucaCharger;
import net.essence.client.render.model.mob.euca.ModelEucaFighter;
import net.essence.client.render.model.mob.euca.ModelEucaHopper;
import net.essence.client.render.model.mob.euca.ModelGolder;
import net.essence.client.render.model.mob.euca.ModelInsecto;
import net.essence.client.render.model.mob.euca.ModelPsyollom;
import net.essence.client.render.model.mob.frozen.ModelFrozenMerchant;
import net.essence.client.render.model.mob.frozen.ModelFrozenTroll;
import net.essence.client.render.model.mob.frozen.ModelPermafraust;
import net.essence.client.render.model.mob.frozen.ModelShiveringBushwalker;
import net.essence.client.render.model.mob.overworld.ModelBigHongo;
import net.essence.client.render.model.mob.overworld.ModelBoomBoom;
import net.essence.client.render.model.mob.overworld.ModelBunny;
import net.essence.client.render.model.mob.overworld.ModelDragonEgg;
import net.essence.client.render.model.mob.overworld.ModelFish;
import net.essence.client.render.model.mob.overworld.ModelMage;
import net.essence.client.render.model.mob.overworld.ModelMageTransparent;
import net.essence.client.render.model.mob.overworld.ModelMediumHongo;
import net.essence.client.render.model.mob.overworld.ModelReaper;
import net.essence.client.render.model.mob.overworld.ModelRobot;
import net.essence.client.render.model.mob.overworld.ModelSandCrawler;
import net.essence.client.render.model.mob.overworld.ModelSmallHongo;
import net.essence.client.render.model.mob.overworld.ModelSpyclops;
import net.essence.client.render.model.mob.overworld.ModelTurtle;
import net.essence.client.render.model.statue.StatueRenderer;
import net.essence.entity.EntityDragonEgg;
import net.essence.entity.MobStats;
import net.essence.entity.mob.boiling.EntityAshHoarder;
import net.essence.entity.mob.boiling.EntityBurningLight;
import net.essence.entity.mob.boiling.EntityBurntAsh;
import net.essence.entity.mob.boiling.EntityBurntMiner;
import net.essence.entity.mob.boiling.EntityCrisp;
import net.essence.entity.mob.boiling.EntityExposedFlame;
import net.essence.entity.mob.boiling.EntityMagmaBlaze;
import net.essence.entity.mob.boiling.EntityMagmaGiant;
import net.essence.entity.mob.boiling.npc.EntityBoilTrader;
import net.essence.entity.mob.boiling.npc.EntityEscapedConvict;
import net.essence.entity.mob.boss.EntityBlazier;
import net.essence.entity.mob.boss.EntityCalcia;
import net.essence.entity.mob.boss.EntityEudor;
import net.essence.entity.mob.boss.EntityFourfa;
import net.essence.entity.mob.boss.EntityNetherBeast;
import net.essence.entity.mob.boss.EntitySentryKing;
import net.essence.entity.mob.boss.EntitySoulWatcher;
import net.essence.entity.mob.boss.EntityTempleGuardian;
import net.essence.entity.mob.boss.EntityThunderbird;
import net.essence.entity.mob.boss.EntityWitheringBeast;
import net.essence.entity.mob.cloudia.EntityCloudGhost;
import net.essence.entity.mob.corba.EntityLeafBlower;
import net.essence.entity.mob.corba.EntityOverseer;
import net.essence.entity.mob.corba.EntityOverseerElder;
import net.essence.entity.mob.corba.EntitySurfaceSeer;
import net.essence.entity.mob.corba.EntityTreeGolem;
import net.essence.entity.mob.corba.EntityWoodCreature;
import net.essence.entity.mob.corba.npc.EntityRedTordo;
import net.essence.entity.mob.corba.npc.EntityTordo;
import net.essence.entity.mob.depths.EntityDarknessCrawler;
import net.essence.entity.mob.depths.EntityDepthsBeast;
import net.essence.entity.mob.depths.EntityDepthsHunter;
import net.essence.entity.mob.depths.EntityRoc;
import net.essence.entity.mob.depths.EntitySpikedBeast;
import net.essence.entity.mob.depths.npc.EntityStaringGuardian;
import net.essence.entity.mob.euca.EntityDynaster;
import net.essence.entity.mob.euca.EntityEucaCharger;
import net.essence.entity.mob.euca.EntityEucaFighter;
import net.essence.entity.mob.euca.EntityEucaHopper;
import net.essence.entity.mob.euca.EntityGolder;
import net.essence.entity.mob.euca.EntityInsecto;
import net.essence.entity.mob.euca.EntityPsyollom;
import net.essence.entity.mob.euca.npc.EntityAlloyMender;
import net.essence.entity.mob.frozen.EntityFrozenTroll;
import net.essence.entity.mob.frozen.EntityPermafraust;
import net.essence.entity.mob.frozen.EntityShatterer;
import net.essence.entity.mob.frozen.EntityShiveringBushwalker;
import net.essence.entity.mob.frozen.npc.EntityFrozenMerchant;
import net.essence.entity.mob.overworld.EntityBigHongo;
import net.essence.entity.mob.overworld.EntityBoom;
import net.essence.entity.mob.overworld.EntityBunny;
import net.essence.entity.mob.overworld.EntityFireMage;
import net.essence.entity.mob.overworld.EntityFish;
import net.essence.entity.mob.overworld.EntityIceMage;
import net.essence.entity.mob.overworld.EntityMediumHongo;
import net.essence.entity.mob.overworld.EntityReaper;
import net.essence.entity.mob.overworld.EntityRobot;
import net.essence.entity.mob.overworld.EntitySandCrawler;
import net.essence.entity.mob.overworld.EntitySmallHongo;
import net.essence.entity.mob.overworld.EntitySpyclops;
import net.essence.entity.mob.overworld.EntityTurtle;
import net.essence.entity.mob.overworld.npc.EntityBlacksmith;
import net.essence.entity.mob.overworld.npc.EntityMage;
import net.essence.entity.mob.overworld.npc.water_tribe.EntityWaterTribeFisherman;
import net.essence.entity.projectile.EntityBasicProjectile;
import net.essence.entity.projectile.EntityBoilingPiercer;
import net.essence.entity.projectile.EntityBouncingProjectile;
import net.essence.entity.projectile.EntityConjuring;
import net.essence.entity.projectile.EntityCorbaPiercer;
import net.essence.entity.projectile.EntityDarknessArrow;
import net.essence.entity.projectile.EntityDepthsPiercer;
import net.essence.entity.projectile.EntityDoomsBringer;
import net.essence.entity.projectile.EntityEnlightenment;
import net.essence.entity.projectile.EntityEucaPiercer;
import net.essence.entity.projectile.EntityFireBall;
import net.essence.entity.projectile.EntityFlameArrow;
import net.essence.entity.projectile.EntityForestPlasma;
import net.essence.entity.projectile.EntityFrostbittenPiercer;
import net.essence.entity.projectile.EntityFrostyPiercer;
import net.essence.entity.projectile.EntityFrozenArrow;
import net.essence.entity.projectile.EntityFrozenPiercer;
import net.essence.entity.projectile.EntityGreenpace;
import net.essence.entity.projectile.EntityIceBall;
import net.essence.entity.projectile.EntityLightningBall;
import net.essence.entity.projectile.EntityMagmaFireball;
import net.essence.entity.projectile.EntityNetherPlasma;
import net.essence.entity.projectile.EntityNethicPiercer;
import net.essence.entity.projectile.EntityOceanPlasma;
import net.essence.entity.projectile.EntityPoisonArrow;
import net.essence.entity.projectile.EntityRockProjectile;
import net.essence.entity.projectile.EntityTempleBall;
import net.essence.entity.projectile.EntityWizardsStar;
import net.essence.util.Textures;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelBlaze;
import net.minecraft.client.renderer.tileentity.TileEntityItemStackRenderer;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class EntityRendering {

	private static Textures tex;
	private static MobStats stat;

	public static void init() {
		RenderingRegistry.registerEntityRenderingHandler(EntityBasicProjectile.class, new RenderStaffProjectile(tex.basic, 1.0F, 0.2F, 0.2F));
		RenderingRegistry.registerEntityRenderingHandler(EntityDoomsBringer.class, new RenderStaffProjectile(tex.basic, 1.2F, 0.2F, 0.2F));
		RenderingRegistry.registerEntityRenderingHandler(EntityConjuring.class, new RenderStaffProjectile(tex.basic, 0.1F, 1.0F, 0.7F));
		RenderingRegistry.registerEntityRenderingHandler(EntityEnlightenment.class, new RenderStaffProjectile(tex.basic, 0.7F, 0.0F, 0.7F));
		RenderingRegistry.registerEntityRenderingHandler(EntityGreenpace.class, new RenderStaffProjectile(tex.basic, 0.6F, 1.0F, 0.0F));
		RenderingRegistry.registerEntityRenderingHandler(EntityWizardsStar.class, new RenderStaffProjectile(tex.basic, 1.0F, 1.0F, 0.2F));
		RenderingRegistry.registerEntityRenderingHandler(EntityBouncingProjectile.class, new RenderProjectile(tex.bouncingProjectile));
		RenderingRegistry.registerEntityRenderingHandler(EntityMagmaFireball.class, new RenderProjectile(tex.magmaBall));
		RenderingRegistry.registerEntityRenderingHandler(EntityFlameArrow.class, new RenderModArrow());
		RenderingRegistry.registerEntityRenderingHandler(EntityPoisonArrow.class, new RenderModArrow());
		RenderingRegistry.registerEntityRenderingHandler(EntityDarknessArrow.class, new RenderModArrow());
		RenderingRegistry.registerEntityRenderingHandler(EntityFrozenArrow.class, new RenderModArrow());
		RenderingRegistry.registerEntityRenderingHandler(EntityFireBall.class, new RenderStaffProjectile(tex.empty, 1F, 1F, 1F));
		RenderingRegistry.registerEntityRenderingHandler(EntityIceBall.class, new RenderStaffProjectile(tex.empty, 1F, 1F, 1F));
		RenderingRegistry.registerEntityRenderingHandler(EntityTempleBall.class, new RenderStaffProjectile(tex.templeBall, 0F, 0F, 0F));
		RenderingRegistry.registerEntityRenderingHandler(EntityLightningBall.class, new RenderStaffProjectile(tex.empty, 1F, 1F, 1F));
		RenderingRegistry.registerEntityRenderingHandler(EntityRockProjectile.class, new RenderProjectile(tex.rockChunk));
		RenderingRegistry.registerEntityRenderingHandler(EntityNetherPlasma.class, new RenderProjectile(tex.plasma));
		RenderingRegistry.registerEntityRenderingHandler(EntityOceanPlasma.class, new RenderProjectile(tex.plasma));
		RenderingRegistry.registerEntityRenderingHandler(EntityForestPlasma.class, new RenderProjectile(tex.plasma));
		RenderingRegistry.registerEntityRenderingHandler(EntityBoilingPiercer.class, new RenderItemProjectile(EssenceItems.boilingPiercer));
		RenderingRegistry.registerEntityRenderingHandler(EntityNethicPiercer.class, new RenderItemProjectile(EssenceItems.nethicPiercer));
		RenderingRegistry.registerEntityRenderingHandler(EntityFrozenPiercer.class, new RenderItemProjectile(EssenceItems.frozenPiercer));
		RenderingRegistry.registerEntityRenderingHandler(EntityEucaPiercer.class, new RenderItemProjectile(EssenceItems.eucaPiercer));
		RenderingRegistry.registerEntityRenderingHandler(EntityDepthsPiercer.class, new RenderItemProjectile(EssenceItems.depthsPiercer));
		RenderingRegistry.registerEntityRenderingHandler(EntityCorbaPiercer.class, new RenderItemProjectile(EssenceItems.corbaPiercer));
		RenderingRegistry.registerEntityRenderingHandler(EntityFrostbittenPiercer.class, new RenderItemProjectile(EssenceItems.frostbittenPiercer));
		RenderingRegistry.registerEntityRenderingHandler(EntityFrostyPiercer.class, new RenderItemProjectile(EssenceItems.frostyPiercer));

		RenderingRegistry.registerEntityRenderingHandler(EntityRobot.class, new RenderModMob(new ModelRobot(), tex.robot));
		RenderingRegistry.registerEntityRenderingHandler(EntitySpikedBeast.class, new RenderModMob(new ModelSpikedBeast(), tex.spikedBeast));
		RenderingRegistry.registerEntityRenderingHandler(EntitySpyclops.class, new RenderSpyclops(new ModelSpyclops()));
		RenderingRegistry.registerEntityRenderingHandler(EntityMagmaGiant.class, new RenderModMob(new ModelMagmaGiant(), tex.magmaGiant));
		RenderingRegistry.registerEntityRenderingHandler(EntityInsecto.class, new RenderInsecto(new ModelInsecto()));
		RenderingRegistry.registerEntityRenderingHandler(EntityPsyollom.class, new RenderPsyollom(new ModelPsyollom()));
		RenderingRegistry.registerEntityRenderingHandler(EntityDepthsBeast.class, new RenderSizeable(new ModelDepthsBeast(), 0.8F, 1.5F, tex.depthsBeast));
		RenderingRegistry.registerEntityRenderingHandler(EntityDarknessCrawler.class, new RenderModMob(new ModelDarknessCrawler(), tex.darknessCrawler));
		RenderingRegistry.registerEntityRenderingHandler(EntityBoom.class, new RenderBoomBoom(new ModelBoomBoom(), tex.boom));
		RenderingRegistry.registerEntityRenderingHandler(EntityBigHongo.class, new RenderModMob(new ModelBigHongo(), tex.bigHongo));
		RenderingRegistry.registerEntityRenderingHandler(EntityMediumHongo.class, new RenderModMob(new ModelMediumHongo(), tex.mediumHongo));
		RenderingRegistry.registerEntityRenderingHandler(EntitySmallHongo.class, new RenderModMob(new ModelSmallHongo(), tex.smallHongo));
		RenderingRegistry.registerEntityRenderingHandler(EntityEucaFighter.class, new RenderEucaFighter(new ModelEucaFighter()));
		RenderingRegistry.registerEntityRenderingHandler(EntityMagmaBlaze.class, new RenderModMob(new ModelBlaze(), tex.magmaBlaze));
		RenderingRegistry.registerEntityRenderingHandler(EntityCrisp.class, new RenderModMob(new ModelDarknessCrawler(), tex.crisp));
		RenderingRegistry.registerEntityRenderingHandler(EntityBurntMiner.class, new RenderModBiped(new ModelBiped(), tex.burntMiner));
		RenderingRegistry.registerEntityRenderingHandler(EntityExposedFlame.class, new RenderModBiped(new ModelBiped(), tex.exposedFlame));
		RenderingRegistry.registerEntityRenderingHandler(EntityBurningLight.class, new RenderModBiped(new ModelBiped(), tex.burningLight));
		RenderingRegistry.registerEntityRenderingHandler(EntityEucaHopper.class, new RenderEucaHopper(new ModelEucaHopper(), tex.eucaHopper));
		RenderingRegistry.registerEntityRenderingHandler(EntityAshHoarder.class, new RenderSizeable(new ModelDepthsBeast(), 0.8F, 1.5F, tex.ashHoarder));
		RenderingRegistry.registerEntityRenderingHandler(EntityBurntAsh.class, new RenderSizeable(new ModelPsyollom(), 0.5F, 1.5F, tex.burntAsh));
		RenderingRegistry.registerEntityRenderingHandler(EntityReaper.class, new RenderReaper(new ModelReaper(), tex.reaper));
		RenderingRegistry.registerEntityRenderingHandler(EntityDepthsHunter.class, new RenderSizeable(new ModelDepthsHunter(), 0.5F, 1.5F, tex.depthsHunter));
		RenderingRegistry.registerEntityRenderingHandler(EntityEucaCharger.class, new RenderSizeable(new ModelEucaCharger(), 0.5F, 1.5F, tex.eucaCharger));
		RenderingRegistry.registerEntityRenderingHandler(EntityBunny.class, new RenderModMob(new ModelBunny(), 0.3F, tex.bunny));
		RenderingRegistry.registerEntityRenderingHandler(EntitySandCrawler.class, new RenderModMob(new ModelSandCrawler(), 0.5F, tex.sandCrawler));
		RenderingRegistry.registerEntityRenderingHandler(EntityTurtle.class, new RenderModMob(new ModelTurtle(), 0.5F, tex.turtle));
		RenderingRegistry.registerEntityRenderingHandler(EntityFish.class, new RenderFish(new ModelFish()));
		RenderingRegistry.registerEntityRenderingHandler(EntityWaterTribeFisherman.class, new RenderModBiped(new ModelBiped(), tex.waterFisherman));
		RenderingRegistry.registerEntityRenderingHandler(EntityFireMage.class, new RenderMage(new ModelMage(), tex.fireMage));
		RenderingRegistry.registerEntityRenderingHandler(EntityIceMage.class, new RenderMage(new ModelMageTransparent(), tex.iceMage));
		RenderingRegistry.registerEntityRenderingHandler(EntityMage.class, new RenderMage(new ModelMage(), tex.mage));
		RenderingRegistry.registerEntityRenderingHandler(EntityBlacksmith.class, new RenderModBiped(new ModelBiped(), tex.blacksmith));
		RenderingRegistry.registerEntityRenderingHandler(EntityFrozenMerchant.class, new RenderModMob(new ModelFrozenMerchant(), tex.frozenMerchant));
		RenderingRegistry.registerEntityRenderingHandler(EntityEscapedConvict.class, new RenderModMob(new ModelEscapedConvict(), tex.escapedConvict));
		RenderingRegistry.registerEntityRenderingHandler(EntityBoilTrader.class, new RenderModMob(new ModelBoilTrader(), tex.boilTrader));
		RenderingRegistry.registerEntityRenderingHandler(EntityAlloyMender.class, new RenderModMob(new ModelAlloyMender(), tex.alloyMender));
		//RenderingRegistry.registerEntityRenderingHandler(EntityDragon.class, new RenderDragon());
		RenderingRegistry.registerEntityRenderingHandler(EntityOverseer.class, new RenderModMob(new ModelOverseer(), tex.overseer));
		RenderingRegistry.registerEntityRenderingHandler(EntitySurfaceSeer.class, new RenderModMob(new ModelOverseer(), tex.surfaceSeer));
		RenderingRegistry.registerEntityRenderingHandler(EntityOverseerElder.class, new RenderModMob(new ModelOverseerElder(), tex.overseerElder));
		RenderingRegistry.registerEntityRenderingHandler(EntityTordo.class, new RenderModMob(new ModelTordo(), tex.blueTordo));
		RenderingRegistry.registerEntityRenderingHandler(EntityRedTordo.class, new RenderModMob(new ModelTordo(), tex.redTordo));
		RenderingRegistry.registerEntityRenderingHandler(EntityCloudGhost.class, new RenderModMob(new ModelCloudGhost(), tex.cloudGhost));
		RenderingRegistry.registerEntityRenderingHandler(EntityStaringGuardian.class, new RenderModMob(new ModelStaringGuardian(), tex.staringGuardian));
		RenderingRegistry.registerEntityRenderingHandler(EntityTreeGolem.class, new RenderModMob(new ModelTreeGolem(), tex.treeGolem));
		RenderingRegistry.registerEntityRenderingHandler(EntityWoodCreature.class, new RenderModMob(new ModelWoodCreature(), tex.woodCreature));
		RenderingRegistry.registerEntityRenderingHandler(EntityRoc.class, new RenderModMob(new ModelRoc(), tex.roc));
		RenderingRegistry.registerEntityRenderingHandler(EntityDynaster.class, new RenderModMob(new ModelDynaster(), tex.dynaster));
		RenderingRegistry.registerEntityRenderingHandler(EntityGolder.class, new RenderModMob(new ModelGolder(), tex.golder));
		
		RenderingRegistry.registerEntityRenderingHandler(EntityDragonEgg.class, new RenderDragonEgg(new ModelDragonEgg()));
		
		RenderingRegistry.registerEntityRenderingHandler(EntityShatterer.class, new RenderShatterer());
		RenderingRegistry.registerEntityRenderingHandler(EntityFrozenTroll.class, new RenderModMob(new ModelFrozenTroll(), tex.frozenTroll));
		RenderingRegistry.registerEntityRenderingHandler(EntityPermafraust.class, new RenderModMob(new ModelPermafraust(), tex.permafraust));
		RenderingRegistry.registerEntityRenderingHandler(EntityShiveringBushwalker.class, new RenderModMob(new ModelShiveringBushwalker(), tex.shiveringBushwalker));
		RenderingRegistry.registerEntityRenderingHandler(EntityLeafBlower.class, new RenderModMob(new ModelLeafBlower(), tex.leafBlower));
		
		
		RenderingRegistry.registerEntityRenderingHandler(EntityNetherBeast.class, new RenderBoss(new ModelBeastOfTheNether(), 0.5F, 2.0F, tex.netherBeast, stat.netherBeastBossID));
		RenderingRegistry.registerEntityRenderingHandler(EntityWitheringBeast.class, new RenderBoss(new ModelWitheringBeast(), 0.5F, 2.0F, tex.witheringBeast, stat.witheringBeastBossID));
		RenderingRegistry.registerEntityRenderingHandler(EntityCalcia.class, new RenderCalcia(new ModelClacia(), 0.5F, 2.0F, tex.calcia, stat.calciaBossID));
		RenderingRegistry.registerEntityRenderingHandler(EntityEudor.class, new RenderEudor(new ModelEudor(), 0.5F, 2.0F, tex.eudor, stat.eudorBossID));
		RenderingRegistry.registerEntityRenderingHandler(EntityTempleGuardian.class, new RenderModBiped(new ModelBiped(), 1.5F, tex.templeGuardian));
		RenderingRegistry.registerEntityRenderingHandler(EntityFourfa.class, new RenderFourfa());
		RenderingRegistry.registerEntityRenderingHandler(EntityBlazier.class, new RenderBoss(new ModelBlazier(), 0.5F, 2.0F, tex.blazier, stat.blazierBossID));
		RenderingRegistry.registerEntityRenderingHandler(EntitySoulWatcher.class, new RenderBoss(new ModelBeastOfTheNether(), 0.5F, 2.0F, tex.netherBeast, stat.soulWatcherBossID));
		RenderingRegistry.registerEntityRenderingHandler(EntitySentryKing.class, new RenderBoss(new ModelSentryKing(), 0.5F, 2.0F, tex.sentryKing, stat.sentryKingBossID));
		RenderingRegistry.registerEntityRenderingHandler(EntityThunderbird.class, new RenderBoss(new ModelThunderbird(), 0.5F, 2.0F, tex.thunderbird, stat.thunderbirdBossID));

		//RenderingRegistry.registerEntityRenderingHandler(EntityWraith.class, new RenderBoss(new ModelWraith(), 0.5F, 1.0F, tex.wraith, stat.wraithBossID));
		
		//SlayerAPI.registerItemRenderer(EssenceBlocks.netherBeastStatue, new ItemRendererStatue("netherBeastStatue"));
		//SlayerAPI.registerItemRenderer(EssenceBlocks.witheringBeastStatue, new ItemRendererStatue("witheringBeastStatue"));
		//SlayerAPI.registerItemRenderer(EssenceBlocks.enderChampionStatue, new ItemRendererStatue("enderChampionStatue"));
		//SlayerAPI.registerItemRenderer(EssenceBlocks.wraithStatue, new ItemRendererStatue("wraithStatue"));
		//SlayerAPI.registerItemRenderer(EssenceBlocks.calciaStatue, new ItemRendererStatue("calciaStatue"));
		//SlayerAPI.registerItemRenderer(EssenceBlocks.eudorStatue, new ItemRendererStatue("eudorStatue"));
		
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().getModelManager().getBlockModelShapes().registerBuiltInBlocks(EssenceBlocks.calciaStatue);
		TileEntityItemStackRenderer.instance = new ModeledBlockInventoryRenderer(TileEntityItemStackRenderer.instance);
		
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityStatue.class, new StatueRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityGrindstone.class, new GrindstoneRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCorbaPortal.class, new CorbaPortalRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityEssenceSign.class, new EssenceSignRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityKnowledgeTable.class, new KnowledgeTableRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySummoningTable.class, new SummoningTableRenderer());

		//RenderingRegistry.registerBlockHandler(EssenceBlocks.celestiumOre.getRenderType(), new OreRenderer());
		//RenderingRegistry.registerBlockHandler(EssenceBlocks.mossyEssenceStone.getRenderType(), new OtherBlockRenderer());
	}
}