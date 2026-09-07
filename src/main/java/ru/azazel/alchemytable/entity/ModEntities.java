package ru.azazel.alchemytable.entity;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import ru.azazel.alchemytable.AzazelSAlchemyTable;

public final class ModEntities {

    public static final EntityType<LightProjectile> LIGHT_PROJECTILE = Registry.register(
            BuiltInRegistries.ENTITY_TYPE,
            AzazelSAlchemyTable.id("light_projectile"),
            EntityType.Builder.<LightProjectile>of(LightProjectile::new, MobCategory.MISC)
                    .sized(0.25F, 0.25F)
                    .clientTrackingRange(4)
                    .updateInterval(10)
                    .build()
    );

    public static void registerModEntities() {
        AzazelSAlchemyTable.LOGGER.info("Registering projectile entities");
    }

    private ModEntities() {
    }
}
