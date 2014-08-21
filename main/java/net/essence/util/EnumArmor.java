package net.essence.util;

import net.essence.EssenceItems;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.slayer.api.SlayerAPI;

public enum EnumArmor {

    HELLSTONE(SlayerAPI.addArmorMaterial("hellstone", 3000, new int[] {3, 4, 3, 2 }, 10), "hellstone", false, 50, EssenceItems.hellstoneIngot),
    FLAIRIUM(SlayerAPI.addArmorMaterial("flairium", 3000, new int[] {3, 4, 3, 2 }, 10), "flairium", false, 70, EssenceItems.flairiumIngot),
    CELESTIUM(SlayerAPI.addArmorMaterial("celestium", 3000, new int[] {3, 4, 3, 2 }, 10), "celestium", false, 65, EssenceItems.celestiumIngot),
    LUNIUM(SlayerAPI.addArmorMaterial("lunium", 3000, new int[] {3, 4, 3, 2 }, 10), "lunium", false, 40, EssenceItems.luniumIngot),
    SHADIUM(SlayerAPI.addArmorMaterial("shadium", 3000, new int[] {3, 4, 3, 2 }, 10), "shadium", false, 40, EssenceItems.shadiumIngot),
    CONDENCED_DIAMOND(SlayerAPI.addArmorMaterial("condencedDiamond", 3000, new int[] {3, 4, 3, 2 }, 10), "condencedDiamond", false, 60, Blocks.diamond_block);
    
    private ArmorMaterial armorMaterial;
    private String type;
    private boolean undamageable;
    private int damageReduction;
    private Item repairItem;

    private EnumArmor(ArmorMaterial armorMaterial, String type, boolean undamageable, int damageReduction, Item repair) {
        this.armorMaterial = armorMaterial;
        this.type = type;
        this.undamageable = undamageable;
        this.damageReduction = damageReduction;
        this.repairItem = repair;
    }
    
    private EnumArmor(ArmorMaterial armorMaterial, String type, boolean undamageable, int damageReduction, Block repair) {
        this.armorMaterial = armorMaterial;
        this.type = type;
        this.undamageable = undamageable;
        this.damageReduction = damageReduction;
        this.repairItem = SlayerAPI.toItem(repair);
    }

    public Item getRepairItem(){
    	return repairItem;
    }
    
    public ArmorMaterial getArmorMaterial() {
        return armorMaterial;
    }

    public String getType() {
        return type;
    }

    public boolean isUndamageable() {
        return undamageable;
    }

    public int getDamageReduction() {
        return damageReduction;
    }
}