package ru.azazel.alchemytable.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import ru.azazel.alchemytable.AzazelSAlchemyTable;
import ru.azazel.alchemytable.entity.CrystalSpider;

public class CrystalSpiderModel extends EntityModel<CrystalSpider> {

    public static final ModelLayerLocation LAYER_LOCATION =
            new ModelLayerLocation(
                    AzazelSAlchemyTable.id("crystal_spider"),
                    "main"
            );

    private final ModelPart root;

    public CrystalSpiderModel(ModelPart root) {
        this.root = root;
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();

        root.addOrReplaceChild("part_0",
                CubeListBuilder.create().texOffs(32, 20)
                        .addBox(-5.0F, -6.0F, -4.0F, 10.0F, 6.0F, 7.0F),
                PartPose.offsetAndRotation(0.0F, 20.0F, -3.0F, 0.0F, 0.0F, 0.0F));

        root.addOrReplaceChild("part_1",
                CubeListBuilder.create().texOffs(32, 33)
                        .addBox(-0.75F, -3.0F, 0.0F, 2.0F, 12.0F, 2.0F),
                PartPose.offsetAndRotation(6.75F, 19.5F, -2.5F, 0.174533F, 0.0F, -1.047198F));

        root.addOrReplaceChild("part_2",
                CubeListBuilder.create().texOffs(0, 36)
                        .addBox(-1.0F, -3.0F, -1.0F, 2.0F, 12.0F, 2.0F),
                PartPose.offsetAndRotation(6.75F, 19.25F, -4.0F, -0.174533F, 0.0F, -1.047198F));

        root.addOrReplaceChild("part_3",
                CubeListBuilder.create().texOffs(8, 36)
                        .addBox(-1.0F, -3.0F, -1.0F, 2.0F, 12.0F, 2.0F),
                PartPose.offsetAndRotation(6.25F, 19.0F, -6.0F, -0.523599F, 0.0F, -1.047198F));

        root.addOrReplaceChild("part_4",
                CubeListBuilder.create().texOffs(16, 36)
                        .addBox(0.25F, -3.0F, 0.0F, 2.0F, 12.0F, 2.0F),
                PartPose.offsetAndRotation(6.25F, 20.25F, -0.25F, 0.523599F, 0.0F, -1.047198F));

        root.addOrReplaceChild("part_5",
                CubeListBuilder.create().texOffs(24, 36)
                        .addBox(-1.0F, -8.0F, -1.0F, 2.0F, 12.0F, 2.0F),
                PartPose.offsetAndRotation(-11.0F, 21.5F, -4.5F, -0.174533F, 0.0F, 1.047198F));

        root.addOrReplaceChild("part_6",
                CubeListBuilder.create().texOffs(40, 33)
                        .addBox(-1.0F, -8.0F, -1.0F, 2.0F, 12.0F, 2.0F),
                PartPose.offsetAndRotation(-11.0F, 21.5F, -0.75F, 0.174533F, 0.0F, 1.047198F));

        root.addOrReplaceChild("part_7",
                CubeListBuilder.create().texOffs(32, 47)
                        .addBox(-1.0F, -8.0F, -1.0F, 2.0F, 12.0F, 2.0F),
                PartPose.offsetAndRotation(-10.0F, 21.0F, 3.0F, 0.523599F, 0.0F, 1.047198F));

        root.addOrReplaceChild("part_8",
                CubeListBuilder.create().texOffs(40, 47)
                        .addBox(-1.0F, -8.0F, -1.0F, 2.0F, 12.0F, 2.0F),
                PartPose.offsetAndRotation(-10.0F, 21.0F, -8.25F, -0.523599F, 0.0F, 1.047198F));

        root.addOrReplaceChild("part_9",
                CubeListBuilder.create().texOffs(0, 20)
                        .addBox(-4.0F, -6.0F, -7.0F, 8.0F, 8.0F, 8.0F),
                PartPose.offsetAndRotation(0.0F, 19.0F, -8.0F, 0.0F, 0.0F, 0.0F));

        root.addOrReplaceChild("part_10",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-6.0F, -3.0F, 0.0F, 12.0F, 8.0F, 12.0F),
                PartPose.offsetAndRotation(0.0F, 16.0F, 0.0F, 0.0F, 0.0F, 0.0F));

        root.addOrReplaceChild("part_11",
                CubeListBuilder.create().texOffs(-5, -5)
                        .addBox(-1.0F, -3.0F, -1.0F, 0.0F, 3.0F, 7.0F),
                PartPose.offsetAndRotation(-2.0F, 13.0F, 3.0F, 0.0F, 0.0F, -0.1309F));

        root.addOrReplaceChild("part_12",
                CubeListBuilder.create().texOffs(-5, -5)
                        .addBox(-1.0F, -3.0F, -1.0F, 0.0F, 3.0F, 7.0F),
                PartPose.offsetAndRotation(4.0F, 13.0F, 3.0F, 0.0F, 0.0F, 0.1309F));

        root.addOrReplaceChild("part_13",
                CubeListBuilder.create().texOffs(36, -5)
                        .addBox(1.0F, -3.0F, -3.0F, 0.0F, 3.0F, 6.0F),
                PartPose.offsetAndRotation(-1.0F, 13.0F, -10.0F, 0.0F, 0.0F, 0.0F));

        root.addOrReplaceChild("part_14",
                CubeListBuilder.create().texOffs(31, 7)
                        .addBox(-1.0F, 0.0F, -4.0F, 2.0F, 0.0F, 5.0F),
                PartPose.offsetAndRotation(-7.0F, 17.0F, 8.0F, 0.0F, 0.0F, 0.261799F));

        root.addOrReplaceChild("part_15",
                CubeListBuilder.create().texOffs(35, 7)
                        .addBox(-1.0F, 0.0F, -4.0F, 2.0F, 0.0F, 5.0F),
                PartPose.offsetAndRotation(7.0F, 17.0F, 8.0F, 0.0F, 0.0F, -0.261799F));

        return LayerDefinition.create(mesh, 128, 128);
    }

    @Override
    public void setupAnim(
            CrystalSpider entity,
            float limbSwing,
            float limbSwingAmount,
            float ageInTicks,
            float netHeadYaw,
            float headPitch
    ) {
        // Пока сохраняем исходную позу из Blockbench.
        // Анимацию лап добавим отдельным следующим шагом.
    }

    @Override
    public void renderToBuffer(
            PoseStack poseStack,
            VertexConsumer vertexConsumer,
            int packedLight,
            int packedOverlay,
            int color
    ) {
        root.render(
                poseStack,
                vertexConsumer,
                packedLight,
                packedOverlay,
                color
        );
    }
}
