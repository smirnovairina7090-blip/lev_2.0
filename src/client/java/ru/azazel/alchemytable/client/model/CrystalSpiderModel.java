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
import net.minecraft.util.Mth;
import ru.azazel.alchemytable.AzazelSAlchemyTable;
import ru.azazel.alchemytable.entity.CrystalSpider;

public class CrystalSpiderModel extends EntityModel<CrystalSpider> {

    public static final ModelLayerLocation LAYER_LOCATION =
            new ModelLayerLocation(
                    AzazelSAlchemyTable.id("crystal_spider"),
                    "main"
            );

    private static final float DEG_TO_RAD =
            (float) Math.PI / 180.0F;

    private static final float WALK_SPEED = 0.6662F;
    private static final float WALK_AMOUNT = 0.45F;
    private static final float HALF_CYCLE = (float) Math.PI;

    private final ModelPart root;
    private final ModelPart head;

    private final ModelPart legFrontLeft;
    private final ModelPart legMiddleFrontLeft;
    private final ModelPart legMiddleBackLeft;
    private final ModelPart legBackLeft;

    private final ModelPart legFrontRight;
    private final ModelPart legMiddleFrontRight;
    private final ModelPart legMiddleBackRight;
    private final ModelPart legBackRight;

    public CrystalSpiderModel(ModelPart bakedRoot) {
        this.root = bakedRoot.getChild("bb_main");

        this.head = this.root.getChild("head");

        this.legFrontLeft =
                this.root.getChild("leg_front_left");

        this.legMiddleFrontLeft =
                this.root.getChild("leg_middle_front_left");

        this.legMiddleBackLeft =
                this.root.getChild("leg_middle_back_left");

        this.legBackLeft =
                this.root.getChild("leg_back_left");

        this.legFrontRight =
                this.root.getChild("leg_front_right");

        this.legMiddleFrontRight =
                this.root.getChild("leg_middle_front_right");

        this.legMiddleBackRight =
                this.root.getChild("leg_middle_back_right");

        this.legBackRight =
                this.root.getChild("leg_back_right");
    }

