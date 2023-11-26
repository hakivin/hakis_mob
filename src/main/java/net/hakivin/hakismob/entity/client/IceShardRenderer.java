package net.hakivin.hakismob.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.hakivin.hakismob.entity.model.IceShardModel;
import net.hakivin.hakismob.entity.projectile.IceShard;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;

public class IceShardRenderer extends EntityRenderer<IceShard> {
    private final IceShardModel model;
    private static final ResourceLocation ICE_SHARD_LOCATION =
            new ResourceLocation("hakis_mob:textures/entities/ice_shard.png");

    public IceShardRenderer(EntityRendererProvider.Context pContext) {
        super(pContext);
        this.model = new IceShardModel(pContext.bakeLayer(HakisMobLayers.ICE_SHARD_LAYER));
    }

    @Override
    public void render(IceShard pEntity, float pEntityYaw, float pPartialTicks, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight) {
        pPoseStack.pushPose();
        pPoseStack.mulPose(this.entityRenderDispatcher.cameraOrientation());
        pPoseStack.mulPose(Axis.YP.rotationDegrees(180.0F));
        VertexConsumer vertexconsumer = pBuffer.getBuffer(this.model.renderType(this.getTextureLocation(pEntity)));
        this.model.renderToBuffer(pPoseStack, vertexconsumer, pPackedLight, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
        pPoseStack.popPose();
        super.render(pEntity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
    }

    @Override
    public ResourceLocation getTextureLocation(IceShard pEntity) {
        return ICE_SHARD_LOCATION;
    }
}
