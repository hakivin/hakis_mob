package net.hakivin.hakismob;

import com.mojang.logging.LogUtils;
import net.hakivin.hakismob.entity.HakisMobEntities;
import net.hakivin.hakismob.entity.client.FrostRenderer;
import net.hakivin.hakismob.entity.client.IceShardRenderer;
import net.hakivin.hakismob.entity.client.PalliateRenderer;
import net.hakivin.hakismob.item.HakisMobItems;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.block.PointedDripstoneBlock;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(HakisMob.MOD_ID)
public class HakisMob {
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "hakis_mob";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public HakisMob() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        HakisMobItems.register(modEventBus);
        HakisMobEntities.registerEvent(modEventBus);

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.SPAWN_EGGS) {
            event.accept(HakisMobItems.PALLIATE_SPAWN_EGG);
            event.accept(HakisMobItems.FROST_SPAWN_EGG);
        }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            EntityRenderers.register(HakisMobEntities.PALLIATE.get(), PalliateRenderer::new);
            EntityRenderers.register(HakisMobEntities.FROST.get(), FrostRenderer::new);
            EntityRenderers.register(HakisMobEntities.SMALL_ICE_SHARD.get(), IceShardRenderer::new);
        }
    }
}
