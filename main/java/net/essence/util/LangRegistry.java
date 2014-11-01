package net.essence.util;

import java.util.ArrayList;

import net.essence.EssenceTabs;
import net.essence.blocks.BlockColouredBricks;
import net.essence.blocks.BlockMiniColouredBricks;
import net.minecraft.block.Block;
import net.minecraft.item.Item;

public class LangRegistry extends RegistryFile {

    private static ArrayList<Block> blocks = new ArrayList<Block>();
    private static ArrayList<Item> items = new ArrayList<Item>();
    private static ArrayList<EssenceTabs> tabs = new ArrayList<EssenceTabs>();
    private static ArrayList<String> mobs = new ArrayList<String>();
    private final static String FILE_NAME = "/en_US.lang";
    private final static String[] PATHS = new String[] {"./Essence/resources/assets/eotg/lang", "./resources/assets/eotg/lang", "./main/resources/assets/eotg/lang", "./src/main/resources/assets/eotg/lang"};

    private static final RegistryFile instance = new LangRegistry();
    
    public LangRegistry() {
        super(FILE_NAME, PATHS);
    }

    public static void registerNames(){
        instance.addNames();
        instance.closeFile();
    }

	public static void addMisc() {
		instance.addToFile("itemGroup.essence.blocks=Essence Of The Gods: Blocks");
		instance.addToFile("itemGroup.essence.items=Essence Of The Gods: Items");
		instance.addToFile("itemGroup.essence.weapons=Essence Of The Gods: Weapons");
		instance.addToFile("itemGroup.essence.ranged=Essence Of The Gods: Ranged");
		instance.addToFile("itemGroup.essence.tools=Essence Of The Gods: Tools");
		instance.addToFile("itemGroup.essence.util=Essence Of The Gods: Utilities");
		instance.addToFile("itemGroup.essence.misc=Essence Of The Gods: Misc.");
		instance.addToFile("itemGroup.essence.armor=Essence Of The Gods: Armor");
		instance.addToFile("itemGroup.essence.decoration=Essence Of The Gods: Decoration");
		for(int j = 0; j < 13; j++) instance.addToFile("tile." + BlockColouredBricks.textures[j] + "ColouredBricks.name=" + BlockColouredBricks.names[j] + " Coloured Brick");
		for(int j = 0; j < 13; j++) instance.addToFile("tile." + BlockMiniColouredBricks.textures[j] + "MiniColouredBricks.name=" + BlockMiniColouredBricks.names[j] + " Coloured Mini Brick");
		instance.addToFile("tile.glowshroom_top.name=Glowshroom");
		instance.addToFile("tile.glowshroom_bottom.name=Glowshroom");
	}
	
	public static void addOPFood(String name, String actual) {
		instance.addToFile("item." + name + ".name=" + actual);
	}
	
	public static void addEnchantment(String name){
		instance.addToFile("enchantment." + name + "=" + name);
	}

	public static void addMob(String name) {
		mobs.add(name);
	}
    
    public static void addBlock(Block block) {
        blocks.add(block);
    }

    public static void addItem(Item item) {
        items.add(item);
    }

    @Override
    public void addNames() {
        for(Block block : blocks)
            localizeName("tile", block.getUnlocalizedName());
        for(Item item : items)
            localizeName("item", item.getUnlocalizedName());
        addMobNames();
        addMisc();
    }
    
    public static void addMobNames(){
    	for(int i = 0; i < mobs.size(); i++){
    		String mob = mobs.get(i);
    		instance.addToFile("entity." + mob + ".name=" + mob);
    	}
    }
}