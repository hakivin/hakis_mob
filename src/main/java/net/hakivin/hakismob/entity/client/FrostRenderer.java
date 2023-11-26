package net.hakivin.hakismob.entity.client;


import net.hakivin.hakismob.entity.model.FrostModel;
import net.hakivin.hakismob.entity.world.Frost;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class FrostRenderer extends MobRenderer<Frost, FrostModel<Frost>> {
    private static final ResourceLocation FROST_LOCATION = new ResourceLocation("hakis_mob:textures/entities/frost.png");

    public FrostRenderer(EntityRendererProvider.Context context) {
        super(context, new FrostModel<>(context.bakeLayer(HakisMobLayers.FROST_LAYER)), 0.5F);
    }

    protected int getBlockLightLevel(Frost pEntity, BlockPos pPos) {
        return 15;
    }

    /**
     * Returns the location of an entity's texture.
     */
    public ResourceLocation getTextureLocation(Frost pEntity) {
        return FROST_LOCATION;
    }
}