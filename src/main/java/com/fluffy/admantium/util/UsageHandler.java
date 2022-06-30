package com.fluffy.admantium.util;

import java.util.ArrayList;
import java.util.List;

import com.fluffy.admantium.AdmantiumMain;
import com.fluffy.admantium.items.AdmArmor;

import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.TickEvent.PlayerTickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = AdmantiumMain.MODID, bus = Bus.FORGE)
public class UsageHandler {
	private static List<AdmArmor> REGISTERED;

	public static void createHandler() {
		REGISTERED = new ArrayList<>();
	}

	public static void registerUsage(AdmArmor itm) {
		AdmantiumMain.LOGGER.debug("Added: " + itm.getDescriptionId());
		REGISTERED.add(itm);

	}

	@SubscribeEvent
	public static void playerTick(PlayerTickEvent event) {
		ItemStack stack;
		if (!REGISTERED.isEmpty())
			for (int i = 0; i < REGISTERED.size(); i++) {
				stack = new ItemStack(REGISTERED.get(i));
				while (event.player.getArmorSlots().iterator().hasNext()) {
					ItemStack stack2 = event.player.getArmorSlots().iterator().next();
					if (stack2.getItem() == stack.getItem()) {
						((AdmArmor) stack.getItem()).whenWorn(event.player, stack);

					}
				}
			}
	}

}
