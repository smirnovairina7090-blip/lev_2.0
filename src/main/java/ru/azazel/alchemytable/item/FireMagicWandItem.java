package ru.azazel.alchemytable.item;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import ru.azazel.alchemytable.entity.FireProjectile;

public class FireMagicWandItem extends Item {

    public FireMagicWandItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);

        if (!level.isClientSide) {
            FireProjectile projectile = new FireProjectile(level, player);
            projectile.shootFromRotation(
                    player,
                    player.getXRot(),
                    player.getYRot(),
                    0.0F,
                    1.5F,
                    1.0F
            );
            level.addFreshEntity(projectile);
        }

        return InteractionResultHolder.sidedSuccess(stack, level.isClientSide());
    }
}
