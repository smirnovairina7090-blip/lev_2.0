package ru.azazel.alchemytable.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;

public class LightProjectile extends ThrowableItemProjectile {

    public LightProjectile(EntityType<? extends LightProjectile> entityType, Level level) {
        super(entityType, level);
    }

    public LightProjectile(Level level, LivingEntity owner) {
        super(ModEntities.LIGHT_PROJECTILE, owner, level);
    }

    @Override
    protected Item getDefaultItem() {
        return Items.GLOWSTONE_DUST;
    }

    @Override
    protected void onHit(HitResult result) {
        super.onHit(result);

        if (!level().isClientSide) {
            discard();
        }
    }
}
