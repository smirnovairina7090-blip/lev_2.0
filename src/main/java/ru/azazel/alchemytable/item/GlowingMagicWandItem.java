package ru.azazel.alchemytable.item;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.List;

public class GlowingMagicWandItem extends Item {

    public GlowingMagicWandItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(
            Level level,
            Player player,
            InteractionHand hand
    ) {
        ItemStack stack = player.getItemInHand(hand);

        if (!level.isClientSide) {
            List<Mob> mobs = level.getEntitiesOfClass(
                    Mob.class,
                    player.getBoundingBox().inflate(20.0D),
                    mob -> player.distanceToSqr(mob) <= 400.0D
            );

            for (Mob mob : mobs) {
                mob.addEffect(
                        new MobEffectInstance(
                                MobEffects.GLOWING,
                                600,
                                0
                        )
                );
            }

            player.getCooldowns().addCooldown(this, 200);
        }

        return InteractionResultHolder.sidedSuccess(
                stack,
                level.isClientSide()
        );
    }
}
