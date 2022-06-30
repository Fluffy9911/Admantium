package com.fluffy.admantium.items;

import com.fluffy.admantium.util.ADMMaterial;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public abstract class StaffItem extends AdmItem {

	public StaffItem(Properties properties) {
		super(properties);

	}

	public abstract ADMMaterial getMaterial();

	@Override
	public void inventoryTick(ItemStack stack, Level p_41405_, Entity p_41406_, int p_41407_, boolean p_41408_) {
		this.inventory(stack, p_41405_, p_41406_);
		super.inventoryTick(stack, p_41405_, p_41406_, p_41407_, p_41408_);
	}

	public abstract void inventory(ItemStack stack, Level level, Entity entity);

}
