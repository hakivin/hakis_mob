package net.hakivin.hakismob.event;

import net.hakivin.hakismob.HakisMob;
import net.hakivin.hakismob.entity.HakisMobEntities;
import net.hakivin.hakismob.entity.world.Frost;
import net.hakivin.hakismob.entity.world.Palliate;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = HakisMob.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class HakisMobEvents {

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(HakisMobEntities.PALLIATE.get(), Palliate.createAttributes().build());
        event.put(HakisMobEntities.FROST.get(), Frost.createAttributes().build());
    }
}