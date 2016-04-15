package net.journey.entity.mob.nether;

import net.journey.JourneyItems;
import net.journey.entity.MobStats;
import net.journey.enums.EnumSounds;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.slayer.api.entity.EntityModMob;

public class EntityHellCow extends EntityModMob {

	protected int animID = 1;
	protected int animTick = 1;
	
	public EntityHellCow(World par1World) {
		super(par1World);
		addAttackingAI();
		this.isImmuneToFire = true;
		setSize(0.7F, 2.0F);
	}

	@Override
	public double setAttackDamage(MobStats s) {
		return s.baseJourneyDamage;
	}

	@Override
	public double setMaxHealth(MobStats s) {
		return s.baseNetherHealth;
	}

    protected String getLivingSound()
    {
        return "mob.cow.idle";
    }
    
    protected String getHurtSound()
    {
        return "mob.cow.hurt";
    }
    
    protected String getDeathSound()
    {
        return "mob.cow.death";
    }
	
	@Override
	public Item getItemDropped() {
		return JourneyItems.flamingHide;
	}
	
	@Override
	protected void dropFewItems(boolean b, int j) {
		if(rand.nextInt(4) == 0) dropItem(JourneyItems.flamingBeef, 2);
		if(rand.nextInt(2) == 0) dropItem(JourneyItems.flamingBeef, 2);
		if(rand.nextInt(1) == 0) dropItem(JourneyItems.flamingBeef, 1);
		if(rand.nextInt(4) == 0) dropItem(JourneyItems.blood, 1);
		if(rand.nextInt(5) == 0) dropItem(JourneyItems.blood, 2);
		if(rand.nextInt(2) == 0) dropItem(JourneyItems.flamingHide, 2);
		if(rand.nextInt(30) == 0) dropItem(JourneyItems.horn, 1);
		if(rand.nextInt(40) == 0) dropItem(JourneyItems.horn, 2);
		super.dropFewItems(b, j);
	}

	@Override
	public EnumSounds setLivingSound() {
		return EnumSounds.EMPTY;
	}

	@Override
	public EnumSounds setHurtSound() {
		return EnumSounds.EMPTY;
	}

	@Override
	public EnumSounds setDeathSound() {
		return EnumSounds.EMPTY;
	}
}