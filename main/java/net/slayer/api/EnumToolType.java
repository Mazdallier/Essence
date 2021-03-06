package net.slayer.api;

import net.essence.util.EssenceToolMaterial;
import net.minecraft.item.Item;

public enum EnumToolType {
    
    WOOD_PICK("pickaxe", Item.ToolMaterial.WOOD.getHarvestLevel()),
    GOLD_PICK("pickaxe", Item.ToolMaterial.GOLD.getHarvestLevel()),
    STONE_PICK("pickaxe", Item.ToolMaterial.STONE.getHarvestLevel()),
    IRON_PICK("pickaxe", Item.ToolMaterial.IRON.getHarvestLevel()),
    DIAMOND_PICK("pickaxe", Item.ToolMaterial.EMERALD.getHarvestLevel());
   /* HELLSTONE("pickaxe", EssenceToolMaterial.HELLSTONE_PICKAXE.getHarvestLevel()),
    CELESTIUM("pickaxe", EssenceToolMaterial.CELESTIUM_PICKAXE.getHarvestLevel()),
    LUNIUM("pickaxe", EssenceToolMaterial.LUNIUM_PICKAXE.getHarvestLevel()),
    FLAIRIUM("pickaxe", EssenceToolMaterial.FLAIRIUM_PICKAXE.getHarvestLevel()),
    SHADIUM("pickaxe", EssenceToolMaterial.SHADIUM_PICKAXE.getHarvestLevel());*/
    
    private String toolType;
    private int harvestLevel;
    
    private EnumToolType(String toolType, int harvestLevel){
        this.toolType = toolType;
        this.harvestLevel = harvestLevel;
    }
    
    public String getType(){
        return toolType;
    }
    
    public int getLevel(){
        return harvestLevel;
    }
}
