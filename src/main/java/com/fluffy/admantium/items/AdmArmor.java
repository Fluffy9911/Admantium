package com.fluffy.admantium.items;

import com.fluffy.admantium.util.ADMMaterial;
import com.fluffy.admantium.util.MaterialBuilder;
import com.fluffy.admantium.util.UsageHandler;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;

public abstract class AdmArmor extends ArmorItem {
	ADMMaterial mat;

	public AdmArmor(Properties properties, EquipmentSlot ec, ADMMaterial mat, MaterialBuilder builder) {
		super(builder, ec, properties);
		this.mat = mat;
	}

	public void registerWorn() {
		UsageHandler.registerUsage(this);
	}

	public abstract void whenWorn(Player p, ItemStack stack);

}
