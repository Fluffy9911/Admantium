package com.fluffy.admantium.util;

import java.util.ArrayList;
import java.util.List;

import com.fluffy.admantium.AdmantiumMain;
import com.fluffy.admantium.items.AdmItem;
import com.fluffy.admantium.items.IToolTip;
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

	private static List<IToolTip> REGISTERED;

	public static void createHandler() {
		REGISTERED = new ArrayList<>();
	}

	public static void registerTooltip(IToolTip itm) {
		if (itm.getHighlightedDescription() != null) {

			REGISTERED.add(itm);
		}
	}

	@SubscribeEvent
	public static void createTooltips(GatherComponents gc) {
		ItemStack stack;
		if (!REGISTERED.isEmpty())
			for (int i = 0; i < REGISTERED.size(); i++) {
				stack = new ItemStack(REGISTERED.get(i).get());
				if (gc.getItemStack().getItem() == stack.getItem()) {
					IToolTip item = (IToolTip) stack.getItem();
					if (item instanceof AdmItem) {
						AdmItem it = (AdmItem) stack.getItem();
						gc.getTooltipElements()
								.add(Either.left(FormattedText.of(
										item.getHighlightedDescription().getText() + " Power: " + it.getPowerLevel(),
										Style.EMPTY.withColor(it.getHighlightedDescription().getColor()))));
					}
					gc.getTooltipElements().add(Either.left(FormattedText.of(item.getHighlightedDescription().getText(),
							Style.EMPTY.withColor(item.getHighlightedDescription().getColor()))));

					// float power = 0;

				}
			}

	}

}
