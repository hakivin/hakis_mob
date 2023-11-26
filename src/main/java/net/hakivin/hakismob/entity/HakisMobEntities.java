package net.hakivin.hakismob.entity;

import net.hakivin.hakismob.HakisMob;
import net.hakivin.hakismob.entity.projectile.IceShard;
import net.hakivin.hakismob.entity.projectile.SmallIceShard;
import net.hakivin.hakismob.entity.world.Frost;
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

    public static final RegistryObject<EntityType<Frost>> FROST =
            ENTITY_TYPES.register("frost", () -> EntityType.Builder.of(Frost::new, MobCategory.CREATURE)
                    .sized(0.7F, 0.6F).clientTrackingRange(8).build("frost"));

    public static final RegistryObject<EntityType<SmallIceShard>> SMALL_ICE_SHARD =
            ENTITY_TYPES.register("small_ice_shard", () -> EntityType.Builder.<SmallIceShard>of(SmallIceShard::new, MobCategory.MISC)
                    .fireImmune().sized(1.0F, 1.0F).clientTrackingRange(4)
                    .updateInterval(10).build("small_ice_shard"));

    public static void registerEvent(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
