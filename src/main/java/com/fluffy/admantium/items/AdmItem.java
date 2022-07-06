package com.fluffy.admantium.items;

import java.util.Random;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

public abstract class AdmItem extends Item implements IToolTip {

	public AdmItem(Properties properties) {
		super(properties);
		// TooltipHandler.registerTooltip(this);

	}

	public abstract float getPowerLevel();

	public abstract boolean entityLeftClicked(ItemStack stack, Entity entity, Player p);

	public abstract void blockRightClicked(Block b, Player p, Level l, BlockPos pos);

	public abstract boolean useRandomPower();

	@Override
	public Item get() {
		// TODO Auto-generated method stub
		return this;
	}

	@Override
	public boolean onLeftClickEntity(ItemStack stack, Player player, Entity entity) {
		return this.entityLeftClicked(stack, entity, player);
	}

	public float saveOrLoadedFloat(ItemStack stack, float save, String name) {

		CompoundTag tag = stack.getOrCreateTag();

		if (stack.getCount() == 1)
			if (stack.getTag().get(name) != null) {
				return tag.getFloat(name);
			} else {
				System.out.println("creating...");
				tag.putFloat(name, save);
				stack.save(tag);
				return save;
			}

		return 0;
	}

	private float getPossibleRandom(float p) {
		if (this.useRandomPower())
			return new Random().nextFloat(p);
		return p;
	}

}
