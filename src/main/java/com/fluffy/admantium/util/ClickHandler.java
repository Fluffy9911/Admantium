package com.fluffy.admantium.util;

import java.util.ArrayList;
import java.util.List;

import com.fluffy.admantium.AdmantiumMain;
import com.fluffy.admantium.items.AdmItem;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickBlock;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = AdmantiumMain.MODID, bus = Bus.FORGE)
public class ClickHandler {
	private static List<AdmItem> REGISTERED;

	public static void createHandler() {
		REGISTERED = new ArrayList<>();
	}

	public static void registerUsage(AdmItem itm) {
		AdmantiumMain.LOGGER.debug("Added: " + itm.getDescriptionId());
		REGISTERED.add(itm);

	}

	@SubscribeEvent
	public static void playerTick(RightClickBlock event) {
		ItemStack stack;
		if (!REGISTERED.isEmpty())
			for (int i = 0; i < REGISTERED.size(); i++) {
				stack = new ItemStack(REGISTERED.get(i));
				if (event.getSide().isServer()
						&& event.getPlayer().getItemBySlot(EquipmentSlot.MAINHAND).getItem() == REGISTERED.get(i)) {
					REGISTERED.get(i).blockRightClicked(event.getWorld().getBlockState(event.getPos()).getBlock(),
							event.getPlayer(), event.getWorld(), event.getPos());
				}
			}
	}
}
