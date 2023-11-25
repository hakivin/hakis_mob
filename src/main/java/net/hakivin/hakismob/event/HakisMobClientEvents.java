package net.hakivin.hakismob.event;

import net.hakivin.hakismob.HakisMob;
import net.hakivin.hakismob.entity.client.HakisMobLayers;
import net.hakivin.hakismob.entity.model.PalliateModel;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = HakisMob.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class HakisMobClientEvents {

    @SubscribeEvent
    public static void registerEntityRenderers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(HakisMobLayers.PALLIATE_LAYER, PalliateModel::createBodyLayer);
    }
}