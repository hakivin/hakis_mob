package net.hakivin.hakismob.entity.model;// Made with Blockbench 4.8.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.Entity;

public class IceShardModel<T extends Entity> extends EntityModel<T> {
    private final ModelPart root;

    public IceShardModel(ModelPart root) {
        this.root = root.getChild("root");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offsetAndRotation(1.0F, -5.0F, -2.0F, 3.1416F, 0.0F, 3.1416F));

        PartDefinition back = root.addOrReplaceChild("back", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, 3.0F, -2.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(11, 12).addBox(-1.0F, 2.0F, -5.0F, 1.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(14, 21).addBox(-1.0F, 1.0F, -4.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(5, 0).addBox(-1.0F, 0.0F, -2.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 5.0F, -1.0F));

        PartDefinition front = root.addOrReplaceChild("front", CubeListBuilder.create().texOffs(0, 12).addBox(-1.0F, 3.0F, -2.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(13, 0).addBox(-1.0F, 2.0F, -5.0F, 1.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(22, 22).addBox(-1.0F, 1.0F, -4.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(5, 4).addBox(-1.0F, 0.0F, -2.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 5.0F, -1.0F));

        PartDefinition mid = root.addOrReplaceChild("mid", CubeListBuilder.create().texOffs(0, 4).addBox(0.0F, 4.0F, -2.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(21, 9).addBox(0.0F, 3.0F, -4.0F, 1.0F, 1.0F, 7.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(0.0F, 2.0F, -6.0F, 1.0F, 1.0F, 11.0F, new CubeDeformation(0.0F))
                .texOffs(0, 12).addBox(0.0F, 1.0F, -5.0F, 1.0F, 1.0F, 9.0F, new CubeDeformation(0.0F))
                .texOffs(0, 22).addBox(0.0F, 0.0F, -4.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 5.0F, -1.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }
}