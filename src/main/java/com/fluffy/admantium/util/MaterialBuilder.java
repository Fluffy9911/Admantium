package com.fluffy.admantium.util;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;

public class MaterialBuilder implements ArmorMaterial {
	int defense, durability, enchValue;
	float toughness, resistance;
	ItemStack repair;

	public MaterialBuilder(int defense, int durability, int enchValue, float toughness, float resistance,
			ItemStack repair) {
		super();
		this.defense = defense;
		this.durability = durability;
		this.enchValue = enchValue;
		this.toughness = toughness;
		this.resistance = resistance;
		this.repair = repair;
	}

	@Override
	public int getDurabilityForSlot(EquipmentSlot p_40410_) {

		return this.durability;
	}

	@Override
	public int getDefenseForSlot(EquipmentSlot p_40411_) {

		return this.defense;
	}

	@Override
	public int getEnchantmentValue() {

		return this.enchValue;
	}

	@Override
	public SoundEvent getEquipSound() {

		return SoundEvents.BEACON_ACTIVATE;
	}

	@Override
	public Ingredient getRepairIngredient() {

		return Ingredient.of(this.repair);
	}

	@Override
	public String getName() {

		return "adm_material";
	}

	@Override
	public float getToughness() {
		// TODO Auto-generated method stub
		return this.toughness;
	}

	@Override
	public float getKnockbackResistance() {
		// TODO Auto-generated method stub
		return this.resistance;
	}

}
