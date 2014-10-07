package net.essence;

import net.essence.*;
import net.essence.items.*;
import net.essence.items.ItemEgg;
import net.essence.util.*;
import net.minecraft.item.*;
import net.minecraft.potion.Potion;
import net.slayer.api.*;
import net.slayer.api.item.*;

public class EssenceItems {

	public static int HEAD = 0, BODY = 1, LEGS = 2, BOOTS = 3;
	
	public static final Item hellstoneIngot = new ItemMod("hellstoneIngot");
	public static final Item shadiumIngot = new ItemMod("shadiumIngot");
	public static final Item celestiumIngot = new ItemMod("celestiumIngot");
	public static final Item luniumIngot = new ItemMod("luniumIngot");
	public static final Item flairiumIngot = new ItemMod("flairiumIngot");
	public static final Item ash = new ItemMod("ash");
	public static final Item sapphire = new ItemMod("sapphire");
	public static final Item hellstoneClump = new ItemMod("hellstoneClump");
	public static final Item shadiumClump = new ItemMod("shadiumClump");
	public static final Item luniumClump = new ItemMod("luniumClump");
	public static final Item spawnerClump = new ItemMod("spawnerClump");
	public static final Item spawnerBar = new ItemMod("spawnerBar");
	
	public static final Item flameCoin = new ItemFlameCoin("flameCoin");
	public static final Item essenceDetractor = new ItemAttractor("essenceDetractor", false, true, 100);
	public static final Item chaosCannon = new ItemChaosCannon("chaosCannon");

	public static final Item hellstoneMultiTool = new ItemMultiTool("hellstoneMultiTool", EssenceToolMaterial.HELLSTONE_MULTI_TOOL);
	public static final Item shadiumMultiTool = new ItemMultiTool("shadiumMultiTool", EssenceToolMaterial.SHADIUM_MULTI_TOOL);
	public static final Item celestiumMultiTool = new ItemMultiTool("celestiumMultiTool", EssenceToolMaterial.CELESTIUM_MULTI_TOOL);
	public static final Item luniumMultiTool = new ItemMultiTool("luniumMultiTool", EssenceToolMaterial.LUNIUM_MULTI_TOOL);
	public static final Item flairiumMultiTool = new ItemMultiTool("flairiumMultiTool", EssenceToolMaterial.FLAIRIUM_MULTI_TOOL);
	public static final Item sapphireMultiTool = new ItemMultiTool("sapphireMultiTool", EssenceToolMaterial.SAPPHIRE_MULTI_TOOL);

	public static final Item hellstonePickaxe = new ItemModPickaxe("hellstonePickaxe", EssenceToolMaterial.HELLSTONE_PICKAXE);
	public static final Item shadiumPickaxe = new ItemModPickaxe("shadiumPickaxe", EssenceToolMaterial.SHADIUM_PICKAXE);
	public static final Item celestiumPickaxe = new ItemModPickaxe("celestiumPickaxe", EssenceToolMaterial.CELESTIUM_PICKAXE);
	public static final Item luniumPickaxe = new ItemModPickaxe("luniumPickaxe", EssenceToolMaterial.LUNIUM_PICKAXE);
	public static final Item flairiumPickaxe = new ItemModPickaxe("flairiumPickaxe", EssenceToolMaterial.FLAIRIUM_PICKAXE);
	public static final Item sapphirePickaxe = new ItemModPickaxe("sapphirePickaxe", EssenceToolMaterial.SAPPHIRE_PICKAXE);

	public static final Item hellstoneShovel = new ItemModShovel("hellstoneShovel", EssenceToolMaterial.HELLSTONE_SHOVEL);
	public static final Item shadiumShovel = new ItemModShovel("shadiumShovel", EssenceToolMaterial.SHADIUM_SHOVEL);
	public static final Item celestiumShovel = new ItemModShovel("celestiumShovel", EssenceToolMaterial.CELESTIUM_SHOVEL);
	public static final Item luniumShovel = new ItemModShovel("luniumShovel", EssenceToolMaterial.LUNIUM_SHOVEL);
	public static final Item flairiumShovel = new ItemModShovel("flairiumShovel", EssenceToolMaterial.FLAIRIUM_SHOVEL);
	public static final Item sapphireShovel = new ItemModShovel("sapphireShovel", EssenceToolMaterial.SAPPHIRE_SHOVEL);

