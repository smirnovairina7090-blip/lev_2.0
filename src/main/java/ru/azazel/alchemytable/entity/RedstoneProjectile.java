package ru.azazel.alchemytable.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import ru.azazel.alchemytable.block.ModBlocks;

public class RedstoneProjectile extends ThrowableItemProjectile {

    public RedstoneProjectile(
            EntityType<? extends RedstoneProjectile> entityType,
            Level level
    ) {
        super(entityType, level);
    }

    public RedstoneProjectile(Level level, LivingEntity owner) {
        super(ModEntities.REDSTONE_PROJECTILE, owner, level);
    }

    @Override
    protected Item getDefaultItem() {
        return Items.REDSTONE;
    }

    @Override
    protected void onHit(HitResult result) {
        super.onHit(result);

        if (!level().isClientSide) {
            if (result instanceof BlockHitResult blockHit) {
                BlockPos signalPos = blockHit
                        .getBlockPos()
                        .relative(blockHit.getDirection());

                if (level().isEmptyBlock(signalPos)) {
                    level().setBlock(
                            signalPos,
                            ModBlocks.REDSTONE_PULSE.defaultBlockState(),
                            Block.UPDATE_ALL
                    );
                }
            }

            discard();
        }
    }
}
