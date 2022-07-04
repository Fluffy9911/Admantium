package com.fluffy.admantium.items;

import com.fluffy.admantium.util.TextComponent;

import net.minecraft.world.item.Item;

public interface IToolTip {
	public abstract TextComponent getHighlightedDescription();

	public Item get();
}