	public static final Item hellstoneAxe = new ItemModAxe("hellstoneAxe", EssenceToolMaterial.HELLSTONE_AXE);
	public static final Item shadiumAxe = new ItemModAxe("shadiumAxe", EssenceToolMaterial.SHADIUM_AXE);
	public static final Item celestiumAxe = new ItemModAxe("celestiumAxe", EssenceToolMaterial.CELESTIUM_AXE);
	public static final Item luniumAxe = new ItemModAxe("luniumAxe", EssenceToolMaterial.LUNIUM_AXE);
	public static final Item flairiumAxe = new ItemModAxe("flairiumAxe", EssenceToolMaterial.FLAIRIUM_AXE);
	public static final Item sapphireAxe = new ItemModAxe("sapphireAxe", EssenceToolMaterial.SAPPHIRE_AXE);

	public static final Item hellstoneHoe = new ItemModHoe("hellstoneHoe", EssenceToolMaterial.HELLSTONE_HOE);
	public static final Item shadiumHoe = new ItemModHoe("shadiumHoe", EssenceToolMaterial.SHADIUM_HOE);
	public static final Item celestiumHoe = new ItemModHoe("celestiumHoe", EssenceToolMaterial.CELESTIUM_HOE);
	public static final Item luniumHoe = new ItemModHoe("luniumHoe", EssenceToolMaterial.LUNIUM_HOE);
	public static final Item flairiumHoe = new ItemModHoe("flairiumHoe", EssenceToolMaterial.FLAIRIUM_HOE);
	public static final Item sapphireHoe = new ItemModHoe("sapphireHoe", EssenceToolMaterial.SAPPHIRE_HOE);

	public static final Item hellstoneSword = new ItemFireSword("hellstoneSword", EssenceToolMaterial.HELLSTONE_SWORD);
	public static final Item shadiumSword = new ItemFreezeSword("shadiumSword", EssenceToolMaterial.SHADIUM_SWORD);
	public static final Item celestiumSword = new ItemModSword("celestiumSword", EssenceToolMaterial.CELESTIUM_SWORD);
	public static final Item luniumSword = new ItemModSword("luniumSword", EssenceToolMaterial.LUNIUM_SWORD);
	public static final Item flairiumSword = new ItemFireSword("flairiumSword", EssenceToolMaterial.FLAIRIUM_SWORD);
	public static final Item sapphireSword = new ItemFireSword("sapphireSword", EssenceToolMaterial.SAPPHIRE_SWORD);
	public static final Item poisonSword = new ItemPoisionSword("poisonSword", EssenceToolMaterial.POISON_SWORD);
	public static final Item cloudSlicer = new ItemModSword("cloudSlicer", EssenceToolMaterial.CLOUD_SLICER);
	public static final Item dragonsTooth = new ItemModSword("dragonsTooth", EssenceToolMaterial.DRAGONS_TOOTH);
	public static final Item netherBeastSword = new ItemModSword("netherBeastSword", EssenceToolMaterial.NETHER_BEAST_SWORD);
	public static final Item witheringBeastSword = new ItemWitherSword("witheringBeastSword", EssenceToolMaterial.WITHERING_BEAST_SWORD);
	public static final Item calciaSword = new ItemModSword("calciaSword", EssenceToolMaterial.CALCIA_SWORD);
	public static final Item championsSword = new ItemModSword("championsSword", EssenceToolMaterial.CHAMPIONS_SWORD);
	public static final Item theWraith = new ItemModSword("theWraith", EssenceToolMaterial.THE_WRAITH);
	
	public static final Item eucaPortalGem = new ItemMod("eucaPortalGem");
	public static final Item depthsPortalGem = new ItemMod("depthsPortalGem");
	
	public static final Item calciaOrb = new ItemNetherBossSpawner("calciaOrb");
	public static final Item netherBeastOrb = new ItemNetherBossSpawner("netherBeastOrb");
	public static final Item witheringBeastOrb = new ItemNetherBossSpawner("witheringBeastOrb");
	
