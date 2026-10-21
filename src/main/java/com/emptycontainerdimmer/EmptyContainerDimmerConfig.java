package com.emptycontainerdimmer;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.Range;

@ConfigGroup("empty-container-dimmer")
public interface EmptyContainerDimmerConfig extends Config {
    @Range(max = 100)
    @ConfigItem(keyName = "dimStrength", name = "Dimming Strength (%)", description = "0 leaves items unchanged, 100 makes them black", position = 0)
    default int dimStrength() {
        return 50;
    }

    @ConfigItem(keyName = "dimEmptyJugs", name = "Dim empty jugs", description = "Dim empty jugs in your inventory", position = 1)
    default boolean dimEmptyJugs() {
        return true;
    }

    @ConfigItem(keyName = "dimEmptyBuckets", name = "Dim empty buckets", description = "Dim empty buckets in your inventory", position = 2)
    default boolean dimEmptyBuckets() {
        return true;
    }

    @ConfigItem(keyName = "dimEmptyVials", name = "Dim empty vials", description = "Dim empty vials in your inventory", position = 3)
    default boolean dimEmptyVials() {
        return true;
    }

    @ConfigItem(keyName = "dimEmptyBowls", name = "Dim empty bowls", description = "Dim empty bowls in your inventory", position = 4)
    default boolean dimEmptyBowls() {
        return true;
    }

    @ConfigItem(keyName = "dimEmptyPots", name = "Dim empty pots", description = "Dim empty pots in your inventory", position = 5)
    default boolean dimEmptyPots() {
        return true;
    }

    @ConfigItem(keyName = "dimEmptyBeerGlasses", name = "Dim empty beer glasses", description = "Dim empty beer glasses in your inventory", position = 6)
    default boolean dimEmptyBeerGlasses() {
        return true;
    }

    @ConfigItem(keyName = "dimEmptyCups", name = "Dim empty cups", description = "Dim empty cups in your inventory", position = 7)
    default boolean dimEmptyCups() {
        return true;
    }

    @ConfigItem(keyName = "dimEmptyPlantPots", name = "Dim empty plant pots", description = "Dim empty plant pots in your inventory", position = 8)
    default boolean dimEmptyPlantPots() {
        return true;
    }

    @ConfigItem(keyName = "dimEmptyWateringCans", name = "Dim empty watering cans", description = "Dim empty watering cans in your inventory", position = 9)
    default boolean dimEmptyWateringCans() {
        return true;
    }

    @ConfigItem(keyName = "dimEmptyFishbowls", name = "Dim empty fishbowls", description = "Dim empty fishbowls in your inventory", position = 10)
    default boolean dimEmptyFishbowls() {
        return true;
    }

    @ConfigItem(keyName = "dimEmptyBaskets", name = "Dim empty baskets", description = "Dim empty baskets in your inventory", position = 11)
    default boolean dimEmptyBaskets() {
        return true;
    }

    @ConfigItem(keyName = "dimEmptySacks", name = "Dim empty sacks", description = "Dim empty sacks in your inventory", position = 12)
    default boolean dimEmptySacks() {
        return true;
    }
}
