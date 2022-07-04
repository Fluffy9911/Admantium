package com.fluffy.admantium.blocks;

import java.util.Random;

import com.fluffy.admantium.AdmantiumMain;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.PlantType;

public class MitiumPlant extends CropBlock {
	public static final IntegerProperty AGE = BlockStateProperties.AGE_15;
	private static final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[] { Block.box(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D),
			Block.box(0.0D, 0.0D, 0.0D, 16.0D, 3.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 4.0D, 16.0D),
			Block.box(0.0D, 0.0D, 0.0D, 16.0D, 5.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 6.0D, 16.0D),
			Block.box(0.0D, 0.0D, 0.0D, 16.0D, 7.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D),
			Block.box(0.0D, 0.0D, 0.0D, 16.0D, 9.0D, 16.0D) };

	public MitiumPlant(Properties p_52247_) {
		super(p_52247_);

	}

	@Override
	public PlantType getPlantType(BlockGetter level, BlockPos pos) {
		// TODO Auto-generated method stub
		return PlantType.CAVE;
	}

	@Override
	protected ItemLike getBaseSeedId() {
		return AdmantiumMain.MITIUM_CRYSTAL.get();
	}

	@Override
	public VoxelShape getShape(BlockState p_51330_, BlockGetter p_51331_, BlockPos p_51332_,
			CollisionContext p_51333_) {
		return SHAPE_BY_AGE[p_51330_.getValue(this.getAgeProperty())];
	}

	@Override
	protected boolean mayPlaceOn(BlockState state, BlockGetter p_52303_, BlockPos p_52304_) {
		// TODO Auto-generated method stub
		return state.is(Blocks.DEEPSLATE);
	}

	@Override
	public void destroy(LevelAccessor p_49860_, BlockPos p_49861_, BlockState p_49862_) {
		Random r = new Random();
		int amount = r.nextInt(1, 3);
	}

	@Override
	public IntegerProperty getAgeProperty() {
		return AGE;
	}

	@Override
	public int getMaxAge() {
		return 15;
	}

	@Override
	public void randomTick(BlockState state, ServerLevel p_221051_, BlockPos p_221052_, RandomSource p_221053_) {
		if (!p_221051_.isAreaLoaded(p_221052_, 1))
			return; // Forge: prevent loading unloaded chunks when checking neighbor's light
		if (p_221051_.getRawBrightness(p_221052_, 0) >= 9) {
			int i = this.getAge(state);
			if (i < this.getMaxAge()) {
				float f = getGrowthSpeed(this, p_221051_, p_221052_);
				if (net.minecraftforge.common.ForgeHooks.onCropsGrowPre(p_221051_, p_221052_, state,
						p_221053_.nextInt((int) (25.0F / f) + 1) == 0)) {
					p_221051_.setBlock(p_221052_, this.getStateForAge(i + 1), 2);
					net.minecraftforge.common.ForgeHooks.onCropsGrowPost(p_221051_, p_221052_, p_221050_);
				}
			}
		}

	}

	@Override
	public void growCrops(Level p_52264_, BlockPos p_52265_, BlockState p_52266_) {

	}

	@Override
	protected int getBonemealAgeIncrease(Level p_52262_) {
		return 0;
	}

	@Override
	public boolean canSurvive(BlockState state, LevelReader lr, BlockPos pos) {
		return (lr.getRawBrightness(pos, 0) == 0 || !lr.canSeeSky(pos)) && super.canSurvive(state, lr, pos);
	}

}
