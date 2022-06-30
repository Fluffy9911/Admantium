package com.fluffy.admantium.items;

import com.fluffy.admantium.util.ClickHandler;
import com.fluffy.admantium.util.TextComponent;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

public class AdmantiumShard extends AdmItem {

	public AdmantiumShard() {
		super(new Properties().tab(CreativeModeTab.TAB_MATERIALS).stacksTo(1));
		ClickHandler.registerUsage(this);
	}

	@Override
	public float getPowerLevel() {
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	public boolean entityLeftClicked(ItemStack stack, Entity entity, Player p) {

		return false;
	}

	@Override
	public boolean useRandomPower() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public TextComponent getHighlightedDescription() {

		return new TextComponent() {

			@Override
			public String getText() {
				// TODO Auto-generated method stub
				return " Powerful shard of pure Admantium!";
			}

			@Override
			public ChatFormatting getColor() {
				// TODO Auto-generated method stub
				return ChatFormatting.LIGHT_PURPLE;
			}

		};
	}

	@Override
	public void blockRightClicked(Block b, Player p, Level l, BlockPos pos) {
		System.out.println("hey!");
		l.setBlock(pos, Blocks.DIAMOND_BLOCK.defaultBlockState(), 7);

	}

}
