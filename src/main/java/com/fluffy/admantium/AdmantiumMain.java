package com.fluffy.admantium;

import java.util.function.Supplier;

import org.slf4j.Logger;

import com.fluffy.admantium.blocks.MitiumPlant;
import com.fluffy.admantium.items.AdmantiumShard;
import com.fluffy.admantium.items.item.CalciteCrown;
import com.fluffy.admantium.util.ADMMaterial;
import com.fluffy.admantium.util.ClickHandler;
import com.fluffy.admantium.util.DataGen;
import com.fluffy.admantium.util.MaterialBuilder;
import com.fluffy.admantium.util.TooltipHandler;
import com.fluffy.admantium.util.UsageHandler;
import com.fluffy.admantium.util.VersionInfo;
import com.mojang.logging.LogUtils;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Material;
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
		// DataGen.initKeys();
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

	public static RegistryObject<Item> registerItem(String name, Supplier<Item> itm) {
		DataGen.addFull(itm.get(), name);
		return ITEMS.register(name, itm);
	}

	public static final RegistryObject<Item> ADMANTIUM_SHARD = ITEMS.register("admantium_shard",
			() -> new AdmantiumShard());
	public static final RegistryObject<Item> MITIUM_CRYSTAL = ITEMS.register("mitium_crystal",
			() -> new AdmantiumShard());
	public static final RegistryObject<Block> MITIUM_PLANT = BLOCKS.register("mitium_plant",
			() -> new MitiumPlant(Block.Properties.of(Material.PLANT).randomTicks()));

	public static final RegistryObject<ArmorItem> CALCITE_CROEN = ITEMS.register("calcite_crown",
			() -> new CalciteCrown(new Properties().stacksTo(1).tab(CreativeModeTab.TAB_MISC), EquipmentSlot.HEAD,
					ADMMaterial.ADMANTIUM, new MaterialBuilder(0, 0, 0, 0, 0, new ItemStack(Items.CALCITE)),
					"calcite_crown"));

}
