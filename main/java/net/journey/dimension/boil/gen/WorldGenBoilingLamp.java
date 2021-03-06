package net.journey.dimension.boil.gen;

import java.util.Random;

import net.journey.JourneyBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.slayer.api.worldgen.WorldGenAPI;

public class WorldGenBoilingLamp extends WorldGenerator {
	@Override
	public boolean generate(World world, Random rand, BlockPos pos) {
		int i = pos.getX(), j = pos.getY(), k = pos.getZ();
		IBlockState leaves = WorldGenAPI.getCorbaLeaves().getDefaultState(), log = WorldGenAPI.getCorbaLog().getDefaultState();
		i-=5;
		k-=5;
			world.setBlockState(new BlockPos(i + 0, j + 0, k + 1), JourneyBlocks.sizzlingPost.getDefaultState());
			world.setBlockState(new BlockPos(i + 1, j + 0, k + 0), JourneyBlocks.sizzlingPost.getDefaultState());
			world.setBlockState(new BlockPos(i + 1, j + 0, k + 1), JourneyBlocks.brisonStone.getDefaultState());
			world.setBlockState(new BlockPos(i + 1, j + 0, k + 2), JourneyBlocks.sizzlingPost.getDefaultState());
			world.setBlockState(new BlockPos(i + 1, j + 1, k + 1), JourneyBlocks.sizzlingPost.getDefaultState());
			world.setBlockState(new BlockPos(i + 1, j + 2, k + 1), JourneyBlocks.sizzlingPost.getDefaultState());
			world.setBlockState(new BlockPos(i + 1, j + 3, k + 1), JourneyBlocks.boilingLamp.getDefaultState());
			world.setBlockState(new BlockPos(i + 2, j + 0, k + 1), JourneyBlocks.sizzlingPost.getDefaultState());
		return true;
	}
}