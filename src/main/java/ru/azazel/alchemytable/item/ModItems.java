package ru.azazel.alchemytable.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import ru.azazel.alchemytable.AzazelSAlchemyTable;

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
            new Item(new Item.Properties().stacksTo(1))
    );

    public static final Item WIND_MAGIC_WAND = Registry.register(
            BuiltInRegistries.ITEM,
            AzazelSAlchemyTable.id("wind_magic_wand"),
            new Item(new Item.Properties().stacksTo(1))
    );

    public static final Item REDSTONE_MAGIC_WAND = Registry.register(
            BuiltInRegistries.ITEM,
            AzazelSAlchemyTable.id("redstone_magic_wand"),
            new Item(new Item.Properties().stacksTo(1))
    );

    public static final Item GLOWING_MAGIC_WAND = Registry.register(
            BuiltInRegistries.ITEM,
            AzazelSAlchemyTable.id("glowing_magic_wand"),
            new Item(new Item.Properties().stacksTo(1))
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
    }

    private ModItems() {
    }
}
