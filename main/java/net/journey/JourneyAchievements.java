package net.journey;

import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;

public class JourneyAchievements {
	
	public static final AchievementPage ap = new AchievementPage("Journey Achievements");
	public static Achievement achievementOre;
	public static Achievement achievementGem;
	public static Achievement achievementSapphireSword;
	
	public static void init() {
		AchievementPage.registerAchievementPage(ap);
		registerAchievements();
	}

	private static void registerAchievements() {
		achievementOre = addAchievement("achievement.ore", "ore", 0, 0, new ItemStack(JourneyItems.sapphire), (Achievement)null);
		achievementGem = addAchievement("achievement.gem", "gem", -2, 0, new ItemStack(JourneyItems.blueGem), (Achievement)null);
		achievementSapphireSword = addAchievement("achievement.sapphireSword", "sapphireSword", 0, 2, new ItemStack(JourneyItems.sapphireSword), achievementOre);	
	}

	private static Achievement addAchievement(String n, String id, int x, int y, ItemStack icon, Achievement a) {
		Achievement achievement = new Achievement(n, id, x, y, icon, a);
		achievement.registerStat();
		ap.getAchievements().add(achievement);
		return achievement;
	}
}