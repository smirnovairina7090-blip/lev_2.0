package ru.azazel.alchemytable.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SpawnEggItem;
import ru.azazel.alchemytable.AzazelSAlchemyTable;
import ru.azazel.alchemytable.entity.ModEntities;

public final class ModItems {

    public static final Item MAGIC_WAND = Registry.register(
            BuiltInRegistries.ITEM,
            AzazelSAlchemyTable.id("magic_wand"),
            new Item(new Item.Properties().stacksTo(1))
    );

    public static final Item LIGHT_MAGIC_WAND = Registry.register(
            BuiltInRegistries.ITEM,
            AzazelSAlchemyTable.id("light_magic_wand"),
            new ChargedMagicWandItem(new Item.Properties().stacksTo(1))
    );

    public static final Item FIRE_MAGIC_WAND = Registry.register(
            BuiltInRegistries.ITEM,
            AzazelSAlchemyTable.id("fire_magic_wand"),
            new FireMagicWandItem(new Item.Properties().stacksTo(1))
    );

    public static final Item WATER_MAGIC_WAND = Registry.register(
            BuiltInRegistries.ITEM,
            AzazelSAlchemyTable.id("water_magic_wand"),
            new WaterMagicWandItem(new Item.Properties().stacksTo(1))
    );

    public static final Item WIND_MAGIC_WAND = Registry.register(
            BuiltInRegistries.ITEM,
            AzazelSAlchemyTable.id("wind_magic_wand"),
            new WindMagicWandItem(new Item.Properties().stacksTo(1))
    );

    public static final Item REDSTONE_MAGIC_WAND = Registry.register(
            BuiltInRegistries.ITEM,
            AzazelSAlchemyTable.id("redstone_magic_wand"),
            new RedstoneMagicWandItem(new Item.Properties().stacksTo(1))
    );

    public static final Item GLOWING_MAGIC_WAND = Registry.register(
            BuiltInRegistries.ITEM,
            AzazelSAlchemyTable.id("glowing_magic_wand"),
            new GlowingMagicWandItem(new Item.Properties().stacksTo(1))
    );

    // Яйцо призыва кристаллического паука.
    // Теперь моба можно создавать обычным ПКМ, без команды /summon.
    //
    // Первое число - основной цвет стандартного яйца.
    // Второе число - цвет пятен.
    // Позже стандартную картинку заменим на вашу готовую текстуру.
    public static final Item CRYSTAL_SPIDER_SPAWN_EGG = Registry.register(
            BuiltInRegistries.ITEM,
            AzazelSAlchemyTable.id("crystal_spider_spawn_egg"),
            new SpawnEggItem(
                    ModEntities.CRYSTAL_SPIDER,
                    0x6E45A8,
                    0xD7B7FF,
                    new Item.Properties()
            )
    );

    public static void registerModItems() {
        ItemGroupEvents.modifyEntriesEvent(
                CreativeModeTabs.TOOLS_AND_UTILITIES
        ).register(entries -> {
            entries.accept(MAGIC_WAND);
            entries.accept(LIGHT_MAGIC_WAND);
            entries.accept(FIRE_MAGIC_WAND);
            entries.accept(WATER_MAGIC_WAND);
            entries.accept(WIND_MAGIC_WAND);
            entries.accept(REDSTONE_MAGIC_WAND);
            entries.accept(GLOWING_MAGIC_WAND);
        });

        // Яйцо кладём именно во вкладку "Яйца призыва",
        // чтобы его было легко найти в Creative.
        ItemGroupEvents.modifyEntriesEvent(
                CreativeModeTabs.SPAWN_EGGS
        ).register(entries -> {
            entries.accept(CRYSTAL_SPIDER_SPAWN_EGG);
        });
    }

    private ModItems() {
    }
}
