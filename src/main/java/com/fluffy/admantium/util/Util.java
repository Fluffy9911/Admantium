package com.fluffy.admantium.util;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.ParticleEngine;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;

public class Util {
	public static void summonParticalAtBlock(BlockPos pos, ParticleType p) {
		Minecraft m = Minecraft.getInstance();
		ParticleEngine e = m.particleEngine;
		e.createParticle(new ParticleOptions() {

			@Override
			public ParticleType<?> getType() {
				// TODO Auto-generated method stub
				return p;
			}

			@Override
			public void writeToNetwork(FriendlyByteBuf p_123732_) {
				// TODO Auto-generated method stub

			}

			@Override
			public String writeToString() {
				// TODO Auto-generated method stub
				return null;
			}

		}, pos.getX(), pos.getY(), pos.getZ(), 0, 0, 0);
	}

	public static void dropItems(ItemStack stack, int amount, BlockPos pos, LevelAccessor la) {
		stack.setCount(amount);
		Entity item = new ItemEntity((Level) la, pos.getX(), pos.getY(), pos.getZ(), stack);
		la.addFreshEntity(item);
	}
}
