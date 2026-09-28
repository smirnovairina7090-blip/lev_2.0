package ru.azazel.alchemytable.entity;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Spider;
import net.minecraft.world.level.Level;

public class CrystalSpider extends Spider {

    // 2 единицы здоровья = 1 сердечко у игрока.
    private static final float REFLECTED_DAMAGE = 2.0F;

    public CrystalSpider(
            EntityType<? extends Spider> entityType,
            Level level
    ) {
        super(entityType, level);
    }

    @Override
    public boolean hurt(DamageSource source, float amount) {
        // Сначала паук получает обычный урон.
        boolean wasHurt = super.hurt(source, amount);

        // Если урон не прошёл, мы на клиенте или это уже отражённый урон,
        // ничего дополнительно не делаем.
        if (!wasHurt || this.level().isClientSide() || source.is(DamageTypes.THORNS)) {
            return wasHurt;
        }

        Entity attacker = source.getEntity();
        Entity directEntity = source.getDirectEntity();

        // Ближний бой:
        // тот, кто нанёс урон, и непосредственный источник урона - одно существо.
        // Поэтому стрела, снежок, трезубец в полёте и другие снаряды сюда не попадут.
        boolean isMeleeAttack =
                attacker instanceof LivingEntity
                        && directEntity == attacker
                        && attacker != this;

        if (isMeleeAttack) {
            LivingEntity livingAttacker = (LivingEntity) attacker;

            // Возвращаем атакующему 2 единицы урона как от "Шипов".
            livingAttacker.hurt(
                    this.level().damageSources().thorns(this),
                    REFLECTED_DAMAGE
            );
        }

        return wasHurt;
    }
}