    public static LayerDefinition createBodyLayer() {

        MeshDefinition meshDefinition =
                new MeshDefinition();

        PartDefinition partDefinition =
                meshDefinition.getRoot();

        /*
         * Главная часть модели.
         *
         * Здесь остаются детали, которые не нужно
         * отдельно двигать во время ходьбы:
         * грудь, брюшко и центральный шип.
         */
        PartDefinition bbMain =
                partDefinition.addOrReplaceChild(
                        "bb_main",
                        CubeListBuilder.create()

                                // Грудь.
                                .texOffs(32, 20)
                                .addBox(
                                        -5.0F,
                                        -10.0F,
                                        -7.0F,
                                        10.0F,
                                        6.0F,
                                        7.0F
                                )

                                // Брюшко.
                                .texOffs(0, 0)
                                .addBox(
                                        -6.0F,
                                        -11.0F,
                                        0.0F,
                                        12.0F,
                                        8.0F,
                                        12.0F
                                )

                                // Центральный тонкий кристалл.
                                .texOffs(36, -5)
                                .addBox(
                                        0.0F,
                                        -14.0F,
                                        -13.0F,
                                        0.0F,
                                        3.0F,
                                        6.0F
                                ),

                        PartPose.offset(
                                0.0F,
                                24.0F,
                                0.0F
                        )
                );

        /*
         * ГОЛОВА
         *
         * Раньше голова была просто кубом внутри bb_main.
         * Теперь она отдельная ModelPart.
         *
         * Благодаря этому setupAnim() может поворачивать её,
         * не двигая всё тело паука.
         */
        bbMain.addOrReplaceChild(
                "head",
                CubeListBuilder.create()
                        .texOffs(0, 20)
                        .addBox(
                                -4.0F,
                                -4.0F,
                                -8.0F,
                                8.0F,
                                8.0F,
                                8.0F
                        ),
                PartPose.offset(
                        0.0F,
                        -7.0F,
                        -7.0F
                )
        );

        /*
         * ШИПЫ
         *
         * Их пока не анимируем.
         * Геометрия и UV оставлены такими же,
         * как в модели Льва.
         */
        bbMain.addOrReplaceChild(
                "spike_back_left",
                CubeListBuilder.create()
                        .texOffs(35, 7)
                        .addBox(
                                -1.0F,
                                0.0F,
                                -4.0F,
                                2.0F,
                                0.0F,
                                5.0F
                        ),
                PartPose.offsetAndRotation(
                        7.0F,
                        -7.0F,
                        8.0F,
                        0.0F,
                        0.0F,
                        -0.2618F
                )
        );

        bbMain.addOrReplaceChild(
                "spike_back_right",
                CubeListBuilder.create()
                        .texOffs(31, 7)
                        .addBox(
                                -1.0F,
                                0.0F,
                                -4.0F,
                                2.0F,
                                0.0F,
                                5.0F
                        ),
                PartPose.offsetAndRotation(
                        -7.0F,
                        -7.0F,
                        8.0F,
                        0.0F,
                        0.0F,
                        0.2618F
                )
        );

        bbMain.addOrReplaceChild(
                "spike_side_left",
                CubeListBuilder.create()
                        .texOffs(-5, -5)
                        .addBox(
                                -1.0F,
                                -3.0F,
                                -1.0F,
                                0.0F,
                                3.0F,
                                7.0F
                        ),
                PartPose.offsetAndRotation(
                        4.0F,
                        -11.0F,
                        3.0F,
                        0.0F,
                        0.0F,
                        0.1309F
                )
        );

        bbMain.addOrReplaceChild(
                "spike_side_right",
                CubeListBuilder.create()
                        .texOffs(-5, -5)
                        .addBox(
                                -1.0F,
                                -3.0F,
                                -1.0F,
                                0.0F,
                                3.0F,
                                7.0F
                        ),
                PartPose.offsetAndRotation(
                        -2.0F,
                        -11.0F,
                        3.0F,
                        0.0F,
                        0.0F,
                        -0.1309F
                )
        );

        /*
         * ЛАПЫ
         *
         * Самое важное изменение для анимации:
         * каждая лапа получает СОБСТВЕННУЮ ModelPart.
         *
         * Внешняя часть - это "кость", которую мы вращаем.
         * Внутри неё лежит cube - сама геометрия лапы.
         *
         * Так точка вращения находится около тела,
         * поэтому лапа двигается как конечность,
         * а не крутится вокруг своего центра.
         */

        // -----------------------------------------------------
        // ЛЕВАЯ ПЕРЕДНЯЯ
        // -----------------------------------------------------

        PartDefinition legFrontLeft =
                bbMain.addOrReplaceChild(
                        "leg_front_left",
                        CubeListBuilder.create(),
                        PartPose.offset(
                                4.0F,
                                -6.5F,
                                -4.5F
                        )
                );

        legFrontLeft.addOrReplaceChild(
                "cube",
                CubeListBuilder.create()
                        .texOffs(8, 36)
                        .addBox(
                                -1.0F,
                                -3.0F,
                                -1.0F,
                                2.0F,
                                12.0F,
                                2.0F
                        ),
                PartPose.offsetAndRotation(
                        2.25F,
                        1.5F,
                        -1.5F,
                        -0.5236F,
                        0.0F,
                        -1.0472F
                )
        );

        // -----------------------------------------------------
        // ЛЕВАЯ СРЕДНЯЯ ПЕРЕДНЯЯ
        // -----------------------------------------------------

        PartDefinition legMiddleFrontLeft =
                bbMain.addOrReplaceChild(
                        "leg_middle_front_left",
                        CubeListBuilder.create(),
                        PartPose.offset(
                                4.25F,
                                -6.5F,
                                -3.5F
                        )
                );

        legMiddleFrontLeft.addOrReplaceChild(
                "cube",
                CubeListBuilder.create()
                        .texOffs(0, 36)
                        .addBox(
                                -1.0F,
                                -3.0F,
                                -1.0F,
                                2.0F,
                                12.0F,
                                2.0F
                        ),
                PartPose.offsetAndRotation(
                        2.5F,
                        1.75F,
                        -0.5F,
                        -0.1745F,
                        0.0F,
                        -1.0472F
                )
        );

        // -----------------------------------------------------
        // ЛЕВАЯ СРЕДНЯЯ ЗАДНЯЯ
        // -----------------------------------------------------

        PartDefinition legMiddleBackLeft =
                bbMain.addOrReplaceChild(
                        "leg_middle_back_left",
                        CubeListBuilder.create(),
                        PartPose.offset(
                                4.25F,
                                -6.5F,
                                -2.25F
                        )
                );

        legMiddleBackLeft.addOrReplaceChild(
                "cube",
                CubeListBuilder.create()
                        .texOffs(32, 33)
                        .addBox(
                                -0.75F,
                                -3.0F,
                                0.0F,
                                2.0F,
                                12.0F,
                                2.0F
                        ),
                PartPose.offsetAndRotation(
                        2.5F,
                        2.0F,
                        -0.25F,
                        0.1745F,
                        0.0F,
                        -1.0472F
                )
        );

        // -----------------------------------------------------
        // ЛЕВАЯ ЗАДНЯЯ
        // -----------------------------------------------------

        PartDefinition legBackLeft =
                bbMain.addOrReplaceChild(
                        "leg_back_left",
                        CubeListBuilder.create(),
                        PartPose.offset(
                                4.25F,
                                -6.5F,
                                -1.0F
                        )
                );

        legBackLeft.addOrReplaceChild(
                "cube",
                CubeListBuilder.create()
                        .texOffs(16, 36)
                        .addBox(
                                0.25F,
                                -3.0F,
                                0.0F,
                                2.0F,
                                12.0F,
                                2.0F
                        ),
                PartPose.offsetAndRotation(
                        2.0F,
                        2.75F,
                        0.75F,
                        0.5236F,
                        0.0F,
                        -1.0472F
                )
        );

        // -----------------------------------------------------
        // ПРАВАЯ ПЕРЕДНЯЯ
        // -----------------------------------------------------

        PartDefinition legFrontRight =
                bbMain.addOrReplaceChild(
                        "leg_front_right",
                        CubeListBuilder.create(),
                        PartPose.offset(
                                -4.0F,
                                -6.5F,
                                -4.25F
                        )
                );

        legFrontRight.addOrReplaceChild(
                "cube",
                CubeListBuilder.create()
                        .texOffs(40, 47)
                        .addBox(
                                -1.0F,
                                -8.0F,
                                -1.0F,
                                2.0F,
                                12.0F,
                                2.0F
                        ),
                PartPose.offsetAndRotation(
                        -6.0F,
                        3.5F,
                        -4.0F,
                        -0.5236F,
                        0.0F,
                        1.0472F
                )
        );

        // -----------------------------------------------------
        // ПРАВАЯ СРЕДНЯЯ ПЕРЕДНЯЯ
        // -----------------------------------------------------

        PartDefinition legMiddleFrontRight =
                bbMain.addOrReplaceChild(
                        "leg_middle_front_right",
                        CubeListBuilder.create(),
                        PartPose.offset(
                                -4.25F,
                                -6.5F,
                                -3.25F
                        )
                );

        legMiddleFrontRight.addOrReplaceChild(
                "cube",
                CubeListBuilder.create()
                        .texOffs(24, 36)
                        .addBox(
                                -1.0F,
                                -8.0F,
                                -1.0F,
                                2.0F,
                                12.0F,
                                2.0F
                        ),
                PartPose.offsetAndRotation(
                        -6.75F,
                        4.0F,
                        -1.25F,
                        -0.1745F,
                        0.0F,
                        1.0472F
                )
        );

        // -----------------------------------------------------
        // ПРАВАЯ СРЕДНЯЯ ЗАДНЯЯ
        // -----------------------------------------------------

        PartDefinition legMiddleBackRight =
                bbMain.addOrReplaceChild(
                        "leg_middle_back_right",
                        CubeListBuilder.create(),
                        PartPose.offset(
                                -4.25F,
                                -6.5F,
                                -2.25F
                        )
                );

        legMiddleBackRight.addOrReplaceChild(
                "cube",
                CubeListBuilder.create()
                        .texOffs(40, 33)
                        .addBox(
                                -1.0F,
                                -8.0F,
                                -1.0F,
                                2.0F,
                                12.0F,
                                2.0F
                        ),
                PartPose.offsetAndRotation(
                        -6.75F,
                        4.0F,
                        1.5F,
                        0.1745F,
                        0.0F,
                        1.0472F
                )
        );

        // -----------------------------------------------------
        // ПРАВАЯ ЗАДНЯЯ
        // -----------------------------------------------------

        PartDefinition legBackRight =
                bbMain.addOrReplaceChild(
                        "leg_back_right",
                        CubeListBuilder.create(),
                        PartPose.offset(
                                -4.0F,
                                -6.5F,
                                -1.0F
                        )
                );

        legBackRight.addOrReplaceChild(
                "cube",
                CubeListBuilder.create()
                        .texOffs(32, 47)
                        .addBox(
                                -1.0F,
                                -8.0F,
                                -1.0F,
                                2.0F,
                                12.0F,
                                2.0F
                        ),
                PartPose.offsetAndRotation(
                        -6.0F,
                        3.5F,
                        4.0F,
                        0.5236F,
                        0.0F,
                        1.0472F
                )
        );

        return LayerDefinition.create(
                meshDefinition,
                128,
                128
        );
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

        /*
         * Minecraft передаёт поворот головы в градусах,
         * а ModelPart хранит углы в радианах.
         */
        this.head.yRot =
                netHeadYaw * DEG_TO_RAD;

        this.head.xRot =
                headPitch * DEG_TO_RAD;

        /*
         * limbSwing - где мы сейчас внутри шага.
         * Он постоянно меняется, пока моб идёт.
         *
         * limbSwingAmount - насколько активно моб движется.
         * Если паук стоит, значение близко к 0.
         */
        float walkCycle =
                limbSwing * WALK_SPEED;

        float walkStrength =
                Math.min(
                        limbSwingAmount,
                        1.0F
                ) * WALK_AMOUNT;

        /*
         * Ноги двигаются двумя чередующимися группами.
         *
         * HALF_CYCLE = PI.
         * Добавить PI к cos(...) означает
         * сдвинуть движение на половину цикла:
         *
         * первая группа идёт вперёд,
         * вторая в этот момент идёт назад.
         */

        this.legFrontLeft.yRot =
                Mth.cos(walkCycle)
                        * walkStrength;

        this.legMiddleFrontLeft.yRot =
                Mth.cos(
                        walkCycle
                                + HALF_CYCLE
                ) * walkStrength;

        this.legMiddleBackLeft.yRot =
                Mth.cos(walkCycle)
                        * walkStrength;

        this.legBackLeft.yRot =
                Mth.cos(
                        walkCycle
                                + HALF_CYCLE
                ) * walkStrength;

        this.legFrontRight.yRot =
                Mth.cos(
                        walkCycle
                                + HALF_CYCLE
                ) * walkStrength;

        this.legMiddleFrontRight.yRot =
                Mth.cos(walkCycle)
                        * walkStrength;

        this.legMiddleBackRight.yRot =
                Mth.cos(
                        walkCycle
                                + HALF_CYCLE
                ) * walkStrength;

        this.legBackRight.yRot =
                Mth.cos(walkCycle)
                        * walkStrength;
    }

    @Override
    public void renderToBuffer(
            PoseStack poseStack,
            VertexConsumer vertexConsumer,
            int packedLight,
            int packedOverlay,
            int color
    ) {

        this.root.render(
                poseStack,
                vertexConsumer,
                packedLight,
                packedOverlay,
                color
        );
    }
}
