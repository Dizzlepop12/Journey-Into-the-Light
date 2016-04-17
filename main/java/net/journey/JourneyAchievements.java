package net.journey;

import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;

public class JourneyAchievements {
	
	public static final AchievementPage ap = new AchievementPage("Journey Achievements");
	public static Achievement achievementGiantMushroom;
	public static Achievement achievementOre;
	public static Achievement achievementGem;
	public static Achievement achievementBoil;
	public static Achievement achievementSapphireSword;
	public static Achievement achievementKillNether;
	public static Achievement achievementEuca;
	public static Achievement achievementDepths;
	public static Achievement achievementCorba;
	public static Achievement achievementTerrania;
	public static Achievement achievementCloudia;
	public static Achievement achievementFl;
	public static Achievement achievementCave;
	
	public static void init() {
		AchievementPage.registerAchievementPage(ap);
		registerAchievements();
	}

	private static void registerAchievements() {
		achievementGiantMushroom = addAchievement("achievement.giantMushroom", "giantMushroom", 0, 0, new ItemStack(JourneyItems.hongoShroom), (Achievement)null);
		achievementOre = addAchievement("achievement.ore", "ore", 2, 0, new ItemStack(JourneyItems.sapphire), achievementGiantMushroom);
		achievementGem = addAchievement("achievement.gem", "gem", -2, 0, new ItemStack(JourneyItems.blueGem), achievementGiantMushroom);
		achievementSapphireSword = addAchievement("achievement.sapphireSword", "sapphireSword", 0, 2, new ItemStack(JourneyItems.sapphireSword), achievementOre);	
		achievementFl = addAchievement("achievement.fl", "fl", 2, -2, new ItemStack(JourneyItems.crystalFlake), achievementOre).setSpecial();
		achievementKillNether = addAchievement("achievement.netherKill", "netherKill", -4, -2, new ItemStack(JourneyItems.blood), achievementFl);
		achievementBoil = addAchievement("achievement.boil", "boil", -4, -4, new ItemStack(JourneyItems.boilingSkull), achievementKillNether).setSpecial();
		achievementEuca = addAchievement("achievement.euca", "euca", -2, -4, new ItemStack(JourneyItems.eucaPortalGem), achievementBoil).setSpecial();
		achievementDepths = addAchievement("achievement.depths", "depths", 0, -4, new ItemStack(JourneyItems.depthsPortalGem), achievementEuca).setSpecial();
		achievementCorba = addAchievement("achievement.corba", "corba", 2, -4, new ItemStack(JourneyItems.corbaPortalGem), achievementDepths).setSpecial();
		achievementTerrania = addAchievement("achievement.terrania", "terrania", 4, -4, new ItemStack(JourneyItems.terraniaPortalGem), achievementCorba).setSpecial();
		achievementCloudia = addAchievement("achievement.cloudia", "cloudia", 6, -4, new ItemStack(JourneyItems.cloudiaPortalGem), achievementTerrania).setSpecial();
		achievementCave = addAchievement("achievement.cave", "cave", 4, 1, new ItemStack(JourneyItems.caveCrystal), achievementGiantMushroom);
	}

	private static Achievement addAchievement(String n, String id, int x, int y, ItemStack icon, Achievement a) {
		Achievement achievement = new Achievement(n, id, x, y, icon, a);
		achievement.registerStat();
		ap.getAchievements().add(achievement);
		return achievement;
	}
}