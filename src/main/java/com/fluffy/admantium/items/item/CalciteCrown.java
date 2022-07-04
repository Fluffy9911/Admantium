package com.fluffy.admantium.items.item;

import com.fluffy.admantium.items.AdmArmor;
import com.fluffy.admantium.util.ADMMaterial;
import com.fluffy.admantium.util.MaterialBuilder;
import com.fluffy.admantium.util.TextComponent;
import com.fluffy.admantium.util.UsageHandler;

import net.minecraft.ChatFormatting;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public class CalciteCrown extends AdmArmor {

	public CalciteCrown(Properties properties, EquipmentSlot ec, ADMMaterial mat, MaterialBuilder builder,
			String name) {
		super(properties, ec, mat, builder);
		UsageHandler.registerUsage(this);
		builder.name = name;
	}

	@Override
	public TextComponent getHighlightedDescription() {
		// TODO Auto-generated method stub
		return new TextComponent() {

			@Override
			public String getText() {
				// TODO Auto-generated method stub
				return "Crown of pure calcite, little to no properties";
			}

			@Override
			public ChatFormatting getColor() {
				// TODO Auto-generated method stub
				return ChatFormatting.WHITE;
			}

		};
	}

	@Override
	public void whenWorn(Player p, ItemStack stack) {
		p.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 1, 1));
	}

}
