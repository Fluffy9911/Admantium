package com.fluffy.admantium.items.item;

import com.fluffy.admantium.items.AdmItem;
import com.fluffy.admantium.util.TextComponent;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

public class MitiumCrystal extends AdmItem {

	public MitiumCrystal(Properties properties) {
		super(properties);
		// TODO Auto-generated constructor stub
	}

	@Override
	public TextComponent getHighlightedDescription() {
		// TODO Auto-generated method stub
		return new TextComponent() {

			@Override
			public String getText() {
				// TODO Auto-generated method stub
				return "Powerful crystal from the Mitium plant, not many known uses";
			}

			@Override
			public ChatFormatting getColor() {
				// TODO Auto-generated method stub
				return ChatFormatting.BLACK;
			}

		};
	}

	@Override
	public float getPowerLevel() {
		// TODO Auto-generated method stub
		return 3;
	}

	@Override
	public boolean entityLeftClicked(ItemStack stack, Entity entity, Player p) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void blockRightClicked(Block b, Player p, Level l, BlockPos pos) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean useRandomPower() {
		// TODO Auto-generated method stub
		return false;
	}

}
