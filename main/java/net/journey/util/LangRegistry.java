package net.journey.util;

import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import net.journey.items.ItemModArmor;

public class LangRegistry {

	public static LangRegistry instance = new LangRegistry();

	public String location = "C:/Users/Camden/Desktop/JourneyWorkspace/src/Essence/main/resources/assets/essence/lang/";
	//"C:/Users/Camden/Desktop/Essence Modding/src/Essence/main/resources/assets/essence/lang"
	private BufferedWriter writer;
	public static ArrayList<String> blockUnloc = new ArrayList<String>(), blockFinal = new ArrayList<String>(), itemUnloc = new ArrayList<String>(), itemFinal = new ArrayList<String>()
			, fileText = new ArrayList<String>();
	public static String[] brickNames = {"Black", "Blue", "Brown", "Cyan", "Gray", "Lime", "Magenta", "Orange", "Pink", "Purple", "Red", "White", "Yellow"};
	public static String[] brickTextures = {"black", "blue", "brown", "cyan", "gray", "lime", "magenta", "orange", "pink", "purple", "red", "white", "yellow"};

	public static ArrayList<String> mobUnloc = new ArrayList<String>(), mobFinal = new ArrayList<String>(), armourUnloc = new ArrayList<String>(), armorType = new ArrayList<String>(), armorPiece = new ArrayList<String>();

