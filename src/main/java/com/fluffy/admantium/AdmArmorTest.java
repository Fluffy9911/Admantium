package com.fluffy.admantium;

import com.fluffy.admantium.items.AdmArmor;
import com.fluffy.admantium.util.ADMMaterial;
import com.fluffy.admantium.util.MaterialBuilder;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public class AdmArmorTest extends AdmArmor {

	public AdmArmorTest(Properties properties, EquipmentSlot ec, ADMMaterial mat, MaterialBuilder builder) {
		super(properties, ec, mat, builder);
		this.registerWorn();
	}

	@Override
	public void whenWorn(Player p, ItemStack stack) {
		p.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 5000, 5000));

	}

}
