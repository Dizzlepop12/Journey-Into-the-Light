package net.journey.event;

import net.journey.JourneyItems;
import net.journey.JITL;
import net.journey.util.Config;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerChangedDimensionEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.slayer.api.SlayerAPI;

public class PlayerEvent {

	@SubscribeEvent
	public void onBlockHarvested(HarvestDropsEvent event) {
		EntityPlayer p = event.harvester;
		boolean isWorking = false;
		if(hasItemEnchantment(JITL.hotTouch, p)) isWorking = true;
		if(isWorking){
			if(event.harvester != null && event.harvester instanceof EntityPlayer && event.harvester.getHeldItem() != null) {
				if(!event.isSilkTouching){
					ItemStack stack = FurnaceRecipes.instance().getSmeltingResult(new ItemStack(event.state.getBlock()));
					if(stack != null && event.state.getBlock() != Blocks.redstone_ore && event.state.getBlock() != Blocks.lapis_ore && event.state.getBlock() != Blocks.lapis_ore) {
						event.drops.clear();
						event.drops.add(stack.copy());
					}
				}
			}
		}
		if(event.harvester != null && event.harvester instanceof EntityPlayer && event.harvester.getHeldItem() != null && event.harvester.getHeldItem().getItem() == JourneyItems.multiToolOfEternalSmelting) {
			if(!event.isSilkTouching){
				ItemStack stack = FurnaceRecipes.instance().getSmeltingResult(new ItemStack(event.state.getBlock()));
				if(stack != null && event.state.getBlock() != Blocks.redstone_ore && event.state.getBlock() != Blocks.lapis_ore && event.state.getBlock() != Blocks.lapis_ore) {
					event.drops.clear();
					event.drops.add(stack.copy());
				}
			}
		}
	}

	@SubscribeEvent
	public void onTick(TickEvent.PlayerTickEvent event) {
		EntityPlayer player = event.player;
		int i = MathHelper.floor_double(player.posX);
		int j = MathHelper.floor_double(player.posY);
		int k = MathHelper.floor_double(player.posZ);
		Material m = event.player.worldObj.getBlockState(new BlockPos(i, j, k)).getBlock().getMaterial();
		boolean mat = (m == Material.water);
		boolean isWorking = false;
		if(hasArmorEnchantment(JITL.waterWalk, player)) isWorking = true;
		if(isWorking) {
			if(mat && player.motionY < 0.0D) {
				if(player.worldObj.getBlockState(new BlockPos(i, j - 1, k)).getBlock().getMaterial() == Material.water || player.worldObj.getBlockState(new BlockPos(i, j, k)).getBlock().getMaterial() == Material.water) player.motionY = 0.0D;
				if(!Minecraft.getMinecraft().gameSettings.keyBindJump.isKeyDown()) player.motionY = 0.0D; 
				else if(Minecraft.getMinecraft().gameSettings.keyBindJump.isKeyDown()) player.motionY = 0.5D;
			}
		}
	}

	public static int getItemEnchantment(Enchantment en, EntityLivingBase e) {
		if(en != null && e != null) return EnchantmentHelper.getEnchantmentLevel(en.effectId, e.getHeldItem());
		else return 0;
	}

	public static boolean hasItemEnchantment(Enchantment en, EntityLivingBase e) {
		return getItemEnchantment(en, e) > 0;
	}

	public static int getArmorEnchantment(Enchantment en, EntityLivingBase e) {
		if(en != null && e != null) return EnchantmentHelper.getMaxEnchantmentLevel(en.effectId, e.getInventory());
		else return 0;
	}

	public static boolean hasArmorEnchantment(Enchantment en, EntityLivingBase e) {
		return getArmorEnchantment(en, e) > 0;
	}
}