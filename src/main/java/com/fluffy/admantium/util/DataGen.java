package com.fluffy.admantium.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import com.fluffy.admantium.AdmantiumMain;

import net.minecraft.data.DataGenerator;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(modid = AdmantiumMain.MODID, bus = Bus.MOD)
public class DataGen {
	public static Map<Item, String> lang;

	public static void addFull(Item item, String name) {
		lang.put(item, name);

	}

	public static void initKeys() {
		lang = new HashMap<>();

	}

	@SubscribeEvent
	public static void gatherData(GatherDataEvent event) throws IOException {

		DataGenerator gen = event.getGenerator();

		gen.addProvider(true, new Lang(gen));

		gen.run();
	}

	public static class Lang extends LanguageProvider {

		public Lang(DataGenerator gen) {
			super(gen, AdmantiumMain.MODID, "en_us");

		}

		@Override
		protected void addTranslations() {
			for (Map.Entry<Item, String> entry : lang.entrySet()) {
				Item key = entry.getKey();
				String val = entry.getValue();
				System.out.println(key.toString());
				this.add(key, val);

			}
		}

	}

	public static class Models extends ModelProvider {

		public Models(DataGenerator generator, String modid, String folder, Function factory,
				ExistingFileHelper existingFileHelper) {
			super(generator, modid, folder, factory, existingFileHelper);
			// TODO Auto-generated constructor stub
		}

		@Override
		public String getName() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		protected void registerModels() {
			for (Map.Entry<Item, String> entry : lang.entrySet()) {
				Item key = entry.getKey();
				String val = entry.getValue();
				System.out.println(key.toString());

			}
		}

	}

}
