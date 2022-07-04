package com.fluffy.admantium.items;

import com.fluffy.admantium.util.ADMMaterial;
import com.fluffy.admantium.util.MaterialBuilder;
import com.fluffy.admantium.util.TooltipHandler;
import com.fluffy.admantium.util.UsageHandler;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public abstract class AdmArmor extends ArmorItem implements IToolTip {
	@Override
	public Item get() {
		// TODO Auto-generated method stub
		return this;
	}

	ADMMaterial mat;

	public AdmArmor(Properties properties, EquipmentSlot ec, ADMMaterial mat, MaterialBuilder builder) {
		super(builder, ec, properties);
		this.mat = mat;
		TooltipHandler.registerTooltip(this);
	}

	public void registerWorn() {
		UsageHandler.registerUsage(this);
	}

	public abstract void whenWorn(Player p, ItemStack stack);

}