	public static final Item weakDarkEnergyPotion = new ItemEssencePotion("weakDarkEnergyPotion", false, false);
	public static final Item strongDarkEnergyPotion = new ItemEssencePotion("strongDarkEnergyPotion", true, false);
	public static final Item weakEssencePotion = new ItemEssencePotion("weakEssencePotion", false, true);
	public static final Item strongEssencePotion = new ItemEssencePotion("strongEssencePotion", true, true);
	
	public static final Item hellstoneHelmet = new ItemModArmor(EnumArmor.HELLSTONE, HEAD);
	public static final Item hellstoneChest = new ItemModArmor(EnumArmor.HELLSTONE, BODY);
	public static final Item hellstoneLegs = new ItemModArmor(EnumArmor.HELLSTONE, LEGS);
	public static final Item hellstoneBoots = new ItemModArmor(EnumArmor.HELLSTONE, BOOTS);

	public static final Item flairiumHelmet = new ItemModArmor(EnumArmor.FLAIRIUM, HEAD);
	public static final Item flairiumChest = new ItemModArmor(EnumArmor.FLAIRIUM, BODY);
	public static final Item flairiumLegs = new ItemModArmor(EnumArmor.FLAIRIUM, LEGS);
	public static final Item flairiumBoots = new ItemModArmor(EnumArmor.FLAIRIUM, BOOTS);
	
	public static final Item celestiumHelmet = new ItemModArmor(EnumArmor.CELESTIUM, HEAD);
	public static final Item celestiumChest = new ItemModArmor(EnumArmor.CELESTIUM, BODY);
	public static final Item celestiumLegs = new ItemModArmor(EnumArmor.CELESTIUM, LEGS);
	public static final Item celestiumBoots = new ItemModArmor(EnumArmor.CELESTIUM, BOOTS);
	
	public static final Item luniumHelmet = new ItemModArmor(EnumArmor.LUNIUM, HEAD);
	public static final Item luniumChest = new ItemModArmor(EnumArmor.LUNIUM, BODY);
	public static final Item luniumLegs = new ItemModArmor(EnumArmor.LUNIUM, LEGS);
	public static final Item luniumBoots = new ItemModArmor(EnumArmor.LUNIUM, BOOTS);
	
	public static final Item shadiumHelmet = new ItemModArmor(EnumArmor.SHADIUM, HEAD);
	public static final Item shadiumChest = new ItemModArmor(EnumArmor.SHADIUM, BODY);
	public static final Item shadiumLegs = new ItemModArmor(EnumArmor.SHADIUM, LEGS);
	public static final Item shadiumBoots = new ItemModArmor(EnumArmor.SHADIUM, BOOTS);

	public static final Item condencedDiamondHelmet = new ItemModArmor(EnumArmor.CONDENCED_DIAMOND, HEAD);
	public static final Item condencedDiamondChest = new ItemModArmor(EnumArmor.CONDENCED_DIAMOND, BODY);
	public static final Item condencedDiamondLegs = new ItemModArmor(EnumArmor.CONDENCED_DIAMOND, LEGS);
	public static final Item condencedDiamondBoots = new ItemModArmor(EnumArmor.CONDENCED_DIAMOND, BOOTS);
	
	public static final Item sapphireHelmet = new ItemModArmor(EnumArmor.SAPPHIRE, HEAD);
	public static final Item sapphireChest = new ItemModArmor(EnumArmor.SAPPHIRE, BODY);
	public static final Item sapphireLegs = new ItemModArmor(EnumArmor.SAPPHIRE, LEGS);
	public static final Item sapphireBoots = new ItemModArmor(EnumArmor.SAPPHIRE, BOOTS);
	
	public static final Item backBiter = new ItemBattleAxe("backBiter", EssenceToolMaterial.BACK_BITER);
	public static final Item dawnBreaker = new ItemBattleAxe("dawnBreaker", EssenceToolMaterial.DAWN_BREAKER);
	public static final Item tempestBattleaxe = new ItemBattleAxe("tempestBattleaxe", EssenceToolMaterial.TEMPEST_BATTLEAXE);

