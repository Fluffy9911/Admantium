package com.fluffy.admantium;

import com.fluffy.admantium.items.AdmArmor;
import com.fluffy.admantium.util.ADMMaterial;
import com.fluffy.admantium.util.MaterialBuilder;
import com.fluffy.admantium.util.TextComponent;

import net.minecraft.ChatFormatting;
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

	@Override
	public TextComponent getHighlightedDescription() {
		// TODO Auto-generated method stub
		return new TextComponent() {

			@Override
			public String getText() {
				// TODO Auto-generated method stub
				return "Test Armor";
			}

			@Override
			public ChatFormatting getColor() {
				// TODO Auto-generated method stub
				return ChatFormatting.DARK_RED;
			}

		};
	}

}
