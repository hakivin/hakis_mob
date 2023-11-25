package net.hakivin.hakismob.entity.client;

import net.hakivin.hakismob.entity.model.PalliateModel;
import net.hakivin.hakismob.entity.world.Palliate;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class PalliateRenderer extends MobRenderer<Palliate, PalliateModel> {
    private static final ResourceLocation PALLIATE_LOCATION =
            new ResourceLocation("hakis_mob:textures/entities/palliate.png");
    private static final ResourceLocation PALLIATE_CHARGING_LOCATION =
            new ResourceLocation("hakis_mob:textures/entities/palliate_charging.png");

    public PalliateRenderer(EntityRendererProvider.Context context) {
        super(context, new PalliateModel(context.bakeLayer(HakisMobLayers.PALLIATE_LAYER)), 0.3F);
        this.addLayer(new ItemInHandLayer<>(this, context.getItemInHandRenderer()));
    }

    protected int getBlockLightLevel(Palliate pEntity, BlockPos pPos) {
        return 15;
    }

    /**
     * Returns the location of an entity's texture.
     */
    public ResourceLocation getTextureLocation(Palliate pEntity) {
        return pEntity.isCharging() ? PALLIATE_CHARGING_LOCATION : PALLIATE_LOCATION;
    }
}