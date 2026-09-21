package ru.azazel.alchemytable.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Spider;
import net.minecraft.world.level.Level;

public class CrystalSpider extends Spider {

    public CrystalSpider(
            EntityType<? extends Spider> entityType,
            Level level
    ) {
        super(entityType, level);
    }
}
