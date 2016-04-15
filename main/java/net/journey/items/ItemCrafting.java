package net.journey.items;

import java.util.List;

import net.journey.JourneyBlocks;
import net.journey.JourneyItems;
import net.journey.JourneyTabs;
import net.journey.blocks.machines.BlockStoneCraftingTable;
import net.journey.blocks.tileentity.container.ContainerJourneyCrafting;
import net.journey.client.server.DarkEnergyBar;
import net.journey.enums.EnumSounds;
import net.journey.items.container.ContainerJourneyItemCrafting;
import net.journey.util.LangRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.IChatComponent;
import net.minecraft.world.IInteractionObject;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.slayer.api.SlayerAPI;

public class ItemCrafting extends Item {

	protected int healAmount = 0;

	public ItemCrafting(String name, String finalName){
		this(name, finalName, JourneyTabs.items);
	}

	public ItemCrafting(String name, String finalName, CreativeTabs tab){
		LangRegistry.addItem(name, finalName);
		setUnlocalizedName(name);
		setCreativeTab(tab);
		JourneyItems.itemNames.add(name);
		GameRegistry.registerItem(this, name);
	}

	public ItemCrafting setHealAmount(int healAmount){
		this.healAmount = healAmount;
		return this;
	}

	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		EnumSounds.playSound(EnumSounds.CHEST_OPEN_0, world, player);
        if (world.isRemote)
        {
            player.displayGui(new ItemCrafting.InterfaceCrafting(world, null));
        }
		return stack;
	}
	
	 public static class InterfaceCrafting implements IInteractionObject
     {
         private final World world;
         private final BlockPos position;

         public InterfaceCrafting(World w, BlockPos p)
         {
             this.world = w;
             this.position = p;
         }

         public String getName()
         {
             return null;
         }

         public boolean hasCustomName()
         {
             return false;
         }

         public IChatComponent getDisplayName()
         {
             return new ChatComponentTranslation(JourneyItems.pocketCrafting.getUnlocalizedName() + ".name", new Object[0]);
         }

         public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn)
         {
             return new ContainerJourneyItemCrafting(playerInventory, this.world, this.position);
         }

         public String getGuiID()
         {
             return "minecraft:crafting_table";
         }
     }

	public void spawnEntityIntoWorld(World w, EntityPlayer p, Entity entity, boolean magic, String sound, boolean damage, ItemStack item, int dam) {
		if(!w.isRemote){
			if(magic) w.spawnEntityInWorld(entity);
		}
		if(magic) {
			EnumSounds.playSound(sound, w, p);
			if(damage) item.damageItem(dam, p);
		}
	}

	public void spawnEntityIntoWorld(World w, EntityPlayer p, Entity entity, String sound, boolean damage, ItemStack item, int dam) {
		if(!w.isRemote){
			w.spawnEntityInWorld(entity);
			EnumSounds.playSound(sound, w, p);
			if(damage) item.damageItem(dam, p);
		}
	}

	public void spawnEntityIntoWorld(World w, EntityPlayer p, Entity entity, boolean magic, String sound) {
		spawnEntityIntoWorld(w, p, entity, magic, sound, false, new ItemStack(Items.apple), 0);
	}

	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List list){ }

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
		addInformation(par1ItemStack, par2EntityPlayer, par3List);
	}
}