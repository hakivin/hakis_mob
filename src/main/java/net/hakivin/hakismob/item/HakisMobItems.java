package net.hakivin.hakismob.item;

import net.hakivin.hakismob.HakisMob;
import net.hakivin.hakismob.entity.HakisMobEntities;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class HakisMobItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, HakisMob.MOD_ID);
    public static final RegistryObject<Item> PALLIATE_SPAWN_EGG = ITEMS.register("palliate_spawn_egg",
            () -> new ForgeSpawnEggItem(HakisMobEntities.PALLIATE,
                    56063, 44543, new Item.Properties()));

    public static final RegistryObject<Item> FROST_SPAWN_EGG = ITEMS.register("frost_spawn_egg",
            () -> new ForgeSpawnEggItem(HakisMobEntities.FROST,
                    15658718, 14014157, new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