	public LangRegistry() {
		File en_US = new File(location + "en_US.lang");
		try {
			en_US.mkdirs();
			if(en_US.exists()) en_US.delete();
			en_US.createNewFile();
			writer = new BufferedWriter(new FileWriter(en_US));
			//Desktop.getDesktop().open(new File(location));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void misc() {
		writeToFile("itemGroup.journey.blocks=Journey into the Light: Blocks");
		writeToFile("itemGroup.journey.decoration=Journey into the Light: Decoration Blocks");
		writeToFile("itemGroup.journey.items=Journey into the Light: Items");
		writeToFile("itemGroup.journey.tools=Journey into the Light: Tools");
		writeToFile("itemGroup.journey.swords=Journey into the Light: Swords");
		writeToFile("itemGroup.journey.battleaxes=Journey into the Light: Battleaxes");
		writeToFile("itemGroup.journey.bows=Journey into the Light: Bows");
		writeToFile("itemGroup.journey.piercers=Journey into the Light: Piercers");
		writeToFile("itemGroup.journey.staves=Journey into the Light: Staves and Wands");
		writeToFile("itemGroup.journey.util=Journey into the Light: Utilities");
		writeToFile("itemGroup.journey.misc=Journey into the Light: Miscellaneous");
		writeToFile("itemGroup.journey.armor=Journey into the Light: Armor");
		writeToFile("itemGroup.journey.spawners=Journey into the Light: Spawners");
		writeToFile("itemGroup.journey.crops=Journey into the Light: Crops");
		writeToFile("itemGroup.journey.machineBlocks=Journey into the Light: Machine Blocks");
		writeToFile("itemGroup.journey.portalBlocks=Journey into the Light: Portal Blocks");
		writeToFile("itemGroup.journey.hammers=Journey into the Light: Hammers");
		writeToFile("achievement.sapphireSword=Time for an Upgrade");
		writeToFile("achievement.sapphireSword.desc=Craft a Sapphire Sword");
		writeToFile("achievement.ore=Unfamiliar Substance");
		writeToFile("achievement.ore.desc=Obtain Sapphire");
		writeToFile("achievement.gem=Dungeon Looter");
		writeToFile("achievement.gem.desc=Obtain a dungeon gemstone");
		writeToFile("item.record.underwaterWorld.desc=Chris Geddes - Underwater World");
		writeToFile("item.record.blueWater.desc=Chris Geddes - Blue Water");
		writeToFile("item.record.raceStar.desc=Chris Geddes - Race Star");
		writeToFile("item.record.compBegins.desc=Chris Geddes - Comp Begins");
		writeToFile("item.record.deepBlue.desc=Chris Geddes - Deep Blue");
		writeToFile("item.record.raceShore.desc=Chris Geddes - Race Shore");
		writeToFile("enchantment.Hot Touch=Hot Touch");
		writeToFile("enchantment.Water Walker=Water Walker");
		writeToFile("essence.knowledgeTable=Knowledge Table");
		writeToFile("essence.summoningTable=Summoning Table");
		writeToFile("essence.efficiency=Efficiency");
		writeToFile("essence.usesRemaining=Uses Remaining");
		writeToFile("essence.infinite=Infinite");
		writeToFile("essence.uses=Uses");
		writeToFile("essence.essence=Essence");
		writeToFile("essence.dark=Dark Energy");
		writeToFile("essence.rangedDamage=Ranged Damage");
		writeToFile("essence.unbreakable=Unbreakable");
		writeToFile("essence.hit=On hit");
		writeToFile("essence.wither=Withers foe for");
		writeToFile("essence.seconds=seconds");
		writeToFile("essence.bossSpawn=Spawns boss");
		writeToFile("essence.petSpawn=Spawns pet");
		writeToFile("essence.time=Time: ");
		writeToFile("mage.deals=I have some great deals!");
		writeToFile("mage.valuables=I've got some nice valuables!");
		writeToFile("mage.greetings=Greetings, weary traveller!");
		writeToFile("smith.deals=I have some great deals!");
		writeToFile("smith.valuables=I've got some nice valuables!");
		writeToFile("smith.greetings=Greetings, weary traveller!");
		writeToFile("elf.welcome=Welcome welcome!");
		writeToFile("elf.hello=Hello!");
		writeToFile("elf.good=Good to see you!");
		for(int j = 0; j < 13; j++) writeToFile("tile." + brickTextures[j] + "ColouredBricks.name=" + brickNames[j] + " Coloured Brick");
		for(int j = 0; j < 13; j++) writeToFile("tile." + brickTextures[j] + "MiniColouredBricks.name=" + brickNames[j] + " Coloured Mini Brick");
	}

	public void register() {
		block();
		item();
		mob();
		armour();
		misc();
		closeFile();
	}

	public static void addBlock(String unloc, String finalName) {
		blockUnloc.add(unloc);
		blockFinal.add(finalName);
	}

	public static void addItem(String unloc, String finalName) {
		itemUnloc.add(unloc);
		itemFinal.add(finalName);
	}

	public static void addMob(String unloc, String finalName) {
		mobUnloc.add("essence." + unloc);
		mobFinal.add(finalName);
	}

	public static void addArmour(ItemModArmor a, EnumArmor ar, int t) {
		armourUnloc.add(a.getUnlocalizedName());
		int HEAD = 0, BODY = 1, LEGS = 2, BOOTS = 3;
		armorType.add(ar.getFinalName());
		String part = t == HEAD ? "Helmet" : t == BODY ? "Chestplate" : t == LEGS ? "Leggings" : t == BOOTS ? "Boots" : "UNKNOWN";
		armorPiece.add(part);
	}

	public void block() {
		for(int i = 0; i < blockUnloc.size(); i++)
			writeToFile("tile." + blockUnloc.get(i) + ".name=" + blockFinal.get(i));
	}

	public void mob() {
		for(int i = 0; i < mobUnloc.size(); i++)
			writeToFile("entity." + mobUnloc.get(i) + ".name=" + mobFinal.get(i));
	}

	public void item() {
		for(int i = 0; i < itemUnloc.size(); i++)
			writeToFile("item." + itemUnloc.get(i) + ".name=" + itemFinal.get(i));
	}
	
	public void armour() {
		for(int i = 0; i < armourUnloc.size(); i++)
			writeToFile(armourUnloc.get(i) + ".name=" + armorType.get(i) + " " + armorPiece.get(i));
	}

	private void writeToFile(String s) {
		try {
			instance.writer.write(s + "\n");
		} catch (IOException e) {
			e.printStackTrace(); 
		}
	}

	private void closeFile() {
		try {
			instance.writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}