	public static final Item staffOfHellstone = new ItemStaff("staffOfHellstone", 25, 1000, 10, false, false);
	public static final Item doomsBringer = new ItemStaff("doomsBringer", 25, 1000, 10, false, false);
	public static final Item conjuringStaff = new ItemStaff("conjuringStaff", 25, 1000, 10, true, false);
	public static final Item staffOfEnlightment = new ItemStaff("staffOfEnlightment", 25, 1000, 10, true, false);
	public static final Item staffOfGreenpace = new ItemStaff("staffOfGreenpace", 25, 1000, 10, true, false);
	public static final Item wizardsStar = new ItemStaff("wizardsStar", 25, 1000, 10, true, false);
	public static final Item teleportationStaff = new ItemTeleport("teleportationStaff", 20);
		
	/*public static final Item blueEgg = new ItemMod("blueEgg", EssenceTabs.misc);
	public static final Item redEgg = new ItemMod("redEgg", EssenceTabs.misc);
	public static final Item greenEgg = new ItemMod("greenEgg", EssenceTabs.misc);
	public static final Item orangeEgg = new ItemMod("orangeEgg", EssenceTabs.misc);
	public static final Item purpleEgg = new ItemMod("purpleEgg", EssenceTabs.misc);
	public static final Item yellowEgg = new ItemMod("yellowEgg", EssenceTabs.misc);
	public static final Item pinkEgg = new ItemMod("pinkEgg", EssenceTabs.misc);
	public static final Item cyanEgg = new ItemMod("cyanEgg", EssenceTabs.misc);
	
	public static final Item incubatedBlueEgg = new ItemEgg("incubatedBlueEgg");
	public static final Item incubatedRedEgg = new ItemEgg("incubatedRedEgg");
	public static final Item incubatedGreenEgg = new ItemEgg("incubatedGreenEgg");
	public static final Item incubatedOrangeEgg = new ItemEgg("incubatedOrangeEgg");
	public static final Item incubatedPurpleEgg = new ItemEgg("incubatedPurpleEgg");
	public static final Item incubatedYellowEgg = new ItemEgg("incubatedYellowEgg");
	public static final Item incubatedPinkEgg = new ItemEgg("incubatedPinkEgg");
	public static final Item incubatedCyanEgg = new ItemEgg("incubatedCyanEgg");*/
	
	public static final Item goldenSteak = new ItemGoldenFood("normalGoldenSteak", "goldenSteak", "Golden Steak", 4, 1.2F, false, false).setPotionEffect(Potion.regeneration.id, 5, 1, 1.0F).setAlwaysEdible();
	public static final Item goldenSteakOP = new ItemGoldenFood("OPGoldenSteak", "goldenSteak", "Golden Steak", 4, 1.2F, false, true).setPotionEffect(Potion.regeneration.id, 5, 1, 1.0F).setAlwaysEdible();
	
	public static final Item goldenPotato = new ItemGoldenFood("normalGoldenPotato", "goldenPotato", "Golden Potato", 4, 1.2F, false, false).setPotionEffect(Potion.regeneration.id, 5, 1, 1.0F).setAlwaysEdible();
	public static final Item goldenPotatoOP = new ItemGoldenFood("OPGoldenPotato", "goldenPotato", "Golden Potato", 4, 1.2F, false, true).setPotionEffect(Potion.regeneration.id, 5, 1, 1.0F).setAlwaysEdible();
	
	public static final Item goldenPork = new ItemGoldenFood("normalGoldenPork", "goldenPorkchop", "Golden Porkchop", 4, 1.2F, false, false).setPotionEffect(Potion.regeneration.id, 5, 1, 1.0F).setAlwaysEdible();
	public static final Item goldenPorkOP = new ItemGoldenFood("OPGoldenPork", "goldenPorkchop", "Golden Porkchop", 4, 1.2F, false, true).setPotionEffect(Potion.regeneration.id, 5, 1, 1.0F).setAlwaysEdible();	

	public static final ItemModDoor hotDoorItem = new ItemModDoor(EssenceBlocks.hotDoor, "hotDoor");
}