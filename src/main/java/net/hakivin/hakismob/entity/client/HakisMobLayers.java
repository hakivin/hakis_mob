package net.hakivin.hakismob.entity.client;

import net.hakivin.hakismob.HakisMob;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;

public class HakisMobLayers {
    public static final ModelLayerLocation PALLIATE_LAYER = new ModelLayerLocation(
            new ResourceLocation(HakisMob.MOD_ID, "palliate"), "main");

    public static final ModelLayerLocation FROST_LAYER = new ModelLayerLocation(
            new ResourceLocation(HakisMob.MOD_ID, "frost"), "main");

    public static final ModelLayerLocation ICE_SHARD_LAYER = new ModelLayerLocation(
            new ResourceLocation(HakisMob.MOD_ID, "ice_shard"), "main");

}