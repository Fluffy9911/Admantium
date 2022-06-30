package com.fluffy.admantium.util;

import java.util.ArrayList;
import java.util.List;

import com.fluffy.admantium.AdmantiumMain;
import com.fluffy.admantium.items.AdmItem;
import com.mojang.datafixers.util.Either;

import net.minecraft.network.chat.FormattedText;
import net.minecraft.network.chat.Style;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.event.RenderTooltipEvent.GatherComponents;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = AdmantiumMain.MODID, bus = Bus.FORGE)
public class TooltipHandler {

	private static List<AdmItem> REGISTERED;

	public static void createHandler() {
		REGISTERED = new ArrayList<>();
	}

	public static void registerTooltip(AdmItem itm) {
		if (itm.getHighlightedDescription() != null) {
			AdmantiumMain.LOGGER.debug("Added: " + itm.getDescriptionId());
			REGISTERED.add(itm);
		}
	}

	@SubscribeEvent
	public static void createTooltips(GatherComponents gc) {
		ItemStack stack;
		if (!REGISTERED.isEmpty())
			for (int i = 0; i < REGISTERED.size(); i++) {
				stack = new ItemStack(REGISTERED.get(i));
				if (gc.getItemStack().getItem() == stack.getItem()) {
					AdmItem item = (AdmItem) stack.getItem();

					gc.getTooltipElements()
							.add(Either.left(FormattedText.of(
									item.getHighlightedDescription().getText() + " Power: " + item.getPowerLevel(),
									Style.EMPTY.withColor(item.getHighlightedDescription().getColor()))));

					// float power = 0;

				}
			}

	}

}
