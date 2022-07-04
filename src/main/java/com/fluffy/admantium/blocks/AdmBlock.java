package com.fluffy.admantium.blocks;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public abstract class AdmBlock extends Block {
	List<Item> items;

	public AdmBlock(Properties p_49795_) {
		super(p_49795_);
		items = new ArrayList<>();

	}

	public abstract List<Item> dropItems();

	public abstract void onBroken(Level l, BlockPos pos, Player p);

	@Override
	public void playerDestroy(Level l, Player p, BlockPos pos, BlockState p_49830_, BlockEntity p_49831_,
			ItemStack p_49832_) {
		this.onBroken(l, pos, p);
		for (int i = 0; i < items.size(); i++) {
			ItemEntity ent = new ItemEntity(l, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(items.get(i)));

			l.addFreshEntity(ent);
		}
		super.playerDestroy(l, p, pos, p_49830_, p_49831_, p_49832_);
	}

}
