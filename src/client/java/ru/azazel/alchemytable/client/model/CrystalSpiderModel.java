package ru.azazel.alchemytable.client.model;

import net.minecraft.client.model.SpiderModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import ru.azazel.alchemytable.AzazelSAlchemyTable;
import ru.azazel.alchemytable.entity.CrystalSpider;

public class CrystalSpiderModel extends SpiderModel<CrystalSpider> {

    public static final ModelLayerLocation LAYER_LOCATION =
            new ModelLayerLocation(
                    AzazelSAlchemyTable.id("crystal_spider"),
                    "main"
            );

    public CrystalSpiderModel(ModelPart root) {
        super(root);
    }

    public static LayerDefinition createBodyLayer() {
        // Временная геометрия обычного паука.
        // После экспорта модели из Blockbench этот метод
        // заменяется кодом, который сгенерировал Blockbench.
        return SpiderModel.createSpiderBodyLayer();
    }
}
