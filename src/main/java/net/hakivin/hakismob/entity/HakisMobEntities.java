package net.hakivin.hakismob.entity;

import net.hakivin.hakismob.HakisMob;
import net.hakivin.hakismob.entity.world.Palliate;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class HakisMobEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, HakisMob.MOD_ID);

    public static final RegistryObject<EntityType<Palliate>> PALLIATE =
            ENTITY_TYPES.register("palliate", () -> EntityType.Builder.of(Palliate::new, MobCategory.CREATURE)
                    .fireImmune().sized(0.4F, 0.8F)
                    .clientTrackingRange(8).build("palliate"));

    public static void registerEvent(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}