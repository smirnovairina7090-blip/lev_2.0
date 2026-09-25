package ru.azazel.alchemytable.client.renderer;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import ru.azazel.alchemytable.AzazelSAlchemyTable;
import ru.azazel.alchemytable.client.model.CrystalSpiderModel;
import ru.azazel.alchemytable.entity.CrystalSpider;

public class CrystalSpiderRenderer
        extends MobRenderer<CrystalSpider, CrystalSpiderModel> {

    private static final ResourceLocation TEXTURE =
            AzazelSAlchemyTable.id(
                    "textures/entity/crystal_spider.png"
            );

    public CrystalSpiderRenderer(EntityRendererProvider.Context context) {
        super(
                context,
                new CrystalSpiderModel(
                        context.bakeLayer(
                                CrystalSpiderModel.LAYER_LOCATION
                        )
                ),
                0.8F
        );
    }

    @Override
    public ResourceLocation getTextureLocation(CrystalSpider entity) {
        return TEXTURE;
    }
}
