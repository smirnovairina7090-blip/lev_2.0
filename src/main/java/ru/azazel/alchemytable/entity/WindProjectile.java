package ru.azazel.alchemytable.entity;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

import java.util.List;

public class WindProjectile extends ThrowableItemProjectile {

    public WindProjectile(EntityType<? extends WindProjectile> entityType, Level level) {
        super(entityType, level);
    }

    public WindProjectile(Level level, LivingEntity owner) {
        super(ModEntities.WIND_PROJECTILE, owner, level);
    }

    @Override
    protected Item getDefaultItem() {
        return Items.WIND_CHARGE;
    }

    @Override
    protected void onHit(HitResult result) {
        super.onHit(result);

        if (!level().isClientSide) {
            List<Mob> mobs = level().getEntitiesOfClass(
                    Mob.class,
                    getBoundingBox().inflate(5.0D)
            );

            for (Mob mob : mobs) {
                Vec3 direction = mob.position()
                        .subtract(position())
                        .normalize();

                mob.push(
                        direction.x * 2.5D,
                        0.8D,
                        direction.z * 2.5D
                );

                mob.addEffect(
                        new MobEffectInstance(
                                MobEffects.SLOW_FALLING,
                                200,
                                0
                        )
                );
            }

            discard();
        }
    }
}
