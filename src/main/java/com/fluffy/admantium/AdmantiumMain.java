package com.fluffy.admantium;

import org.slf4j.Logger;

import com.fluffy.admantium.items.AdmantiumShard;
import com.fluffy.admantium.util.ClickHandler;
import com.fluffy.admantium.util.TooltipHandler;
import com.fluffy.admantium.util.UsageHandler;
import com.fluffy.admantium.util.VersionInfo;
import com.mojang.logging.LogUtils;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod(AdmantiumMain.MODID)
public class AdmantiumMain {

	public static final String MODID = "admantium";

	public static final Logger LOGGER = LogUtils.getLogger();

	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);

	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

	public static final VersionInfo version = AdmantiumMain.getVersionInfo(VersionInfo.TESTING);

	public AdmantiumMain() {
		TooltipHandler.createHandler();
		UsageHandler.createHandler();
		ClickHandler.createHandler();
		IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

		modEventBus.addListener(this::commonSetup);

		BLOCKS.register(modEventBus);

		ITEMS.register(modEventBus);

		MinecraftForge.EVENT_BUS.register(this);

	}

	private void commonSetup(final FMLCommonSetupEvent event) {

	}

	@SubscribeEvent
	public void onServerStarting(ServerStartingEvent event) {
		LOGGER.info(
				"Admantium startup, any and all crash reports regarding this mod pleas report to Fluffy#9911 on discord! enjoy the mod");
	}

	@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class ClientModEvents {
		@SubscribeEvent
		public static void onClientSetup(FMLClientSetupEvent event) {

		}
	}

	private static VersionInfo getVersionInfo(VersionInfo info) {
		if (info == VersionInfo.ALPHA) {
			LOGGER.debug("Admantium in Alpha major issues present!");
		}
		if (info == VersionInfo.BETA) {
			LOGGER.debug("Admantium in Beta issues present!");
		}
		if (info == null) {
			LOGGER.debug("Warning Unsigned version!");
		}
		if (info == VersionInfo.TESTING) {
			LOGGER.debug("Testing version of Admantium");
		}
		if (info == VersionInfo.RELEASE) {

		}
		return info;
	}

	public static final RegistryObject<Item> ADMANTIUM_SHARD = ITEMS.register("admantium_shard",
			() -> new AdmantiumShard());

}
